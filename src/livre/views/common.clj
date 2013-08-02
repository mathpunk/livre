(ns livre.views.common
  (:use [noir.core :only [defpartial]]
        [hiccup.page :only [include-css include-js html5]]))
; overtonecljs ; [hiccup.page-helpers :only [include-css include-js html5]]))

(defpartial layout [& content]
            (html5
              [:head
               [:title "punk mathematics"]
               (include-css "/css/reset.css")
               (include-css "/css/fstorr-mathpunk.css")
               (include-js "https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js")] 
              [:body
               [:div#wrapper
                content]
               (include-js "/cljs/bootstrap.js")]))
