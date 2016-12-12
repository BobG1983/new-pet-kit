(ns new-pet-clj.site.scripts)

(defn inline-script [js]
  [:script js])

(defn script [js]
  [:script {:async true :defer true} js])