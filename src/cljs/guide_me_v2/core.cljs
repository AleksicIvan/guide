(ns guide-me-v2.core
  (:require
  		[ajax.core :refer [GET POST]]
    [day8.re-frame.http-fx]
    [reagent.core :as r]
    [re-frame.core :as rf]
    [goog.events :as events]
    [goog.history.EventType :as HistoryEventType]
    [markdown.core :refer [md->html]]
    [guide-me-v2.ajax :as ajax]
    [guide-me-v2.events]
    [reitit.core :as reitit]
    [clojure.string :as string])
  (:import goog.History))

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
	:auth/handle-login
		(fn [db [_ {:keys [identity]}]]
				(assoc db :auth/user identity)))

(rf/reg-event-db
	:auth/handle-logout
		(fn [db _]
			(dissoc db :auth/user)))

(rf/reg-sub
		:session/loading?
			(fn [db _]
			(:session/loading? db)))

(rf/reg-sub
		:auth/user
			(fn [db _]
				(:auth/user db)))

(rf/reg-sub
	:auth/user-state
	:<-[:auth/user]
	:<-[:session/loading?]
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

(def log (.-log js/console))

(defn redirect! [loc]
  (set! (.-location js/window) loc))

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

(defn modal-button [id title body footer]
	[:div
		[:button.button.is-primary.has-background-white.has-text-black
			{:on-click #(rf/dispatch [:app/show-modal id])}
			title]
		[modal-card id title body footer]])


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
     (println "register data" @fields)
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
     [:div.label "email"]
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
													[:button.button.is-primary.is-fullwidth
														{:on-click do-register
														:disabled (or (string/blank? (:login @fields))
                            (string/blank? (:first_name @fields))
                            (string/blank? (:last_name @fields))
                            (string/blank? (:city @fields))
                            (string/blank? (:email @fields))
                            (string/blank? (:pass @fields))
                            (string/blank? (:confirm @fields)))}
																					"Create Account"]]))


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


(defn nav-link [uri title page]
  [:a.navbar-item.has-text-white
   {:href   uri
    :class (when (= page @(rf/subscribe [:page])) :is-active)}
   title])

(defn navbar []
	[:nav.navbar.has-background-black.is-fixed-top
		[:div.container
			[:div.navbar-brand
				[:a.navbar-item.has-text-white
					{:href "/"
						:style {:font-weight "bold"}}
						"vodi me"]
					[:span.navbar-burger.burger
						{:data-target "nav-menu"}
						[:span]
						[:span]
						[:span]]]
			[:div#nav-menu.navbar-menu
        [:div.navbar-end
         [:div.navbar-item
          (case @(rf/subscribe [:auth/user-state])
            :loading
            [:div {:style {:width "5em"}}
             [:progress.progress.is-dark.is-small {:max 100} "30%"]]
            :authenticated
            [:div.buttons
             [nameplate @(rf/subscribe [:auth/user])]
             [logout-button]]
            :anonymous
            [:div.buttons
             [login-button]
             [register-button]])]]]]])


(defn home-page []
  [:section.section>div.container.is-fluid>div.content
   (if @(rf/subscribe [:auth/user])
     (when-let [user @(rf/subscribe [:auth/user])]
       (println "user?" user)
       [:div
        [:section.hero
         [:div.hero-body
          [:div.container
           [:h1 "Dobro došli " (:login user) ", "]
           [:h2 "Želite da "]
           [:ul.no-bullet
            [:li
             [:a.button {:href "#/tip/registracija"} "registujete auto"]]
            [:li
             [:a.button {:href "#/tip/porez-na-imovinu"} "platite porez"]]
            [:li
             [:a.button {:href "#/tip/uknjizba"} "uknjižite stan"]]]]]]])
     [:div
      [:section.hero
       [:div.hero-body
        [:div.container
         [:div.notification
          [:img.image {:src "/img/kiosk.png"}]
          ]]]]])])

(defn where-page []
  [:section.section>div.container.is-fluid>div.content
   (if @(rf/subscribe [:auth/user])
     (when-let [route @(rf/subscribe [:route])]
       [:div
        [:section.hero
         [:div.hero-body
          [:div.container
           [:h1 "Mesto:"]
           [:ul.no-bullet
            [:li
             [:a.button {:href (str "#/tip/" (get-in route [:path-params :tip]) "/mesto/beograd/rezultat")} "Beograd"]]
            [:li
             [:a.button {:href (str "#/tip/" (get-in route [:path-params :tip]) "/mesto/uzice/rezultat")} "Uzice"]]
            [:li
             [:a.button {:href (str "#/tip/" (get-in route [:path-params :tip]) "/mesto/zajecar/rezultat")} "Zajecar"]]]]]]])
     (redirect! "/"))])

(defn resultion-page []
  [:section.section>div.container.is-fluid>div.content
   (if @(rf/subscribe [:auth/user])
     (when-let [route @(rf/subscribe [:route])]
       [:div
        [:section.hero.is-light
         [:div.hero-body
          [:div.container
           [:h3 (str "Tip: " (get-in route [:path-params :tip]))]
           [:h3 (str "Mesto: " (get-in route [:path-params :mesto]))]
           [:h3 "Rezultat:"]
           [:p "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."]]]]])
     (redirect! "/"))])

(def pages
  {:home #'home-page
   :where #'where-page
   :result #'resultion-page})

(defn page []
  [:div
   [navbar]
   [(pages @(rf/subscribe [:page]))]])

;; -------------------------
;; Routes

(def router
  (reitit/router
   [["/" :home]
    ["/tip/:tip" :where]
    ["/tip/:tip/mesto/:mesto/rezultat" :result]]))

;; -------------------------
;; History
;; must be called after routes have been defined
(defn hook-browser-navigation! []
  (doto (History.)
    (events/listen
      HistoryEventType/NAVIGATE
      (fn [event]
        (let [uri (or (not-empty (string/replace (.-token event) #"^.*#" "")) "/")]
          (println uri)
          (println (reitit/match-by-path router uri))
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
