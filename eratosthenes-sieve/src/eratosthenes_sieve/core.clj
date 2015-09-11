(ns eratosthenes-sieve.core)

(defn primes-up-to [n]
  (filter #(or (not= 0 (mod % 2))
               (= 2 %))
   (range 2 (inc n))))
