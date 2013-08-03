; TRANSFORM INTO DATA STRUCTURES
(def archive "/home/thomas/cerebra/wiki/wiki-archive") ; dead

; Transform all archive's files into Files (not Directories) and map them.
(defn records [archive]
    (map record 
         (filter #(.isFile %) 
                  (file-seq (clojure.java.io/file archive)))
        )
  )

