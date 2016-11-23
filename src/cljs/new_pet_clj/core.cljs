(ns new-pet-clj.core
    (:require [reagent.core :as reagent]
              [re-frame.core :as re-frame]
              [new-pet-clj.events]
              [new-pet-clj.subs]
              [new-pet-clj.routes :as routes]
              [new-pet-clj.views :as views]
              [new-pet-clj.config :as conf]))


(defn dev-setup []
  (when conf/DEBUG
    (enable-console-print!)
    (println "dev mode")))

(defn mount-root []
  (reagent/render [views/main-panel]
                  (.getElementById js/document "app")))

(defn ^:export init []
  (conf/config-logging)
  (routes/app-routes)
  (re-frame/dispatch-sync [:initialize-db])
  (dev-setup)
  (mount-root))
