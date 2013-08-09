(ns livre.views.welcome
  (:require [livre.views.common :as common])
  (:use [noir.core :only [defpage]]
        [noir.fetch.remotes :only [defremote]]))

(defpage "/" []
         (common/layout
           [:p "Welcome to livre"]))

(defpage "/statistics" []
  "Communicates with the server to get a lastModified value and counts."
         (common/layout
           [:div#statistics 
            [:p "word count: " (str 455251)]
            [:p "index cards: " (str 1142)]
            [:p "notebook pages: " (str 1686)]
            [:p "web clippings: " (str "parsing")]
           ]
           [:div#graph
            
           ]
          ))

;; buttons and such
(defpage "/builder" [ ]
  (common/layout
    [:div#controls
     [:p "I wish I were a piano"]]
    ))

(defremote count-something [n]
  (println "One number you can count to is" n))

