(defproject livre "0.1.0-SNAPSHOT"
  :description "Book server and client"
            :dependencies [[org.clojure/clojure "1.4.0"]
                           [jayq "0.1.0-SNAPSHOT"]
                           [crate "0.1.0-SNAPSHOT"]
                           [fetch "0.1.0-SNAPSHOT"]
                           [noir "1.3.0-beta3"]]
  :cljsbuild {:source-path "src"
              :compiler {:output-dir "resources/public/cljs/"
                         :output-to "resources/public/cljs/bootstrap.js"
                         :optimizations :simple
                         :pretty-print true}}
            :main livre.server)
