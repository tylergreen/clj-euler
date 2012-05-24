(ns prj-euler.problem1-spec
  (:use [speclj.core] [prj-euler.problem1])
  )

(describe "multiples"
          (it "generates all the multiples of a number"
            (should= [2 4 6] (take 3 (multiples 2)))
            (should= [3 6 9] (take 3 (multiples 3)))
            ))

(describe "drop-fives"
          (it "removes multiples of 5 from a seq"
            (should= [1] (drop-fives [1 5]))
            (should= [1 11] (drop-fives [1 5 10 11]))
            )
          )

(describe "multiples-3and5-under"
          (it "generates all multiples of 3 and 5 under n"
            (should=  [3 5 ] (multiples-3and5-under 6))
            (should= [ 3 6 9 12 5 10 15] (multiples-3and5-under 16))))

