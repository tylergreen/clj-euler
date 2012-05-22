(ns prj-euler.problem2
  [:use clojure.contrib.math]
  )

(= [1 1 2 3 5 8] (take 6 (fibo)))
(= [0 2 8 34] (take 4 (even-fibo))

(defn fibo
  ([] (concat [0 1] (fibo 0 1)))
  ([a b] (lazy-seq
          (cons (+ a b) (fibo b (+ a b))))))

(defn even-fibo []
  (filter even? (fibo)))

(defn problem2 []
  (reduce +
          (take-while #(< % (* 4 (expt 10 6)))
                      (even-fibo))))

