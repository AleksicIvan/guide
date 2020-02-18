(ns guide-me-v2.components.breadcrumbs
  (:require
   [day8.re-frame.http-fx]
   [re-frame.core :as rf]
   [guide-me-v2.store.subs]
   [guide-me-v2.store.events]))

(defn my-blank-component []
  [:div {:dangerouslySetInnerHTML {:__html "&nbsp;"}}])

(defn breadcrumbs []
  (if @(rf/subscribe [:auth/user])
    (let [route @(rf/subscribe [:route])]
      [:section#section.section>div.container.is-fluid>div.content
       [:div
        [:nav.breadcrumb
         [:ul#breadcrumb-ul
          [:li
           [:a#section-breadcrumb-a-first.section-breadcrumb-a {:href "#/"}
            "Usluga"
            [my-blank-component]
            [:img.image.is-16x16 {:src "/img/009-file.svg"}]]]
          (if (get-in route [:path-params :tip])
            [:li
             [:a.section-breadcrumb-a {:href (str "#/usluga/" (get-in route [:path-params :tip]))}
              "Mesto" [my-blank-component]
              [:img.image.is-16x16 {:src "/img/046-office-building.svg"}]]]
            nil)
          (if (and (get-in route [:path-params :tip]) (get-in route [:path-params :mesto]))
            [:li
             [:a.section-breadcrumb-a {:href (str "#/usluga/" (get-in route [:path-params :tip]) "/mesto" (get-in route [:path-params :place]))} "Rezultat"]]
            nil)]]]])
    nil))
