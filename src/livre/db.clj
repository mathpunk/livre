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

(connect-to-mongo "units")
;; (connect! { :host "localhost" :port 27017 })                  ;; this is commented out for some reason

;; Records
(defn article [filename]
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

(try
  2      (/ 1 0)
  3      (catch Exception e (str "caught exception: " (.getMessage e))))
4  
5 "caught exception: Divide by zero"


; test
(def test-string "~/src/livre/material/wiki/test.wiki")

(article test-string)

;; Glue between files and records-- there's glue all over me oh dear god
(defn text-directory-as-values [dirname]
  (let [dir (clojure.java.io/file dirname),
        files (filter #(.isFile %) (file-seq dir))]
      (map text-file-as-value (remove #(.isHidden %) files))
    )
  )

;; Documents
;; this may not work
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

