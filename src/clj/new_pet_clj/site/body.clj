(ns new-pet-clj.site.body)

(def cljs-entrypoint "new_pet_clj.core.init()")

(defn body []
  (list [:div#app]
        [:script {:src "/js/compiled/app.js"}]
        [:script (str cljs-entrypoint ";")]
        [:noscript
         [:img
          {:src "https://www.facebook.com/tr?id=700000206841751&ev=PageView&noscript=1",
           :style "display:none",
           :width "1",
           :height "1"}]]))
