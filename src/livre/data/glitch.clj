(ns livre.data.inventory
  (:require [clojure.edn :as edn]))

; /configure
(def config (clojure.edn/read-string  (slurp "/home/thomas/src/livre/config.clj") ))


; /archive
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
      (set (map value-of-a-text-file (remove #(.isHidden %) files)))
    )
  )

(defn- dir-thrower [dirname]
  ; write to a file.... with tags?
  ; why tags? 
  (let [values (transform-text-directory-to-values dirname)
        tag "#com.punkmathematics.livre/inventory "
        dir (clojure.java.io/file dirname)
        output-file (str "/home/thomas/src/livre/data/" (.getName dir) ".edn")]
      (println (mapcat #(str tag %) values))
    )
  )


(dir-thrower (first ((config :archives) :directories)))
