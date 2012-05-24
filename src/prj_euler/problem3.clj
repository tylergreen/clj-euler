(ns prj-euler.problem3
  [:use
   clojure.set]
  [:require [prj-euler.core :as util]]
  )

(defn factor-with [n fac]
  (let [times (count (take-while #(util/factor? % fac)
                                 (iterate #(/ % fac) n)))
        factor-list (repeat times fac)
        residue (/ n (int (Math/pow fac times)))] 
        [ factor-list residue ]))

(defn prime-factors [n]
  (first
   (reduce
    (fn [[factor-list residue] prime]
      (let [[more-factors new-residue] (factor-with residue prime)]
        (if (= new-residue residue)
          [factor-list residue]
          [(concat more-factors factor-list) new-residue])))
    [[] n]
    (util/sieve n)))) ;; need to fix this hack Here

(defn problem3 [n]
  (apply max (prime-factors n)
  ))


