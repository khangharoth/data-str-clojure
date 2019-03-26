(ns data-str-clojure.visualize
  (:require
    [oz.core :as oz]
    ))

(oz/start-plot-server!)

(defn play-data [& names]
  (for [n names
        i (range 20)]
    {:time i :item n :quantity (+ (Math/pow (* i (count n)) 0.8) (rand-int (count n)))}))

(def line-plot
  {:data     {:values (play-data "monkey" "slipper" "broom")}
   :encoding {:x     {:field "time"}
              :y     {:field "quantity"}
              :color {:field "item" :type "nominal"}}
   :mark     "line"})

(println "about to plot")
(Thread/sleep 5000)
;; Render the plot
(oz/v! line-plot)


(defn -main
  [& args]
  (while true (Thread/sleep 5000)))