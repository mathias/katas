(ns eratosthenes-sieve.core)

(defn- all-integers-up-to [n]
  (range 2 (inc n)))

(defn- multiple-of? [n prime]
  (and (zero? (mod n prime)) (not= n prime)))

(defn- next-prime [last-prime numbers]
  (first (filter #(> % last-prime) numbers)))

(defn- sieve [numbers prime]
  (remove #(multiple-of? % prime) numbers))

(defn primes-up-to [n]
  (loop [numbers (all-integers-up-to n)
         prime 2]
    (if (nil? prime)
      numbers
      (recur (sieve numbers prime) (next-prime prime numbers)))))
