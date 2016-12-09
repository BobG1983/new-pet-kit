(ns new-pet-clj.views
    (:require [re-frame.core :as rf]
              [new-pet-clj.components.core :as comp]))

(defn home-panel []
  (fn []
    [:div.hero-body
     [:div.container
      [:div.columns
       [:div.column.is-5.has-text-right
        (comp/splash)]
       [:div.column.is-6.is-offset-1.has-text-left.is-vcentered
        (comp/kit-selector)
        (comp/cart-display)
        (comp/kit-display)]]]]))

(defmulti panels identity)
(defmethod panels :home-panel [] [home-panel])
(defmethod panels :default [] [:div [:a {:href "/"} "Home"]])

(defn show-panel
  [panel-name]
  [panels panel-name])

(defn main-panel []
  (let [active-panel (rf/subscribe [:active-panel])]
    (fn []
      [:section.is-full-height.is-dark.hero
       (comp/header)
       [:div [show-panel @active-panel]]
       (comp/footer)])))