(ns new-pet-clj.handler
  (:require [compojure.core :refer [GET defroutes context]]
            [compojure.route :refer [resources]]
            [ring.util.response :refer [resource-response]]
            [ring.middleware.reload :refer [wrap-reload]]
            [new-pet-clj.config :refer [DEBUG]]))

(defroutes routes
  (GET "/" [] (resource-response "index.html" {:root "public"}))
  (resources "/")
  (context "/api" []
    (defroutes api-routes
      (GET "/" request {:status 200 :body request}))))



(def dev-handler (->
                   #'routes
                   wrap-reload))

(def prod-handler routes)

(def handler (if DEBUG
               (dev-handler)
               (prod-handler)))