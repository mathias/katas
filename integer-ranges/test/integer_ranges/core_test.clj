(ns integer-ranges.core-test
  (:require [midje.sweet :refer :all]
            [integer-ranges.core :refer :all]))

(facts "about integer ranges"

       (fact
        "it knows which numbers an range includes"
        (includes? "[2, 5]" "{2,3,4,5}") => true))
