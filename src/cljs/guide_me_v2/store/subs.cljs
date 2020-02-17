(ns guide-me-v2.store.subs
  (:require
   [day8.re-frame.http-fx]
   [re-frame.core :as rf]
   [guide-me-v2.events]))

(rf/reg-sub
 :session/loading?
 (fn [db _]
   (:session/loading? db)))

(rf/reg-sub
 :rule
 (fn [db _]
   (:rule db)))


(rf/reg-sub
 :route
 (fn [db _]
   (:route db)))


(rf/reg-sub
 :auth/user
 (fn [db _]
   (:auth/user db)))

(rf/reg-sub
 :auth/user-state
 :<- [:auth/user]
 :<- [:session/loading?]
 (fn [[user loading?]]
   (cond
     (true? loading?) :loading
     user :authenticated
     :else :anonymous)))

(rf/reg-sub
 :app/active-modals
 (fn [db _]
   (:app/active-modals db {})))

(rf/reg-sub
 :app/modal-showing?
 :<- [:app/active-modals]
 (fn [modals [_ modal-id]]
   (get modals modal-id false)))
