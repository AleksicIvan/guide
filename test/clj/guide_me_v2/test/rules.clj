(ns guide-me-v2.test.rules
  (:require
   [clojure.test :refer :all]
   [guide-me-v2.rules :refer [running-clara]]))


(deftest test-clara-rules-app
  (testing "clara rules for uknjizba-stana and Beograd"
    (let [result (get-in (first (running-clara "uknjizba-stana" "Beograd")) [:?rule-result :result])]
      (is (= 113 result))))

  (testing "clara rules for porez-na-dohodak and Beograd"
    (let [result (get-in (first (running-clara "porez-na-dohodak" "Beograd")) [:?rule-result :result])]
      (is (= 112 result))))

  (testing "clara rules for registracija-auta and Beograd"
    (let [result (get-in (first (running-clara "registracija-auta" "Beograd")) [:?rule-result :result])]
      (is (= 111 result))))


  (testing "clara rules for registracija-auta and Užice"
    (let [result (get-in (first (running-clara "registracija-auta" "Užice")) [:?rule-result :result])]
      (is (= 311 result))))

  (testing "clara rules for porez-na-dohodak and Užice"
    (let [result (get-in (first (running-clara "porez-na-dohodak" "Užice")) [:?rule-result :result])]
      (is (= 312 result))))

  (testing "clara rules for uknjizba-stana and Užice"
    (let [result (get-in (first (running-clara "uknjizba-stana" "Užice")) [:?rule-result :result])]
      (is (= 313 result))))


  (testing "clara rules for registracija-auta and Zaječar"
    (let [result (get-in (first (running-clara "registracija-auta" "Zaječar")) [:?rule-result :result])]
      (is (= 191 result))))

  (testing "clara rules for uknjizba-stana and Zaječar"
    (let [result (get-in (first (running-clara "uknjizba-stana" "Zaječar")) [:?rule-result :result])]
      (is (= 193 result))))

  (testing "clara rules for porez-na-dohodak and Zaječar"
    (let [result (get-in (first (running-clara "porez-na-dohodak" "Zaječar")) [:?rule-result :result])]
      (is (= 192 result)))))
