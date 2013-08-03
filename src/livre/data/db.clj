; Here is an attempt at a local database using protocols and records. Modified from 
; http://blog.malcolmsparks.com/?p=67 because I wanted to try something with the edn reader.

(ns data.inventory.vimwiki)

(defprotocol Transaction 
  (update [_ state]))

(defn- uuid [] (str (java.util.UUID/randomUUID)))

(defrecord CreateCopy [file]
  Transaction
  (update [this db]
    (update-in db [:copy] conj
      {
        :id (uuid)
        :history [
            { :timestamp (.lastModified file)   ; using modified time as a best guess
              :diff ""
            }
          ]
        :content (slurp file)                   ; the full text of the file
        :title  (.getName file)
        :path (.getParent file)
      })
    )
  )

(CreateCopy file)

(def file "~/src/livre/resources/material/vimwiki/big-picture.wiki")

(defrecord DeleteUser [email remove-date]
  Transaction
  (update [this db]
    (update-in db [:users]
      (fn [coll] (remove (fn [r] (= (:email r) email)) coll)))))

 
  
; TRANSFORM INTO DATA STRUCTURES
; take the archive path, choose only the files, and convert those to records
(def archive "/home/thomas/cerebra/wiki/wiki-archive")
(defn records [archive-path]
  (map record 
    (filter #(.isFile %) 
      (file-seq (clojure.java.io/file archive-path)))
    )
  )
(doall (map #(str "#inventory/vimwiki " %) (records archive)))
(count (doall (map #(str "#inventory/vimwiki " %) (records archive))))
(spit output-file (str "#inventory/vimwiki " (first (records archive))))
(count (records archive))




; Data is important. We’ll want to keep records of these transactions.

(defprotocol TransactionLog (record [_ tx]))

; Here’s an implementation that uses an agent to write the records to a print-stream.

(defrecord DefaultTransactionLog [ag]
  TransactionLog
  (record [this tx]
    (send-off ag
      (fn [out]
        (binding [*out* out *flush-on-newline* true]
          (io! (prn tx)) out)))))

; The agent will hold the print-stream. Agents are good for I/O because messages
; to them only get delivered if the transaction completes its update succesfully.
; If a retry is needed the message doesn’t get delivered. We let the Clojure prn
; function figure out how to serialize it. It’s optional, but I’ve wrapped the
; actual print statement in an io! wrapper as a safety check.

; Having written the records we’ll need some way of reading them back. We’ll just
; use the standard Clojure reader for this. This function returns a list of all
; the transactions in a file.

(defn read-transactions [f]
  (if-not (.exists f) []
    (let [rdr (java.io.PushbackReader. (clojure.java.io/reader f))]
      (take-while identity
        (repeatedly 
          (fn [] (read rdr false nil)))))))

; Now we move on to the database state. Let’s decorate the transaction log with
; something that will hold this state. As transactions are added to it they will
; update the in-memory state and be recorded on disk. This can support the
; TransactionLog protocol as well. The state will be a Clojure ref. The delegate
; will be a backing transaction log.

(defrecord Database [state delegate]
  TransactionLog
  (record [this tx]
    (dosync
     (alter state (partial update tx))
     (record delegate tx))))

; Now we’re ready to create our database with the Clojure ref and backing
; transaction log. We’ll initialize the ref with a result of updating an empty
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

; Remember those transactions we coded earlier? Let’s add some convenience functions that will create and apply these transactions :-

(defn create-user [name email]
    (record db (CreateUser. name email (java.util.Date.))))

(defn delete-user [email]
    (record db (DeleteUser. email (java.util.Date.))))

; Notice how we’re creating java.util.Date instances.

; Now, let’s test it.

(create-user "Bob" "bob@example.org")
(create-user "Alice" "alice@example.org")
(create-user "Carol" "carol@example.org")
(delete-user "alice@example.org")
