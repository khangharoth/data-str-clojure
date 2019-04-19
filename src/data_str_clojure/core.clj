(ns data-str-clojure.core
  (:gen-class)
  (:require [dk.ative.docjure.spreadsheet :as spreadsheet])
  (:require [clojure.reflect :as r]))




(defn read-rows [file-name]
  (->>
    (spreadsheet/load-workbook (str "resources/" file-name))
    (spreadsheet/select-sheet "NEFT")
    (spreadsheet/select-columns {:C :bankName :D :numOfTransaction})))

(defn valid-row? [row]
  (and (not (nil? (:bankName row)))
       (not (= "BANK" (str (:bankName row))))
       (number? (:numOfTransaction row))
       (> (:numOfTransaction row) 10000000)
       )
  )

(defn in-million [row]
  {:bankName (:bankName row) :tranInMil (/ (:numOfTransaction row) 1000000)}
  )


(defn all-valid-rows [file-name]
  (->>
    (read-rows file-name)
    (rest)
    (filter valid-row?)
    (map in-million)))

(defn data-by-month [file-name]
  {:month file-name :data (doall (sort-by last (drop-last (all-valid-rows file-name))))}
  )



(defn -main
  [& args]
  (println (data-by-month "dec2018.XLS"))
  (println (data-by-month "feb2019.XLS"))
  (println (data-by-month "jan2019.XLS"))

  )
