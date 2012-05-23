(ns prj-euler.core
  [:use [prj-euler.core clojure.contrib.math] ]
  )

(def problem10 
  (reduce + (sieve (* 2 (expt 10 6)))))

