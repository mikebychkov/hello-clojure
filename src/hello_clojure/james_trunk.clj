(ns hello-clojure.james-trunk
  (:require [clojure.core]
            [clojure.string :as str])
  )

(def book (slurp "https://www.gutenberg.org/files/2701/2701-0.txt"))

(def words (re-seq #"[\w|']+" book))

(count words)

(take 20 words)

;; MOST FREQUENT WORDS

(->> words
     (map str/lower-case)
     (frequencies)
     (filter #(> (val %1) 1000))
     ;;(sort-by val)
     (take-last 20))

;; LONGEST WORDS

(->> words
     (distinct)
     (sort-by count) ;; BECAUSE COUNT ON STRING RETURNS IT LENGTH
     (take-last 20)
     (group-by count))

;; PALINDROME

(defn palindrome? [col]
  (= (seq col) (reverse col)))

(palindrome? [1 2 3 2 1])
(palindrome? "racecar")

;; LONGEST PALINDROME

(->> words
     (distinct)
     (filter palindrome?)
     (sort-by count)
     (take-last 1))