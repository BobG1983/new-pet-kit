(ns new-pet-clj.components.kit-selector
  (:require [re-frame.core :as rf]))

(def kit-selector-title "kit-selector")
(def placeholder-selection "...")
(def kit-title "Pick your kit")

(defn kit-selector-option
  [kit]
  (let [name (:name kit)]
    [:option {:value name
              :key (keyword name)} name]))

(defn get-kit-by-name
  [kit-name kits]
  (some #(when (= (:name %) kit-name) %) kits))

(defn render-kit-selector [kits default-kit]
  [:div.section
    [:div.control.is-horizontal
     [:div.control-label
      [:label.title.is-5.is-inline kit-title]]
     [:div.control
      [:div.select
       [:select {:id kit-selector-title
                 :on-change #(rf/dispatch [:set-selected-kit (get-kit-by-name (-> % .-target .-value) kits)])
                 :defaultValue placeholder-selection}
        [:option {:value placeholder-selection :disabled true :hidden true} placeholder-selection]
        (map kit-selector-option kits)]]]]])
