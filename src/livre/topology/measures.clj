
; # counter
; (def measure nil)
; (def counter nil)
; "Should dispatch on units with types -- words, files, unique words, scans, pages, cards,
; research items." 
;



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
