(ns livre.views.welcome
  (:require [livre.views.common :as common])
  (:use [noir.core :only [defpage]]
        [noir.fetch.remotes :only [defremote]]))

; landing page
(defpage "/" []
         (common/layout
           [:p "the PM bookserver"]))

; statistics
(defpage "/statistics" []
  "Communicates with the server to get counts of resources and a last-modified estimate."
        (common/layout
          [:div#statistics 
            [:p "word count: " (str "lots")]
            [:p "index cards: " (str 142)]
            [:p "notebook pages: " (str 1686)]
            [:p "web clippings: " (str "parsing")]
           ]
          )
  )

(defremote count-something [n]
  (println "One number you can count to is" n))


; builder
(defpage "/builder" [ ]
  (common/layout
    [:div#builder
     [:p "search and organize resources into stories"]
    ]
    )
  )
