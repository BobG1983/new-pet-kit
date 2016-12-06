(ns new-pet-clj.components.header)

(defn header []
  [:header
   [:div.row
    [:a {:href "#/"}
     [:img.ten.pad-left-one.columns {:alt "New Pet Kit - The Right Start"
                                     :src "/gfx/white_logo_color_background_trimmed.png"}]]]])
