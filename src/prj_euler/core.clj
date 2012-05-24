(ns prj-euler.core
  [:use clojure.test]
  )

(defn ones-digit [n]
  (mod n 10))

(defn break-off-ones-digit [n]
  (/ (- n (ones-digit n)) 10))

(defn digits [integer]
  (loop [n integer
         digits []]
    (if (= 0 n)
      digits
      (recur (break-off-ones-digit n)
             (cons (int (ones-digit n)) digits)))))

(defn naive-sieve  [[p & rst]]
  (lazy-seq (cons p (naive-sieve (remove #(= 0 (mod % p)) rst)))))


(def naive-primes (naive-sieve (cons 2 (iterate #(+ 2 %) 3))))

(defn factor? [n fac]
  (= 0 (mod n fac)))

                                        ; Due to Rich Hickey
(with-test
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
(is (=
     (sieve 100)
     '(2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97))))


(defn odds []
  (iterate #(+ 2 %) 1 ))

(with-test
    (defn factor? [n fac]
      (= 0 (mod n fac)))
  (is (factor? 4 2))
  (is (factor? 9 3))
  (is (factor? 11 3))
  (is (factor? 2 4)))

