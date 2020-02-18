(ns guide-me-v2.components.buttons
  (:require
   [ajax.core :refer [POST]]
   [day8.re-frame.http-fx]
   [reagent.core :as r]
   [re-frame.core :as rf]
   [guide-me-v2.helpers :refer [redirect!]]
   [guide-me-v2.store.subs]
   [guide-me-v2.store.events]
   [guide-me-v2.components.modals :as modals]
   [clojure.string :as string]))


(defn modal-button [id title body footer]
  [:div
   [:button.button.has-background-white.has-text-black.border-black
    {:on-click #(rf/dispatch [:app/show-modal id])}
    title]
   [modals/modal-card id title body footer]])


(defn login-button []
  (r/with-let
    [fields (r/atom {})
     error (r/atom nil)
     do-login
     (fn [_]
       (reset! error nil)
       (POST "/api/login"
         {:headers {"Accept" "application/transit+json"}
          :params @fields
          :handler (fn [response]
                     (reset! fields {})
                     (rf/dispatch [:auth/handle-login response])
                     (rf/dispatch [:app/hide-modal :user/login]))
          :error-handler (fn [error-response]
                           (reset! error
                                   (or (:message (:response error-response))
                                       (:status-text error-response)
                                       "Unknown Error")))}))]
    [modal-button :user/login
				;; Title
     "Prijavi se"
				;; Body
     [:div
      (when-not (string/blank? @error)
        [:div.notification.is-danger
         @error])
      [:div.field
       [:div.label "Korisničko ime"]
       [:div.control
        [:input.input
         {:type "text"
          :value (:login @fields)
          :on-change #(swap! fields assoc :login (.. % -target -value))}]]]
      [:div.field
       [:div.label "Šifra"]
       [:div.control
        [:input.input
         {:type "password"
          :value (:pass @fields)
          :on-change #(swap! fields assoc :pass (.. % -target -value))
										;; Submit login form when `Enter` key is pressed
          :on-key-down #(when (= (.-keyCode %) 13)
                          (do-login))}]]]]
										;; Footer
     [:button.button.is-primary.is-fullwidth.has-background-black.has-text-white
      {:on-click do-login
       :disabled (or (string/blank? (:login @fields)) (string/blank? (:pass @fields)))}
      "OK"]]))

(defn register-button []
  (r/with-let
    [fields (r/atom {})
     error (r/atom nil)
     do-register
     (fn [_]
       (reset! error nil)
       (POST "/api/register"
         {:headers {"Accept" "application/transit+json"}
          :params @fields
          :handler (fn [response]
                     (reset! fields {})
                     (rf/dispatch [:app/hide-modal :user/register])
                     (rf/dispatch [:app/show-modal :user/login]))
          :error-handler (fn [error-response]
                           (reset! error
                                   (or (:message (:response error-response))
                                       (:status-text error-response)
                                       "Unknown Error")))}))]

    [modal-button :user/register
;; Title
     "Registruj se"
			;; Body
     [:div
      (when-not (string/blank? @error)
        [:div.notification.is-danger
         @error])
      [:div.field
       [:div.label "Korisničko ime"]
       [:div.control
        [:input.input
         {:type "text"
          :value (:login @fields)
          :on-change #(swap! fields assoc :login (.. % -target -value))}]]]
      [:div.field
       [:div.label "Ime"]
       [:div.control
        [:input.input
         {:type "text"
          :value (:first_name @fields)
          :on-change #(swap! fields assoc :first_name (.. % -target -value))}]]]
      [:div.field
       [:div.label "Prezime"]
       [:div.control
        [:input.input
         {:type "text"
          :value (:last_name @fields)
          :on-change #(swap! fields assoc :last_name (.. % -target -value))}]]]
      [:div.field
       [:div.label "Mesto"]
       [:div.control
        [:input.input
         {:type "text"
          :value (:city @fields)
          :on-change #(swap! fields assoc :city (.. % -target -value))}]]]
      [:div.field
       [:div.label "Email"]
       [:div.control
        [:input.input
         {:type "email"
          :value (:email @fields)
          :on-change #(swap! fields assoc :email (.. % -target -value))}]]]
      [:div.field
       [:div.label "Šifra"]
       [:div.control
        [:input.input
         {:type "password"
          :value (:pass @fields)
          :on-change #(swap! fields assoc :pass (.. % -target -value))}]]]
      [:div.field
       [:div.label "Unesi šifru ponovo"]
       [:div.control
        [:input.input
         {:type "password"
          :value (:confirm @fields)
          :on-change #(swap! fields assoc :confirm (.. % -target -value))
										;; Submit login form when `Enter` key is pressed
          :on-key-down #(when (= (.-keyCode %) 13)
                          (do-register))}]]]]
									;; Footer
     [:button.button.is-primary.is-fullwidth.has-background-black.has-text-white
      {:on-click do-register
       :disabled (or (string/blank? (:login @fields))
                     (string/blank? (:first_name @fields))
                     (string/blank? (:last_name @fields))
                     (string/blank? (:city @fields))
                     (string/blank? (:email @fields))
                     (string/blank? (:pass @fields))
                     (string/blank? (:confirm @fields)))}
      "OK"]]))


(defn logout-button []
  [:button.button.has-background-white.has-text-black
   {:on-click #(POST "/api/logout"
                 {:handler (fn [_]
                             (redirect! "/")
                             (rf/dispatch [:auth/handle-logout]))})}
   "Odjavi se"])

(defn nameplate [{:keys [login]}]
  [:button.button
   login])
