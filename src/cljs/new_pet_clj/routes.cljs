(ns new-pet-clj.routes
    (:require-macros [secretary.core :refer [defroute]])
    (:import goog.History)
    (:require [secretary.core :as s]
              [goog.events :as events]
              [goog.history.EventType :as EventType]
              [re-frame.core :as rf]))

(defn hook-browser-navigation! []
  (doto (History.)
    (events/listen
     EventType/NAVIGATE
     (fn [event]
       (s/dispatch! (.-token event))))
    (.setEnabled true)))

(defn app-routes []
  (s/set-config! :prefix "#")
  ;; --------------------
  ;; define routes here
  (defroute "/" []
    (rf/dispatch [:set-active-panel :home-panel]))
  (defroute "/about" []
    (rf/dispatch [:set-active-panel :about-panel]))
  ;; --------------------
  (hook-browser-navigation!))
