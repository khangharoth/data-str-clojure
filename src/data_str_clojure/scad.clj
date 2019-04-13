(ns data-str-clojure.scad
  (:use [scad-clj.scad])
  (:use [scad-clj.model]))


(def primitives
  (union
    (cube 150 75 75)
    (sphere 70)
    (cylinder 10 250)))



(defn -main
  [& args]
  (spit "out.scad" (write-scad primitives))
  )