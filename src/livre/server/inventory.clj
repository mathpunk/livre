(ns livre.server.inventory
  (:require [clojure.edn :as edn]))

; # thrower
(defn- value-of-a-text-file [file]
     {
       :title       (.getName file)
       :path     (.getParent file)
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

(defn tagged-value-of-a-directory [dirname]
  (let [values (transform-text-directory-to-values dirname) 
        tag "#com.punkmathematics.livre/inventory "]
    (map #(str tag % "\n") values))
  )

; works

(defn local-dir-to-local-edn [dirname] 
    (let [data (tagged-value-of-a-directory dirname)]
      (spit (clojure.java.io/file "/home/thomas/src/livre/data/test.edn") data)
     )
  )

; used to work
          
(local-dir-to-local-edn text-test-dir)


; test
; --------------------------------------------------- 
(def full-test-dir "/home/thomas/src/livre/material/")
(def text-test-file "/home/thomas/src/livre/material/vimwiki/big-picture.wiki")
(def text-test-dir "/home/thomas/src/livre/material/vimwiki")

(dir-thrower text-test-dir)

; actually do it
; --------------------------------------------------- 
;  read a config file
;  defn monger
;  monger on text-dir-as-values
;  factor to dir-as-values
;  polymorphism (??)
