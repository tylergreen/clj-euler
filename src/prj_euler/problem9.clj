(ns prj-euler.problem9
  [:use clojure.test]
  )

(defn pythag-triple? [a b c]
  (= (Math/pow c 2) (+ (Math/pow a 2) (Math/pow b 2))))

(defn problem9 []
  (for [c (range 400 1000)
        b (range 300 c)
        a (range 100 b)
        :when (and (pythag-triple? a b c)
                   (= 1000 (+ a b c)))
        ]
    (* a b c)))
