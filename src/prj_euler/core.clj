(ns prj-euler.core)

(defn multiples [x]
  (iterate (partial + x) x))

(defn drop-fives [seq]
  (remove #(= 0 (mod % 5)) seq))

(defn multiples-3and5-under [n]
  (mapcat (fn [seq] (take-while #(> n %) seq))
          [(drop-fives (multiples 3))
           (multiples 5)]))

(defn problem1 []
  (reduce + (multiples-3and5-under 1000)))


;; Tests
(= [2 4 6 8 10] (take 5 (multiples 2)))
(= '(3 6 9 12 15) (take 5 (multiples 3)))
(= '(5 10 15 20 25) (take 5 (multiples 5)))
(= '(0 3 6 9 12 18 21 24 27 33) (take 9 (-> 3 multiples drop-fives )))
(= '(5 3 10 6 15 9 20 12 25) (take 9 (3&5-multiples)))

   

   

                                      