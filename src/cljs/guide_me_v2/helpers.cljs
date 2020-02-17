(ns guide-me-v2.helpers)

(defn redirect! [loc]
  (set! (.-location js/window) loc))
