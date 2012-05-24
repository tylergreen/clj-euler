(ns prj-euler.problem3-spec
  [:use [speclj.core] [prj-euler.problem3]])

(describe "factor-with"
          (it "returns a list with fac repeated and the resulting number"
            (should= [[2 2] 1] (factor-with 4 2))
            (should= [[2 2 2] 3]  (factor-with 24 2))
            (should= [[2 2] 3] (factor-with 12 2))
            (should= [[] 15] (factor-with 15 2))))

(describe "prime-factors"
          (it "returns a list of prime numbers, which, if all multiplied, equal the original number"
            (should= '(3 2 2 2) (prime-factors 24))
            (should= '(5 3 3 2 2) (prime-factors 180))
            (should= '(5 3 2) (prime-factors 30))))

(describe "problem3"
          (it "returns the largest prime factor of a number"
            (should= 11 (problem3 33))
            (should= 7 (problem3 35))
            ))


