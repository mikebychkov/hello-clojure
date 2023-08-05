(ns hello-clojure.trys
  (:require
   [clojure.core]))


(defn sayHi [name] 
  (str "Hi, " name))

(sayHi "Mike")

(let [x (fn [x]
         (sayHi x)
         (let [x 7]
           (sayHi x)))]
  (x 3))

;; 

( seq [1 2 3 4]) 

( peek [1 2 3 4]) 
( pop [1 2 3 4]) 

( first [1 2 3 4]) 
( rest [1 2 3 4]) 

;; 

( seq '(1 2 3 4)) 

( peek '(1 2 3 4)) 
( pop '(1 2 3 4)) 

( first '(1 2 3 4)) 
( rest '(1 2 3 4)) 

;; 

( seq {1 2 3 4})

( first {1 2 3 4})
( rest {1 2 3 4})

;; 

(loop [x [1 2 3 4 5]]
  (if (first x)
    (do
      (println (first x))
      (recur (rest x)))))

;; 

(def z (cons 6 (cons 5 (cons 3 nil))))
(first z)
(rest z)
(first (rest z))
(rest (rest z))

;; 

(defn do-lazy [n b]
  (lazy-seq
   (if (> n b)
     nil
     (cons n (do-lazy (inc n) b)))))

(do-lazy 1 10)
(first (do-lazy 1 10))
(first (rest (do-lazy 1 10)))

(loop [l (do-lazy 1 10)]
  (if (first l)
    (do 
      (println (first l))
      (recur (rest l)))
    (println "end")
    ))

;; 

(defn zeroes []
  (lazy-seq
   (cons 0 (zeroes))))

(first (zeroes))
(first (rest (zeroes)))
;; (print (rest (zeroes)))

(loop [l (zeroes) n 10]
  (if (> n 0)
    (do 
      (println (first l))
      (recur (rest l) (dec n)))
    (println "end")
    ))

;; 

(repeatedly 3 rand)

;; 

(apply * (range 1 10))

;; 

(reduce + 20 [1 2 3 4])
(reductions + 20 [1 2 3 4])

;; 

(import java.time.LocalDateTime)
(print (LocalDateTime/now))

;; 

(keyword? :foo)
(symbol? :foo)

;; 

(def my-set #{1 2 3})
(print my-set)

;; 

(def m {:x 8 :y 89 :q 45})
(let [{:keys [x q]} m]
  (print x q))

;; 

([1 2 3] 1)
({:x 13 :r 33} :r)
(:x {:x 13 :r 33})

;; 

(def f-f #(print "hello" %2 %1))
(f-f 33 44)

;; 

(def bar "QWAS")
(def xx ^:foo ^bar [1 3 2])
(meta xx)

;; 

;; (clojure.pprint/pprint (meta #'+))

;;

;; FIXING NESTED FUNCTIONS

;; REGULAR
(filter odd? (map inc (range 5)))

;; STREAM LIKE WITH "->>" - "TREAD LAST" MACRO
(->> (range 5)
     (map inc)
     (filter odd?))
