;; looking for and handling aliases
(ns livre.copy.aliases)

(def known-aliases
  #{
    #"<<.+>>",
    #"((.+))",
    #"^---",
    "see also: 'sigils' files" }
  )


(ns livre.copy.hierarchy)
;; We know that textons are a directed graph, not a tree.
;; However, since it's so simple to turn a linear (scroll) document into an outline,
;; we propose that the tree structure is a useful "local understanding" structure for writing.
;;
;; Here, the goal will be to
;;   change bad markdown (vimwiki 'equals' syntax)
;;   find top-level headings and their body
;;   find nth-level headings and their body
;;   build a data structure
;;   "qualify the namespace" with the name of the file plus these hierarchical words and phrases


;; managing resources

(ns livre.material.inventory)
;; import previously written "auteur" code
;; save it "datom"-style


(ns livre.material.records)
;; start with a simple local file
;; upgrade to a db
;; upgrade to datomic d


(ns livre.material.units)
;; an overly abstract entity or something useful?
;; some units have transcripts, i.e., they are copy
;; but other units are merely scans or photos


(ns livre.material.morgue)
;; there are notebook names, which (kind of) relate to project/workspace/namespaces
;; there are tags to count up
;; there are short urls to correct
;; there is faceting to do--
;;   by date
;;   by twitter-user
;;   by full text search
;;   by tag
(ns livre.query.saved)
;; the Author is supposed to come up with interesting queries to examine
;; they might be based on hierarchies of markdown in copy
;; they might be based on large numbers of tags from evernotes


(ns livre.query.clip)
;; I'd like to have queries that return results that can then be pulled into copy
;; for now, that's an author bit
;; but readers might like to do that with a federated page
