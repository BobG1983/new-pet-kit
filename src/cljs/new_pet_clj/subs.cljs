(ns new-pet-clj.subs
    (:require-macros [reagent.ratom :refer [reaction]])
    (:require [re-frame.core :as rf]))

(rf/reg-sub
 :selected-kit
 (fn [db] (:selected-kit db)))

(rf/reg-sub
 :active-panel
 (fn [db _] (:active-panel db)))

(rf/reg-sub
 :kits
 (fn [db] (:kits db)))

(rf/reg-sub
  :cart
  (fn [db] (:cart db)))

(rf/reg-sub
  :cart-status
  (fn [db] (:cart-status db)))