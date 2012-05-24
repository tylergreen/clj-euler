(ns prj-euler.problem8-spec
  [:use [speclj.core] [prj-euler.problem8]])

(describe "all-subseqs"
          (it "returns all the n-length subsequences inside a sequence"
            (should= [[8]] (all-subseqs 1 [8]))
            (should= [[1 2]] (all-subseqs 2 [1 2]))
            (should= [[1 2] [2 3]] (all-subseqs 2 [1 2 3]))
            (should= [[1 2 3 4 5] [2 3 4 5 6]] (all-subseqs 5 [1 2 3 4 5 6]))
            (should= [[1 2]] (all-subseqs 5 [1 2]))))
