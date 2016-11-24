(ns new-pet-clj.config
  (:require [taoensso.timbre :as t]))

(def DEBUG
  ^boolean js/goog.DEBUG)

(defn log-environment []
  (when DEBUG
    (t/debug (str "Debug: " DEBUG))))

(defn configure-logging
  "Configured Timbre logging"
  []
  (let [level (if DEBUG :debug :warn)]
    (t/set-level! level)))