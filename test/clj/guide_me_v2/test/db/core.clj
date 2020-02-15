(ns guide-me-v2.test.db.core
  (:require
   [guide-me-v2.db.core :refer [*db*] :as db]
   [java-time.pre-java8]
   [luminus-migrations.core :as migrations]
   [clojure.test :refer :all]
   [clojure.java.jdbc :as jdbc]
   [guide-me-v2.config :refer [env]]
   [mount.core :as mount]))

(use-fixtures
  :once
  (fn [f]
    (mount/start
     #'guide-me-v2.config/env
     #'guide-me-v2.db.core/*db*)
    (migrations/migrate ["migrate"] (select-keys env [:database-url]))
    (f)))

(deftest test-users
  (jdbc/with-db-transaction [t-conn *db*]
    (jdbc/db-set-rollback-only! t-conn)
    (is (= 1 (db/create-user!*
              t-conn
              {:login "pera.peric"
               :first_name "pera"
               :last_name "peric"
               :city "Beograd"
               :is_admin nil
               :email "pera.peric@example.com"
               :pass "pass"})))
    (is (= {:login "pera.peric"
            :first_name "pera"
            :last_name "peric"
            :city "Beograd"
            :is_admin nil
            :email "pera.peric@example.com"
            :pass "pass"}
           (db/get-user-for-auth* t-conn {:login "pera.peric"})))
    ))
