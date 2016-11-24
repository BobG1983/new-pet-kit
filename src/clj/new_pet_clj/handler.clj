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

;; Can't use SSL with Figwheel
;(def site-defs (if conf/DEBUG site-defaults (assoc secure-site-defaults :proxy true)))
;(def api-defs (if conf/DEBUG api-defaults (assoc secure-api-defaults :proxy true)))

;; Wrap handlers in appropriate defaults
(def site  (wrap-defaults site-routes secure-site-defaults))
(def api   (wrap-defaults api-routes api-defaults))

;; Combine handlers
(def routes (cjr/routes api site))

;; Main handler
(def prod-handler  (-> routes
                       (wrap-cors conf/CORS_POLICY)
                       (wrap-transit-body {:keywords? true :opts {}})
                       (wrap-transit-response)))

;; Add dev mode wraps
(def dev-handler (-> prod-handler
                     (wrap-reload)))

