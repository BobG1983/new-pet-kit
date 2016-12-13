(ns new-pet-clj.components.footer)

(def trademark-notice
  "All trademarks™ belong to their respective holders.")

(defn footer []
  [:div.hero-foot
   [:div.container
     [:div.copyright.is-inline
      [:a {:href "mailto:bob.gardner.professional@gmail.com"} "© Robert Gardner, 2016"]]
     [:div.trademark.is-inline trademark-notice]]])