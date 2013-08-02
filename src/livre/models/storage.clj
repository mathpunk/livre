(ns livre.models.storage
  (:require [clojure.data.json :as json]))

; write a test json file destructively
(defn write! [data]
  (spit "/home/thomas/src/livre/storage/test-data.json" (json/write-str data)))

; append to the test json file
(defn write [data]
  (spit "/home/thomas/src/livre/storage/test-data.json" (json/write-str data) :append true ))

; some simple test data
(def vw
  {:name "blah.wiki"
   :copy "look at the many things I have to say about things"
   :date "EPOCH"
   :tags ""})

; writing
(write! vw)
(write "omgomgomgomgomg\newlineomgomgomg")
