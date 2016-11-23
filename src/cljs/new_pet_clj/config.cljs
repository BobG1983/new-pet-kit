(ns new-pet-clj.config
  (:require [taoensso.timbre :as t]))

(def DEBUG
  ^boolean js/goog.DEBUG)

(defn config-logging
  "Configured Timbre logging"
  []
  (let [level (if DEBUG :debug :info)]
    (t/set-level! level)))