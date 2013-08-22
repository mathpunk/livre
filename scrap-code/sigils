magic: 
  pattern: /{{(.*?)}}/m 
  style: scan
dissonance: 
# Me yelling at me. 
  pattern: /<<(.*?)\>>/m
  style: scan
journal: 
# Ramblings outside of the text
  pattern: /\(\((.*?)\)\)/m
  style: scan
consonance: 
# Yes, it's identical to a journal. But this is for writing ideas that would be
# good for the text, that are consonant ideas, but perhaps optional... y'know,
# curvy. 
  pattern: /\(\((.*?)\)\)/m
  style: scan
pages: 
# Pages are the points of your text space. 
  pattern: /\[\[(.*?)\]\]/m
  style: scan
tags: 
# Like, topics... concepts...? They suggest textons that want to be close, and they
# suggest searches that ought be performed. 
  pattern: /\#(\w+)/
  style: scan
paragraphs: 
  pattern: /\n\n+/
  style: split
tears: 
# Nasty, nasty. Some of these will be separate thoughts, and others will be just
# old ways of entering journal entries and such. 
  pattern: /^---$/
  style: split
ideas: 
  pattern: /^\*{3,}$/
  style: split
beats: 
  pattern: /\*{2,}/ 
  style: split
associations:
# Wants a mediating texton, but will be content with a link to a concept. 
  pattern: /\s?->\s?/
  style: chain
jumps:
# Wants a mediating texton, and will throw errors without one. 
  pattern: /\s?=>\s?/
  style: chain
