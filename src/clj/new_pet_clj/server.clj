(ns new-pet-clj.server
  (:require [new-pet-clj.handler :refer [handler]]
            [config.core :refer [env]]
            [ring.adapter.jetty :refer [run-jetty]]
            [new-pet-clj.config :as conf])
  (:gen-class))

(defn -main [& args]
  (let [port (Integer/parseInt (or (env :port) "3000"))]
    (do (conf/config-logging)
        (run-jetty handler {:port port :join? false}))))
