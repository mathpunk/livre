(ns livre.models.content-inventory.inventory
  (:require [clojure.edn :as edn]))

(defn local-dir-to-local-edn [dirname output-name] 
    (let [data (tagged-value-of-a-directory dirname)
          output (clojure.java.io/file output-name)]
      (map #(spit output % :append true) data)
     )
  )

(local-dir-to-local-edn text-test-dir "/home/thomas/src/livre/data/test.edn")
; (defn- tagged-value-of-a-directory [dirname]
;   (let [values (text-directory-as-values dirname) 
 ;        tag "#com.punkmathematics.livre/inventory "]
  ;   (map #(str tag % "\n") values))
  ; )
