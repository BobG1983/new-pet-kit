(ns new-pet-clj.routes
  (:require [compojure.core :refer [GET ANY defroutes context]]
            [compojure.route :refer [not-found resources]]
            [ring.util.response :refer [resource-response]]
            [new-pet-clj.api.routes :refer [api-routes]]))

(defroutes routes
           (GET "/" [] (assoc-in (resource-response "index.html" {:root "public"})
                                 [:headers "Content-Type"] "text/html"))
           (resources "/")
           (ANY "*" request {:status 404
                             :headers {"Content-Type" "text/html"}
                             :body "Error 404 in Site"}))

(def site-routes routes)
