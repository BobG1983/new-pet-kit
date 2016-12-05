(ns new-pet-clj.components.header
  (:require [secretary.core :as s]))


(defn header []
  [:header
   [:div.logo
    [:a {:href "#/"}
     [:img {:alt "New Pet Kit - The Right Start"
            :width 524
            :height 131
            :src "/gfx/color_logo_524x131.png"}]]]])
