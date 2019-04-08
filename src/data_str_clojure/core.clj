(ns data-str-clojure.core
  (:gen-class)
  (:require [dk.ative.docjure.spreadsheet :as spreadsheet])
  (:require [clojure.reflect :as r]))




(defn read-rows [file-name]
  (println file-name)
  (->>
    (spreadsheet/load-workbook (str "resources/" file-name))
    (spreadsheet/select-sheet "NEFT")
    (spreadsheet/select-columns {:file-name file-name :C :bankName :D :numOfTransaction})))

(defn valid-row? [row]
  (and (not (nil? (:bankName row)))
       (not (= "BANK" (str (:bankName row))))
       (number? (:numOfTransaction row))
       (> (:numOfTransaction row) 5000000)
       )
  )

(defn in-million [row]
  (println row)
  {:file-name (:file-name row) :bankName (:bankName row) :numOfTransaction (/ (:numOfTransaction row) 1000000)}
  )


(defn all-valid-rows [file-name]
  (->>
    (read-rows file-name)
    (rest)
    (filter valid-row?)
    (map in-million)))



(defn -main
  [& args]
  (println (doall (sort-by last (drop-last (all-valid-rows "feb2019.XLS")))))
  )
