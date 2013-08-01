;; word functions
;;


(ns livre.words.wordnik)
(def my-wordnik-key "fe13b068fae9104fa90000d481c035c96157a13f3ca6f2ef9")
(def word-base "http://developer.wordnik.com/v4/word.json/" )
(def key-param
  (str "&api_key=" my-wordnik-key))

(ns livre.words.wordnik.api)
;; api calls of interest
; /word.json/{word}/definitions
; /word.json/{word}/topExample
; /word.json/{word}/relatedWords
; /word.json/{word}/etymologies
(defn wordnik-request [name word]                                     ; should be, like, define api call?
  (str wordnik-base-url name api-key-uri))


(ns livre.words)
(defn etymology
  "Get an etymology (or etymologies) from the Wordnik api."
  ([word]
   ;; bind default parameters
   ;; call 2-arity function
  ([word params])
   ;; form request
   ;; build and return data structure
   )
  )

(defn definition
  "Get a definition (or definitions) from the Wordnik api."
  ([word]
   ;; bind default parameters
   ;; call 2-arity function
  ([word params])
   ;; form request
   ;; build and return data structure
  )
 )

(defn phrase? [texton]
  ;; has spaces
  )

;; defn doallwords [phrase]

(ns livre.words.lexicon)
;; find and use private definitions and clips -- i.e., vimwiki pages with word/phrase names
