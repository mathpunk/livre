
(ns livre.server.inventory
  (:require [monger.collection :as m] [monger.core :as mc] [monger.query :as q])
  (:use [monger.operators])
  (:import [org.bson.types ObjectId] [com.mongodb DB WriteConcern MongoOptions ServerAddress]))


(defprotocol Texton 
  "the doc string for a protocol.
  No! A protocol that--
  No!
  A texton has a string and an origin
  which is a protocol string or whatever?
  "
  (text [x] "We'd call it content, but that can be ambiguous, so this is where we admit that the thing 'is' a string.")
  (origin [x] "I think a texton knows who wrote it. At least, it knows who last wrote it-- thus we distinguish between 
              a texton slyly written by Menard and another earnestly written by Quixote, or vice versa.")
  )


(defrecord FileLikeTexton [host filename] 
  Texton


  (let [oid (ObjectId.)
        file (clojure.java.io/file filename)] 
     {
       :_id         oid
       :origin      { :host host  :name (.getName file), :path (.getParent file) }
       :text      (slurp file)
       :history     [{:tx (.lastModified file) :diff nil}]
      }
    )
  )

  "Something file-like is data existing on some computer in space and time. It can happen to the best of us. Since
  we know it's running off to a sunnier climes in a database, we'll give it an id."

(defn- text-file-as-value [file]
  )

; [ ] TODO: Refactor so that img and text files have the same-ish affordances
; value-of-an-image-file
;   :title nil
;   :ws nil
;   :content {:uri blah} ? ; it will come from the ~/material directory on livre at the moment

(defn- text-directory-as-values [dirname]
  (let [dir (clojure.java.io/file dirname),
        files (filter #(.isFile %) (file-seq dir))]
      (map text-file-as-value (remove #(.isHidden %) files))
    )
  )

; add documents
; I'm not convinced this works
(defn- do-add-text-dir-to-db [dirname]
  (let [values (text-directory-as-values dirname)]
    (do
      (m/insert-batch "document" values))          
    )
  )


* Texton
grafs / stanzas
lines
words
bag-of-words
String
origin
Try to become Interesting
* Interesting Texton
????
* File-like Texton
name
location 
path
File
* Graphic Texton
img
transcription 
  if null
    call for a transcription
* Markdown Texton
hed
links
  internal
    wiki syntax
  external
    http
    mongo?
  computed
    mongo?
    exercises, extensions, questions, evidence, "media"

IsInteresting
  degree
    from number of clicks
    from appearance in keywords
    from appearance in textons



## queues

QueueCards

PartialOrdure


## functions

split by ---, ***

look for #s

look for #{ ((, [[, ... }

look for keywords



; units of text
word 
line
stanza
page  
- has-links?
- is-leaf? (not has-links)
codex
library 
Library
; note: there is no information on whether every *configuration* of books is realized; we believe it to be
; an undecideable proposition.


word 
keywords, dictionary definitions, lexicon definitions

line
find lines containing word, expand word to nearest line containing it

stanza
find stanzas containing word, expand line to its surrounding stanza

page  
I was about to claim that paper cannot link, but that's certainly not true. but a page that has no links is "safe" in some sense
and might want to put its own links at the footer. 
(defprotocol Unit
  (title [ ] "may or may not have a name")
  (ws [ ] "exists in some writespace - better be pm or lf5, slacker")
  (content [ ] "text, sound, image, etc")
  (context [ ] "ooooh")
  (history [ ] "all the history")
  )

