(ns prj-euler.problem9-spec
  [:use [speclj.core] [prj-euler.problem9]])

(describe "pythat-triple?"
          (it "checks it 3 numbers satisfy a^2 + b^2 = c^2"
            (should (pythag-triple? 3 4 5))
            (should (pythag-triple? 5 12 13))
            (should (not (pythag-triple? 1 4 5)))))

