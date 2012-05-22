(ns prj-euler.problem3
  [:use [clojure.contrib.math clojure.set]]
  )

(use 'clojure.contrib.math)
(use 'clojure.set)

(= [3 5 7 9 11] (take 5 odds))
(= true (factor? 9 3))
(= false (factor? 11 3))

;; renname (and swap bool) to coprime?
(defn factor? [n fac]
  (= 0 (mod n fac)))

; Due to Rich Hickey
; this need to be a lazy sequence
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

(= [[2 2] 1] (factor-with 4 2))
(= [[3 3] (factor-with 24 2))
(= [2 3] (factor-with 12 2))
(= [0 15] (factor-with 15 2))

(defn factor-with [n fac]
  (let [times (count (take-while #(factor? % fac)
                                 (iterate #(/ % fac) n)))
        factor-list (repeat times fac)
        residue (/ n (expt fac times))] 
    [ factor-list residue ]))
      
(defn prime-factors-slow [n]
  (first
   (reduce
    (fn [[factor-list residue] prime]
      (let [[more-factors new-residue] (factor-with residue prime)]
        (if (= new-residue residue)
          [factor-list residue]
          [(concat more-factors factor-list) new-residue])))
    [[] n]
    (sieve 100000)))) ;; need to fix this hack here

(defn prime-factors [n]
  (reductions
    (fn [[factor-list residue] prime]
      (let [[more-factors new-residue] (factor-with residue prime)]
        (if (= new-residue residue)
          [factor-list residue]
          [(concat more-factors factor-list) new-residue])))
    [[] n]
    (sieve 100000))) ;; need to fix this hack here

(= '(2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97)
   (sieve 100))

(= '(2 2 2 3) (prime-factors 24))
(= '(2 2 3 3 5) (prime-factors 180))
(= '(2 3 5) (prime-factors 30))
(let [n (rand-int 100)]
  (and (= (reduce * (prime-factors n)))
       (subset? (set (prime-factors n))
                (set (sieve n)))))



