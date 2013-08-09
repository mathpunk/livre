(ns livre.client.main
  (:require [crate.core :as crate]
            [fetch.remotes :as remotes])
  (:use [jayq.core :only [$ append delegate data]])
  (:use-macros [crate.macros :only [defpartial]]))

; divisions
(def $body ($ :body))
(def $builder ($ :#builder))

; buttons
(defpartial button [{:keys [label action param]}]
  [:a.button {:href "#" :data-action action :data-param param} label])

(delegate $body button :click
      (fn [e]
        (.preventDefault e)
        (this-as me
                  (let [$me ($ me)
                        action (data $me :action)
                        param (data $me :param)
                        params (if (= param "")
                                [ ]
                                [param])]
                    (remotes/remote-callback action params)))))


; building controls
(append $builder (button {:label "count something" 
                           :action "count-something" 
                           :param "40"}))



