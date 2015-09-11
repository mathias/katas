(ns eratosthenes-sieve.core)

(defn- all-integers-up-to [n]
  (range 2 (inc n)))

(defn- multiple-of? [n p]
  (and (zero? (mod n p)) (not= n p)))

(defn primes-up-to [n]
  (filter #(multiple-of? % 2)
          (all-integers-up-to n)))
