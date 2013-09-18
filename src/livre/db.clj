(ns livre.db
  (:require [monger.collection :as m] [monger.core :as mc])
  (:use [monger.operators])
  (:import [org.bson.types ObjectId] [com.mongodb DB WriteConcern MongoOptions ServerAddress]))

;; Database defaults
(defn connection [host db]
  (let [^MongoOptions opts (mc/mongo-options :threads-allowed-to-block-for-connection-multiplier 300)
        port 27017
        ^ServerAddress sa  (mc/server-address host port)]
    (do
      (mc/connect! sa opts)
      (mc/set-db! (mc/get-db db))
      )
    )
  )

;; Connect to my db
(defn connect [ ]
  (connection "feuille" "livre"))

;; A record: "article"
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

;; A mess of records: "articles"
(defn articles [dirname]
  (let [dir (clojure.java.io/file dirname),
        files (filter #(.isFile %) (file-seq dir))]
      (map article (remove #(.isHidden %) files))
    )
  )

;; Rebase many records into a database of some name
(defn rebase-articles [dirname]
  (let [values (articles dirname)]
    (m/insert-batch "articles" values)))

(connect)
