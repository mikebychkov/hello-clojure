(ns hello-clojure.ddz
  (:require
   [clojure.core]))

(defn get-guess []
  (println "Play your hand: (r)ock, (p)aper, (s)cissors")
  (let [guess (read-line)]
    (if (contains? #{"r" "p" "s"} guess) guess nil)))

(defn winner [guess1 guess2]
  (let [guesses [guess1 guess2]]
    (cond
      (= guess1 guess2) 0
      (= guesses ["p" "r"]) 1
      (= guesses ["r" "p"]) 2
      (= guesses ["s" "r"]) 2
      (= guesses ["r" "s"]) 1
      (= guesses ["p" "s"]) 2
      (= guesses ["s" "p"]) 1
      )))

(defn play-hand []
  (let [computer-guess (rand-nth ["r" "p" "s"])
        user-guess (get-guess)
        winner (winner computer-guess user-guess)]
    (println "The computer guess: " computer-guess)
    (println "Your guess: " user-guess)
    (cond
      (= user-guess nil)(println "Your input was invalid.")
      (= winner 0)(println "Game tied!")
      (= winner 1)(println "Computer wins!")
      (= winner 2)(println "You win!")
      )))

(defn play-game [] 
  (loop []
     (play-hand)
     (recur)))

;; (play-game)