(ns new-pet-clj.api.routes
  (:require [compojure.core :refer [GET POST ANY defroutes context]]
            [compojure.route :refer [not-found resources]]
            [ring.util.response :refer [resource-response]]
            [new-pet-clj.config :as conf]
            [new-pet-clj.api.core :as api]))

(defroutes api-routes (context "/api" []
                               (POST "/create-cart" request {:status 200
                                                             :headers {"Content-Type" "application/transit+json"}
                                                             :body (api/create-cart-response (:body request))})
                               (POST "/buy-cart" request {:status 200
                                                          :headers {"Content-Type" "application/transit+json"}
                                                          :body (api/buy-cart-response (:body request))})
                               (ANY "*" request {:status 404
                                                 :headers {"Content-Type" "text/html"}
                                                 :body "Error 404 in API"})))

