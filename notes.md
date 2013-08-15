# theory: text phenomenonomy

What's it like to be text?

reading: Alien Phenomenology (Bogost), Cybertext (Aarseth)


## granularity

When are words merely words, and when are they thoughts?
  
## symmetry

see Allen Tan's audition.js for a simple example of "rotating" text with sets as degrees of freedom. 

## atoms

words
keywords
units
textons
scriptons
designs
  

## topologys of text

hypertext is a graph
codex text is a tree
writespace text is hypertext with a label layer
script text is linear BUT needs breath to live
game or generative text: ...?
 
  
## godel escher bach

recursive transition networks
multiple levels, smooth and jarring transitions between them
"bottoming out"




# copy
What makes text different from copy?

copy has been vetted
copy has context
copy has sources
copy may have quotes
copy may have templated fields like title, hed, pullquotes, etc
copy is trying to be in the form of a "story" with different bits?

## stories

In the Federated Wiki, the "story" is a thing that is a list of paragraphs, images, and data visualizations. 



# writespaces
  
One writes in different registers, to different audiences, to different standards. Here are 4 of mine:

/pm
  the book i'm working on now
/alg
  the book I'm working on for the future, accidentally
/datam
  a book I am decidedly not working on, but I know what evernote folder I'd source
/briar
  letters and notes for a crypto working group

## reuse
It is possible to use something from one writespace in another, but it should be intellectually honest (the Lehrer
problem) and it should be explicit (correct resolving of hierarchies of entries in a lexicon, for example).

## posting
Something that is "ready" in /briar should be PGP'd and secure-emailed to either a single recipient or the circle of
briar, because to send them things from GMail is professionally embarrassing.


# material

What's been created to date. 
## wiki
A wiki is a convenient way to create hypertext. 

### local wiki
I use a wiki of almost flat files on a local disk. 

### federated wiki
There's all sorts of things to like about Ward's federated wiki. What if we
were to create JSON objects with his "story" and "journal" abstractions and
build on top of that? 

### xikis
What new actions and abstractions will xiki's afford when they become
available and stable in our editors of choice? 



## evernotes
Evernote is the most-built tool for copying disparate types of information
(photographs, text notes, web clippings) and immediately putting them into
categories, adding tags or other context. 

Problems with evernote:
- locked format
- categorization is forced at every clip's creation
- bloated web app

But you go to war with the army you've got, so I have many thousands of these
notes to crack open and get at the gooey data center inside. 

## tweets
Tweets come into my general morguespace in several different ways.

- my own twitter archive, downloadable in batches from twitter.com
- i've saved evernotes of tweets, but from different clients and hence
differently styled, attributed
- twitter favorites
- pinboard robots


# art
## found
flickr

## submitted

## sharpie
  sharpie 'x' as null img
  sharpie as glyph for link
  sharpie diagrams with context

## processing
## background strips
  b&w
  copy machine
  slice

## css




# ui
In approximate order of priority:

## ./tattler
Something that publishes numbers and graphs on my material and my material-dt
concepts: "numbers", "change"

## ./builder
Something for putting words, textons, and art in order.
concepts: "order", "labels"

## ./editor
Make a guess at a story
Afford reordering, editing, deletion
Rank by 'readiness' somehow to get picked up by...

## ./publisher
Call on pandoc to create ebooks, html, pdf, etc. 

## ./minder  [lowest priority]

schedule
mailings
bookings
fulfillment


worktable
results tray
zoom in, zoom out
graph, grid, list

