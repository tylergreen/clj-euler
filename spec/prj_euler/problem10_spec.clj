(ns prj-euler.problem10-spec
  [:use [speclj.core] [prj-euler.problem10]])

(describe "problem10"
          (it "calculates the sum of all prime numbers below 2 million"
            (should= 142913828922 (problem10))
            ))