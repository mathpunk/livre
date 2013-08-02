(ns livre.client.main
  (:require [crate.core :as crate]
                        [fetch.remotes :as remotes])
  (:use [jayq.core :only [$ append delegate data]])
  (:use-macros [crate.macros :only [defpartial]]))


