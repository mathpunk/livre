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

(connect-to-mongo)

(defn- text-file-as-value [file]
  (let [oid (ObjectId.)] 
     {
       :_id         oid
       :title       (.getName file)
       :path     (.getParent file)
       :ws          (.getName (.getParentFile file))
       :content     (slurp file)
       :history     [{:tx (.lastModified file) :diff nil}]
      }
    )
  )

; [ ] TODO: Refactor so that img and text files have the same-ish affordances
; value-of-an-image-file
;   :title nil
;   :ws nil
;   :content {:uri blah} ? ; it will come from the ~/material directory on livre at the moment

(defn- text-directory-as-values [dirname]
  (let [dir (clojure.java.io/file dirname),
        files (filter #(.isFile %) (file-seq dir))]
      (map text-file-as-value (remove #(.isHidden %) files))
    )
  )

; add documents
; I'm not convinced this works
(defn- do-add-text-dir-to-db [dirname]
  (let [values (text-directory-as-values dirname)]
    (do
      (m/insert-batch "document" values))          
    )
  )


; test
(def base "/home/thomas/src/livre/")
(def pm (str "material/text/pm/"))
(def file (str base pm "keywords.wiki"))

(m/insert "document" (text-file-as-value (clojure.java.io/file file)))


; prod
(def the-real-thing  "/home/thomas/cerebra/wiki/pm/zeroth-draft")

