(ns new-pet-clj.components.core
  (:require [re-frame.core :as rf]
            [new-pet-clj.components.kit-selector :as ks :refer [render-kit-selector]]
            [new-pet-clj.components.kit-display :as kd :refer [render-kit-display]]))

;; Kit Selector
(defn kit-selector []
  (let [selected-kit (rf/subscribe [:selected-kit])
        kits (rf/subscribe [:kits])]
    (ks/render-kit-selector @kits @selected-kit)))

(defn kit-display []
  (let [selected-kit (rf/subscribe [:selected-kit])]
    (if-not
      (nil? @selected-kit)
      (kd/render-kit-display @selected-kit))))
