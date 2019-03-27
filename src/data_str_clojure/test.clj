(ns data-str-clojure.test
  (:require [dk.ative.docjure.spreadsheet :as spreadsheet])
  (:require [clojure.reflect :as r]))


(defn read-rows [file-name]
  (->>
    (spreadsheet/load-workbook (str "resources/" file-name))
    (spreadsheet/select-sheet "NEFT")
    (spreadsheet/select-columns {:C :bankName :D :numOfTransaction})))


(defn -main
  [& args]
  (println (read-rows "feb2019.XLS")))
