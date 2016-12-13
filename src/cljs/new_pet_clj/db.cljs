(ns new-pet-clj.db
  (:require [new-pet-clj.kits.core :as k]))

(def default-db
  {:active-panel :home-panel
   :cart nil
   :cart-status :inactive
   :selected-kit nil
   :kits (list k/puppy-kit
               k/small-dog-kit
               k/medium-dog-kit
               k/large-dog-kit
               k/kitten-kit
               k/cat-kit)})