(ns prj-euler.problem7
  [:require [prj-euler.core :as util]]
  )

(defn find-nth-prime [n]
  (nth (util/sieve 200000) (- n 1)))

(defn problem7 []
  (find-nth-prime 10001))
