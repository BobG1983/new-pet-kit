(ns new-pet-clj.config
  (require [environ.core :refer :all]))

(def DEBUG (env :dev))