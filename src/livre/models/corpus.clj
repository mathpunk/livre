(ns livre.corpus
  (:use [livre.db :only (article-space)])
  (:require [monger.collection :as m] [monger.core :as mc] [monger.query :as q]))

(def corpus (article-space "/home/thomas/src/livre/material/wiki"))

;; # STATISTICS
;; ## articles (i.e., textons with names)
(def number-of-articles (count corpus))

;; ## words
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

;; ## lines


(defn lines 
  [article]
  (-> (article :content)
      (

;; ## headings

(defn heds 
  (fn 
    ([article] ; filter lines 
    ([article search]


;; ## stanzas


;; # PATTERN MATCHING
; this is just for playing with strings
(defn toy-corpus
  [content]
  (fn 
    ([ ] content)
    ([pattern] (re-seq pattern content))))

; what would the real one look like? well, it has to take some source for data...
