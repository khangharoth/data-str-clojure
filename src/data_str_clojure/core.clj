(ns data-str-clojure.core
  (:gen-class)
  (:require [dk.ative.docjure.spreadsheet :as spreadsheet])
  (:require [clojure.reflect :as r]))



(defn read-rows []
  (->>
    (spreadsheet/load-workbook "resources/feb2019.XLS")
    (spreadsheet/select-sheet "NEFT")
    (spreadsheet/select-columns {:C :bankName :D :numOfTransaction})))

(defn valid-row? [col]
  (and (not (nil? (:bankName col)))
       (not (= "BANK" (str (:bankName col))))
       )
  )

(defn all-valid-rows []
  (->>
    (read-rows)
    (rest)
    (filter valid-row?)))

(defn -main
  [& args]
  (println (doall (sort-by last (drop-last (all-valid-rows))))))
