(ns new-pet-clj.components.cart-display
  (:require [taoensso.timbre :as t]))

(defn render-cart
  [cart status]
  [:div [:div (str "Cart Status: " (name status))]
        [:div (str "URL: " (:url cart))]
        [:div (str "Price: " (:price cart))]
        [:div (str "Cart ID: " (:cart-id cart))]])
