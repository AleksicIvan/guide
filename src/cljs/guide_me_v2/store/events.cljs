(ns guide-me-v2.store.events
  (:require
   [ajax.core :refer [GET POST]]
   [day8.re-frame.http-fx]
   [re-frame.core :as rf]
   [guide-me-v2.store.subs]))


(rf/reg-fx
 :ajax/get
 (fn [{:keys [url success-event error-event success-path]}]
   (GET url
     (cond-> {:headers {"Accept" "application/transit+json"}}
       success-event (assoc :handler
                            #(rf/dispatch
                              (conj success-event
                                    (if success-path
                                      (get-in % success-path)
                                      %))))
       error-event   (assoc :error-handler
                            #(rf/dispatch
                              (conj error-event %)))))))

(rf/reg-fx
 :ajax/post
 (fn [{:keys [url rule value success-event error-event success-path]}]
   (POST url
     (cond-> {:headers {"Accept" "application/transit+json"}
              :params {:tip rule :value value}}
       success-event (assoc :handler
                            #(rf/dispatch
                              (conj success-event
                                    (if success-path
                                      (get-in % success-path)
                                      %))))
       error-event   (assoc :error-handler
                            #(rf/dispatch
                              (conj error-event %)))))))


(rf/reg-event-fx
 :app/initialize
 (fn [_ _]
   {:db {:session/loading? true}
    :dispatch [:session/load]}))
;;...
(rf/reg-event-fx
 :session/load
 (fn [{:keys [db]} _]
   {:db (assoc db :session/loading? true)
    :ajax/get {:url "/api/session"
               :success-path [:session]
               :success-event [:session/set]}}))
;;...
(rf/reg-event-db
 :session/set
 (fn [db [_ {:keys [identity]}]]
   (assoc db
          :auth/user identity
          :session/loading? false)))

(rf/reg-event-db
 :app/show-modal
 (fn [db [_ modal-id]]
   (assoc-in db [:app/active-modals modal-id] true)))

(rf/reg-event-db
 :app/hide-modal
 (fn [db [_ modal-id]]
   (update db :app/active-modals dissoc modal-id)))

(rf/reg-event-db
 :session/update-rule
 (fn [db [_ rule]]
   (println "rule from reducer" rule)
   (assoc  db :session/rule rule)))

(rf/reg-event-db
 :rule/add-result
 (fn [db [_ rule]]
   (println "rule from reducer" rule)
   (assoc-in db [:rule :result] rule)))



(rf/reg-event-db
 :auth/handle-login
 (fn [db [_ {:keys [identity]}]]
   (assoc db :auth/user identity)))

(rf/reg-event-db
 :auth/handle-logout
 (fn [db _]
   (dissoc db :auth/user)))

(rf/reg-event-db
 :rule/add-place
 (fn [db [_ place-arg]]
   (assoc-in db [:rule :place] place-arg)))

(rf/reg-event-db
 :rule/add-type
 (fn [db [_ type-arg]]
   (assoc-in db [:rule :type] type-arg)))
