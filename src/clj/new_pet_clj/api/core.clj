(ns new-pet-clj.api.core
  (:require [environ.core :refer [env]]
            [pradpi.core :as p]
            [clojure.pprint :as pp]))

(def associate-id (env :associate-id))
(def amazon-key (env :amazon-key))
(def secret-key (env :secret-key))

(def config {:associate-tag associate-id
             :key-id amazon-key
             :secret secret-key})

(defn asin-list->item-map
  "Converts a list of ASINs to a map of items"
  [asins]
  (reduce conj {}
    (map-indexed (fn [idx asin] (let [key-root (str "Item." (inc idx))
                                      asin-key (keyword (str key-root ".ASIN"))
                                      quant-key (keyword (str key-root ".Quantity"))]
                                  {asin-key asin quant-key 1}))
                 asins)))

(defn create-cart-request
  "Takes a map of items and returns a 'CartCreate' request"
  [items-map]
  (p/request "CartCreate" "https" config items-map))

(defn build-response
  "Extracts price, cartid, and purchase url from the amazon response"
  [cart-request]
  (let [cart (:cart @cart-request)
        cart-id (:cart-id cart)
        price (:formatted-price (:sub-total cart))
        url (:purchase-url cart)]
    {:cart-id cart-id :price price :url url}))

(defn create-cart
  "Given a kit creates an Amazon cart containing
  the items in the kit and returns the url to buy it."
  [kit]
  (do (println (str "Request Body: " kit))
      (try (->> kit
                (:contents)
                (map :code)
                (asin-list->item-map)
                (create-cart-request)
                (build-response))
           (catch Exception e (println e)))))
