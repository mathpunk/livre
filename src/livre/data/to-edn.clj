(ns data.edn.dir
  (:require [clojure.edn :as edn]))

(def config (clojure.edn/read-string  (slurp "/home/thomas/src/livre/config.clj") ))

; k back to doing things
(defn value-of-a-text-file [file]
     { 
       :title       (.getName file)
       :ws-path     (.getParent file)
       :ws          (.getName :ws-path)
       :content     (slurp file)
       :history     [{:tx (.lastModified file) :diff nil}]
      }
  )

(def transform-text-directory-to-values
  (let [dir (clojure.java.io/file (config :directory)), 
        files (filter #(.isFile %) (file-seq dir))]
      (set (map value-of-a-text-file files))
    )
  )


(def dead-wiki "/home/thomas/cerebra/wiki/wiki-archive") 
(def live-pm-wiki "/home/thomas/cerebra/wiki/pm")
(defprotocol Writespace [x]
  "A namespace for text. Like, a book you're working on, a side project, and letter to a circle. You can add whatever you
  like as you're drafting in this space, but they are membraned off from other text that you are working."

    (name [ ]     "Writespaces have a name, like a word or a full title." 
    (abbrev [ ]   "Writespaces may have a short-name for referring to."
)))
