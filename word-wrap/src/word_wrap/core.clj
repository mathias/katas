(ns word-wrap.core
  (:require [clojure.string :as string]))

(defn wrap
  [s cols]
  (string/replace s " " "\n"))
