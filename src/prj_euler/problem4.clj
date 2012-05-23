(ns prj-euler.problem4
  [:use clojure.test]
  [:require [prj-euler.core :as util]]
  )

(with-test
    (defn palindrome? [seq]
      (let [length (count seq)
            [left right] (split-at (/ length 2) seq)]
        (cond
          (= 1 length) true
          (odd? length) (= (butlast left) (reverse right))
          (even? length) (= left (reverse right)))))
  (is (palindrome? [:a]))
  (is (palindrome? [:a :a]))
  (is (palindrome? [:a :b :a]))
  (is (palindrome? [:a :b :b :a]))
  (is (palindrome? [:a :b :c :b :a]))
  (is (not (palindrome? [:a :b ])))
  (is (not (palindrome? [:a :b :c])))
  (is (not (palindrome? [:a :b :c :b]))))

(with-test
    (defn n-digit-numbers [n]
      (range (int (Math/pow 10 (- n 1))) (int (Math/pow 10 n))))
  (is (= (range 1 10) (n-digit-numbers 1)))
  (is (= (range 10 100) (n-digit-numbers 2)))
  (is (= (range 100 1000) (n-digit-numbers 3))))


(with-test 
    (defn problem4 [n-digit]
      (apply max
             (for [a (n-digit-numbers n-digit)
                   b (n-digit-numbers n-digit)
                   :when (palindrome? (util/digits (* a b)))
                   ]
               (* a b)  )))
  (is (= 9009 (problem4 2)))
  )

  

