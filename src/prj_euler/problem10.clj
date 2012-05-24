(ns prj-euler.problem10
  [:use [prj-euler.core] ]
  )

(defn problem10 []
  (reduce + (sieve (* 2 (Math/pow 10 6)))))

