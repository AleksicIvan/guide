(ns guide-me-v2.auth
  (:require
   [buddy.hashers :as hashers]
   [clojure.java.jdbc :as jdbc]
   [guide-me-v2.db.core :as db]))

(defn create-user! [login password first_name last_name city email]
  (jdbc/with-db-transaction [t-conn db/*db*]
    (if-not (empty? (db/get-user-for-auth* t-conn {:login login}))
      (throw (ex-info "User already exists!"
                      {:guide-me-v2/error-id ::duplicate-user
                       :error "User already exists!"}))
      (db/create-user!* t-conn
                        {:login login
                         :first_name first_name
                         :last_name last_name
                         :city city
                         :email email
                         :pass (hashers/derive password)}))))

(defn authenticate-user [login password]

  (let [{hashed :pass :as user} (db/get-user-for-auth* {:login login})]
    (when (hashers/check password hashed)
      (dissoc user :pass))))
