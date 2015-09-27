(ns word-wrap.core
  (:require [clojure.string :as string]))


(defn- take-cols
  [cols s]
  (string/trim (apply str (take cols s))))

(defn- drop-cols
  [cols s]
  (apply str (drop cols s)))

(defn- join-newline
  [acc tail]
  (string/join "\n" (list acc tail)))

(defn- wrap-inner
  [s cols]
  (loop [acc (take-cols cols s)
         tail (drop-cols cols s)]
    (if (>= cols (count tail))
      (string/join "\n" (list acc tail))
      (recur (join-newline acc (take-cols cols tail)) (drop-cols cols tail)))))

(defn wrap
  [s cols]
  (if (> (count s) cols)
    (wrap-inner s cols)
    s))
