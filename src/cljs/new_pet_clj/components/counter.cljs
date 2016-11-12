(ns new-pet-clj.components.counter)

(defn render-counter
  [selected-kit count on-click-fn]
  [:div
   [:div.row (str "Tits from " (:name selected-kit) ". This is the Home Page.")]
   [:div.row
    [:div [:button {:on-click #(on-click-fn)} "Test"]]
    [:div
     [:p (str "Button has been clicked " count " times.")]]]
   [:div.row [:a {:href "#/about"} "go to About Page"]]])

