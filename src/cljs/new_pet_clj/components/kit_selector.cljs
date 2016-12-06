(ns new-pet-clj.components.kit-selector
  (:require [re-frame.core :as rf]))

(def kit-selector-title "kit-selector")

(def placeholder-selection "...")

(defn kit-selector-option
  [kit]
  (let [name (:name kit)]
    [:option {:value name
              :key (keyword name)} name]))

(defn get-kit-by-name
  [kit-name kits]
  (some #(when (= (:name %) kit-name) %) kits))

(defn render-kit-selector-body [kits default-kit]
  [:div.row
   [:div.six.columns.pad-left-three
    [:div.inline "I'm getting a: "]
    [:div.inline
      [:form
       [:select {:id kit-selector-title
                 :on-change #(rf/dispatch [:set-selected-kit (get-kit-by-name (-> % .-target .-value) kits)])}
        [:option {:value placeholder-selection :disabled true :selected true :hidden true} placeholder-selection]
        (map kit-selector-option kits)]]]]])

(defn render-kit-selector-intro []
  [:div.row
   [:div.eight.columns.pad-left-two.
    [:h2.center-text "New pet?"]
    [:h4.center-text "Get everything you need in two clicks"]]])

(defn render-kit-selector [kits default-kit]
  [:div
   (render-kit-selector-intro)
   (render-kit-selector-body kits default-kit)])