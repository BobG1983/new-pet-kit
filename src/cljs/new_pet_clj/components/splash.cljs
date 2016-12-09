(ns new-pet-clj.components.splash)

(def title "New Pet?")
(def subtitle "Get everything you need in two clicks")

(defn splash []
  [:div.section
   [:div.title
    [:p title]]
   [:div.subtitle
    [:p subtitle]]])
