; Forked and mutated from http://blog.malcolmsparks.com/?p=67 

(ns data.inventory.vimwiki)
; data protocols/records
(defprotocol Transaction (update [_ state]))

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

; transaction protocols/records

(defprotocol TransactionLog (record [_ tx]))

; Here’s an implementation that uses an agent to write the records to a print-stream.
;
; The agent will hold the print-stream. Agents are good for I/O because messages
; to them only get delivered if the transaction completes its update succesfully.
; If a retry is needed the message doesn’t get delivered. We let the Clojure prn
; function figure out how to serialize it. It’s optional, but the
; actual print statement is in an io! wrapper as a safety check.

(defrecord DefaultTransactionLog [ag]
  TransactionLog
  (record [this tx]
    (send-off ag
      (fn [out]
        (binding [*out* out *flush-on-newline* true]
          (io! (prn tx)) out)))))

; reading the transactions in a file
; Having written the records we’ll need some way of reading them back. We’ll
; just use the standard Clojure reader for this. This function returns a list
; of all the transactions in a file.

(defn read-transactions [f]
  (if-not (.exists f) []
    (let [rdr (java.io.PushbackReader. (clojure.java.io/reader f))]
      (take-while identity
        (repeatedly 
          (fn [] (read rdr false nil)))))))

; database state
; Now we move on to the database state. Let’s decorate the transaction log with
; something that will hold this state. As transactions are added to it they
; will update the in-memory state and be recorded on disk. This can support the
; TransactionLog protocol as well. The state will be a Clojure ref. The
; delegate will be a backing transaction log.

(defrecord Database [state delegate]
  TransactionLog
  (record [this tx]
    (dosync
     (alter state (partial update tx))
     (record delegate tx))))
; creating the database 
; Now we’re ready to create our database with the Clojure ref and backing  transaction log. 
; We’ll initialize the ref with a result of updating an empty
; map with a series of transactions read from our file.

(def db 
   (Database.
     (ref (reduce (fn [db tx] (update tx db)) {}
                    (read-transactions
                      (clojure.java.io/file "my.db.clj"))))
     (DefaultTransactionLog. 
       (agent (clojure.java.io/writer
                (clojure.java.io/file "my.db.clj")
                :append true)))))

; convenience functions

(defn delete-user [email]
    (record db (DeleteUser. email (java.util.Date.))))

(defn create-user [name email]
    (record db (CreateUser. name email (java.util.Date.))))

; tests

(create-user "Bob" "bob@example.org")
(create-user "Alice" "alice@example.org")
(create-user "Carol" "carol@example.org")
(delete-user "alice@example.org")


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; repurposing for Copy records
;
(def test-file "/home/thomas/src/livre/resources/material/vimwiki/big-picture.wiki")
(def test-dir "/home/thomas/src/livre/resources/material/vimwiki/")
(defn- uuid [] (str (java.util.UUID/randomUUID)))

(defrecord CreateCopy [id title path content history]
  Transaction
  (update [this db]
    (update-in db [:copy] conj
      {:id id 
       :title title
       :path path 
       :content content
       :history history}
      )
    )
  )

(defn create-copy [filename]
  (let [file (new java.io.File filename)]
    (record db (CreateCopy. 
                  (uuid),                         ; id
         (.getName file),                         ; title
       (.getParent file),                         ; path
            (slurp file),                         ; content
  [{:timestamp (.lastModified file) :diff nil}]))    ; history 
    )
  )



(create-copy test-file)


; What’s the state of the database?

(deref (:state db))    

; You should see something like this :-

{:users 
  ({:name "Carol",
    :email "carol@example.org",
    :start-date #inst "2012-04-19T16:00:35.903-00:00"}
   {:name "Bob",
    :email "bob@example.org",
    :start-date #inst "2012-04-19T16:00:35.901-00:00"})}

; Goal data: something like--
{:copy 
  ({:name "big-picture.wiki"
    :content "<<some stuff>>"
    :history {:timestamp #inst "<<m-time>>", :diff ""}
    :path "~/src/livre/src/livre/data/vimwiki"})}


; What’s in our database file? Below is the raw content. Unlike some database
; files it’s quite easy to read and even possible to edit by hand if the need
; arises.

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
