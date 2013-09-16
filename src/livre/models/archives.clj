(ns livre.models.archives
  (:use [livre.db :only (article-space)])
  (:require [monger.collection :as m] [monger.core :as mc] [monger.query :as q]))




;; corpus
;;
(defn corpus 
  [ ]
  (let [articles (article-space "/home/thomas/src/livre/material/wiki")]
    (fn [] articles)))

   ; (fn [dict] ; for each key, search that field by values 
   ;   )))


;; articles (i.e., textons with names)

(def number-of-articles (count corpus))

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



;; zipper
;; Try to think recursively: since your zipper has differnt functions at different levels, make a couple of different
;; zippers


(require '[clojure.zip :as zip])

(def root-loc (zip/seq-zip (seq (map :title arts))))

Usage: (zipper branch? children make-node root)

    Creates a new zipper structure. 

branch? is a fn that, given a node, returns true if can have
children, even if it currently doesn't.

children is a fn that, given a branch node, returns a seq of its
children.

make-node is a fn that, given an existing node and a seq of
children, returns a new branch node with the supplied children.
root is the root node.

(def zp (zip/zipper false (gather-words "blahblah blah") (fn [node kids] nil) []))

(def titles (map #(% :title) copy))

(def z (zip/seq-zip titles))

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

fn [corpus]
  :wq

