;; this is not functional style at all.
;;
;; for your queries, you'll want to build up a language.
;;
(count (m/find-maps "document" {:ws {$exists true}}))

