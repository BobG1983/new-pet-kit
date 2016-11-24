(ns new-pet-clj.server
  (:require [new-pet-clj.handler :refer [handler]]
            [config.core :refer [env]]
            [org.httpkit.server :refer [run-server]]
            [new-pet-clj.config :as conf])
  (:gen-class))

(defn -main [& args]
  (let [port (Integer/parseInt (or (env :port) "3449"))]
    (run-server handler {:port port})))
