(ns guide-me-v2.components.navbar
  (:require
   [day8.re-frame.http-fx]
   [re-frame.core :as rf]
   [guide-me-v2.components.buttons :as buttons]))

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
      "vodi§"]
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
          [buttons/nameplate @(rf/subscribe [:auth/user])]
          [buttons/logout-button]]
         :anonymous
         [:div.buttons
          [buttons/login-button]
          [buttons/register-button]])]]]]])
