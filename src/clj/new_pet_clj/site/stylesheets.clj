(ns new-pet-clj.site.stylesheets)

(defn sheet-url [folder sheet]
  (if (nil? folder)
    sheet
    (str "/" folder "/" sheet)))

(defn stylesheet [css-folder sheet]
  [:link {:href (sheet-url css-folder sheet) :onload "this.rel='stylesheet'" :as "style" :rel "preload"}])

(defn stylesheets [css-folder & sheets]
  (list (map #(stylesheet css-folder %1) sheets)))