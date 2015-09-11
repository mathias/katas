(ns eratosthenes-sieve.core)

(defn- all-integers-up-to [n]
  (range 2 (inc n)))

(defn primes-up-to [n]
  (filter #(or (not= 0 (mod % 2))
               (= 2 %))
          (all-integers-up-to n)))
