(ns word-wrap.core-test
  (:require [midje.sweet :refer :all]
            [word-wrap.core :refer :all]))

(facts "wrap"
       (fact "empty string is empty"
             (wrap "" 80) => "")
       (fact "Text that is less than the requested cols does not wrap"
             (wrap "this" 10) => "this")
       (fact "Wrap single word when requested cols is less than its length"
             (wrap "word" 2) => "wo\nrd")
       (fact "Wrap string without spaces that will wrap multiple times"
             (wrap "abcdefghij" 3) => "abc\ndef\nghi\nj"))
