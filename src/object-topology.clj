(ns livre.object-topology)

(defprotocol Unit
  (title [ ] "may or may not have a name")
  (ws [ ] "exists in some writespace - better be pm or lf5, slacker")
  (content [ ] "text, sound, image, etc")
  (context [ ] "ooooh")
  (history [ ] "all the history")
  )

