(ns livre.views.welcome
  (:require [livre.views.common :as common])
  (:use [noir.core :only [defpage]]))

(defpage "/welcome" []
         (common/layout
           [:p "Welcome to livre"]))


(defpage "/" []
         (common/layout
           [:div#piano]))
