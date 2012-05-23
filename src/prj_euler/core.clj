(ns prj-euler.core
  [:use clojure.test]
  )

(with-test
    (defn ones-digit [n]
      (mod n 10))
  (is (= 1 (ones-digit 1)))
  (is (= 2 (ones-digit 12)))
  (is (= 3 (ones-digit 543))))

(with-test
    (defn break-off-ones [n]
      (/ (- n (ones-digit n)) 10))
  (is (every? #(= 0 %) (map break-off-ones (range 9))))
  (is (= 9 (break-off-ones 93))))
  (is (= 98 (break-off-ones 987)))
  (is (= 123 (break-off-ones 1234)))

(with-test
    (defn digits [integer]
      (loop [n integer
             digits []]
        (if (= 0 n)
          digits
          (recur (break-off-ones n)
                 (cons (int (ones-digit n)) digits)))))
      (is (= [1] (digits 1)))
      (is (= [3 7] (digits 37)))
      (is (= [1 2 3] (digits 123)))
      )

(defn naive-sieve  [[p & rst]]
  (lazy-seq (cons p (naive-sieve (remove #(= 0 (mod % p)) rst)))))


(def naive-primes (naive-sieve (cons 2 (iterate #(+ 2 %) 3))))

(defn factor? [n fac]
  (= 0 (mod n fac)))

; Due to Rich Hickey
(defn sieve [n]
  (let [n (long n)]
    "Returns a list of all primes from 2 to n"
    (let [root (long (Math/round (Math/floor (Math/sqrt n))))]
      (loop [i (long 3)
             a (long-array n)
             result (list 2)]
        (if (>= i n)
          (reverse result)
          (recur (+ i (long 2))
                 (if (< i root)
                   (loop [arr a
                          inc (+ i i)
                          j (* i i)]
                     (if (>= j n)
                       arr
                       (recur (do (aset arr j (long 1)) arr)
                              inc
                              (+ j inc))))
                   a)
                 (if (zero? (aget a i))
                   (conj result i)
                   result)))))))

(defn odds []
  (iterate #(+ 2 %) 3 ))
