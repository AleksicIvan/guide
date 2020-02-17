(ns guide-me-v2.core
  (:require
   [day8.re-frame.http-fx]
   [reagent.core :as r]
   [re-frame.core :as rf]
   [goog.events :as events]
   [goog.history.EventType :as HistoryEventType]
  ;  [markdown.core :refer [md->html]]
   [guide-me-v2.ajax :as ajax]
   [guide-me-v2.components.navbar :refer [navbar]]
   [guide-me-v2.components.breadcrumbs :refer [breadcrumbs]]
   [reitit.core :as reitit]
   [guide-me-v2.store.subs]
   [guide-me-v2.store.events]
   [guide-me-v2.views.home :refer [home-page]]
   [guide-me-v2.views.where :refer [where-page]]
   [guide-me-v2.views.resolution :refer [resolution-page]]
   [clojure.string :as string])
  (:import goog.History))


(def pages
  {:home #'home-page
   :where #'where-page
   :result #'resolution-page})

(defn page []
  [:div
   [navbar]
   [breadcrumbs]
   [(pages @(rf/subscribe [:page]))]])

;; -------------------------
;; Routes

(def router
  (reitit/router
   [["/" :home]
    ["/usluga/:tip" :where]
    ["/usluga/:tip/mesto/:mesto/rezultat" :result]]))

;; -------------------------
;; History
;; must be called after routes have been defined
(defn hook-browser-navigation! []
  (doto (History.)
    (events/listen
      HistoryEventType/NAVIGATE
      (fn [event]
        (let [uri (or (not-empty (string/replace (.-token event) #"^.*#" "")) "/")]
          (rf/dispatch
           [:navigate (reitit/match-by-path router uri)]))))
    (.setEnabled true)))

;; -------------------------
;; Initialize app
(defn ^:dev/after-load mount-components []
  (rf/clear-subscription-cache!)
  (r/render [#'page] (.getElementById js/document "app")))

(defn init! []
  (rf/dispatch-sync [:navigate (reitit/match-by-name router :home)])

  (ajax/load-interceptors!)
  (rf/dispatch [:app/initialize])
  (hook-browser-navigation!)
  (mount-components))
