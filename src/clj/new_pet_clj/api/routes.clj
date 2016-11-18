(ns new-pet-clj.api.routes
  (:require [compojure.core :refer [GET POST ANY defroutes context]]
            [compojure.route :refer [not-found resources]]
            [ring.util.response :refer [resource-response]]
            [new-pet-clj.config :as conf]
            [new-pet-clj.api.core :as api]))

(defn echo-handler [request]
  (do (println (str "Request Body: " (:body request)))
      (:body request)))

(def echo (context "/echo" []
                   (GET "/" request {:status 200
                                     :headers {"Content-Type" "application/transit+json"}
                                     :body (echo-handler request)})
                   (POST "/" request {:status 200
                                      :headers {"Content-Type" "application/transit+json"}
                                      :body (echo-handler request)})
                   (ANY "*" [] {:status 404})))

(def api (context "/api" []
                  (POST "/" request {:status 200
                                     :headers {"Content-Type" "application/transit+json"}
                                     :body (echo-handler request)})
                  (POST "/create-cart" request {:status 200
                                                :headers {"Content-Type" "application/transit+json"}
                                                :body (api/create-cart (:body request))})
                  (ANY "*" [] {:status 404})))

(defroutes api-routes
           (when conf/DEBUG echo)
           api)

