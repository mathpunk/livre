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


; Testing 
(def test-string "/home/thomas/src/livre/material/wiki/test.wiki")
(def test-file (clojure.java.io/file test-string))
(def test-dirname "/home/thomas/src/livre/material/wiki")

(article test-file)

(m/insert "articles" (article test-file))

;; Usage
(connect-to-mongo "units")
;; (connect! { :host "localhost" :port 27017 })                  ;; this is commented out for some reason

(rebase-text-data "units" "articles")
