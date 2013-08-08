;; Bases for comparison
;;
;; file names
;; file sizes
;; file checksums
;;  but how do you get checksums?
; --------------------------




(ns livre.data.munge.wiki
  (:use clojure.set))

(def vw "/home/thomas/cerebra/wiki/wiki-archive/vim-wiki/")
(def wb "/home/thomas/cerebra/wiki/wiki-archive/wiki-backup/")

(defn file [string] (clojure.java.io/file string))

(defn file-names [string]
  (map #(.getName %) (.listFiles (file string))))

(defn name-distinct [dir other]
  (let [a (set (file-names dir)),
        b (set (file-names other))]
    (dorun
      (spit "/home/thomas/cerebra/wiki/wiki-archive/distinct.txt" (map #(str dir %) (difference a b)) :append false)
      (spit "/home/thomas/cerebra/wiki/wiki-archive/distinct.txt" (map #(str dir %) (difference b a)) :append true))))

(name-distinct vw wb) 



difference (parent's files) (other-parent's files)
  all appended to parent
  move to safe directory


