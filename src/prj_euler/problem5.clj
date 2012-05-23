(ns prj-euler.problem5
  [:use clojure.test]
  [:require [prj-euler.core :as util]]
  )

(defn problem5 []
  (some
   #(if (every? (partial util/factor? %) (range 2 20))
      %)
   (iterate #(+ 20 %) 20 )))


  
