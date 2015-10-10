(ns integer-ranges.core-test
  (:require [midje.sweet :refer :all]
            [integer-ranges.core :refer :all]))

(facts "about integer ranges"
       (fact
        "it knows which numbers a range includes"
        (includes? "[2, 5]" "{2,3,4,5}") => true
        (includes? "[2, 5]" "{2,-1}") => false)
       (fact
        "all-numbers gives all numbers in interval"
        (all-numbers "[2,6]") => [2 3 4 5 6]
        (all-numbers "[1, 5]") => [1 2 3 4 5]
        (all-numbers "(1,5]") => [2 3 4 5]
        (all-numbers "(1,5)") => [2 3 4])
       (fact
        "it knows when an interval contains another interval"
        (contains-range? "[2,10)" "[2,5]") => true
        (contains-range? "(2,10]" "[2,5]") => false
        (contains-range? "[2,4]" "[2,5]") => false
        (contains-range? "[2,4]" "[2,5)") => true))
