(ns hello-clojure.exmp
  (:require
   [clojure.core]))

(defn factorial [n]
  (if (<= n 1) n
      (loop [val n i n]
        (if (<= i 1) val
            (recur (*' val (dec i))(dec i))))))

(factorial 15500)

;; 

(defn fizz-buzz [] 
  (loop [n 1]
    (if (<= n 100)
      (do
        (cond
          (and (= (rem n 3) 0) (= (rem n 5) 0)) (println "FizzBuzz")
          (= (rem n 3) 0) (println "Fizz")
          (= (rem n 5) 0) (println "Buzz")
          :else (println n))
        (recur (inc n))))))

(fizz-buzz)