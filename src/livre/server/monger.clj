(ns livre.server
  (:require [monger.core :as mg])
  (:import [com.mongodb MongoOptions ServerAddress]))

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

(ns livre.server
    (:use [monger.core :only [connect! connect set-db! get-db]]
                  [monger.collection :only [insert insert-batch]])
    (:import [org.bson.types ObjectId]
                        [com.mongodb DB WriteConcern]))

(insert "documents" { :_id (ObjectId.) :hello "world" })

;; multiple documents at once
(insert-batch "document" [{ :first_name "John" :last_name "Lennon" }
; ...is a recommended way of inserting batches of documents (from tens to hundreds
; of thousands) because it is very efficient compared to sequentially or even
; concurrently inserting documents one by one.
                          { :first_name "Paul" :last_name "McCartney" }])

;; without document id (when you don't need to use it after storing the document)
(insert "document" { :first_name "John" :last_name "Lennon" })






(ns my.service.server
  (:require [monger.collection :as mc])
  (:use monger.operators))

(mc/insert "documents" {:hello  "dolly" })
(mc/insert "documents" {:hello "nasty" })
(mc/insert "documents" {:hello "nurse"})

(mc/find "documents" {:hello "world"})
(mc/find-maps "documents" {:hello {$exists true}})
