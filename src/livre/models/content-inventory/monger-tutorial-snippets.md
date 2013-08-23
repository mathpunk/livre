; ObjectId
(let [oid (ObjectId.)
      doc { :first_name "John" :last_name "Lennon" }]
  (insert "documents" (merge doc {:_id oid})))

; To convert a string in the object id form (for example, coming from a Web form) to an ObjectId, instantiate ObjectId with an argument:
(ObjectId. "4fea999c0364d8e880c05157") ;; => #<ObjectId 4fea999c0364d8e880c05157>


; How to Insert Documents with Monger

; To insert documents, use monger.collection/insert and monger.collection/insert-batch functions.

(ns my.service.server
  (:use [monger.core :only [connect! connect set-db! get-db]]
        [monger.collection :only [insert insert-batch]])
  (:import [org.bson.types ObjectId]
           [com.mongodb DB WriteConcern]))

;; localhost, default port
(connect!)
(set-db! (monger.core/get-db "monger-test"))

;; with explicit document id (recommended)
(insert "documents" { :_id (ObjectId.) :first_name "John" :last_name "Lennon" })

;; multiple documents at once
(insert-batch "document" [{ :first_name "John" :last_name "Lennon" }
                          { :first_name "Paul" :last_name "McCartney" }])

;; without document id (when you don't need to use it after storing the document)
(insert "document" { :first_name "John" :last_name "Lennon" })

;; with a different write concern
(insert "documents" { :_id (ObjectId.) :first_name "John" :last_name "Lennon" } WriteConcern/JOURNAL_SAFE)

;; with a different database
(let [archive-db (get-db "monger-test.archive")]
  (insert archive-db "documents" { :first_name "John" :last_name "Lennon" } WriteConcern/NORMAL))

; monger.collection/insert returns write result that monger.result/ok? and similar functions can operate on.

; monger.collection/insert-and-return is an alternative insertion function that returns the exact documented inserted, including the generated document id:

(ns doc.examples
  (:require [monger.collection :as mc]))

;; returns the inserted document that includes generated _id
(mc/insert-and-return "documents" {:name "John" :age 30})
