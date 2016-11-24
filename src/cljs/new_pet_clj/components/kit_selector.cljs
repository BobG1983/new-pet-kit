(ns new-pet-clj.components.kit-selector
  (:require [re-frame.core :as rf]))

(def kit-selector-title "kit-selector")

(defn kit-selector-option
  [kit]
  (let [name (:name kit)]
    [:option {:value name
              :key (keyword name)} name]))

(defn get-kit-by-name
  [kit-name kits]
  (some #(when (= (:name %) kit-name) %) kits))

(defn render-kit-selector [kits default-kit]
  [:form
   [:div.row
    [:div
     [:div.two.columns.inline "I'm getting a: "]
     [:div.four.columns.inline
      [:select {:id           kit-selector-title
                :defaultValue (:name default-kit)
                :on-change    #(rf/dispatch [:set-selected-kit (get-kit-by-name (-> % .-target .-value) kits)])}
       (map kit-selector-option kits)]]]]])
