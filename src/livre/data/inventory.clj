
(ns livre.data.inventory
  (:require [clojure.edn :as edn]))

  ; (:use [livre.object-topology]
  

; /configure
(def config (clojure.edn/read-string  (slurp "/home/thomas/src/livre/config.clj") ))

{ 
  ; your home is private, obvsly, but you can let who you want in.
  ; for now, we assume that the home is private and not hoovered up, 
  ; but it's used for the writespace root.
  :home "/home/thomas/cerebra/wiki"             
  ; subdirs in home that are for projectifying
  :writespaces ["pm"] ; "", "lf5", "livre", "alg"]    
 
  :archives {   ; to import things that aren't ; being developed? or that have
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


; notes
; format (or, record)   ; defrecord appears to be what this is for, but it seems pretty repetitive. 
; defn write-on-a-box   ; the text file wants to be read and comprehended by the humans. 
; call-for-work         ; things that lack context want to be given context. 

;; refactoring
(defrecord Units-from-Text-Directories [file]
  Unit
  {
       :title       (.getName file)
       :ws          (.getName (.getParentFile file))
       :ws-path     (.getParent file)
       :content     (slurp file)
       :history     [{:tx (.lastModified file) :diff nil}]
   }
  )

(defrecord Units-that-trust-file-extensions [file]
  Units-from-Text-Directories 
  (let [extension ,,,,,,,,,,,,,,,]
    ["wiki" "md" "txt" "markdown"]
    ["jpg" "png" "gif"]
    )
  )

,,,,,,,,,,,,;;;;;;;;;;;;,,,,,,,,,,,,;;;;;;;;;;;

(defn- value-of-a-text-file [file]
     {
       :title       (.getName file)
       :ws-path     (.getParent file)
       :ws          (.getName (.getParentFile file))
       :content     (slurp file)
       :history     [{:tx (.lastModified file) :diff nil}]
      }
  )

(defn- transform-text-directory-to-values [dirname]
  (let [dir (clojure.java.io/file dirname),
        files (filter #(.isFile %) (file-seq dir))]
      (map value-of-a-text-file (remove #(.isHidden %) files))
    )
  )

(def testdir (first ((config :archives) :directories)))
(transform-text-directory-to-values testdir)


; can you write this as a factory function? 
; what functions would it produce?
; what are the core-functions ("goals") on the deep inside of these bundles?
; how can you ferret out those while still keeping it working?
; bonus: try a pre or post condition

(defn- dir-thrower [dirname]
  (let [values (transform-text-directory-to-values dirname) 
        tag "#com.punkmathematics.livre/inventory "         
        ; whaaaaaaaaaaaaaaaaaaaaaaaaaaaaat??????????????????????????????????????
        dir (clojure.java.io/file dirname)
        ; how many times were you planning on accessing that dir? dir dir dir
        output-file (str "/home/thomas/src/livre/data/" (.getName dir) ".edn")]
        ; this.... yeah. don't laugh it works.
        (map #(spit output-file % :append true) (map #(str tag % "\n") values))
    )
  )

(dir-thrower "/home/thomas/cerebra/wiki/alg")


; this shit is not functional. how much do we care?
; well, the more functional, the more functional-- what is ultimately true about this transformation, i.e., what
; symmetries are actually being broken? 
; 
; for what portions are you not just renaming things ?
;
; how many functions are just because the names are different?

(defn archive [configuration]
  "Take archived directories and home directory + namespaces from config,
  then for each one, do dir-thrower on it, thus generating a bunch of happy
  text files as edn data.
  
  Try it with protocols? No, because protocols are for having multiples, and you are going for simples. Nathan can 
  tell you when it's time to factor toward something like that.
  
  (Did I mention I'd like to see what a magic typewriter would do with a codebase?"

  (let [directories ((config :archives) :directories),
        home (config :home),
        writespaces (config :writespaces)]
    (map (dir-thrower [directories 
    (dir-thrower
    (dir-thrower
  )


(archive)



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
;
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

