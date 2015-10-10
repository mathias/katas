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

(defn- coll-contains-coll? [coll1 coll2]
  (every? #(contains? (set coll1) %) coll2))

(defn includes? [interval includes]
  (let [interval-range (all-numbers interval)
        numbers (parse-numbers includes)]
    (coll-contains-coll? interval-range numbers)))

(defn contains-range? [interval-a interval-b]
  (let [range-a (all-numbers interval-a)
        range-b (all-numbers interval-b)]
    (coll-contains-coll? range-a range-b)))

(defn overlaps? [a b]
  (let [[start-a end-a] (parse-interval a)
        [start-b end-b] (parse-interval b)]
    (and (< start-a end-b) (> end-a start-b))))
