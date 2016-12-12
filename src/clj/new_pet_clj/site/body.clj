(ns new-pet-clj.site.body)

(def cljs-entrypoint "new_pet_clj.core.init()")

(defn body []
  (list [:div#app]
        [:script {:src "/js/compiled/app.js"}]
        [:script (str cljs-entrypoint ";")]))
