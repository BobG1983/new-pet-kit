(ns new-pet-clj.site.routes
  (:require [compojure.core :refer [GET ANY defroutes context]]
            [compojure.route :as route]
            [ring.util.response :refer [resource-response]]
            [new-pet-clj.site.core :as site]))

(defroutes routes
           (GET "/" [] {:status 200
                        :headers {"Content-Type" "text/html"}
                        :body (site/index)})
           (route/resources "/")
           (route/not-found {:status 404
                             :headers {"Content-Type" "text/html"}
                             :body (site/not-found)}))

(def site-routes routes)
