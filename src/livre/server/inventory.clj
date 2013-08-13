; I've been instructed not to care too much about databases. So, these functions just
; take some data and write it as a text file in the extended data notation (edn),
; specified here: https://github.com/edn-format/edn
; 
; For more database-y things, see src/livre/src/livre/server/storage.clj. Which is probably empty.
; --th
;
;
; todo: 
; * should be able to handle img files too. instead of content, record a uri for the server to use. 
; * should suck less


(ns livre.server.inventory
  (:require [clojure.edn :as edn]))

(defn- value-of-a-text-file [file]
     {
       :title       (.getName file)
       :path     (.getParent file)
       :ws          (.getName (.getParentFile file))
       :content     (slurp file)
       :history     [{:tx (.lastModified file) :diff nil}]
      }
  )

; value-of-an-image-file's differences:
; :title nil
; :ws nil
; :content {:uri blah} ?
;

(defn- transform-text-directory-to-values [dirname]
  (let [dir (clojure.java.io/file dirname),
        files (filter #(.isFile %) (file-seq dir))]
      (map value-of-a-text-file (remove #(.isHidden %) files))
    )
  )

(defn- tagged-value-of-a-directory [dirname]
  (let [values (transform-text-directory-to-values dirname) 
        tag "#com.punkmathematics.livre/inventory "]
    (map #(str tag % "\n") values))
  )

(defn local-dir-to-local-edn [dirname output-name] 
    (let [data (tagged-value-of-a-directory dirname)
          output (clojure.java.io/file output-name)]
      (map #(spit output % :append true) data)
     )
  )



; testing
; --------------------------------------------------- 
(def full-test-dir "/home/thomas/src/livre/material/")
(def text-test-file "/home/thomas/src/livre/material/vimwiki/big-picture.wiki")
(def text-test-dir "/home/thomas/src/livre/material/vimwiki")

(local-dir-to-local-edn text-test-dir "/home/thomas/src/livre/data/test.edn")
