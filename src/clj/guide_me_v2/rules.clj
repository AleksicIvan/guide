(ns guide-me-v2.rules
  (:require
   [clojure.string :as str]
   [clara.rules :refer :all])
  (:gen-class))


(defrecord Place [name])

(defrecord Type [label])

(defrecord RuleResult [result])

; Beograd
(defrule is-place-belgrade-is-type-uknjizba-stana
  "Place is Belgrade, type is uknjizba-stana"
  [Place (= "beograd" (str/lower-case name))]
  [Type (= "uknjizba-stana" label)]
  =>
  (insert! (->RuleResult 113)))

(defrule is-place-belgrade-is-type-porez-na-dohodak
  "Place is Belgrade, type is porez-na-dohodak"
  [Place (= "beograd" (str/lower-case name))]
  [Type (= "porez-na-dohodak" label)]
  =>
  (insert! (->RuleResult 112)))

(defrule is-place-belgrade-is-type-registracija-auta
  "Place is Belgrade, type is registracija-auta"
  [Place (= "beograd" (str/lower-case name))]
  [Type (= "registracija-auta" label)]
  =>
  (insert! (->RuleResult 111)))

; Uzice
(defrule is-place-uzice-is-type-uknjizba-stana
  "Place is Užice, type is uknjizba-stana"
  [Place (= "užice" (str/lower-case name))]
  [Type (= "uknjizba-stana" label)]
  =>
  (insert! (->RuleResult 313)))

(defrule is-place-uzice-is-type-porez-na-dohodak
  "Place is Užice, type is porez-na-dohodak"
  [Place (= "užice" (str/lower-case name))]
  [Type (= "porez-na-dohodak" label)]
  =>
  (insert! (->RuleResult 312)))

(defrule is-place-uzice-is-type-registracija-auta
  "Place is Užice, type is registracija-auta"
  [Place (= "užice" (str/lower-case name))]
  [Type (= "registracija-auta" label)]
  =>
  (insert! (->RuleResult 311)))

; Zajecar
(defrule is-place-zajecar-is-type-uknjizba-stana
  "Place is Zaječar, type is uknjizba-stana"
  [Place (= "zaječar" (str/lower-case name))]
  [Type (= "uknjizba-stana" label)]
  =>
  (insert! (->RuleResult 193)))

(defrule is-place-zajecar-is-type-porez-na-dohodak
  "Place is Zaječar, type is porez-na-dohodak "
  [Place (= "zaječar" (str/lower-case name))]
  [Type (= "porez-na-dohodak" label)]
  =>
  (insert! (->RuleResult 192)))

(defrule is-place-zajecar-is-type-registracija-auta
  "Place is Zaječar, type is registracija-auta"
  [Place (= "zaječar" (str/lower-case name))]
  [Type (= "registracija-auta" label)]
  =>
  (insert! (->RuleResult 191)))

(defquery get-answer
  []
  [?rule-result <- RuleResult])


(defn show-answer
  "Get result thruth if type and place facts are both inserted into session"
  [session]
  (query session get-answer))

(defn running-clara [type place]
  (-> (mk-session 'guide-me-v2.rules)
      (insert (->Type type))
      (insert (->Place place))
      (fire-rules)
      (show-answer)))
