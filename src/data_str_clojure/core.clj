(ns data-str-clojure.core
  (:gen-class)
  (:require [dk.ative.docjure.spreadsheet :as spreadsheet]))



(defn read-rows []
  (->>
    (spreadsheet/load-workbook "resources/feb2019.XLS")
    (spreadsheet/select-sheet "NEFT")
    (spreadsheet/select-columns {:C :bankName :D :numOfTransaction})))

(defn -main
  [& args]
  (println type (read-rows)))
