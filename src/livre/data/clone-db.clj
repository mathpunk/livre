
(defprotocol Transaction (update [_ state]))

Here’s some example transactions we want to perform. For this article let’s imagine we’re creating a database of user accounts. We’ll just create two transaction types- creating users and deleting them. Let’s record the name and email address, plus the date they joined or left.

(defrecord CreateUser [name email start-date]
  Transaction
  (update [this db]
    (update-in db [:users] conj
      {:name name :email email :start-date start-date})))

(defrecord DeleteUser [email remove-date]
  Transaction
  (update [this db]
    (update-in db [:users]
      (fn [coll] (remove (fn [r] (= (:email r) email)) coll)))))

Data is important. We’ll want to keep records of these transactions.

(defprotocol TransactionLog (record [_ tx]))

Here’s an implementation that uses an agent to write the records to a print-stream.

(defrecord DefaultTransactionLog [ag]
  TransactionLog
  (record [this tx]
    (send-off ag
      (fn [out]
        (binding [*out* out *flush-on-newline* true]
          (io! (prn tx)) out)))))

The agent will hold the print-stream. Agents are good for I/O because messages to them only get delivered if the transaction completes its update succesfully. If a retry is needed the message doesn’t get delivered. We let the Clojure prn function figure out how to serialize it. It’s optional, but I’ve wrapped the actual print statement in an io! wrapper as a safety check.

Having written the records we’ll need some way of reading them back. We’ll just use the standard Clojure reader for this. This function returns a list of all the transactions in a file.

(defn read-transactions [f]
  (if-not (.exists f) []
    (let [rdr (java.io.PushbackReader. (clojure.java.io/reader f))]
      (take-while identity
        (repeatedly 
          (fn [] (read rdr false nil)))))))

Now we move on to the database state. Let’s decorate the transaction log with something that will hold this state. As transactions are added to it they will update the in-memory state and be recorded on disk. This can support the TransactionLog protocol as well. The state will be a Clojure ref. The delegate will be a backing transaction log.

(defrecord Database [state delegate]
  TransactionLog
  (record [this tx]
    (dosync
     (alter state (partial update tx))
     (record delegate tx))))

Now we’re ready to create our database with the Clojure ref and backing transaction log. We’ll initialize the ref with a result of updating an empty map with a series of transactions read from our file.

(def db 
   (Database.
     (ref (reduce (fn [db tx] (update tx db)) {}
                    (read-transactions
                      (clojure.java.io/file "my.db.clj"))))
     (DefaultTransactionLog. 
       (agent (clojure.java.io/writer
                (clojure.java.io/file "my.db.clj")
                :append true)))))

Remember those transactions we coded earlier? Let’s add some convenience functions that will create and apply these transactions :-

(defn create-user [name email]
    (record db (CreateUser. name email (java.util.Date.))))

(defn delete-user [email]
    (record db (DeleteUser. email (java.util.Date.))))

Notice how we’re creating java.util.Date instances.

Now, let’s test it.

(create-user "Bob" "bob@example.org")
(create-user "Alice" "alice@example.org")
(create-user "Carol" "carol@example.org")
(delete-user "alice@example.org")


What’s the state of the database?

(deref (:state db))    

You should see something like this :-

{:users 
  ({:name "Carol",
    :email "carol@example.org",
    :start-date #inst "2012-04-19T16:00:35.903-00:00"}
   {:name "Bob",
    :email "bob@example.org",
    :start-date #inst "2012-04-19T16:00:35.901-00:00"})}

What’s in our database file? Below is the raw content. Unlike some database files it’s quite easy to read and even possible to edit by hand if the need arises.

#blog.CreateUser{:name "Bob", :email 
"bob@example.org", :start-date #inst 
"2012-04-19T16:00:35.901-00:00"}
#blog.CreateUser{:name "Alice", :email 
"alice@example.org", :start-date #inst 
"2012-04-19T16:00:35.903-00:00"}
#blog.CreateUser{:name "Carol", :email 
"carol@example.org", :start-date #inst 
"2012-04-19T16:00:35.903-00:00"}
#blog.DeleteUser{:email "alice@example.org", 
:remove-date #inst 
"2012-04-19T16:00:35.904-00:00"}

Note, unless you aren’t using Clojure 1.4 or above you won’t see the #inst tags!

Notice how Clojure is writing out and reading back the java.util.Date instance. You can also register your own Java types to it through the *data-readers* dynamic binding (more details in the Clojure 1.4 release notes). This makes things really easy to create some fairly complex atomic transactions.

Now try recompiling – you should find the database is restored. You can also try removing the user. The transaction log will store both the create-user event and the delete-user event, both with timings.

That’s around 30 lines of code to code a transactional database, and a few more lines to code some custom transactions.

You don’t have to limit yourself to a map as your state. At Deutsche Bank we’ve used a similar design but with RDF triple-stores that are queryable in a datalog syntax. A key benefit with using Clojure’s persistent data-structures for simple in-memory datastores is that you don’t have to worry about locks or concurrent updates.

