(ns new-pet-clj.config
  (:require [environ.core :refer :all]
            [taoensso.timbre :as t]))

(def DEBUG (= (env :dev) "true"))

(def CORS_POLICY {:allowed-origins :match-origin
                  :allowed-methods #{:get :post}
                  :request-headers #{"Content-Type"}
                  :exposed-headers nil
                  :allow-credentials? false
                  :origin-varies? false
                  :max-age nil
                  :require-origin? false
                  :ignore-failures? false})

(defn log-environment []
  (when DEBUG
    (t/debug (str "Debug: " DEBUG))
    (t/debug (str "Amazon Key: " (env :amazon-key)))
    (t/debug (str "Secret Key: " (env :secret-key)))
    (t/debug (str "Associate ID: " (env :associate-id)))))

(defn configure-logging
  "Configured Timbre logging"
  []
  (let [level (if DEBUG :debug :warn)]
    (t/set-level! level)))
