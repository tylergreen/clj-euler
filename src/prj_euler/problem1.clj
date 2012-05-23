(ns prj-euler.problem1)

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
