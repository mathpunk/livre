Ceci n'est pas un spec?

# theory: text phenomenonomy

## granularity
question: when is words words and when is words thoughts?
  
## symmetry
words
keywords
units
textons
scriptons
designs
  

## text topology
hypertext is a graph
codex text is a tree
writespace text is hypertext with a label layer
script text is linear BUT needs breath to live
game or generative text: ...?
 
  



# copy
What makes text different from copy?

copy has been vetted
copy has context
copy has sources
copy may have quotes
copy may have templated fields like title, hed, pullquotes, etc
copy is trying to be in the form of a "story" with different bits?

## stories
I think it's worth distinguishing 'story' from 'copy' because you can tell when a story is either done or is convincing 
you to come back next time, and because Ward uses the story abstraction, implemented as a list of <p>'s, <img>'s, and
<data> structures. 




# writespaces
In the interest of prototyping from the specific to the general, here are some writespaces I have:

./
  the toplevel of my ./wiki ought to be safe from prying eyes
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


# data
marshalling
  -> from-dir (text)
  schema
  to-edn ->
storage
retrieval
  "connection"

# material

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


- wikis
- clients
  - editors
  - readers

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
    to-crisp morphisms
  

  
# services

get correct permissions to collaborators

github?

db
  dur dur dur
  
http
  i can make a localhost but dunno how to route



# journal

--------------------------------------------------------------
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

