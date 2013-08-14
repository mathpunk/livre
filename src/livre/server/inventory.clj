; todo: 
; * should be able to handle img files too. instead of content, record a uri for the server to use. 


(ns livre.server.inventory
  (:require [monger.collection :as m] [monger.core :as mc] [monger.query :as q])
  (:use [monger.operators])
  (:import [org.bson.types ObjectId] [com.mongodb DB WriteConcern MongoOptions ServerAddress]))


; connect
;; (connect! { :host "localhost" :port 27017 })

;; connect using MongoOptions to fine-tune connection parameters,
;; like automatic reconnection (highly recommended for production environment)
(defn connect-to-mongo [ ]
  (let [^MongoOptions opts (mc/mongo-options :threads-allowed-to-block-for-connection-multiplier 300)
        ^ServerAddress sa  (mc/server-address "127.0.0.1" 27017)]
    (do
      (mc/connect! sa opts)
      (mc/set-db! (mc/get-db "units"))
      )
    )
  )


; turn target directory into values
(defn- value-of-a-text-file [file]
     {
       :title       (.getName file)
       :path     (.getParent file)
       :ws          (.getName (.getParentFile file))
       :content     (slurp file)
       :history     [{:tx (.lastModified file) :diff nil}]
      }
  )

; TODO: Refactor so that img and text files have the same-ish affordances
; value-of-an-image-file
;   :title nil
;   :ws nil
;   :content {:uri blah} ? ; it will come from the ~/material directory on livre at the moment


; add ObjectIDs
(defn id-stamp [m]
  (assoc m :_id (ObjectId.))
  )


; insert collection
;
; verify find from collection
; 
; reevaluate next steps


; ## Inserting documents and batches

(m/insert "documents" { :_id (ObjectId.) :hello "darlin" })



; ## Finding documents (as maps)

(m/find-maps "documents" {:hello {$exists true}})


; ## Value-ing files


; ## Working with Directories
(defn- text-directory-as-values [dirname]
  (let [dir (clojure.java.io/file dirname),
        files (filter #(.isFile %) (file-seq dir))]
      (map value-of-a-text-file (remove #(.isHidden %) files))
    )
  )

; (defn- tagged-value-of-a-directory [dirname]
;   (let [values (text-directory-as-values dirname) 
 ;        tag "#com.punkmathematics.livre/inventory "]
  ;   (map #(str tag % "\n") values))
  ; )

(defn- do-add-text-dir-to-db [dirname]
  (let [values (text-directory-as-values dirname)]
    (do
      (connect-to-mongo)
      (m/insert-batch "document" values))
    )
  )
        


; testing
; --------------------------------------------------- 
(def full-test-dir "/home/thomas/src/livre/material/")
(def text-test-file "/home/thomas/src/livre/material/vimwiki/big-picture.wiki")
(def text-test-dir "/home/thomas/src/livre/material/vimwiki")



