(ns word-wrap.core
  (:require [clojure.string :as string]))


(defn- take-cols
  [cols s]
  (apply str (take cols s)))

(defn- drop-cols
  [cols s]
  (apply str (drop cols s)))

(defn- join-newline
  [acc tail]
  (string/join "\n" (list acc tail)))

(defn- more-than-1? [lst]
  (> (count lst) 1))

(defn- wrap-inner
  [s cols]
  (loop [acc (take-cols cols s)
         tail (drop-cols cols s)]
    (if (>= cols (count tail))
      (string/join "\n" (list acc tail))
      (let [to-wrap (take-cols cols tail)
            split-to-wrap (string/split to-wrap #" ")]
        (recur (join-newline acc to-wrap) (drop-cols cols tail))))))

(defn wrap
  [s cols]
  (if (> (count s) cols)
    (wrap-inner s cols)
    s))

(defn word-wrapper
  [s cols]
  (let [split-words (string/split s #" ")]
    (loop [acc ""
           row-being-built ""
           words-left split-words]
      (if-not (seq words-left)
        (apply #(string/join \n %) acc row-being-built)
        (if (<= (count row-being-built) cols)
          (recur (apply #(string/join \n %) acc row-being-built) "" words-left)
          (recur acc (apply #(string/join " " %) row-being-built (first words-left)) (rest words-left)))))))

