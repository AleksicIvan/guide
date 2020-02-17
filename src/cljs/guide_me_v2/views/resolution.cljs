(ns guide-me-v2.views.resolution
  (:require
   [day8.re-frame.http-fx]
   [re-frame.core :as rf]
   [guide-me-v2.helpers :refer [redirect!]]
   [guide-me-v2.store.subs]
   [guide-me-v2.store.events]))

(defn get-type [type]
  (case type
    "registracija-auta" "Registracija auta"
    "porez-na-dohodak" "Porez na dohodak"
    "uknjizba-stana" "Uknjižba stana"
    " "))

(defn resolution-page []
  [:section#section.section>div.container.is-fluid>div.content
   (if @(rf/subscribe [:auth/user])
     (let [route @(rf/subscribe [:route])
           rule @(rf/subscribe [:rule])]
       [:div
        [:section.hero
         [:div.hero-body
          [:div.container.has-text-black
          ;  [:h3 (str "Usluga: " (get-type (:type rule)))]
           [:div.columns.is-mobile.is-centered.is-vcentered
            [:div.column.is-one-fifth
             [:img.image.is-32x32 {:src "/img/009-file.svg"}]]
            [:div.column (get-type (:type rule))]]
           [:div.columns.is-mobile.is-centered.is-vcentered
            [:div.column.is-one-fifth
             [:img.image.is-32x32 {:src "/img/046-office-building.svg"}]]
            [:div.column (:place rule)]]
           [:p (:result rule)]]]]])
     (redirect! "/"))])
