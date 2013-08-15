# material

What I've got to contextualize and use. 

## Types

### words
  is a keyword?
  is made-up?
  is uncommon?
  has an entry on Mathworld?
  appears in the context for a book?


### text
  has outlinks?
  is lexicon entry?
  is plagiarised?
  has a rad title?
  has a dumb title?
  has weird sigils?

        [ # ; tagged/in a hierarchy,
          ? ; help on word? get words?
          = ; word statistics? measure, size, count,...
          ! ; get them all
          & ; associations and bisociations
          * ; permute among a class
          #{} ; audition
          @ ; contact, guest, quote?
          $ ; cite, attribute, syndicate?
        ]
        
#### wiki
A wiki is a convenient way to create hypertext. 

##### local wiki
I use a wiki of almost flat files on a local disk. 

##### federated wiki
There's all sorts of things to like about Ward's federated wiki. What if we
were to create JSON objects with his "story" and "journal" abstractions and
build on top of that? 

##### xikis
What new actions and abstractions will xiki's afford when they become
available and stable in our editors of choice? 



### structured text
  bibtex struct? 
    from isbn to bibtex struct
  en struct?
  tw struct?
  other struct?
    list keys
    
#### evernotes
Evernote is the most-built tool for copying disparate types of information
(photographs, text notes, web clippings) and immediately putting them into
categories, adding tags or other context. 

Problems with evernote:
- locked format
- categorization is forced at every clip's creation
- bloated web app

But you go to war with the army you've got, so I have many thousands of these
notes to crack open and get at the gooey data center inside. 


#### tweets
Tweets come into my general morguespace in several different ways.

- my own twitter archive, downloadable in batches from twitter.com
- i've saved evernotes of tweets, but from different clients and hence
differently styled, attributed
- twitter favorites
- pinboard robots





### images
  card v scan, do i care? kind of 
  photos
  transcription?
  text v. diagram
  orientation
  turk control
  
## queueing

??????????????????






# server

keeping track of inventory and scheduling

## livre/inventory

Tools for auditing what I've got and throwing it at the database for reuse and high weirdness.

Functions:

