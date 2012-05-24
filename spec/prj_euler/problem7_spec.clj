(ns prj-euler.problem7-spec
  [:use [speclj.core] [prj-euler.problem7]])

(describe "problem7"
          (it "finds the 10,001 prime number"
            (should= 104743 (problem7)))
          )
