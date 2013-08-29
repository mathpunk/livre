(ns livre.views.welcome
  (:require [livre.views.common :as common])
  (:use [noir.core :only [defpage]]
        [livre.models.archives :as archives]                          ;;;; this is where CG would put Overtone(s)
        [noir.fetch.remotes :only [defremote]]))


; landing page
(defpage "/" []
         (common/layout
           [:p "the PM bookserver"]))

; statistics
(defpage "/statistics" []
  "Present counts of resources and a last-modified estimate."
        (common/layout
          [:div#statistics 
            [:p "word count: " (str "lots")]
            [:p "index cards: " (str 142)]
            [:p "notebook pages: " (str 1686)]
            [:p "web clippings: " (str "parsing")]
           ]
          )
  )

(defpage "/structure" []
        (common/layout
          [:div#canvas]

          )
  )

; builder
(defpage "/builder" [ ]
  (common/layout
    [:div#builder
     [:p "search and organize resources into stories"]
    ]
    )
  )
