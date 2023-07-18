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
