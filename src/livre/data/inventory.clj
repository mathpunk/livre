; {
; data-readers: 
; com.punkmathematics.livre/story    livre.client.story/???
; com.punkmathematics.livre/builder  livre.client.builder/???
; com.punkmathematics.livre/edit     livre.data.facts/???
; }
;
; }
; data-writers:
; #com.punkmathematics.livre/inventory 
; #com.punkmathematics.livre/story
; }

(ns livre.data.inventory
  (:require [clojure.edn :as edn]))

; /configure
(def config (clojure.edn/read-string  (slurp "/home/thomas/src/livre/config.clj") ))

; for reference, the last value of config. dangerous obvsly.
{ 
  :home "/home/thomas/cerebra/wiki"             ; your home is private, obvsly,
                                                ; but you can let who you want in.

  :writespaces ["pm", "lf5", "livre", "alg"]    ; subdirs in home that are for 
                                                ; projectifying
 
  :archives {                                   ; to import things that aren't
                                                ; being developed? or that have
                                                ; record types set up? I dunno.
    :directories [
                    "/home/thomas/cerebra/wiki/wiki-archive/early-pm-wiki"
                  ; "/home/thomas/cerebra/wiki/wiki-archive/wiki-backup"
                  ; "/home/thomas/cerebra/wiki/wiki-archive/vim-wiki"
                  ]
    :twitter nil
    :en nil 
     }
}


; /archive
(defn- dir-thrower [dirname]
  ; /home/thomas/cerebra/wiki
  ; /home/thomas/cerebra/wiki/wiki-archive
  ; write to a file.... with tags?
  ; why tags? 
  (let [values (transform-text-directory-to-values dirname)
        tag "#com.punkmathematics.livre/inventory "
        dir (clojure.java.io/file dirname)
        output-file (str "/home/thomas/src/livre/data/" (.getName dir) ".edn")]

    (spit output-file (mapcat #(str tag %) values))
    
    )
  )

(defn- transform-text-directory-to-values [dirname]
  (let [dir (clojure.java.io/file dirname),
        files (filter #(.isFile %) (file-seq dir))]
      (set (map value-of-a-text-file (remove #(.isHidden %) files)))
    )
  )

(defn- value-of-a-text-file [file]
     {
       :title       (.getName file)
       :ws-path     (.getParent file)
       :ws          (.getName (.getParentFile file))
       :content     (slurp file)
       :history     [{:tx (.lastModified file) :diff nil}]
      }
  )

(defn archive [ ]
  "Take archived directories and home directory + namespaces from config,
  then for each one, do dir-thrower on it, thus generating a bunch of happy
  text files as edn data.
  
  Note: This is suddenly looking super-complex and I wonder if you were trying to
  solve problems w/o knowing it with the Writespace protocol. Look into it."
  (let [; use destructuring instead
        archives (config :archives) :directories,
        home (config :home),
        writespaces (config :writespaces)]
  ; dir-thrower over archives
  ; ws-thrower over writespaces
    ; create writespace-pathnames by stringing them with home
    ; then dir-space them?
  ; dir-thrower over writespace-pathnames
    )
  )


(archive)



(defn read
  )

; TEST
(read "./src/livre/data/sample/all-data-sample.clj")

; /write
;
; /writespaces
;
; NB: I have some ideas, and protocols are supposed to be super great, but I really don't understand what I've written.
; Whether I'm getting it or I'm an elephant painting with my trunk is not so clear. 

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

