(ns livre.views.welcome
  (:require [livre.views.common :as common])
  (:use [noir.core :only [defpage]]))

(defpage "/" []
         (common/layout
           [:p "Welcome to livre"]))


(defpage "/statistics" []
         (common/layout
           [:div#statistics 
            [:p "word count: " (str 455251)]
            [:p "index cards: " (str 1142)]
            [:p "notebook pages: " (str 1686)]
            [:p "web clippings: " (str "unknown")]
           ]
           [:div#graph
           ]
          ))

(defpage "/css-viewer" [ ]
  (common/layout
    [:nav "nav"]
    [:div#wrapper "#wrapper"
      [:div#alert ".alert" ]
      [:div#main 
        [:p "#main"]
        [:p "Look I've got " [:a {:href "omgbutts.com"}]]
        [:div#cont-wrapper "#cont-wrapper"]
        [:div#comments "#comments"]
        [:div#wp_paypal_shopping_cart_widgets "#wp_paypal_shopping_cart_widgets"]
        ]
    ]
    [:footer "footer"]
  ))

