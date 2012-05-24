(ns prj-euler.problem2-spec
  (:use [speclj.core] [prj-euler.problem2])
  )

(describe "fibo"
          (it "generates the fibonacci sequence"
            (should= [0 1 1 2 3 5 8] (take 7 (fibo)))
            (should= [0 2 8 34] (take 4 (even-fibo)))
            ))
