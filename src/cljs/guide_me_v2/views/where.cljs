(ns guide-me-v2.views.where
  (:require
   [ajax.core :refer [POST]]
   [day8.re-frame.http-fx]
   [re-frame.core :as rf]
   [guide-me-v2.helpers :refer [redirect! get-city-from-user is-city-we-have-data]]
   [guide-me-v2.store.subs]
   [guide-me-v2.store.events]))

(defn where-page []
  [:section#section.section>div.container.is-fluid>div.content
   (let [user @(rf/subscribe [:auth/user])]
     (if user
       (when-let [rule @(rf/subscribe [:rule])]
         [:div
          [:section.hero
           [:div.hero-body
            [:div.container
             [:ul.no-bullet
              [:li
               (if (= (.toLowerCase (or (get-in rule [:place]) (:city user) " ")) "beograd")
                 [:a.button.has-text-white.has-background-black
                  {:on-click #(POST "/api/rules"
                                {:headers {"Accept" "application/transit+json"}
                                 :params {:type (get-in rule [:type]) :place "Beograd"}
                                 :handler (fn [response]
                                            (rf/dispatch [:rule/add-place "Beograd"])
                                            (rf/dispatch [:rule/add-result (get-in response [:rules :result])]))})
                   :href (str "#/usluga/" (:type rule) "/mesto/beograd/rezultat")} "Beograd"]
                 [:a.button
                  {:on-click #(POST "/api/rules"
                                {:headers {"Accept" "application/transit+json"}
                                 :params {:type (get-in rule [:type]) :place "Beograd"}
                                 :handler (fn [response]
                                            (rf/dispatch [:rule/add-place "Beograd"])
                                            (rf/dispatch [:rule/add-result (get-in response [:rules :result])]))})
                   :href (str "#/usluga/" (:type rule) "/mesto/beograd/rezultat")} "Beograd"])]
              [:li
               (if (= (.toLowerCase (or (get-in rule [:place]) (:city user) " ")) "užice")
                 [:a.button.has-text-white.has-background-black
                  {:on-click #(POST "/api/rules"
                                {:headers {"Accept" "application/transit+json"}
                                 :params {:type (get-in rule [:type]) :place "Užice"}
                                 :handler (fn [response]
                                            (rf/dispatch [:rule/add-place "Užice"])
                                            (rf/dispatch [:rule/add-result (get-in response [:rules :result])]))})
                   :href (str "#/usluga/" (:type rule) "/mesto/uzice/rezultat")} "Užice"]
                 [:a.button {:on-click #(POST "/api/rules"
                                          {:headers {"Accept" "application/transit+json"}
                                           :params {:type (get-in rule [:type]) :place "Užice"}
                                           :handler (fn [response]
                                                      (rf/dispatch [:rule/add-place "Užice"])
                                                      (rf/dispatch [:rule/add-result (get-in response [:rules :result])]))})
                             :href (str "#/usluga/" (:type rule) "/mesto/uzice/rezultat")} "Užice"])]
              [:li
               (if (= (.toLowerCase (or (get-in rule [:place]) (:city user) " ")) "zaječar")
                 [:a.button.has-text-white.has-background-black
                  {:on-click #(POST "/api/rules"
                                {:headers {"Accept" "application/transit+json"}
                                 :params {:type (get-in rule [:type]) :place "Zaječar"}
                                 :handler (fn [response]
                                            (rf/dispatch [:rule/add-place "Zaječar"])
                                            (rf/dispatch [:rule/add-result (get-in response [:rules :result])]))})
                   :href (str "#/usluga/" (:type rule) "/mesto/zajecar/rezultat")} "Zaječar"]
                 [:a.button {:on-click #(POST "/api/rules"
                                          {:headers {"Accept" "application/transit+json"}
                                           :params {:type (get-in rule [:type]) :place "Zaječar"}
                                           :handler (fn [response]
                                                      (rf/dispatch [:rule/add-place "Zaječar"])
                                                      (rf/dispatch [:rule/add-result (get-in response [:rules :result])]))})
                             :href (str "#/usluga/" (:type rule) "/mesto/zajecar/rezultat")} "Zaječar"])]]]]]])
       (redirect! "/")))])
