(ns guide-me-v2.helpers)

(defn redirect! [loc]
  (set! (.-location js/window) loc))

(defn is-city-we-have-data [city]
  (case (.toLowerCase (or city " "))
    "beograd" true
    "zaječar" true
    "užice" true
    false))

(defn get-city-from-user [user]
  (:city user))

