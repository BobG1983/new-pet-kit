(ns new-pet-clj.api.routes
  (:require [compojure.core :refer [GET POST ANY defroutes context]]
            [compojure.route :refer [not-found resources]]
            [ring.util.response :refer [resource-response]]))

(defn echo-handler [request]
  (do (println (str "Request: " (:body request)))
      (:body request)))

(defroutes api-routes
           (context "/api" []
                    (GET "/" [] {:status 200 :headers {"Content-Type" "text/html; charset=utf-8"} :body "GET Received"})
                    (POST "/" [] {:status 200 :headers {"Content-Type" "text/html; charset=utf-8"} :body "POST Received"})
                    (GET "/echo" request {:status 200 :headers {"Content-Type" "application/transit+json"} :body (echo-handler request)})
                    (POST "/echo" request {:status 200 :headers {"Content-Type" "application/transit+json"} :body (echo-handler request)})
                    (ANY "*" [] {:status 404 :headers {"Content-Type" "text/plain; charset=utf-8"} :body "No such route"})))

