(ns new-pet-clj.handler
  (:require [ring.middleware.reload :refer [wrap-reload]]
            [ring.middleware.defaults :refer :all]
            [new-pet-clj.config :as conf]
            [new-pet-clj.routes :refer [routes]]))

(def prod-handler routes)

(def dev-handler (-> #'prod-handler
                     wrap-reload))

(def handler (wrap-defaults (if conf/DEBUG
                              dev-handler
                              prod-handler)
                            secure-site-defaults))