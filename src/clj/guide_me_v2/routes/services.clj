(ns guide-me-v2.routes.services
  (:require
   [reitit.swagger :as swagger]
   [reitit.swagger-ui :as swagger-ui]
   [reitit.ring.coercion :as coercion]
   [reitit.coercion.spec :as spec-coercion]
   [reitit.ring.middleware.muuntaja :as muuntaja]
   [reitit.ring.middleware.multipart :as multipart]
   [reitit.ring.middleware.parameters :as parameters]
   [guide-me-v2.middleware.formats :as formats]
   [guide-me-v2.middleware.exception :as exception]
   [ring.util.http-response :refer :all]
   [clojure.java.io :as io]
   [guide-me-v2.auth :as auth]
   [guide-me-v2.rules :as rules]
   [spec-tools.data-spec :as ds]))

(defn service-routes []
  ["/api"
   {:coercion spec-coercion/coercion
    :muuntaja formats/instance
    :swagger {:id ::api}
    :middleware [;; query-params & form-params
                 parameters/parameters-middleware
                 ;; content-negotiation
                 muuntaja/format-negotiate-middleware
                 ;; encoding response body
                 muuntaja/format-response-middleware
                 ;; exception handling
                 exception/exception-middleware
                 ;; decoding request body
                 muuntaja/format-request-middleware
                 ;; coercing response bodys
                 coercion/coerce-response-middleware
                 ;; coercing request parameters
                 coercion/coerce-request-middleware
                 ;; multipart
                 multipart/multipart-middleware]}

   ["/session"
    {:get
     {:responses
      {200
       {:body
        {:session
         {:identity
          (ds/maybe
           {:login string?})}}}}
      :handler
      (fn [{{:keys [identity]} :session}]
        (ok {:session
             {:identity
              (not-empty
               (select-keys identity [:login]))}}))}}]

   ;; swagger documentation
   ["" {:no-doc true
        :swagger {:info {:title "my-api"
                         :description "https://cljdoc.org/d/metosin/reitit"}}}

    ["/swagger.json"
     {:get (swagger/create-swagger-handler)}]

    ["/api-docs/*"
     {:get (swagger-ui/create-swagger-ui-handler
            {:url "/api/swagger.json"
             :config {:validator-url nil}})}]]

   ["/rules"
    {:post {:parameters
            {:body
             {:type string?
              :place string?}}
            :responses
            {200
             {:body
              {:rules
               {:result number?}}}}
            :handler (fn [{{{:keys [type place]} :body} :parameters}]
                       (let [rule (get-in (first (rules/running-clara type place)) [:?rule-result :result])]
                         (ok {:rules {:result rule}})))}}]

   ["/login"
    {:post {:parameters
            {:body
             {:login string?
              :pass string?}}
            :responses
            {200
             {:body
              {:identity
               {:login string?}}}
             401
             {:body
              {:message string?}}}
            :handler
            (fn [{{{:keys [login pass]} :body} :parameters
                  session :session}]
              (if-some [user (auth/authenticate-user login pass)]
                (->
                 (ok {:identity user})
                 (assoc :session (assoc session :identity user)))
                (unauthorized
                 {:message "Incorrect login or password"})))}}]
   ["/register"
    {:post {:parameters
            {:body
             {:login string?
              :pass string?
              :first_name string?
              :last_name string?
              :city string?
              :email string?
              :confirm string?}}
            :responses
            {200
             {:body
              {:message string?}}
             400
             {:body
              {:message string?}}
             409
             {:body
              {:message string?}}}
            :handler
            (fn [{{{:keys [login pass first_name last_name city email confirm]} :body} :parameters}]
              (if-not (= pass confirm)
                (bad-request
                 {:message
                  "Password and Confirm do not match."})
                (try
                  (auth/create-user! login pass first_name last_name city email)
                  (ok
                   {:message
                    "Users registration successful. Please log in."})
                  (catch clojure.lang.ExceptionInfo e
                    (if (= (:guide-me-v2/error-id (ex-data e))
                           ::auth/duplicate-user)
                      (conflict
                       {:message
                        "Registration failed! User with login already exists!"})
                      (throw e))))))}}]
   ["/logout"
    {:post {:handler
            (fn [_]
              (->
               (ok)
               (assoc :session nil)))}}]

   ["/ping"
    {:get (constantly (ok {:message "pong"}))}]])
