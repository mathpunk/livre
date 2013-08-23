; verify: find from collection
; eg: Finding documents (as maps)

(count (m/find-maps "document" {:ws {$exists true}}))

