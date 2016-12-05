(ns new-pet-clj.views
    (:require [re-frame.core :as rf]
              [new-pet-clj.components.core :as comp]))

(defn home-panel []
  (fn []
    [:div
     (comp/kit-selector)
     (comp/kit-display)]))

;; Main
(defmulti panels identity)
(defmethod panels :home-panel [] [home-panel])
(defmethod panels :default [] [:div [:a {:href "/"} "Home"]])

(defn show-panel
  [panel-name]
  [panels panel-name])

(defn main-panel []
  (let [active-panel (rf/subscribe [:active-panel])]
    (fn []
      [:div
       (comp/header)
       [show-panel @active-panel]
       (comp/footer)])))