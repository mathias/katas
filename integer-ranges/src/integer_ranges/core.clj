(ns integer-ranges.core)

(defn- parse-interval [interval]
  (let [matched (map first (re-seq #"([\[\(\]\)]{1}|\d+)" interval))
        start-operator (ffirst matched)
        start-number (Integer. (second matched))
        end-number (Integer. (nth matched 2)) ;; 0-indexed vector
        end-operator (first (last matched))]
    [(if (= \[ start-operator)
       start-number
       (inc start-number))
     (if (= \) end-operator)
       end-number
       (inc end-number))]))

(defn- parse-numbers [numbers]
  (->> numbers
       (re-seq #"(\d+)")
       (map first)
       (map #(Integer. %))))

(defn all-numbers [interval]
  (let [[start end] (parse-interval interval)]
    (range start end)))

(defn includes? [interval includes]
  (let [interval-range (all-numbers interval)
        numbers (parse-numbers includes)]
    (every? #(contains? (set interval-range) %) numbers)))
