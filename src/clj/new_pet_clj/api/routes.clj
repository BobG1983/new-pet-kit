(ns new-pet-clj.api.routes
  (:require [compojure.core :refer [GET POST context]]))

(def api-routes
  (context "/api" []
    (GET "/" [] {:status 200 :body "GET Received"})
    (POST "/" [] {:status 200 :body "POST Received"})
    (GET "/echo" request {:status 200 :body request})
    (POST "/echo" request {:status 200 :body request})))