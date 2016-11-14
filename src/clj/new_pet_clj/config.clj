(ns new-pet-clj.config
  (require [environ.core :refer env]))

(def DEBUG (env :dev))