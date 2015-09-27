(ns word-wrap.core
  (:require [clojure.string :as string]))

(defn wrap
  [s cols]
  (if (> (count s) cols)
    (->> (split-at cols s)
         (map #(apply str %))
         (string/join "\n"))
    s))
