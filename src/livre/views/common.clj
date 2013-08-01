(ns livre.views.common
  (:use [noir.core :only [defpartial]]
        [hiccup.page :only [include-css html5]]))

(defpartial layout [& content]
            (html5
              [:head
               [:title "punk mathematics"]
               (include-css "/css/reset.css")
               (include-css "/css/fstorr-mathpunk.css")] 
              [:body
               [:div#wrapper
                content]]))
