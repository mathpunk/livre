;; For a while I had this completely insane notion that I was going to use alot of regular 
;; expressions into a complex and interesting mass of small pieces of text, loosely joined.
;; I certainly got a mass. 
;;
;; Things it would be interesting to do--
;;  "Count occurrences of pattern in the corpus"
;;  "Examine lines that have occurences."
;;  "Edit the surrounding lines."
;;
;;
;; Sigils Ancien (Data)
;; =================================================== 

(ns livre.models.sigils)

(def sigils-ancien
;; I had an insane idea about breaking up text into loose pieces using brittle and easily
;; forgotten patterns of symbols.
  [
    {:anon #"{{(.*?)}}" }
    {:anon #"<<(.*?)\>>" }
    {:anon #"\(\((.*?)\)\)" }

    ;; Who knows how strange such a mad punctuation scheme could become?
    {:anon #"[!@#$%^&?](\w+)"}
    {:command #"^$.*?"}

    ;; But it's not all mad. Wikis really do have outgoing pages--
    {:page #"\[\[(.*?)\]\]"}

    ;; And the two forms of markdown are meaningful.
    {:hed   #"^(#|=)"}

    ;; It wasn't too strange to think of 'tearing' a page. 
    {:tear #"^---\s*$"}

    ;; And who isn't excited by a cliffhanger?!
    {:asteriensis #"^***\s*$"}

    ;; I also toyed with associating things inside the page. 
    {:assoc   #"\s?->\s?"}
    {:jump  #"\s?=>\s?"}
  ]
  )

;; Sigils (moderne)
{:audition  '#{this|that|the other}  'audition.js}
{:old-hed   #"^=.+=$"}
