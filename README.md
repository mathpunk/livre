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

### Architecture and purpose
I'm new to client-server programming, but these are the features I'm imagining. 

* Accountability: Display time and number statistics on my raw word count, raw reference count, and finished word count.
_"A map from atomic text elements to numbers that change over time."_

* Interest Ranking, Context Building: Queue raw data for review, and improve it incrementally. (A simple server for
a subset of this functionality is in the works-- luckily, by someone who knows a lot more than I do.) _"A partial order
to extend to a number of total (i.e. linear) orders; a map from atomic text elements to the power set of words of
interest."_
 
* Storybuilding: Query references and raw text for remixing into new textons. _"Editing as fluid dynamics."_

### design

My CSS ability is nil, so I just yanked something a friend designed for my earlier site, ignoring that it has a bunch of
references to classes/id's that I am not using. Ideally it will be nasty gnarly sharpie'd photocopied noise, with
simply-styled readable text on top. 

The fx directory is for JS or ProcessingJS code for interesting text gnarl experiments. For an example of my interests
in this space, check out https://github.com/tealtan/AuditionText , Allen Tan's sketch of one way to present multiple voicings of one idea. 

### art

Generative artwork is of great interest. When I imagine the site in my head, readable text is in red borders that float
over a background of images ripped from Flickr contexually, processed to add too-many-generations-on-the-copy-machine
noise, cut into vertical strips. This is not what I'm going to spend time on first. 

I also want to take submissions, for printing and for remix.


### speculative mathematics

The topology directory is where the rubber hits the manifold. Unfortunately most of the documentation is still in my
head. Subject to rapid change. See also "notes.md" in the main project directory. 


## Usage

If you use cake, substitute 'lein' with 'cake' below. 

```bash
lein deps
lein run
```

## License

Copyright (C) 2013 Thomas Henderson

Distributed under http://www.mozilla.org/MPL/2.0/ 

