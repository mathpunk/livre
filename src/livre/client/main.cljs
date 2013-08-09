(ns livre.client.main
  (:require [crate.core :as crate]
            [fetch.remotes :as remotes])
  (:use [jayq.core :only [$ append delegate data]])
  (:use-macros [crate.macros :only [defpartial]]))

(def $body ($ :body))
(def $controls   ($ :#controls))

; button
(defpartial button [{:keys [label action param]}]
  [:a.button {:href "#" :data-action action :data-param param} label])

(append $controls (button {:label "count something" 
                           :action "count-something" 
                           :param "rand"}))

(delegate $body button :click
                    (fn [e]
                        (.preventDefault e)
                        (js/alert "clicked!")))

