(ns new-pet-clj.api.core
  (:require [new-pet-clj.api.create-cart :as cc]
            [taoensso.timbre :as t]))



(defn create-cart-response
  "Creates a reponse object to return to the client, including :status and :cart"
  [kit]
  (let [cart (cc/create-cart kit)
        status (if (nil? (:cart-id cart)) :inactive :active)]
    (t/spy :info {:status status :cart cart})))

(defn buy-cart-response [cart]
  (t/spy :info cart))

