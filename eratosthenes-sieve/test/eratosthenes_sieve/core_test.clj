(ns eratosthenes-sieve.core-test
  (:use midje.sweet)
  (:require [eratosthenes-sieve.core :refer :all]))

(facts
 "Eratosthenes sieve"
 (fact
    "it returns all the primes up to a given number"
    (primes-up-to 2) => [2]
    (primes-up-to 3) => [2 3]))
