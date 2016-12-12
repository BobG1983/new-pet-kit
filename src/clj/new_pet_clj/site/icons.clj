(ns new-pet-clj.site.icons)

(defn size-string [size]
  (str size "x" size))

(defn icon [filename size type rel]
  (let [size-string (size-string size)
        href (str filename size-string ".png")
        attribs {:href href :sizes size-string :rel rel}]
    (if (nil? type)
      [:link attribs]
      [:link (conj attribs [:type type])])))

(defn apple-icons [sizes]
  (list (map #(icon "/apple-icon-" %1 nil "apple-touch-icons") sizes)))

(defn android-icons [sizes]
  (list [:link {:href "/manifest.json" :rel "manifest"}]
        (map #(icon "/android-icon-" %1 "image/png" "icon") sizes)))

(defn favicons [sizes]
  (list (map #(icon "/favicon-" %1 "image/png" "icon") sizes)))

(defn msft-icon [size]
  (let [size-string (size-string size)]
    [:meta {:content (str "/ms-icon-" size-string ".png")
            :name "msapplication-TileImage"}]))
(defn msft-icons [sizes]
  (list [:meta {:content "#ffffff" :name "msapplication-TileColor"}]
        (map msft-icon sizes)))

(defn icons [apple-icon-sizes android-icon-sizes msft-icon-sizes favicon-sizes]
  (list (apple-icons apple-icon-sizes)
        (android-icons android-icon-sizes)
        (favicons favicon-sizes)
        (msft-icons msft-icon-sizes)))