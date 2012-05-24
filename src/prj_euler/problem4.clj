(ns prj-euler.problem4
  [:use clojure.test]
  [:require [prj-euler.core :as util]]
  )

(defn palindrome? [seq]
  (let [length (count seq)
        [left right] (split-at (/ length 2) seq)]
    (cond
      (= 1 length) true
      (odd? length) (= (butlast left) (reverse right))
          (even? length) (= left (reverse right)))))

(defn n-digit-numbers [n]
  (range (int (Math/pow 10 (- n 1))) (int (Math/pow 10 n))))

(defn problem4 [n-digit]
  (apply max
         (for [a (n-digit-numbers n-digit)
               b (n-digit-numbers n-digit)
               :when (palindrome? (util/digits (* a b)))
               ]
           (* a b)  )))
