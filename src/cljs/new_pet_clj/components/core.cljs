(ns new-pet-clj.components.core
  (:require [re-frame.core :as rf]
            [new-pet-clj.components.kit-selector :as ks]
            [new-pet-clj.components.kit-display :as kd]
            [new-pet-clj.components.cart-display :as cd]
            [new-pet-clj.components.header :as h]
            [new-pet-clj.components.footer :as f]
            [new-pet-clj.components.splash :as spl]))

(defn kit-selector []
  (let [selected-kit (rf/subscribe [:selected-kit])
        kits (rf/subscribe [:kits])]
    (ks/render-kit-selector @kits @selected-kit)))

(defn cart-display []
  (let [cart (rf/subscribe [:cart])
        status (rf/subscribe [:cart-status])]
    (cd/render-cart @cart @status)))

(defn kit-display []
  (let [selected-kit (rf/subscribe [:selected-kit])
        cart-status (rf/subscribe [:cart-status])]
    (if (= @cart-status :active)
        (kd/render-kit-display @selected-kit @cart-status))))

(defn header []
  (h/header))

(defn footer []
  (f/footer))

(defn splash []
  (spl/splash))