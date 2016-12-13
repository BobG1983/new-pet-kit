(ns new-pet-clj.api.create-cart
  (:require [environ.core :refer [env]]
    [pradpi.core :as p]
    [taoensso.timbre :as t]))

(def associate-id (env :associate-id))
(def amazon-key (env :amazon-key))
(def secret-key (env :secret-key))

(def config {:associate-tag associate-id
             :key-id amazon-key
             :secret secret-key})

(defn asin-list->item-map [asins]
  (reduce conj {}
    (map-indexed
      (fn [idx asin]
          (let [key-root (str "Item." (inc idx))
                asin-key (keyword (str key-root ".ASIN"))
                quant-key (keyword (str key-root ".Quantity"))]
            {asin-key asin quant-key 1}) asins))))

(defn create-cart-request [items-map]
  (p/request "CartCreate" "https" config items-map))

(defn build-response [cart-request]
  (let [cart (:cart @cart-request)
        cart-id (:cart-id cart)
        price (:formatted-price (:sub-total cart))
        url (:purchase-url cart)]
    {:cart-id cart-id :price price :url url}))

(defn create-cart [kit]
  (try (->> kit
            (:contents)
            (map :code)
            (asin-list->item-map)
            (create-cart-request)
            (build-response))
       (catch Exception e (t/error e))))