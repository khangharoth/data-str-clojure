(ns data-str-clojure.linked-list-test
  (:require [clojure.test :refer :all]
            [data-str-clojure.linked_list :refer :all])
  (:import (data_str_clojure.linked_list Node)))

(def node (Node. "foo" nil))

(deftest linked-get-test
  (is (= "foo"  (.getCar node))))