(def $results-words ($ :#results-words))    ; right
(def $table ($ :#results))
(def $results-art ($ :#results-art))        ; left
; # iteration n
; it returns art based on contextual search

# topology

## elementary

sets

lists
- order matters
- first may be a function call

graphs

trees
  inheritance hierarchy
    - "resolve multiple inheritance" as hypertext options
    - counting 'linearizations' of trees, counting hypertexts of trees, counting trees of graphs 
  
measure
  count
  proportion
  fuzzy
    subsethood [k1 k2]
    mutual entropy
    fuzzy-to-crisp morphisms (diffeomorphism)
  
## complex

sets of keywords with fuzzy subsethood defined
graphs weight-neighbored by those sets' pairwise measurements

  


# journal

Sat Aug 10 13:51:56 PDT 2013

current
/home/thomas/src/livre/src/livre/
├── analysis
│   ├── analysis.clj
│   ├── words.clj
│   └── words.txt
├── api.clj
├── client
│   ├── art.clj
│   ├── dashboard.clj
│   ├── main.cljs
│   └── roles.clj
├── config.clj
├── controllers
│   ├── common.clj
│   └── search.clj
├── data
│   ├── data_readers.clj
│   ├── glitch.clj
│   ├── inventory.clj
│   ├── transformations.clj
│   └── util
│       └── diff.clj
├── routes.clj
├── server.clj
├── topology
│   ├── archive_goals.clj
│   ├── objects.clj
│   └── object-topology.clj
├── ui
│   ├── client -> ../client
│   ├── server.clj -> ../server.clj
│   └── views -> ../views
└── views
    ├── common.clj
    └── welcome.clj

what I'm thinking about now is, how can I refactor this directory tree to better represent this notes document I've just 
been working, WITHOUT fucking up a bunch of noir/compojure nonsense that I don't understand? I think by looking a bit
closer at the projects.clj file...

livre.server.authentication

livre.topology.atomic
- work out multi/protocol on cards to learn the desired inheritance tree
livre.topology.structure

livre.client.main*
livre.client.tattler
livre.client.builder
livre.client.editor

# old notes

some may have some utility, i guess?

analysis/analysis.clj
;; looking for and handling aliases
(ns livre.copy.aliases)

(def known-aliases
  #{
    #"<<.+>>",
    #"((.+))",
    #"^---",
    "see also: 'sigils' files" }
  )


(ns livre.copy.hierarchy)
;; We know that textons are a directed graph, not a tree.
;; However, since it's so simple to turn a linear (scroll) document into an outline,
;; we propose that the tree structure is a useful "local understanding" structure for writing.
;;
;; Here, the goal will be to
;;   change bad markdown (vimwiki 'equals' syntax)
;;   find top-level headings and their body
;;   find nth-level headings and their body
;;   build a data structure
;;   "qualify the namespace" with the name of the file plus these hierarchical words and phrases


;; managing resources

(ns livre.material.morgue)
;; there are notebook names, which (kind of) relate to project/workspace/namespaces
;; there are tags to count up
;; there are short urls to correct
;; there is faceting to do--
;;   by date
;;   by twitter-user
;;   by full text search
;;   by tag
## analysis/words.clj
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



## art.clj
(ns livre.art.flickr)

;; Given a word, grab a CC image result from Flickr

;; key:
;; 75ad122e2302dcd7b618ac038a28c672
;; Secret:
;; d79b91067ba66bef

;; search photos by criteria, including tags, and with some fanciness, geo
;; http://www.flickr.com/services/api/flickr.photos.search.html

;; interestingness list
;; http://www.flickr.com/services/api/flickr.interestingness.getList.html

(ns livre.art.inhouse)

;; Find camera images by tags
;; Find scan images by tags or transcription
## statistics/accounting

(ns livre.accounting.statistics)
;; turn material into counts of material
;; display counts, textually or graphically


;; word count
;; material count
;;   cards
;;   pages
;;   references
;;   books
;;     isbns
;;   keywords


(ns livre.accounting.beeminder)
;; interact with beeminder api
;; demonstrate that you're on track somehow... code, wordcount, editing, materials, ????


(ns livre.accounting.iterations)
;; dunno, but
;; it seems like a good idea to have goals for iterations in mind
;; and if you write something too early, to have it know that it can wait another couple weeks
;; but i dunno if this is at the right abstraction level
;; and also it's weird

.
├── api.clj
├── client
│   └── main.cljs
├── config.clj
├── controllers
│   ├── common.clj
│   └── search.clj
├── data
│   ├── data_readers.clj
│   ├── glitch.clj
│   ├── inventory.clj
│   ├── transformations.clj
│   └── util
├── routes.clj
├── server.clj
├── topology
│   ├── archive_goals.clj
│   ├── objects.clj
│   └── object-topology.clj
├── ui
│   ├── client -> ../client
│   ├── server.clj -> ../server.clj
│   └── views -> ../views
└── views
    ├── common.clj
    └── welcome.clj

9 directories, 17 files



## data-readers

The reason for is that they allow for data to be delivered to a clever function to do stuff to it right 
when it arrives, before it even hits the compiler. 

The reason against is, the only thing I can think of right now is passing that thing along as a value. But, 
with some thought to semantics, and some working functions, I bet I can think of something useful to do
as a datom comes in. 


{ 
; data-readers: 
; com.punkmathematics.livre/story    livre.client.story/???
; com.punkmathematics.livre/builder  livre.client.builder/???
; com.punkmathematics.livre/edit     livre.data.facts/???
;
; data-writers:
; com.punkmathematics.livre/inventory 
; com.punkmathematics.livre/story
 }




; relevant docs:
;   *data-readers*

; When Clojure starts, it searches for files named 'data_readers.clj'
; at the root of the classpath. Each such file must contain a literal
; map of symbols, like this:
;
;     {foo/bar my.project.foo/bar
;      foo/baz my.project/baz}
;
; The first symbol in each pair is a tag that will be recognized by
; the Clojure reader. The second symbol in the pair is the
; fully-qualified name of a Var which will be invoked by the reader to
; parse the form following the tag. For example, given the
; data_readers.clj file above, the Clojure reader would parse this
; form:
;
;     #foo/bar [1 2 3]
;
; by invoking the Var #'my.project.foo/bar on the vector [1 2 3]. The
; data reader function is invoked on the form AFTER it has been read
; as a normal Clojure data structure by the reader.
;
; Reader tags without namespace qualifiers are reserved for
; Clojure. Default reader tags are defined in
; clojure.core/default-data-readers but may be overridden in
; data_readers.clj or by rebinding this Var.
