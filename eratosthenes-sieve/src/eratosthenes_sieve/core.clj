(ns eratosthenes-sieve.core)

(defn- all-integers-up-to [n]
  (range 2 (inc n)))

(defn- multiple-of? [n prime]
  (and (zero? (mod n prime)) (not= n prime)))

(defn- sieve [numbers prime]
  (remove #(multiple-of? % prime) numbers))

(defn primes-up-to [n]
  (sieve
   (sieve (all-integers-up-to n) 2)
   3))
