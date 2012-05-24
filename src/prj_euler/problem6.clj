(ns prj-euler.problem6
  [:use clojure.test]
;  [:require clojure.math.numeric-tower]
  )

(defn square [x] (* x x))

(defn squares [n]
  (map square (range 1 (+ 1 n))))

(defn sum-of-squares [n]
      (reduce + (squares n)))

(defn square-of-sums [n]
      (square (reduce + (range 1 (+ 1 n)))))

(defn problem6 [n]
      (- (square-of-sums n)
         (sum-of-squares n)))
