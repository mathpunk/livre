; Should be: graphs, lattices, and the like.
; Is: This garbage.
;
(ns livre.structures)



(defprotocol Unit
  (title [ ] "may or may not have a name")
  (ws [ ] "exists in some writespace - better be pm or lf5, slacker")
  (content [ ] "text, sound, image, etc")
  (context [ ] "ooooh")
  (history [ ] "all the history")
  )

(ns livre.object-topology)

(defprotocol Unit
  (title [ ] "may or may not have a name")
  (ws [ ] "exists in some writespace - better be pm or lf5, slacker")
  (content [ ] "text, sound, image, etc")
  (context [ ] "ooooh")
  (history [ ] "all the history")
  )

(defprotocol Writespace [x]
  "A namespace for text. Like, a book you're working on, a side project, and letter to a circle. You can add whatever you
  like as you're drafting in this space, but they are membraned off from other text that you are working.
  
  It ought to be active text. It's the place that is closest to what you want to publish at this time.

  It ought to have notes that can be excluded, but mostly things are excluded by some 'not quite ready' notion. 

  Supposed to be a little more abstract than directories, yet carry forth the same notion of folderishness: a hard tree
  decision has been made, and the thing firms up like a coral."

      (ws [ ]     "Writespaces have a name, like a word or a full title."
      (abbrev [ ]   "Writespaces may have a short-name for referring to."
      (home [ ]     "Where does it keep its inventory? (Who kNOWS how that's being implemented!?"

      )
    )
  )

(defrecord all
  Writespace
  (ws [ ] "all")
  (home [ ] (config :directory))

