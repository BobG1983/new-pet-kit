(ns new-pet-clj.events
    (:require [re-frame.core :as rf]
              [new-pet-clj.db :as db]))

(rf/reg-event-db
 :initialize-db
 (fn  [_ _]
   db/default-db))

(rf/reg-event-db
 :set-active-panel
 (fn [db [_ active-panel]]
   (assoc db :active-panel active-panel)))

(rf/reg-event-db
 :set-selected-kit
 (fn [db [_ selected-kit]]
   (assoc db :selected-kit selected-kit)))

(rf/reg-event-db
 :count-clicked
 (fn [db [_ _]]
   (assoc db :count (+ (:count db) 1))))

