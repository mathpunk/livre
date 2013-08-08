(ns data.edn.dir
  (:require [clojure.edn :as edn]))

(def config (clojure.edn/read-string  (slurp "/home/thomas/src/livre/config.clj") ))

(defn value-of-a-text-file [file]
     { 
       :title       (.getName file)
       :ws-path     (.getParent file)
       :ws          (.getName (.getParentFile file))
       :content     (slurp file)
       :history     [{:tx (.lastModified file) :diff nil}]
      }
  )

(defn transform-text-directory-to-values [dirname]
  (let [dir (clojure.java.io/file dirname), 
        files (filter #(.isFile %) (file-seq dir))]
      (set (map value-of-a-text-file (remove #(.isHidden %) files)))
    )
  )

(def all-wiki-data (transform-text-directory-to-values (config :directory)))

(def dead-wiki-data (transform-text-directory-to-values "/home/thomas/cerebra/wiki/wiki-archive"))

(def live-pm-wiki-data (transform-text-directory-to-values "/home/thomas/cerebra/wiki/pm"))

(take 5 all-wiki-data)

(take 5 dead-wiki-data)

(take 5 live-pm-wiki-data)



(spit "./src/livre/data/all-data-sample.clj" (take 5 all-wiki-data))

(spit "./src/livre/data/live-pm-sample.clj" (take 5 live-pm-wiki-data))

(spit "./src/livre/data/cut-pm-sample.clj" (take 5 dead-wiki-data))





(defprotocol Writespace [x]
  "A namespace for text. Like, a book you're working on, a side project, and letter to a circle. You can add whatever you
  like as you're drafting in this space, but they are membraned off from other text that you are working."

    (name [ ]     "Writespaces have a name, like a word or a full title." 
    (abbrev [ ]   "Writespaces may have a short-name for referring to."
)))


;;;;;;;;;; OTHER TRANSFORMATIONS
; = to # to make it more markdowny
; [[xxx ] ] to subtextons or however we're doing pagelinks
; ".wiki" as "look i haven't markdowned this"? nooooo
; some really dumb diffing on very important data