count
  wc
  kw (draw this, you're missing the maps)
    from en
    from above (op?)
  en, unprocessed
  img, unprocessed
    card
    page
    photo








### the content inventory

Erin Kissane, Elements of Content Strategy--
  
            Before we go much further, we need to discover what con-
          tent already exists; this step is often called a quantitative
          audit or content inventory. The web is full of useful advice
          on conducting content audits, so I’ll stick to a brief summary.
          Essentially, you’re going to create an extremely detailed site
          map that represents every page and other piece of content
          on the website you are working with, along with every other
          piece of existing content that may end up on the site, but that
          currently lives elsewhere.

          For each piece of content, an inventory generally lists a:
          • title,
          • format (standard text, video, PDF, etc.),
          • URL or other location,
          • content type (landing page, article, support page, contact
          page, etc.), and
          • "owner" (person responsible for upkeep).



### data
* What data do I have?

[ ] wiki files
  early-pm-wiki
  live wiki
  is there additional footage, early drafts, etc?

[ ] attributed-entity archives
  en
  tw

[ ] coming soon: images
  probably using prototypes or multis but don't sweat those details yet

* Data formats, streams, concepts: a small tree

marshalling
  -> from-dir (text)
  schema
  to-edn ->
storage
retrieval
  "connection"



### statistics
goal: To give the content elements some count or measure as a proxy for the review and merges of the editing process,
so that there's some sort of accounting in place. 
  
it might be nice to have exercises, questions, challenges, see-alsos, etc., counted, but for now I only have:

words
cards
pages

and want to have 
en's


[x] static statistics 
  we did a manual count for the last update

[ ] live statistics
  TODO

future
  d3?
  c2?


### storage

Tools to abstract storage away so I can think of my data as values instead of a flux of bits.

[x] edn/text
  I can throw data at a file in edn format right now. 

[ ] mongo
  requires a vpn or tunnel
  Nathan's on it




## "numbers"

Something that publishes numbers and graphs on my material and my material-dt
concepts: "numbers", "change".

It tries to make those numbers go down by shaming the author and getting them to 
put in a lot of time working in...

## "order"

Something for putting interest, correctness, and time ordering on textons and art.
concepts: "order", "labels"

Rank by interestingness somehow to get picked up by...

## "transformation"

Where to edit text. Local lighttable and federation otherwise? We just can't say.

Make a guess at a story
Afford reordering, editing, deletion
Rank by 'readiness' somehow to get picked up by...

## ./publisher

Call on pandoc to create ebooks, html, pdf, etc. 

It is getting yelled at by...

## ./minder  [lowest priority]

schedules to keep 
mailings to send
bookings to make and keep
fulfillment schedule




## minder

mailing list
  mailgun? excel?
  http://documentation.mailgun.com/


## authentication

I do want users at some point. ????????
  
# client & views
  
doing and showing work.

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


## numbers/statistics: tattler
  word count (raw)
  clippings
  pages
  cards
  
### future?: api beeminder
"For task tracking. See also 'accountability'"
https://www.beeminder.com/api

## feature creep/targeting other platforms
federated wiki
lighttable

  







## ordering/partial-ordure: buildure
worktable
results tray
zoom in, zoom out
graph, grid, list

(def $results-words ($ :#results-words))    ; right
(def $table ($ :#results))
(def $results-art ($ :#results-art))        ; left
; # iteration n
; it returns art based on contextual search


### Edit Tags
### Edit Queries

display the unit
display the unit's keywords in the keyword text area
display controls and list their hotkeys
rankings
  (contrast-pair interesting-up, garbage-down)      ; interest layer
  (contrast-pair early-up, later-down)              ; narrative layer
next/random
use a tag for sequence-- seq


## editeur

hoping to turn our data into "stories" with "journals" so as to reuse Ward's stuff. 


[[clojurescript]]
the user makes a query.
the query is saved as a fact. 
the query's results are displayed in an abbreviated list.
the list items can be expanded.
an item can be dragged into the copy area. 
in this way, items are merged.... "save as a merge"?
so when things are merged, they save some facts about where they came from...
...possibly in the same abstraction, a bit of copy knows that it's been referencing some work or another, 
  and adds it to the works cited data about the unit of copy that is developing 
  
  nb: vague as shit



Edit Copy
Edit Photo

# text topology

Some speculative mathematics. 

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

  



the other fun stuff.

atoms
partial orders
trees
graphs
grids
sequences

measures
  inventory-count
  count-keyword-uses
  
fit vectors
  probability-used
  early
    -late
  interesting
    -obscure
  ready
    -review

fit topology
  fuzzy subsethood
  fuzzy equality
  fuzzy mutual entropy (between what sort of object?)

graph topology
  u~v iff (intersect k(u), k(v) )
  
metrics, norms, distances
  what's the difference? is there one? normed vector spaces, positive semidefinite, fuzzy union, fuzzy intersection,

hypergraphs
  words
  keywords

partial orders
  word-cover
  precedes
  
bag-of-words
  words
    etymology
    frequency-analysis
    part-of-speech
    made-up-words
    interesting-words
    hierarchical-words
      #
      ##
      etc

surprise
  it's an information-theoretic concept that i want to develop

vectors
  distance is a well-used metric for viz's one would think
  but you're still looking for metric inputs in libraries
  fuzzy subsethood

## notes

### spaces

Classical spaces. 

#### topological spaces

#### categorical spaces

#### lattice space

#### textspaces

A more speculative space of spaces*, but still just ordinary sets and topologies with 


                                                                          the addition of words + explicit links:
                                        WARNING CONTAINS EXPLICIT CONTEXT



*(Species of spaces, George Perec -> isbn)





sets
  of words
  filter set by does it have rad interesting wordz

modules
ranking keywords 
  z-module: counts of discrete properties and behaviors
  r-module: fuzzy measures, proportions

lists
- order matters
- first may be a function call

graphs

trees
;; We propose that the tree structure is a useful "local understanding" structure for writing, even if the
;; actual data structure is more like a totally gnarly bidirectional graph that looks like spaghetti and C'thulhu 
;; had a baby who they loved, raised, and sent to the Institute of Knitting Abominations.
;;
  inheritance hierarchy
    - "resolve multiple inheritance" as hypertext options
    - counting 'linearizations' of trees, counting hypertexts of trees, counting trees of graphs 

#### measure spaces

measure
  count
  proportion
  fuzzy
    subsethood [k1 k2]
    mutual entropy
    to-crisp morphisms

#### statistics/accounting

I realize that this is getting toward a dangerously applicable area of mathematics for you, Tom, but in order to 
drive home your ideas, you might want to consider applying data science to your own life, i.e., to better quantify
the precise degree to which you are a bum.


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

#### actuarial

i have nothing in particular, it just seems to follow right after accounting and right before casino theorist which
ranks right before ^#^&$#&^&^.

ex: create a procedure for taking a string from the shift-top of the keyboard and convert it to crowd-sourced swears of
an appropriate level of transgression. 


# text phenomenonomy

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




## copy

What makes copy different from mere text?

copy has been vetted
copy has context
copy has sources
copy may have quotes
copy may have templated fields like title, hed, pullquotes, etc
copy is trying to be in the form of a "story" with different bits?

## stories

In the Federated Wiki, the "story" is a thing that is a list of paragraphs, images, and data visualizations. 



## writespaces
  
One writes in different registers, to different audiences, to different standards. Here are 4 of mine:

/pm
  the book i'm working on now
/alg
  the book I'm working on for the future, accidentally
/datam
  a book I am decidedly not working on, but I know what evernote folder I'd source
/briar
  letters and notes for a crypto working group

### reuse
It is possible to use something from one writespace in another, but it should be intellectually honest (the Lehrer
problem) and it should be explicit (correct resolving of hierarchies of entries in a lexicon, for example).

### posting
Something that is "ready" in /briar should be PGP'd and secure-emailed to either a single recipient or the circle of
briar, because to send them things from GMail is professionally embarrassing.



# specific problems to solve

## weird alias problem
prob: i used all these weird aliases as I was writing and I'd invent a meaning for them in my mind on the fly without writing it down. 
  you might say , it was as though i were working in too large an alphabet - extended by (( ?? !! and so forth.

(ns livre.copy.aliases)

(def known-aliases
  #{
    #"<<.+>>",
    #"((.+))",
    #"^---",
    "see also: 'sigils' files" }
  )

search for: paired punctuation, e.g. add to post,

   *(Species of spaces, George Perec -> isbn)





## the weird markdown problem
;;   change bad markdown (vimwiki 'equals' syntax)

## converting markdown to hierarchies
;;   find top-level headings and their body
;;   find nth-level headings and their body
;;   build a data structure
;;   "qualify the namespace" with the name of the file plus these hierarchical words and phrases

## link up hierarchies to namespaces of material

(ns livre.material.morgue)
;; there are notebook names, which (kind of) relate to project/workspace/namespaces
;; there are tags to count up
;; there are short urls to correct
;; there is faceting to do--
;;   by date
;;   by twitter-user
;;   by full text search
;;   by tag


# analysis

## working with words

Litanies and Table of Contents
top keywords
brief contents
unbrief contents
Wordnik?

?????????analysis/words.clj
;; word functions
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


## notes

art.clj
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





# collaboration

I have a lot of emails to write. 

professors
  golan
  bogost
  harriss

friends 
  nathan
  jeme
  eric

new friends
  leto





# tricky stuff

## data-readers

The reason for is that they allow for data to be delivered to a clever function to do stuff to it right 
when it arrives, before it even hits the compiler. 

The reason against is, the only thing I can think of right now is passing that thing along as a value. But, 
with some thought to semantics, and some working functions, I bet I can think of something useful to do
as a datom comes in. 

nevertheless, for now it's a complication.

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



# questionable notes, with likely repetition

i must say: why do we need to have revisions noticed to notice that we've been making revisions? isn't it primarily a
problem of surprise, which itself is a problem of entropy, which itself is a problem of information, which is itself a
problem of data collection and translation?


## livre/inventory

Tools for auditing what I've got and throwing it at the database for reuse and high weirdness.

Erin Kissane, Elements of Content Strategy--
  
            Before we go much further, we need to discover what con-
          tent already exists; this step is often called a quantitative
          audit or content inventory. The web is full of useful advice
          on conducting content audits, so I’ll stick to a brief summary.
          Essentially, you’re going to create an extremely detailed site
          map that represents every page and other piece of content
          on the website you are working with, along with every other
          piece of existing content that may end up on the site, but that
          currently lives elsewhere.

          For each piece of content, an inventory generally lists a:
          • title,
          • format (standard text, video, PDF, etc.),
          • URL or other location,
          • content type (landing page, article, support page, contact
          page, etc.), and
          • "owner" (person responsible for upkeep).



### data
* What data do I have?

[ ] wiki files
  early-pm-wiki
  live wiki
  is there additional footage, early drafts, etc?

[ ] attributed-entity archives
  en
  tw

[ ] coming soon: images
  probably using prototypes or multis but don't sweat those details yet

* Data formats, streams, concepts: a small tree

marshalling
  -> from-dir (text)
  schema
  to-edn ->
storage
retrieval
  "connection"



### statistics
goal: To give the content elements some count or measure as a proxy for the review and merges of the editing process,
so that there's some sort of accounting in place. 
  
it might be nice to have exercises, questions, challenges, see-alsos, etc., counted, but for now I only have:

words
cards
pages

and want to have 
en's


[x] static statistics 
  we did a manual count for the last update

[ ] live statistics
  TODO

future
  d3?
  c2?


### storage

Tools to abstract storage away so I can think of my data as values instead of a flux of bits.

[x] edn/text
  I can throw data at a file in edn format right now. 

[ ] mongo
  requires a vpn or tunnel
  Nathan's on it

## livre/topology

the other fun stuff.

atoms
partial orders
trees
graphs
grids
sequences

measures
  inventory-count
  count-keyword-uses
  
fit vectors
  probability-used
  early
    -late
  interesting
    -obscure
  ready
    -review

fit topology
  fuzzy subsethood
  fuzzy equality
  fuzzy mutual entropy (between what sort of object?)

graph topology
  u~v iff (intersect k(u), k(v) )
  
metrics, norms, distances
  what's the difference? is there one? normed vector spaces, positive semidefinite, fuzzy union, fuzzy intersection,

hypergraphs
  words
  keywords

partial orders
  word-cover
  precedes
  
bag-of-words
  words
    etymology
    frequency-analysis
    part-of-speech
    made-up-words
    interesting-words
    hierarchical-words
      #
      ##
      etc

surprise
  it's an information-theoretic concept that i want to develop

vectors
  distance is a well-used metric for viz's one would think
  but you're still looking for metric inputs in libraries
  fuzzy subsethood


## livre/ui

the fun stuff
### numbers/statistics: tattler
  word count (raw)
  clippings
  pages
  cards
  
### future?: api beeminder
"For task tracking. See also 'accountability'"
https://www.beeminder.com/api

### ordering/partial-ordure: builder
display the unit
display the unit's keywords in the keyword text area
display controls and list their hotkeys
rankings
  (contrast-pair interesting-up, garbage-down)      ; interest layer
  (contrast-pair early-up, later-down)              ; narrative layer
next/random
use a tag for sequence-- seq


### editor
hoping to turn our data into "stories" with "journals" so as to reuse Ward's stuff. 


[[clojurescript]]
the user makes a query.
the query is saved as a fact. 
the query's results are displayed in an abbreviated list.
the list items can be expanded.
an item can be dragged into the copy area. 
in this way, items are merged.... "save as a merge"?
so when things are merged, they save some facts about where they came from...
...possibly in the same abstraction, a bit of copy knows that it's been referencing some work or another, 
  and adds it to the works cited data about the unit of copy that is developing 
  
  nb: vague as shit


### feature creep/targeting other platforms
federated wiki
lighttable

  






## architecture

dir dur dir
- livre.server.inventory
- livre.server.storage
- livre.math.topology
- livre.text.queries

## ordure
### Up Down Left Right


## archives

### directories
I have to actually pull the trigger, but I have code which turns a wiki directory into a clj data structure,
labeled for use by a clojure reader. 

### eversuck
Evernote is a great way to clip data and then never get it out again. 

I'm expecting that I'll be able to query the notes for the usual suspects:
  time
  url
  tags

Also, Evernotes have several text fields with different names, and sometimes they include the full text of a page. I'm not
sure what they're all called, but something like

  title
  contents
  description
  comments

Any other fields they have, I don't know that I care about. 

Why not write something that looks at all the keys?



## words

### lexicon
Etymologies and definitions are fine defaults, but if you've got something written in your personal or project lexicon, that's better. 

### wordnik: dictionary and etymology 
(def my-wordnik-key "fe13b068fae9104fa90000d481c035c96157a13f3ca6f2ef9")
(def wordnik-base-url "http://developer.wordnik.com/v4" )
(def api-key-uri (str "&api_key=" my-wordnik-key))

(defn wordnik-request [name word]                                     ; should be, like, define api call?
  (str wordnik-base-url name api-key-uri))

#### api calls of interest
/word.json/{word}/definitions
/word.json/{word}/topExample
/word.json/{word}/relatedWords
/word.json/{word}/etymologies

There are quite a few parameters, and I'm not immediately sure how I want to approach setting defaults and overriding those defaults. 

## books & citations

and bibliography, and affiliate linking, and microcredit and and and

### com.goodreads

goodreads: no more than 1/s
http://www.goodreads.com/api
does all kinds of shit from an isbn-- that's the way to go, man, mad data yo

  Here is your developer key for using the Goodreads API. This key must be appended to every request using the form
  variable 'key'. (If you're using our write API, you'll need your secret too.)

  key: f2op8GfT53nPHmjfzdaWgQ
  secret: WaJh53LDppFliIVPoczU3DypVg6o7K6BbC0GPPcA

api:

* Get the Goodreads book ID given an ISBN. Response contains the ID without any markup.
URL: http://www.goodreads.com/book/isbn_to_id    (sample url)
HTTP method: GET
Parameters:

    key: Developer key (required).
    isbn: The ISBN of the book to lookup.

* Get the reviews for a book given an ISBN
Get an xml or json file that contains embed code for the iframe reviews widget that shows excerpts (first 300 characters) of the most popular reviews of a book for a given ISBN. The reviews are from all known editions of the book.
URL: http://www.goodreads.com/book/isbn?format=FORMAT&isbn=ISBN    (sample url)
HTTP method: GET
Parameters:

    format: xml or json
    callback: function to wrap JSON response if format=json

    key: Developer key (required only for XML).

    user_id: 22312744 (required only for JSON)

    isbn: The ISBN of the book to lookup.

    rating: Show only reviews with a particular rating (optional)


Example code for using json with callback:

            <script type="text/javascript">
            function myCallback(result) {
              alert('nb of reviews for book: ' + result.reviews.length);
            }
            var scriptTag = document.createElement('script');
            scriptTag.src = "http://www.goodreads.com/book/isbn?callback=myCallback&format=json&isbn=0441172717&user_id=22312744";
            document.getElementsByTagName('head')[0].appendChild(scriptTag);
            </script>
 
* Get an xml file that contains the review and rating
URL: http://www.goodreads.com/review/show.xml    (sample url)
HTTP method: GET
Parameters:

    key: Developer key (required).

    id: id of the review

    page: 1-N. The page number of comments. (default 1, optional)

* Find books by title, author, or ISBN
Get an xml file with the most popular books for the given query. This will search all books in the title/author/ISBN fields and show matches, sorted by popularity on Goodreads. There will be cases where a result is shown on the Goodreads site, but not through the API. This happens when the result is an Amazon-only edition and we have to honor Amazon's terms of service.
URL: http://www.goodreads.com/search.xml    (sample url)
HTTP method: GET
Parameters:

    q: The query text to match against book title, author, and ISBN fields. Supports boolean operators and phrase searching.

    page: Which page to return (default 1, optional)

    key: Developer key (required).

    search[field]: Field to search, one of 'title', 'author', or 'genre' (default is 'all')

### org.isbn

using the Good Reads isbn
by ISBN: http://www.goodreads.com/book/isbn/0590353403

### com.powells

(defn powells-affiliate-link [isbn]
  (let [:my-powells-id 36733]
    (str "http://www.powells.com/biblio/" isbn "?p_isbn&PID=" :my-powells-id)))



#### the 'fact' model
an observed contradiction--
  accountants don't use erasers
  the need to eliminate the vast majority of what i've written

## dynamics :super mathematics

fuzzy cognitive maps (FCMs)
fuzzy rules (fuzzifying if-then statements)



  topology
    keywords
    fuzzy
    up-and-down
      interest
      section
      flow
    graph
  words
    api calls
  phrases
    sequencing
  weird
    plasmids
    garbage

## solving problems

### weird alias problem
prob: i used all these weird aliases as I was writing and I'd invent a meaning for them in my mind on the fly without writing it down. 
  you might say , it was as though i were working in too large an alphabet - extended by (( ?? !! and so forth.

(ns livre.copy.aliases)

(def known-aliases
  #{
    #"<<.+>>",
    #"((.+))",
    #"^---",
    "see also: 'sigils' files" }
  )

search for: paired punctuation, e.g. add to post,

   *(Species of spaces, George Perec -> isbn)




## possible refactoring

from Sat Aug 10 13:51:56 PDT 2013:
$ l
current
/home/thomas/src/livre/src/livre/
[redacted an outofdate dirtree]

what I'm thinking about now is, how can I refactor this directory tree to better represent this notes document I've just 
been working, WITHOUT fucking up a bunch of noir/compojure nonsense that I don't understand? I think by looking a bit
closer at the projects.clj file...

livre.server.server*        ; change ./project.clj
livre.server.inventory*
livre.server.storage
livre.server.authentication

livre.topology.atomic
livre.topology.structure
- work out multi/protocol on cards to learn the desired inheritance tree

livre.client.main*
livre.client.tattler
livre.client.builder
livre.client.editor



## scrap code

probably repetition

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

analysis/words.clj
;; word functions
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



art.clj
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




statistics/accounting

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



data-readers

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
; test data

; vimwiki (bad)
= blah =
find #"^=+\s\w"

; vimwiki (good)

; en

; tw

; images
;   photos
;   pages
;   cards



## old notes

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
### analysis/words.clj
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



### art.clj
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
### statistics/accounting

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



### data-readers

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
