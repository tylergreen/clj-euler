(ns prj-euler.problem2
  )

(defn fibo
  ([] (concat [0 1] (fibo 0 1)))
  ([a b] (lazy-seq
          (cons (+ a b) (fibo b (+ a b))))))

(defn even-fibo []
  (filter even? (fibo)))

(defn problem2 []
  (reduce +
          (take-while #(< % (* 4 (Math/pow 10 6)))
                      (even-fibo))))

