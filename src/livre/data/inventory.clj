(ns livre.data.inventory
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
(def testdir "/home/thomas/cerebra/wiki/alg")
(dir-thrower testdir)



; # counter
; UGH now i have to go learn polymorphism

(defn count-units [this] "many")

;   "Communicates with the server to get counts of resources and a last-modified estimate."
;         (common/layout
;           [:div#statistics 
;            [:p "word count: " (str "lots")]
;            [:p "index cards: " (str 142)]
;            [:p "notebook pages: " (str 1686)]
;            [:p "web clippings: " (str "parsing")]
;            ])
;  )




;;;;;;;;;;
;;;;;;;;;;
;;;;;;;;;;
;;;;;;;;;; OTHER TRANSFORMATIONS
; = to # to make it more markdowny
; [[xxx ] ] to subtextons or however we're doing pagelinks
; ".wiki" as "look i haven't markdowned this"? nooooo
; some really dumb diffing on very important data
