(ns new-pet-clj.config
  (require [environ.core :refer :all]))

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

