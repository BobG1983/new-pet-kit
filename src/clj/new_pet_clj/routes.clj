(ns new-pet-clj.routes
  (:require [compojure.core :refer [GET defroutes context]]
            [compojure.route :refer [not-found resources]]
            [ring.util.response :refer [resource-response]]
            [new-pet-clj.api.routes :refer [api-routes]]))

(defroutes routes
  api-routes
  (GET "/" [] (resource-response "index.html" {:root "public"}))
  (resources "/")
  (not-found (resource-response "404.html" {:root "public"})))