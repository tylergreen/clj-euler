(ns prj-euler.problem5
  [:use clojure.test]
  [:require [prj-euler.core :as util]]
  )

(defn problem5 [n]
  (some
   #(if (every? (partial util/factor? %) (range 2 n))
      %)
   (iterate #(+ n %) n )))


  
