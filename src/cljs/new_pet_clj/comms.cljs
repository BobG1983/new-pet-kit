(ns new-pet-clj.comms
  (:require-macros [cljs.core.async.macros :refer [go]])
  (:require [cljs-http.client :as http]
            [cljs.core.async :refer [<!]]
            [new-pet-clj.config :as conf]
            [re-frame.core :as rf]))

(def url (if conf/DEBUG
           "http://localhost:3449/api/"
           "http://www.newpetkit.com/api/"))

(defn create-cart
  [kit]
  (do (rf/dispatch [:set-cart-status :loading])
      (go (let [endpoint (str url "create-cart")
                response (<! (http/post endpoint {:transit-params kit
                                                  :with-credentials? false}))
                cart (:cart (:body response))
                cart-status (:status (:body response))]
            (do (rf/dispatch [:set-cart cart])
                (rf/dispatch [:set-cart-status cart-status]))))))
