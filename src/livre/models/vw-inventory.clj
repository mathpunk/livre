(ns inventory.vimwiki)
  
; TRANSFORM INTO DATA STRUCTURES
(def archive "/home/thomas/cerebra/wiki/wiki-archive") ; dead

; Turn File objects into records. Defaults are for vimwiki.
(defn record [file]
  "Return a map with vimwiki defaults set and a unique id."
    {
      ; Generate a unique id before java sees immutable data structures and 
      ; freaks out. 
      ; :_id (ObjectId.)
      :origin "vimwiki"
      :content-type "text"
      :keywords []
      :history [
          { :timestamp (.lastModified file)   ; using modified time as a best guess
            :change "<???>"                   ; what's this for?
          }
        ]
      :content (slurp file)                   ; the full text of the file
      :name  (.getName file)
      :title (.getName file) 
      :path (.getParent file)
    }
  )


; Transform all archive's files into Files (not Directories) and map them.
(defn records [archive]
    (map record 
         (filter #(.isFile %) 
                  (file-seq (clojure.java.io/file archive)))
        )
  )

; OUTPUT (???)
(def output-file "/home/thomas/src/auteur/src/auteur/vw.txt")

; This returns what I'd expect, and what I'd want in the file
(doall (map #(str "#inventory/vimwiki " %) (records archive)))
(count (doall (map #(str "#inventory/vimwiki " %) (records archive))))

; This outputs what I'd expect, to the correct file and everything
(spit output-file (str "#inventory/vimwiki " (first (records archive))))

; But what I can't figure out is how to combine the two to get a file of (records archive). 
;
;


; INVENTORY
(count (records archive))

