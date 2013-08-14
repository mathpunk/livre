; I've been instructed not to care too much about databases. So, these functions just
; take some data and write it as a text file in the extended data notation (edn),
; specified here: https://github.com/edn-format/edn
; 
; For more database-y things, see src/livre/src/livre/server/storage.clj. Which is probably empty.
; --th
;
;
; todo: 
; * should be able to handle img files too. instead of content, record a uri for the server to use. 
; * should suck less


(ns livre.server
  (:require [monger.collection :as m])
  (:use [monger.core :only [connect! connect set-db! get-db]]
        [monger.operators])
  (:import [org.bson.types ObjectId] 
        [com.mongodb DB WriteConcern MongoOptions ServerAddress]))

; connect
;; given host, given port
(mg/connect! { :host "localhost" :port 27017 })

;; using MongoOptions allows fine-tuning connection parameters,
;; like automatic reconnection (highly recommended for production environment)
(let [^MongoOptions opts (mg/mongo-options :threads-allowed-to-block-for-connection-multiplier 300)
      ^ServerAddress sa  (mg/server-address "127.0.0.1" 27017)]
  (mg/connect! sa opts))


;; localhost, default port
(mg/connect!)
(mg/set-db! (mg/get-db "units"))


; turn target directory into values, adding ObjectIDs
;
; insert collection
;
; verify
;
; celebrate


; ## Value-ing files
(defn- value-of-a-text-file [file]
     {
       :title       (.getName file)
       :path     (.getParent file)
       :ws          (.getName (.getParentFile file))
       :content     (slurp file)
       :history     [{:tx (.lastModified file) :diff nil}]
      }
  )

; value-of-an-image-file's differences:
; :title nil
; :ws nil
; :content {:uri blah} ?
;

; ## Working with Directories
(defn- transform-text-directory-to-values [dirname]
  (let [dir (clojure.java.io/file dirname),
        files (filter #(.isFile %) (file-seq dir))]
      (map value-of-a-text-file (remove #(.isHidden %) files))
    )
  )

(defn- tagged-value-of-a-directory [dirname]
  (let [values (transform-text-directory-to-values dirname) 
        tag "#com.punkmathematics.livre/inventory "]
    (map #(str tag % "\n") values))
  )

; testing
; --------------------------------------------------- 
(def full-test-dir "/home/thomas/src/livre/material/")
(def text-test-file "/home/thomas/src/livre/material/vimwiki/big-picture.wiki")
(def text-test-dir "/home/thomas/src/livre/material/vimwiki")



; ## Inserting documents and batches

(insert "documents" { :_id (ObjectId.) :hello "world" })
(insert-batch "document" [{ :first_name "John" :last_name "Lennon" }
                          { :first_name "Paul" :last_name "McCartney" }])

;; without document id (when you don't need to use it after storing the document)
(insert "document" { :first_name "John" :last_name "Lennon" })

(m/insert "documents" {:hello  "dolly" })

(m/insert "documents" {:hello "nasty" })

(m/insert "documents" {:hello "nurse"})

(m/find-maps "documents" {:hello {$exists true}})
