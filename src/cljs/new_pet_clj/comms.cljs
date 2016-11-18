(ns new-pet-clj.comms
  (:require-macros [cljs.core.async.macros :refer [go]])
  (:require [cljs-http.client :as http]
            [cljs.core.async :refer [<!]]))

(defn create-cart
  [kit]
  (go (let [response (<! (http/post "http://localhost:3449/api/echo"
                                    {:transit-params kit
                                     :with-credentials? false}))]
        (prn (:body response)))))
