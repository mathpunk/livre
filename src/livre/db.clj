(ns livre.db
  (:require [monger.collection :as m] [monger.core :as mc])
  (:use [monger.operators])
  (:import [org.bson.types ObjectId] [com.mongodb DB WriteConcern MongoOptions ServerAddress]))

;; DB/Connection-- recommended options
(defn connect-to-mongo [db]
  (let [^MongoOptions opts (mc/mongo-options :threads-allowed-to-block-for-connection-multiplier 300)
        ^ServerAddress sa  (mc/server-address "127.0.0.1" 27017)]
    (do
      (mc/connect! sa opts)
      (mc/set-db! (mc/get-db db))
      )
    )
  )


;; Article: records
(defn article [file]
  (let [oid (ObjectId.)] 
     {
       :_id         oid
       :title       (.getName file)
       :path        (.getParent file)
       :content     (slurp file)
       :history     [{:tx (.lastModified file) :diff nil}]
      }
    )
  )

;; Article space: many records
(defn article-space [dirname]
  (let [dir (clojure.java.io/file dirname),
        files (filter #(.isFile %) (file-seq dir))]
      (map article (remove #(.isHidden %) files))
    )
  )


;; Rebase many records into a database of some name
(defn rebase-text-data [dirname dbname]
  (let [values (article-space dirname)]
    (do
      (m/insert-batch dbname values))          
    )
  )

;; Mongo
;; I'm not sure that the stuff is getting into the db/collection because I keep forgetting how to 
;; get stuff out of a db/collection. Try this? 
;; 
;; As for "doing things" right now I'm just using a big dictionary as my corpus. See models/corpus.clj.
;; (connect-to-mongo "livre")

;; (m/insert "articles" (article "/home/thomas/src/livre/material/wiki/test.wiki"))

;; (connect! { :host "feuille" :port 27017 })                  ;; I included this commented line for... reasons?
;; (rebase-text-data "units" "articles")
