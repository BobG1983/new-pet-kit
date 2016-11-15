(ns new-pet-clj.api.routes
  (:require [compojure.core :refer [GET POST defroutes context]]
            [compojure.route :refer [not-found resources]]
            [ring.util.response :refer [resource-response]]
            [new-pet-clj.api.core :as api]))

(def api-routes
  (context "/api" []
    (GET "/" [] {:status 200 :body (str "GET Received")})
    (POST "/" [] {:status 200 :body "POST Received"})))
