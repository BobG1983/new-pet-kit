(ns new-pet-clj.api.core)

(defn create-cart
  "Given a kit creates an Amazon cart containing the items in the kit and returns it."
  [kit]
  (do (println (str "Request Body: " kit))
      kit))
