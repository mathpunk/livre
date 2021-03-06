(defproject livre "0.1.0-SNAPSHOT"
  :description "Book server and client"
            :dependencies [[org.clojure/clojure "1.5.1"]
                           [jayq "0.1.0-SNAPSHOT"]
                           [crate "0.1.0-SNAPSHOT"]
                           [fetch "0.1.0-SNAPSHOT"]
                           [noir "1.3.0-beta3"]
                           [org.clojure/data.json "0.2.2"]
                           [com.novemberain/monger "1.5.0"]]
    
  :plugins [[com.cemerick/austin "0.1.0"]
            [lein-cljsbuild "0.3.2"]]
  :cljsbuild
  {:builds
    [{:source-paths ["src"],
        :builds nil,
        :compiler
        {:pretty-print true,
              :output-dir "resources/public/cljs/",
              :output-to "resources/public/cljs/bootstrap.js",
              :optimizations :simple}}]}

  :main livre.server)


