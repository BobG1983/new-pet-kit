(ns new-pet-clj.comms
  (:require-macros [cljs.core.async.macros :refer [go]])
  (:require [cljs-http.client :as http]
            [cljs.core.async :refer [<!]]
            [new-pet-clj.config :as conf]))

(def url (if conf/DEBUG
           "http://localhost:3449/api/"
           "http://www.newpetkit.com/api/"))

(def echo-url "http://localhost:3449/echo/")

(defn create-cart
  [kit]
  (go (let [endpoint (str url "create-cart")
            response (<! (http/post endpoint {:transit-params kit
                                              :with-credentials? false}))]
        (prn (:body response)))))
