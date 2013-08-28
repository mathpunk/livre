; Goal: 
; Access the corpus abstractly.
; What's a corpus got?
;
; articles - textons that have names
; heds
; stanzas
; lines
; words
;
; That's great, except that right now these things come from my filesystem, and later
; these things come from my db. I want to abstract away the details of where these textons
; "are". 

; this is just for playing with strings
(defn toy-corpus
  [content]
  (fn 
    ([ ] content)
    ([pattern] (re-seq pattern content))))

; what would the real one look like? well, it has to take some source for data...
(defn corpus
  [location]
  ; maybe it's a local directory
  (try
       (clojure.java.io/file location))
  ; or maybe it's a mongo connection
  ; (try ???????)


; CORPUS FILTERS
; So you've got the corpus. What substructures would you want?
  ;
  ; articles (which have names, btw)
  ; heds
  ; lines
  ; words
  ;
; and those ought to chain, so you can get the words of the filtered articles of the corpus, etc.
  
  


  

(ns livre.db
  (:require [monger.collection :as m] [monger.core :as mc] [monger.query :as q])
(defn lines 
  [article]
  (-> (article :content)
      (


(defn heds 
  (fn 
    ([article] ; filter lines 
    ([article search]

