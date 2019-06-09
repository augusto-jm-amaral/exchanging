(ns clojure-simple-http.core
  (:require [org.httpkit.server :refer [run-server]]
            [clj-time.core :as t]
            [compojure.core :refer :all]
            [compojure.route :as route]))

(def PORT (Integer. (or (System/getenv "PORT")
                        "8080")))

(defroutes app
  (GET "/healthcheck" [] "Hello")
  (GET "/user/:id" [id] (if (< (Integer. id) 3) "Menor que três." "Maior ou igual a três."))
  (route/not-found ""))

(defn -main [& args]
  (run-server app {:port PORT})
  (println "Server started on port" PORT))
