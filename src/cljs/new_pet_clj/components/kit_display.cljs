(ns new-pet-clj.components.kit-display)

(defn render-single-kit-element [elem]
  (let [elem-name (:name elem)]
    [:div {:key elem-name} elem-name]))

(defn render-kit-display [selected-kit]
  [:div
   (map #(render-single-kit-element %) (:kit selected-kit))])

