(ns new-pet-clj.site.core
  (:require [hiccup.core :as h]
            [new-pet-clj.site.head :as sh]
            [new-pet-clj.site.body :as sb]
            [new-pet-clj.site.not-found :as snf]))

(defn index []
  (h/html (list [:head (sh/head)]
                [:body (sb/body)])))

(defn not-found []
  (h/html (list [:head (sh/head)]
                [:body (snf/not-found)])))