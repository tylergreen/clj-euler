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
            residue (/ n (int (Math/pow fac times)))] 
        [ factor-list residue ]))
  (is (= [[2 2] 1] (factor-with 4 2)))
  (is (= [[2 2 2] 3]  (factor-with 24 2)))
  (is (= [[2 2] 3] (factor-with 12 2)))
  (is (= [[] 15] (factor-with 15 2))))

(with-test 
(defn prime-factors [n]
  (first
   (reduce
    (fn [[factor-list residue] prime]
      (let [[more-factors new-residue] (factor-with residue prime)]
        (if (= new-residue residue)
          [factor-list residue]
          [(concat more-factors factor-list) new-residue])))
    [[] n]
    (util/sieve (Math/sqrt n))))) ;; need to fix this hack Here

  (is  (= '(3 2 2 2) (prime-factors 24)))
  (is  (= '(5 2 2 3 3 5) (prime-factors 180)))
  (is  (= '(2 3 5) (prime-factors 30)))
)


