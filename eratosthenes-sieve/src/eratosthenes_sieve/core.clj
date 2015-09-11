(ns eratosthenes-sieve.core)

(defn primes-up-to [n]
  (reverse
   (drop-last (reverse (range 1 (inc n))))))
