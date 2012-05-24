(ns prj-euler.core-spec
  (:use [speclj.core] [prj-euler.core])
  )

(describe "ones-digit"
          (it "returns the ones-digit of a number"
            (should= 1 (ones-digit 1))
            (should= 2 (ones-digit 12))
            (should= 3 (ones-digit 543))))

(describe "break-off-ones"
          (it "breaks off the ones digit of a number and shifts it right"
            (should (every? #(= 0 %) (map break-off-ones-digit (range 9))))
            (should= 9 (break-off-ones-digit 93))
            (should= 98 (break-off-ones-digit 987))
            (should= 123 (break-off-ones-digit 1234))))

(describe "digits"
          (it "returns a lists of a numbers digits"
            (should= [1] (digits 1))
            (should= [3 7] (digits 37))
            (should= [1 2 3] (digits 123))
          ))

(run-specs)
          

