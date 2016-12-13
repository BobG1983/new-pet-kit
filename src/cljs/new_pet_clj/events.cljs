(ns new-pet-clj.events
    (:require [re-frame.core :as rf]
              [new-pet-clj.db :as db]
              [new-pet-clj.comms :as c]))

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
   (do
     (c/create-cart selected-kit)
     (assoc db :selected-kit selected-kit))))

(rf/reg-event-db
  :set-cart
  (fn [db [_ cart]]
    (assoc db :cart cart)))

(rf/reg-event-db
  :set-cart-status
  (fn [db [_ cart]]
    (assoc db :cart-status cart)))

(rf/reg-event-db
  :set-conversion
  (fn [db [_ conversion]]
    (assoc db :conversion conversion)))