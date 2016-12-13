(ns new-pet-clj.components.cart-display
  (:require [taoensso.timbre :as t]
            [new-pet-clj.comms :as com]))

(def buy-label "Buy it now")
(def buy-placeholder "...")
(def buy-ready "Buy")
(def price-label "Price: ")
(def tax-warning "Exc. tax & shipping")

(defmulti render-button (fn [cart status] status))
(defmethod render-button :default [_ _]
  [:a.button.is-disabled buy-placeholder])
(defmethod render-button :active [cart _]
  [:a.button {:on-click (com/buy-cart (:cart-id cart))
              :href (:url cart)
              :target "_blank"} buy-ready])
(defmethod render-button :loading [cart _]
  [:a.button.is-loading])

(defmulti render-price (fn [cart status] status))
(defmethod render-price :default [_ _] [:div])
(defmethod render-price :active [cart _]
  [:div [:div.price [:small (str price-label (:price cart))]]
        [:div.price [:small tax-warning]]])

(defn show-cart [cart status]
  [:div.section
   [:div.control.is-horizontal
    [:div.control-label
     [:label.title.is-5 buy-label]
     (render-price cart status)]
    [:div.control
     (render-button cart status)]]])

(defn render-cart
  [cart status]
  (show-cart cart status))

