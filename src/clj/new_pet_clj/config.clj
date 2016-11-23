(ns new-pet-clj.config
  (:require [environ.core :refer :all]
            [taoensso.timbre :as t]))

(def DEBUG (env :dev))

(def CORS_POLICY {:allowed-origins :match-origin
                  :allowed-methods #{:get :post}
                  :request-headers #{"Content-Type"}
                  :exposed-headers nil
                  :allow-credentials? false
                  :origin-varies? false
                  :max-age nil
                  :require-origin? false
                  :ignore-failures? false})

(defn config-logging
  "Configured Timbre logging"
  []
  (let [level (if DEBUG :debug :info)]
    (t/set-level! level)))
