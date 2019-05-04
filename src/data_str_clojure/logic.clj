(ns data-str-clojure.logic
  (:refer-clojure :exclude [==])
  (:use [clojure.core.logic])
  (:use [clojure.core.logic.pldb]))

(db-rel man x)

(def men
  (db
    [man 'Bob]
    [man 'John]))

(defn call-rel []
  (with-db men
           (run 1 [q] (man q))))


(defn -main
  [& args]
  (println (call-rel)))