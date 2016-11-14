(ns new-pet-clj.handler
  (:require [compojure.core :refer [GET ANY defroutes context]]
            [compojure.route :refer [resources]]
            [ring.util.response :refer [resource-response]]
            [ring.middleware.reload :refer [wrap-reload]]
            [new-pet-clj.config :refer [DEBUG]]))

(defroutes routes
  (GET "/" [] (resource-response "index.html" {:root "public"}))
  (resources "/")
  (context "/api" []
    (GET "/" request {:status 200 :body request}))
  (ANY [] (resource-response "404.html" {:root "public"})))

(def prod-handler routes)

(def dev-handler (->
                   #'prod-handler
                   wrap-reload))

(def handler (if DEBUG
               (dev-handler)
               (prod-handler)))