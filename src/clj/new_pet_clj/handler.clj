(ns new-pet-clj.handler
  (:require [ring.middleware.reload :refer [wrap-reload]]
            [ring.middleware.defaults :refer :all]
            [compojure.core :as cjr]
            [new-pet-clj.config :as conf]
            [new-pet-clj.routes :refer [site-routes]]
            [new-pet-clj.api.routes :refer [api-routes]]
            [com.unbounce.encors :refer [wrap-cors]]
            [ring.middleware.transit :refer [wrap-transit-body wrap-transit-response]]
            [taoensso.timbre :as t]))

;; Combine routes
;; TODO: CSRF for the site but not the API.  It's not necessary due to site limitations but...
(def routes (wrap-defaults (cjr/routes api-routes site-routes)
                           (t/spy (if conf/DEBUG
                                      (-> site-defaults
                                          (assoc-in [:security :anti-forgery] false))
                                      (-> secure-site-defaults
                                          (assoc :proxy true)
                                          (assoc-in [:security :anti-forgery] false))))))

;; Production handler
(def prod-handler  (-> routes
                       (wrap-cors conf/CORS_POLICY)
                       (wrap-transit-body {:keywords? true :opts {}})
                       (wrap-transit-response)))

;; Development handler
(def dev-handler (-> prod-handler
                     (wrap-reload)))

