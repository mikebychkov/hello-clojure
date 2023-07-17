(ns hello-clojure.core
  (:gen-class)
  (:require [ring.adapter.jetty :as jet]))

(defn handler [request]
  {:status 200
   :headers {"Content-Type" "text/plain"}
   :body "Hello World"})

(defn -main
  [& args]
  (println "Hello, World!")
  (jet/run-jetty handler {:port 9999}))

;; https://www.baeldung.com/clojure-ring
;; https://github.com/eugenp/tutorials/blob/master/clojure-modules/clojure-ring/src/ring/core.clj