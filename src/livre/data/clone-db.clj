; Forked and mutated from http://blog.malcolmsparks.com/?p=67 
; WARNING: USES HARDCODED DIRECTORY LINKS LIKE A DUMMY see /home/thomas/<blah blah>

; an overspecific namespace-- this db ought to work for other types
(ns data.inventory.vimwiki)

; Cloned db from a random blog post har har
; Record and log protocols
(defprotocol Transaction (update [_ state]))
(defprotocol TransactionLog (record [_ tx]))

; "Uses an agent to write records to a print-stream. If a retry 
; is needed the message doesn't get delivered, because agents. The
; print statement is in an optional io! wrapper as a safety check."
(defrecord DefaultTransactionLog [ag]
  TransactionLog
  (record [this tx]
    (send-off ag
      (fn [out]
        (binding [*out* out *flush-on-newline* true]
          (io! (prn tx)) out)))))

(defn read-transactions [f]
  "Uses the standard Clojure reader to return a list of all the
  transactions in a file."
  (if-not (.exists f) []
    (let [rdr (java.io.PushbackReader. (clojure.java.io/reader f))]
      (take-while identity
        (repeatedly 
          (fn [] (read rdr false nil)))))))

; "As transactions are added they will update the in-memory state 
; and be recorded on disk. The state will be a ref, and the delegate
; will be a backing transaction log. I have no idea what any of this
; means."
(defrecord Database [state delegate]
  TransactionLog
  (record [this tx]
    (dosync
     (alter state (partial update tx))
     (record delegate tx))))

(def db 
  "Create our database with the Clojure ref and backing transaction
  log. We'll initialize the ref with the result of updating an 
  empty map with a series of transactions read from our file."
   (Database.
     (ref (reduce (fn [db tx] (update tx db)) {}
                    (read-transactions
                      (clojure.java.io/file "/home/thomas/src/livre/src/livre/data/text-db.clj"))))
     (DefaultTransactionLog. 
       (agent (clojure.java.io/writer
                (clojure.java.io/file "/home/thomas/src/livre/src/livre/data/text-db.clj")
                :append true)))))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; repurposing for Copy records
(def test-file "/home/thomas/src/livre/resources/material/vimwiki/big-picture.wiki")
(def test-dir "/home/thomas/src/livre/resources/material/vimwiki/")

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
  "Convenience function."
  (let [file (new java.io.File filename),
        uuid (str (java.util.UUID/randomUUID))]
    (record db (CreateCopy. 
                    uuid,              ; id
        (.getName file),               ; title
       (.getParent file),              ; path
            (slurp file),              ; content
  [{:timestamp (.lastModified file)    ; history 
    :diff nil}]))                            
    )
  )

(create-copy test-file)

; What’s the state of the database?
(def conn (deref (:state db)))

(count (conn :copy))

; Should be something like this--
{:copy 
  ({:name "big-picture.wiki"
    :content "<<some stuff>>"
    :history {:timestamp #inst "<<m-time>>", :diff ""}
    :path "~/src/livre/src/livre/data/vimwiki"})}



  
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; an example of a non-destructive "remove" function, for possible
; use later. 

(defrecord DeleteUser [email remove-date]
  "Remove, id'ing by email and noting the date."
  Transaction
  (update [this db]
    (update-in db [:users]
      (fn [coll] (remove (fn [r] (= (:email r) email)) coll)))))

(defn delete-user [email]
  "Convenience function."
    (record db (DeleteUser. email (java.util.Date.))))

