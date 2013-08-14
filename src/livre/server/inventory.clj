; todo: 
; * should be able to handle img files too. instead of content, record a uri for the server to use. 


(ns livre.server.inventory
  (:require [monger.collection :as m])
  (:use [monger.core :only [mongo-options server-address connect! connect set-db! get-db]]
        [monger.operators])
  (:import [org.bson.types ObjectId] 
        [com.mongodb DB WriteConcern MongoOptions ServerAddress]))

; connect
;; (connect! { :host "localhost" :port 27017 })

;; connect using MongoOptions to fine-tune connection parameters,
;; like automatic reconnection (highly recommended for production environment)
(defn connect-to-mongo [ ]
  (let [^MongoOptions opts (mongo-options :threads-allowed-to-block-for-connection-multiplier 300)
        ^ServerAddress sa  (server-address "127.0.0.1" 27017)]
    (do
      (connect! sa opts)
      (set-db! (get-db "units"))
      )
    )
  )

(connect-to-mongo)


; turn target directory into values, adding ObjectIDs
;
; insert collection
;
; verify
;
; celebrate


; ## Inserting documents and batches

(m/insert "documents" { :_id (ObjectId.) :hello "darlin" })

(m/insert-batch "document" [{ :first_name "John" :last_name "Lennon" }
                          { :first_name "Paul" :last_name "McCartney" }])


; ## Finding documents (as maps)

(m/find-maps "documents" {:hello {$exists true}})






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



