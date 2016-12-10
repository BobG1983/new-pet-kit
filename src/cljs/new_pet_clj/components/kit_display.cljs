(ns new-pet-clj.components.kit-display)

(def cart-label "Kit Contents")
(def amazon-prime-text "Need your kit quick?  Try Amazon Prime Free for 30-Days.")
(def amazon-prime-url "https://www.amazon.com/tryprimefree?ref_=assoc_tag_ph_1427739975520&_encoding=UTF8&camp=1789&creative=9325&linkCode=pf4&tag=newpetkit-20&linkId=e607e2601f298cf3a974454106592444")

(defn render-single-kit-element [elem]
  (let [elem-name (:name elem)]
    [:li {:key elem-name} elem-name]))

(defn render-kit-display [kit status]
  [:div.section
   [:small
    [:a {:href amazon-prime-url :target "_blank"} amazon-prime-text]]
   [:div.control.is-horizontal
    [:div.control-label
     [:label.title.is-5.is-inline cart-label]]
    [:div.control
      [:ul
       (map render-single-kit-element (:contents kit))]]]])
