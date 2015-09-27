(ns word-wrap.core
  (:require [clojure.string :as string]))


(defn- take-cols
  [cols s]
  (apply str (take cols s)))
(defn- drop-cols
  [cols s]
  (apply str (drop cols s)))

(defn wrap
  [s cols]
  (if (> (count s) cols)
    (loop [acc (take-cols cols s)
           tail (drop-cols cols s)]
      (if (or (>= cols (count tail)) ;; Less than cols left
              (not (seq tail)))      ;; tail is empty
        (string/join "\n" (list acc tail))
        (recur (string/join "\n" (list acc (take-cols cols tail))) (drop-cols cols tail))))
    s))
