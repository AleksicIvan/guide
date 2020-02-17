(ns guide-me-v2.components.modals
  (:require
   [day8.re-frame.http-fx]
   [re-frame.core :as rf]
   [guide-me-v2.events]
   [guide-me-v2.store.subs]
   [guide-me-v2.store.events]))


(defn modal-card [id title body footer]
  [:div.modal
   {:class (when @(rf/subscribe [:app/modal-showing? id]) "is-active")}
   [:div.modal-background
    {:on-click #(rf/dispatch [:app/hide-modal id])}]
   [:div.modal-card
    [:header.modal-card-head
     [:p.modal-card-title title]
     [:button.delete
      {:on-click #(rf/dispatch [:app/hide-modal id])}]]
    [:section.modal-card-body
     body]
    [:footer.modal-card-foot
     footer]]])
