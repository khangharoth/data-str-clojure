(defproject data-str-clojure "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.8.0"] [dk.ative/docjure "1.11.0"] [metasoarous/oz "1.3.1"]]
  :main ^:skip-aot data-str-clojure.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})

