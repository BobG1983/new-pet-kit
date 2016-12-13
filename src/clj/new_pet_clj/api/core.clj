(ns new-pet-clj.api.core
  (:require [new-pet-clj.api.create-cart :as cc]
            [taoensso.timbre :as t]))

(defn create-cart-response [kit]
  (let [cart (cc/create-cart kit)
        status (if (nil? (:cart-id cart)) :inactive :active)]
    (t/spy :info "create-cart" {:status status :cart cart})))

(defn buy-cart-response [cart-id]
  (t/info "buy-cart" cart-id)
  {:res "ok"})

