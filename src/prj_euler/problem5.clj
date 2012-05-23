(= true (factor? 20 2))
(= false (factor? 2 20))

(defn factor? [n fac]
  (= 0 (mod n fac)))

(defn five []
  (some
   #(if (every? (partial factor? %) (range 2 20))
      %)
   (iterate #(+ 20 %) 20 )))


  
