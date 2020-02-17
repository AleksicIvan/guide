(ns guide-me-v2.views.home
  (:require
   [day8.re-frame.http-fx]
   [re-frame.core :as rf]
   [guide-me-v2.store.subs]
   [guide-me-v2.components.buttons :refer [login-button register-button]]
   [guide-me-v2.store.events]))

(def log (.-log js/console))

(def md-mobile? (js/window.md.mobile))

(defn image-component [src]
  (if (js/window.md.mobile)
    [:img.image.is-48x48 {:src src}]
    [:figure.container
     [:img.image.is-64x64 {:src src}]]))

(defn not-logged-in []
 [:div
  [:section.hero
   [:div
    [:div.container.is-mobile.is-centered.has-text-centered
     [:div#heading
      [:h3 "Kroz džunglu propisa, šaltera i papira potreban Vam je pouzdan vodič."]]
     [:br]
     [:div.columns.is-mobile.is-centered
      [:div.column.is-pulled-right
       [:div.is-pulled-right [login-button]]]
      [:div.column
       [:div.is-pulled-left [register-button]]]]
     [:br]
     [:div.columns.is-mobile.is-centered
      [:div.column
       [image-component "/img/001-envelope.svg"]
       [:br]
       [image-component "/img/012-archives.svg"]
       [:br]
       [image-component "/img/029-desk.svg"]]
      [:div.column
       [image-component "/img/003-printer.svg"]
       [:br]
       [image-component "/img/018-office-chair.svg"]
       [:br]
       [image-component "/img/032-coffee.svg"]]
      [:div.column
       [image-component "/img/006-clock.svg"]
       [:br]
       [image-component "/img/019-briefcase.svg"]
       [:br]
       [image-component "/img/040-drawer.svg"]]
      [:div.column
       [image-component "/img/016-pen.svg"]
       [:br]
       [image-component "/img/028-photocopier.svg"]
       [:br]
       [image-component "/img/041-tape.svg"]]]]]]])

(defn home-page []
  [:section#section.section>div.container.is-fluid>div.content
   (if @(rf/subscribe [:auth/user])
     (when-let [user @(rf/subscribe [:auth/user])]
       [:div
        [:section.hero
         [:div.hero-body
          [:div.container
           [:h3 "Dobro došli " (:login user) ", "]
           [:ul.no-bullet
            [:li 
             [:a.button {:on-click (fn [] (rf/dispatch [:rule/add-type "registracija-auta"]))
                         :href "#/usluga/registracija-auta"}
              "registrujte auto"]]
            [:li
             [:a.button {:on-click (fn [] (rf/dispatch [:rule/add-type "porez-na-dohodak"]))
                         :href "#/usluga/porez-na-dohodak"} 
              "platite porez"]]
            [:li
             [:a.button {:on-click (fn [] (rf/dispatch [:rule/add-type "uknjizba-stana"]))
                         :href "#/usluga/uknjizba-stana"} 
              "uknjižite stan"]]]]]]])
    [not-logged-in])])

