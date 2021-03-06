(ns guide-me-v2.views.home
  (:require
   [ajax.core :refer [POST]]
   [day8.re-frame.http-fx]
   [re-frame.core :as rf]
   [guide-me-v2.helpers :refer [get-city-from-user is-city-we-have-data]]
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
     (let [rule @(rf/subscribe [:rule])]
       (when-let [user @(rf/subscribe [:auth/user])]
         [:div
          [:section.hero
           [:div.hero-body
            [:div.container
             [:h3 "Dobro došli " (:login user) ", "]
             [:ul.no-bullet
              [:li
               (if (= (:type rule) "registracija-auta")
                 [:a.button.has-text-white.has-background-black
                  {:on-click (let [city (get-city-from-user user)
                                   should-do-post (is-city-we-have-data city)]
                               (if should-do-post
                                 #(POST "/api/rules"
                                    {:headers {"Accept" "application/transit+json"}
                                     :params {:type "registracija-auta" :place city}
                                     :handler (fn [response]
                                                (rf/dispatch [:rule/add-type "registracija-auta"])
                                                (rf/dispatch [:rule/add-place city])
                                                (rf/dispatch [:rule/add-result (get-in response [:rules :result])]))})
                                 (fn [] (rf/dispatch [:rule/add-type "registracija-auta"]))))
                   :href (if (is-city-we-have-data (get-city-from-user user))
                           (str "#/usluga/registracija-auta/mesto/" (.toLowerCase (or (get-city-from-user user) " ")) "/rezultat")
                           "#/usluga/registracija-auta")}
                  "registrujte auto"]
                 [:a.button {:on-click (let [city (get-city-from-user user)
                                             should-do-post (is-city-we-have-data city)]
                                         (if should-do-post
                                           #(POST "/api/rules"
                                              {:headers {"Accept" "application/transit+json"}
                                               :params {:type "registracija-auta" :place city}
                                               :handler (fn [response]
                                                          (rf/dispatch [:rule/add-type "registracija-auta"])
                                                          (rf/dispatch [:rule/add-place city])
                                                          (rf/dispatch [:rule/add-result (get-in response [:rules :result])]))})
                                           (fn [] (rf/dispatch [:rule/add-type "registracija-auta"]))))
                             :href (if (is-city-we-have-data (get-city-from-user user))
                                     (str "#/usluga/registracija-auta/mesto/" (.toLowerCase (or (get-city-from-user user) " ")) "/rezultat")
                                     "#/usluga/registracija-auta")}
                  "registrujte auto"])]
              [:li
               (if (= (:type rule) "porez-na-dohodak")
                 [:a.button.has-text-white.has-background-black
                  {:on-click (let [city (get-city-from-user user)
                                   should-do-post (is-city-we-have-data city)]
                               (if should-do-post
                                 #(POST "/api/rules"
                                    {:headers {"Accept" "application/transit+json"}
                                     :params {:type "porez-na-dohodak" :place city}
                                     :handler (fn [response]
                                                (rf/dispatch [:rule/add-type "porez-na-dohodak"])
                                                (rf/dispatch [:rule/add-place city])
                                                (rf/dispatch [:rule/add-result (get-in response [:rules :result])]))})
                                 (fn [] (rf/dispatch [:rule/add-type "porez-na-dohodak"]))))
                   :href (if (is-city-we-have-data (get-city-from-user user))
                           (str "#/usluga/porez-na-dohodak/mesto/" (.toLowerCase (or (get-city-from-user user) " ")) "/rezultat")
                           "#/usluga/porez-na-dohodak")}
                  "platite porez"]
                 [:a.button
                  {:on-click (let [city (get-city-from-user user)
                                   should-do-post (is-city-we-have-data city)]
                               (if should-do-post
                                 #(POST "/api/rules"
                                    {:headers {"Accept" "application/transit+json"}
                                     :params {:type "porez-na-dohodak" :place city}
                                     :handler (fn [response]
                                                (rf/dispatch [:rule/add-type "porez-na-dohodak"])
                                                (rf/dispatch [:rule/add-place city])
                                                (rf/dispatch [:rule/add-result (get-in response [:rules :result])]))})
                                 (fn [] (rf/dispatch [:rule/add-type "porez-na-dohodak"]))))
                   :href (if (is-city-we-have-data (get-city-from-user user))
                           (str "#/usluga/porez-na-dohodak/mesto/" (.toLowerCase (get-city-from-user user)) "/rezultat")
                           "#/usluga/porez-na-dohodak")}
                  "platite porez"])]
              [:li
               (if (= (:type rule) "uknjizba-stana")
                 [:a.button.has-text-white.has-background-black
                  {:on-click (let [city (get-city-from-user user)
                                   should-do-post (is-city-we-have-data city)]
                               (if should-do-post
                                 #(POST "/api/rules"
                                    {:headers {"Accept" "application/transit+json"}
                                     :params {:type "uknjizba-stana" :place city}
                                     :handler (fn [response]
                                                (rf/dispatch [:rule/add-type "uknjizba-stana"])
                                                (rf/dispatch [:rule/add-place city])
                                                (rf/dispatch [:rule/add-result (get-in response [:rules :result])]))})
                                 (fn [] (rf/dispatch [:rule/add-type "uknjizba-stana"]))))
                   :href (if (is-city-we-have-data (get-city-from-user user))
                           (str "#/usluga/uknjizba-stana/mesto/" (.toLowerCase (get-city-from-user user)) "/rezultat")
                           "#/usluga/uknjizba-stana")}
                  "uknjižite stan"]
                 [:a.button {:on-click (let [city (get-city-from-user user)
                                             should-do-post (is-city-we-have-data city)]
                                         (if should-do-post
                                           #(POST "/api/rules"
                                              {:headers {"Accept" "application/transit+json"}
                                               :params {:type "uknjizba-stana" :place city}
                                               :handler (fn [response]
                                                          (rf/dispatch [:rule/add-type "uknjizba-stana"])
                                                          (rf/dispatch [:rule/add-place city])
                                                          (rf/dispatch [:rule/add-result (get-in response [:rules :result])]))})
                                           (fn [] (rf/dispatch [:rule/add-type "uknjizba-stana"]))))
                             :href (if (is-city-we-have-data (get-city-from-user user))
                                     (str "#/usluga/uknjizba-stana/mesto/" (.toLowerCase (get-city-from-user user)) "/rezultat")
                                     "#/usluga/uknjizba-stana")}
                  "uknjižite stan"])]]]]]]))
     [not-logged-in])])

