(ns new-pet-clj.routes
  (:require [compojure.core :refer [GET defroutes context]]
            [compojure.route :refer [not-found resources]]
            [ring.util.response :refer [resource-response]]))

(defroutes routes
  (GET "/" [] (resource-response "index.html" {:root "public"}))
  (context "/api" []
    (GET "/" request {:status 200 :body request}))
  (resources "/")
  (not-found (resource-response "404.html" {:root "public"})))