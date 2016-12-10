(ns new-pet-clj.components.header
  (:require [new-pet-clj.components.social :as soc]))

(defn header []
  [:div.hero-head
   [:div.container
    [:nav.nav
     [:div.container
      [:div.nav-left
       [:a.nav-item {:href "/#/"} [:img {:src "/gfx/white_logo_transparent_background_small.png"
                                         :alt "Home"
                                         :height "48"
                                         :width "259"}]]]
      [:div.nav-right.nav-menu
       ;(soc/facebook)
       ;(soc/twitter)
       (soc/email)]]]]])
