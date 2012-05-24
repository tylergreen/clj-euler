(ns prj-euler.problem6-spec
  [:use [speclj.core] [prj-euler.problem6]])

(describe "squares"
          (it "returns a seq of the squares of the first n natural numbers"
            (should= [1 4 9 ] (squares 3))
            (should= [1 4 9 16 25] (squares 5))))

(describe "sum-of-squares"
          (it "calculates the sum the squares of the first n nat numbers"
            (should= 385 (sum-of-squares 10))))

(describe "square-of-sums"
          (it "calculates the square of the sum of the first n nat numbers"
            (should= 3025 (square-of-sums 10))))

(describe "problem6"
          (it "calculates difference of square of sum and sum of squares"
              (should= 2640 (problem6 10))))
