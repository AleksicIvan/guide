(ns guide-me-v2.routes.home
  (:require
   [guide-me-v2.layout :as layout]
   [guide-me-v2.db.core :as db]
   [clojure.java.io :as io]
   [guide-me-v2.middleware :as middleware]
   [ring.util.response]
   [ring.util.http-response :as response]))

(defn home-page [request]
  (layout/render request "home.html"))

(defn where-page [request]
  (layout/render request "home.html"))

(defn result-page [request]
  (layout/render request "home.html"))

(defn home-protected-routes []
  [""
   {:middleware [middleware/wrap-csrf
                 middleware/wrap-formats
                 middleware/wrap-restricted
                 ]}
   ["/usluga/:tip" {:get where-page}]
   ["/usluga/:tip/mesto/:mesto/rezultat" {:get result-page}]
   ])

(defn home-route []
  [""
   {:middleware [middleware/wrap-csrf
                 middleware/wrap-formats]}
   ["/" {:get home-page}]])

