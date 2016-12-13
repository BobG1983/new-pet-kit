(ns new-pet-clj.components.footer
  (:require [taoensso.timbre :as t]))

(def trademark-notice
  "All trademarks™ belong to their respective holders.")

(defn google-conversion [conv]
  (if (true? conv)
    [:div.conversion-tracking.is-inline
     [:script "var google_conversion_id = 865665491;var google_conversion_language = \"en\";var google_conversion_format = \"3\";var google_conversion_color = \"ffffff\";var google_conversion_label = \"EVujCI3SxmwQ04PknAM\";var google_remarketing_only = false;"]
     [:script {:src "https://www.googleadservices.com/pagead/conversion.js"}]
     [:noscript
       [:img {:src "https://www.googleadservices.com/pagead/conversion/865665491/?label=EVujCI3SxmwQ04PknAM&guid=ON&script=0",
              :alt "",
              :width "1",
              :height "1"}]]]))

(defn footer [conversion]
  [:div.hero-foot
   [:div.container
     [:div.copyright.is-inline
      [:a {:href "mailto:bob.gardner.professional@gmail.com"} "© Robert Gardner, 2016"]]
     [:div.trademark.is-inline trademark-notice]
     (google-conversion conversion)]])
