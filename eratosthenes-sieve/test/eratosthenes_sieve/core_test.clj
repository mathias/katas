(ns eratosthenes-sieve.core-test
  (:use midje.sweet)
  (:require [eratosthenes-sieve.core :refer :all]))

(facts
 "Eratosthenes sieve"
 (fact
    "it returns all the primes up to a given number"
    (primes-up-to 2)  => [2]
    (primes-up-to 3)  => [2 3]
    (primes-up-to 5)  => [2 3 5]
    (primes-up-to 11) => [2 3 5 7 11]
    (primes-up-to 100) => [2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97]))
