; units of text
word 
line
stanza
page  
- has-links?
- is-leaf? (not has-links)
codex
library 
Library
; note: there is no information on whether every *configuration* of books is realized; we believe it to be
; an undecideable proposition.


word 
keywords, dictionary definitions, lexicon definitions

line
find lines containing word, expand word to nearest line containing it

stanza
find stanzas containing word, expand line to its surrounding stanza

page  
I was about to claim that paper cannot link, but that's certainly not true. but a page that has no links is "safe" in some sense
and might want to put its own links at the footer. 
(defprotocol Unit
  (title [ ] "may or may not have a name")
  (ws [ ] "exists in some writespace - better be pm or lf5, slacker")
  (content [ ] "text, sound, image, etc")
  (context [ ] "ooooh")
  (history [ ] "all the history")
  )
