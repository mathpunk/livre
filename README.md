# Livre

Book-as-a-Service, written in Clojure/Script and English.

## Theory
> "If we see the text as a kind of machine, a symbiosis of sign, operator and medium, then
> the cyborg perspective is already implied.
> 
> ...Any cyborg field, as any communicative field, is dominated by the issue of domination or control. The 
> key question in cyborg aesthetics is therefore, Who or what controls the text? Ideologically, there are three
> positions in this struggle: author control, text control, and reader control."
> -- Cybertext, Espen J. Aarseth

### Further reading
*books ("starbooks"), James Bridle
No Longer No Sense of an Ending, Dorian Taylor



## Contributing
### design
I could use some help with CSS. I want a site that is midway between MAX-FUN-GNARL zine style, and readable text.

The fx directory is for JS or ProcessingJS code for interesting text gnarl experiments. For an example of my interests
in this space, check out audition.js, Allen Tan's sketch of one way to present multiple voicings of one idea. 

### art
Generative artwork is of great interest to me. When I imagine the site in my head, readable text is in red borders that 
float over a background of images ripped from Flickr contexually, processed to add
too-many-generations-on-the-copy-machine noise, cut into strips. I'll do that with all my spare time. 

### ui
I'm new to client-server programming, but these are the functions I'm imagining. Subject to change as I hack off
complexity.
* Accountability: Display time and number statistics on my raw word count, raw reference count, and finished word count. 
* Interest Ranking and Context Building: Queue raw data for review, and improve it incrementally. 
* Storybuilding: Query references and raw text for remixing into new textons.

### speculative mathematics
The topology directory is where the rubber hits the manifold. Unfortunately most of the documentation is still in my
head. Subject to rapid change. 




## Usage

If you use cake, substitute 'lein' with 'cake' below. Everything should work fine.

```bash
lein deps
lein run
```

## License

Copyright (C) 2013 Thomas Henderson

Distributed under the... Mozilla Public License 2.0 ?

