(ns livre.models.archives
  (:use [livre.db :only [connect]])
  (:require [monger.collection :as mc] [monger.query :as mq])
  (:import [org.bson.types ObjectID]))



;; articles
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

;; article collection
(defn article-space [dirname]
  (let [dir (clojure.java.io/file dirname),
        files (filter #(.isFile %) (file-seq dir))]
      (map article (remove #(.isHidden %) files))
    )
  )

;; corpus
(defn corpus 
  [ ]
  (let [articles (article-space "/home/thomas/src/livre/material/wiki")]
    (fn [] articles)))


(def number-of-articles (count corpus))

;; rebase
(defn rebase-text-data [dirname dbname]
  (let [values (article-space dirname)]
    (do
      (m/insert-batch dbname values))          
    )
  )

;; headings
; (defn heds 
;   (fn 
;     ([article] ; filter lines 
;     ([article search]

;; stanzas
; (defn stanzas

;; lines
; (defn lines 
;   [article]
;   (-> (article :content)
;       (

;; words
(defn gather-words 
   "Given a string, return a list of lower-case words with whitespace and
    punctuation removed.  --http://blog.darevay.com/2010/10/remedial-clojure-leiningen-lazytest-and-some-code/"
   [s]
   (map #(.toLowerCase %) (filter #(not (.isEmpty %)) (seq (.split #"[\s\W]+" s)))))

(defn wc
  [article]
  (count (gather-words (article :content))))

(defn number-of-words
  [corpus]
  (let [collection (map (fn [article] (wc article)) corpus)]
    (reduce + collection)))

(def wc-total
  (number-of-words corpus))

;; corpuscles
(defn attract [fielded-texton]
  (fn [another-fielded-texton]
    ; search back and forth among their keys
    ))

;; foreaches (???)
; for corpus,
; create a vector of titles

; for each title,
; create vector of headers

; for each header, 
; create a vector of stanzas

; for each stanza,
; create a vector of lines

; for each line,
; create a vector of words

(defn test-connection []
  (doseq
    (connect)
    (first (mc/find-maps "annotations"))
    ))

(m/find-maps "annotations")

(m/insert "articles" (article "/home/thomas/src/livre/material/wiki/test.wiki"))

(mc/connect! { :host "feuille" :port 27017 })  

(m/find)
