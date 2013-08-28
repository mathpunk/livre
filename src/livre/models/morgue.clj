; Goal:
; Abstract away the implementation details of clippings from my morgue files.
;
; The clippings in the morgue have a bunch of fields. Also, they are not data that I have
; any sort of easy access to, because the data format is suck.
;

(def morgue
  (fn [command]
    (throw (Exception. (str ": Morgue connection not implemented, cannot \"" command "\" it.")))))

