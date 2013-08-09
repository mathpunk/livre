(ns livre.views.welcome
  (:require [livre.views.common :as common])
  (:use [noir.core :only [defpage]]
        [livre.data.inventory :as inv]                          ;;;; this is where CG would put Overtone(s)
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

; (defremote count-units [kind]
  ; (inv/count-units kind))
  ; (println "One number you can count to" is (rand)))

; builder
(defpage "/builder" [ ]
  (common/layout
    [:div#builder
     [:p "search and organize resources into stories"]
    ]
    )
  )
