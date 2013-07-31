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


