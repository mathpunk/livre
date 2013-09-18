;; this is not functional style at all.
;;
;; for your queries, you'll want to build up a language.
;;
(count (m/find-maps "document" {:ws {$exists true}}))

;; articles (i.e., textons with names)

; (def number-of-articles (count corpus))

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


(m/find-maps "annotations")
(m/insert "articles" (article "/home/thomas/src/livre/material/wiki/test.wiki"))
(mc/connect! { :host "feuille" :port 27017 })  
(m/find)



