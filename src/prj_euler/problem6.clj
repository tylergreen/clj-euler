(ns prj-euler.problem6
  [:use clojure.test]
;  [:require clojure.math.numeric-tower]
  )

(defn square [x] (* x x))

(with-test
    (defn squares [n]
      (map square (range 1 (+ 1 n))))
  (is (= [1 4 9 16 25] (squares 5)))
  )

(with-test
    (defn sum-of-squares [n]
      (reduce + (squares n)))
  (is (= 385 (sum-of-squares 10))))



(with-test
    (defn square-of-sums [n]
      (square (reduce + (range 1 (+ 1 n)))))
  (is (== 3025 (square-of-sums 10)))
  )

(with-test
    (defn problem6 [n]
      (- (square-of-sums n)
         (sum-of-squares n)))
  (is (== 2640 (problem6 10))))