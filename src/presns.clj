(ns presns
  (:require [clojure.core.typed :refer [ann Any U HMap]]))

; (use 'presns :reload)
; (in-ns 'presns)
; (require '[clojure.core.typed :as t])
; (t/check-ns *ns*)

(defn otherprint [x] (print x))

(ann otherprint [Any -> nil])

(defn othersum [x y] (+ x y))

(ann othersum [Number Number -> Number])

; (defn flexisum [x y] (+ x y))
(ann flexisum [(U nil Number) Number -> Number])

(defn flexisum [x y] (if x (+ x y) y))

(def john {:name "John" :age 40})
(def mary {:name "Mary"})
(defn getage [person] (:age person))
(def ageofjohn (getage john))
; (def ageofmary (getage mary))

(ann getage [(HMap :mandatory {:age Number}) -> Number])

(ann mary (HMap))

