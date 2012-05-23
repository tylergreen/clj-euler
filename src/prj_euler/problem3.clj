(ns prj-euler.problem3
  [:use
   clojure.set
   clojure.test]
  [:require [prj-euler.core :as util]]
  )

(with-test
    (defn factor-with [n fac]
      (let [times (count (take-while #(util/factor? % fac)
                                     (iterate #(/ % fac) n)))
            factor-list (repeat times fac)
            residue (/ n (Math/pow fac times))] 
        [ factor-list residue ]))
  (is (= [[2 2] 1] (factor-with 4 2)))
  (is (= [[2 2 2] 3]  (factor-with 24 2)))
  (is (= [[2 2] 3] (factor-with 12 2)))
  (is (= [[] 15] (factor-with 15 2))))
      
(defn prime-factors-slow [n]
  (first
   (reduce
    (fn [[factor-list residue] prime]
      (let [[more-factors new-residue] (factor-with residue prime)]
        (if (= new-residue residue)
          [factor-list residue]
          [(concat more-factors factor-list) new-residue])))
    [[] n]
    (util/sieve 100000)))) ;; need to fix this hack here

(defn prime-factors [n]
  (reductions
    (fn [[factor-list residue] prime]
      (let [[more-factors new-residue] (factor-with residue prime)]
        (if (= new-residue residue)
          [factor-list residue]
          [(concat more-factors factor-list) new-residue])))
    [[] n]
    (util/sieve 100000))) ;; need to fix this hack here

(= '(2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97)
   (util/sieve 100))

(= '(2 2 2 3) (prime-factors 24))
(= '(2 2 3 3 5) (prime-factors 180))
(= '(2 3 5) (prime-factors 30))
(let [n (rand-int 100)]
  (and (= (reduce * (prime-factors n)))
       (subset? (set (prime-factors n))
                (set (util/sieve n)))))



