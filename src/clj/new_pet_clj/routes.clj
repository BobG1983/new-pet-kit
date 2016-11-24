(ns new-pet-clj.routes
  (:require [compojure.core :refer [GET defroutes context]]
            [compojure.route :refer [not-found resources]]
            [ring.util.response :refer [resource-response]]
            [new-pet-clj.api.routes :refer [api-routes]]))

(defroutes routes
           (GET "/" [] (assoc-in (resource-response "index.html" {:root "public"})
                                 [:headers "Content-Type"] "text/html"))
           (resources "/")
           (not-found (assoc-in (resource-response "404.html" {:root "public"})
                                [:header "Content-Type"] "text/html")))

(def site-routes routes)
