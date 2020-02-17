(ns guide-me-v2.views.where
  (:require
   [ajax.core :refer [POST]]
   [day8.re-frame.http-fx]
   [re-frame.core :as rf]
   [guide-me-v2.helpers :refer [redirect!]]
   [guide-me-v2.store.subs]
   [guide-me-v2.store.events]))

(defn where-page []
  [:section#section.section>div.container.is-fluid>div.content
   (if @(rf/subscribe [:auth/user])
     (when-let [rule @(rf/subscribe [:rule])]
       [:div
        [:section.hero
         [:div.hero-body
          [:div.container
           [:ul.no-bullet
            [:li
             [:a.button {:on-click #(POST "/api/rules"
                                      {:headers {"Accept" "application/transit+json"}
                                       :params {:type (get-in rule [:type]) :place "Beograd"}
                                       :handler (fn [response]
                                                  (println "response for Belgrade" (get-in response [:rules :result]))
                                                  (rf/dispatch [:rule/add-place "Beograd"])
                                                  (rf/dispatch [:rule/add-result (get-in response [:rules :result])]))})
                         :href (str "#/usluga/" (:type rule) "/mesto/beograd/rezultat")} "Beograd"]]
            [:li
             [:a.button {:on-click #(POST "/api/rules"
                                      {:headers {"Accept" "application/transit+json"}
                                       :params {:type (get-in rule [:type]) :place "Užice"}
                                       :handler (fn [response]
                                                  (println "response for Užice" (get-in response [:rules :result]))
                                                  (rf/dispatch [:rule/add-place "Užice"])
                                                  (rf/dispatch [:rule/add-result (get-in response [:rules :result])]))})
                         :href (str "#/usluga/" (:type rule) "/mesto/uzice/rezultat")} "Užice"]]
            [:li
             [:a.button {:on-click #(POST "/api/rules"
                                      {:headers {"Accept" "application/transit+json"}
                                       :params {:type (get-in rule [:type]) :place "Zaječar"}
                                       :handler (fn [response]
                                                  (println "response for Zaječar" (get-in response [:rules :result]))
                                                  (rf/dispatch [:rule/add-place "Zaječar"])
                                                  (rf/dispatch [:rule/add-result (get-in response [:rules :result])]))})
                         :href (str "#/usluga/" (:type rule) "/mesto/zajecar/rezultat")} "Zaječar"]]]]]]])
     (redirect! "/"))])
