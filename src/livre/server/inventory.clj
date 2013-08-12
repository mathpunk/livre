(ns livre.server.inventory
  (:require [clojure.edn :as edn]))

; # thrower
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

(defn dir-thrower [dirname]
  (let [values (transform-text-directory-to-values dirname) 
        tag "#com.punkmathematics.livre/inventory "         
        dir (clojure.java.io/file dirname)
        output-file (str "/home/thomas/src/livre/data/" (.getName dir) ".edn")]
        (map #(spit output-file % :append true) (map #(str tag % "\n") values))
    )
  )

; test
; --------------------------------------------------- 
(def testdir "/home/thomas/cerebra/wiki/alg")
(dir-thrower testdir)
; actually do it
; --------------------------------------------------- 
;  read a config file
;  defn monger
;  monger on text-dir-as-values
;  factor to dir-as-values
;  polymorphism (??)
