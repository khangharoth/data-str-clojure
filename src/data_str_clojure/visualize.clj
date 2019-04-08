(ns data-str-clojure.visualize
  (:require
    [oz.core :as oz]
    ))

(oz/start-plot-server!)

(defn coeff [name]
  (println name)
  (cond
    (= "first" name) 1
    (= "second" name) 2
    (= "third" name) 3
    :else 5
    )
  )

(defn play-data [& names]
  (for [n names i (range 3)]
    {:time i :item n :quantity (* (coeff n) i)}))

(def line-plot
  {:data     {:values (play-data "first" "second" "third")}
   :encoding {:x     {:field "time"}
              :y     {:field "quantity"}
              :color {:field "item" :type "nominal"}}
   :mark     "line"})

(println "about to plot")
(Thread/sleep 1000)
;; Render the plot
(oz/v! line-plot)


(defn -main
  [& args]
  (while true (Thread/sleep 5000)))