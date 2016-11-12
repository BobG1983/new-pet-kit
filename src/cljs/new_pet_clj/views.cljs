(ns new-pet-clj.views
    (:require [re-frame.core :as rf]
              [new-pet-clj.components.core :as comp]))


;; Home
(defn increment-counter
  []
  (rf/dispatch [:count-clicked]))

(defn home-panel []
  (fn []
    [:div
     (comp/kit-selector)
     (comp/kit-display)]))

;; About
(defn about-panel []
  (fn []
    [:div "This is the About Page."
     [:div [:a {:href "#/"} "go to Home Page"]]]))


;; Main
(defmulti panels identity)
(defmethod panels :home-panel [] [home-panel])
(defmethod panels :about-panel [] [about-panel])
(defmethod panels :default [] [:div])

(defn show-panel
  [panel-name]
  [panels panel-name])

(defn main-panel []
  (let [active-panel (rf/subscribe [:active-panel])]
    (fn []
      [show-panel @active-panel])))
