(defproject data-str-clojure "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [dk.ative/docjure "1.11.0"]
                 [metasoarous/oz "1.3.1"]
                 [scad-clj "0.1.0"]
                 [org.clojure/core.logic "0.8.11"]
                 ]
  :main ^:skip-aot data-str-clojure.logic
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})

