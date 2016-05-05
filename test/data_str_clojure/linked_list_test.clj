(ns data-str-clojure.linked-list-test
  (:require [clojure.test :refer :all]
            [data-str-clojure.linked-list :refer :all])
  (:import (data_str_clojure.linked_list Node)))

(deftest get-test
  (let [node (Node. "foo" nil)]
    (is (= "foo"  (.getCar node)))))



(deftest change-get-test
  (let [someNode (Node. "foo" nil)]
    (.setCar someNode "bar")
    (is (= "bar"  (.getCar someNode)))))