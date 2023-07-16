(ns hello-clojure.tic-tac-toe
  (:require
   [clojure.core]))

(defn triple-winner? [triple]
  (if (every? #{:x} triple) :x
      (if (every? #{:o} triple) :o)))

(declare triples)

(defn winner? [board]
  (first 
   (filter #{:x :o} 
           (map triple-winner? (triples board)))))

(defn triples [board]
  (concat
   (partition-all 3 board)
   (list
    (take-nth 3 board)
    (take-nth 3 (drop 1 board))
    (take-nth 3 (drop 2 board))
    (take-nth 4 board)
    (take-nth 2 (drop-last 2 (drop 2 board))))))

;; Just me learning about the code ((

(def x [1 2 3 :x :x :x 7 8 9])
(def y [1 2 3 4 5 6 7 8 9])

(partition-all 3 x)
(triples x)

(winner? x)

(map triple-winner? (triples x))
(filter #{:x :o} (map triple-winner? (triples x)))
(filter #{:x :o} (map triple-winner? (triples y)))
(map println (triples x))

;; ))

