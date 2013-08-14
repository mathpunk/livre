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


(ns livre.server.inventory
  (:require [clojure.edn :as edn]))

(ns livre.server
  (:require [monger.core :as mg])
  (:import [com.mongodb MongoOptions ServerAddress]))
(ns my.service.server
  (:require [monger.collection :as mc])
  (:use monger.operators))
(ns livre.server
    (:use [monger.core :only [connect! connect set-db! get-db]]
                  [monger.collection :only [insert insert-batch]])
    (:import [org.bson.types ObjectId]
                        [com.mongodb DB WriteConcern]))
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

(defn local-dir-to-local-edn [dirname output-name] 
    (let [data (tagged-value-of-a-directory dirname)
          output (clojure.java.io/file output-name)]
      (map #(spit output % :append true) data)
     )
  )



; testing
; --------------------------------------------------- 
(def full-test-dir "/home/thomas/src/livre/material/")
(def text-test-file "/home/thomas/src/livre/material/vimwiki/big-picture.wiki")
(def text-test-dir "/home/thomas/src/livre/material/vimwiki")

(local-dir-to-local-edn text-test-dir "/home/thomas/src/livre/data/test.edn")

; sanity docs
; * what am i doing?
; you are...
; you need to get your documents into the database. 
; you know how to convert your documents into values.
; you have a snippet on adding an object id to a document.
; you made a connection to a database.
; you have added documents to the database.
;
;
; algorithm:
;
; load monger namespace and requirements
; (remove edn requirement)
; 
; turn target directory into values, adding ObjectIDs
;
; insert collection
;
; verify
;
; celebrate


;; given host, given port
(mg/connect! { :host "localhost" :port 27017 })

;; using MongoOptions allows fine-tuning connection parameters,
;; like automatic reconnection (highly recommended for production environment)
(let [^MongoOptions opts (mg/mongo-options :threads-allowed-to-block-for-connection-multiplier 300)
      ^ServerAddress sa  (mg/server-address "127.0.0.1" 27017)]
  (mg/connect! sa opts))

(get-collection-names)


;; localhost, default port

(mg/connect!)

(mg/set-db! (mg/get-db "units"))


(insert "documents" { :_id (ObjectId.) :hello "world" })

;; multiple documents at once
(insert-batch "document" [{ :first_name "John" :last_name "Lennon" }
; ...is a recommended way of inserting batches of documents (from tens to hundreds
; of thousands) because it is very efficient compared to sequentially or even
; concurrently inserting documents one by one.
                          { :first_name "Paul" :last_name "McCartney" }])

;; without document id (when you don't need to use it after storing the document)
(insert "document" { :first_name "John" :last_name "Lennon" })







(mc/insert "documents" {:hello  "dolly" })
(mc/insert "documents" {:hello "nasty" })
(mc/insert "documents" {:hello "nurse"})

(mc/find "documents" {:hello "world"})
(mc/find-maps "documents" {:hello {$exists true}})
