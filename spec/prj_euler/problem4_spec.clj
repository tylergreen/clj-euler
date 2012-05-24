(ns prj-euler.problem4-spec
  [:use [speclj.core] [prj-euler.problem4]])

(describe "palindrome?"
          (it "checks if a list is the same forwards as backwards"
              (should (palindrome? [:a]))
              (should (palindrome? [:a :a]))
              (should (palindrome? [:a :b :a]))
              (should (palindrome? [:a :b :b :a]))
              (should (palindrome? [:a :b :c :b :a]))
              (should (not (palindrome? [:a :b ])))
              (should (not (palindrome? [:a :b :c])))
              (should (not (palindrome? [:a :b :c :b])))))

(describe "n-digit-numbers"
          (it "returns all numbers with n digits"
            (should= (range 1 10) (n-digit-numbers 1))
            (should= (range 10 100) (n-digit-numbers 2))
            (should= (range 100 1000) (n-digit-numbers 3))
            ))

(describe "problem4"
          (it "largest palindrome made from the product of two n-digit numbers"
            (should= 9009 (problem4 2))))




