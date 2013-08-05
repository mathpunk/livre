(ns livre.client.main
  (:require [crate.core :as crate]
            [fetch.remotes :as remotes])
  (:use [jayq.core :only [$ append delegate data]])
  (:use-macros [crate.macros :only [defpartial]]))

(def $controls   ($ :#controls))



$
(def $results   ($ :#results))



(defpartial button [{:keys [label action param]}]
  [:a.button {:href "#" :data-action action :data-param param} label])

(append $controls (button {:label "i'm a freaking button" :action "nothing" :param "0"}))
