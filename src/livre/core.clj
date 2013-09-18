(ns livre.core
  (require [monger.collection :as m] [monger.query :as q])
  (use [livre.db :only [connect rebase-articles articles]])
  )

;; Rebase my Punk Mathematics wiki
(defn rebase-wiki [ ]
  (let [pm "/home/thomas/src/livre/material/wiki"]
    (do
      (connect)
      (rebase-articles pm))
    )
  )

; (rebase-wiki)
; (defn test-rebase [ ]
;   (first (m/find-maps "articles")))
; (test-rebase)
