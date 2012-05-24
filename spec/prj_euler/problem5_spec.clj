(ns prj-euler.problem5-spec
  [:use [speclj.core] [prj-euler.problem5]])

(describe "problem5"
          (it "returns the smallest positive number that is evenly divisible by all of the numbers from 1 to n "
            (should= 2520 (problem5 10))
            ))
