(ns data-str-clojure.linked-list)

(definterface INode
  (getCar [])
  (getCdr [])
  (setCar [x])
  (setCdr [x]))

(deftype Node [^:volatile-mutable car ^:volatile-mutable cdr]
  INode
  (getCar [_] car)
  (getCdr [_] cdr)
  (setCar [this x] (set! car x) this)
  (setCdr [this x] (set! cdr x) this))
