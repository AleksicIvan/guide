(ns guide-me-v2.app
  (:require [guide-me-v2.core :as core]))

;;ignore println statements in prod
(set! *print-fn* (fn [& _]))

(core/init!)
