

(require '[clojure.zip :as zip])

(def root-loc (zip/seq-zip (seq (map :title arts))))

Usage: (zipper branch? children make-node root)

    Creates a new zipper structure. 

branch? is a fn that, given a node, returns true if can have
children, even if it currently doesn't.

children is a fn that, given a branch node, returns a seq of its
children.

make-node is a fn that, given an existing node and a seq of
children, returns a new branch node with the supplied children.
root is the root node.

(def zp (zip/zipper false (gather-words "blahblah blah") (fn [node kids] nil) []))

(def titles (map #(% :title) copy))

(def z (zip/seq-zip titles))

