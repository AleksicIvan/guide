(ns guide-me-v2.rules
  (:require
   [clara.rules :refer :all])
  (:gen-class))


(defrecord Place [name])

(defrecord Type [label])

(defrecord RuleResult [result])

; Beograd
(defrule is-place-belgrade-is-type-uknjizba-stana
  "Place is Belgrade, type is uknjizba-stana"
  [Place (= "Beograd" name)]
  [Type (= "uknjizba-stana" label)]
  =>
  (insert! (->RuleResult 113)))

(defrule is-place-belgrade-is-type-porez-na-dohodak
  "Place is Belgrade, type is porez-na-dohodak"
  [Place (= "Beograd" name)]
  [Type (= "porez-na-dohodak" label)]
  =>
  (insert! (->RuleResult 112)))

(defrule is-place-belgrade-is-type-registracija-auta
  "Place is Belgrade, type is registracija-auta"
  [Place (= "Beograd" name)]
  [Type (= "registracija-auta" label)]
  =>
  (insert! (->RuleResult 111)))

; Uzice
(defrule is-place-uzice-is-type-uknjizba-stana
  "Place is Užice, type is uknjizba-stana"
  [Place (= "Užice" name)]
  [Type (= "uknjizba-stana" label)]
  =>
  (insert! (->RuleResult 313)))

(defrule is-place-uzice-is-type-porez-na-dohodak
  "Place is Užice, type is porez-na-dohodak"
  [Place (= "Užice" name)]
  [Type (= "porez-na-dohodak" label)]
  =>
  (insert! (->RuleResult 312)))

(defrule is-place-uzice-is-type-registracija-auta
  "Place is Užice, type is registracija-auta"
  [Place (= "Užice" name)]
  [Type (= "registracija-auta" label)]
  =>
  (insert! (->RuleResult 311)))

; Zajecar
(defrule is-place-zajecar-is-type-uknjizba-stana
  "Place is Zaječar, type is uknjizba-stana"
  [Place (= "Zaječar" name)]
  [Type (= "uknjizba-stana" label)]
  =>
  (insert! (->RuleResult 193)))

(defrule is-place-zajecar-is-type-porez-na-dohodak
  "Place is Zaječar, type is porez-na-dohodak "
  [Place (= "Zaječar" name)]
  [Type (= "porez-na-dohodak" label)]
  =>
  (insert! (->RuleResult 192)))

(defrule is-place-zajecar-is-type-registracija-auta
  "Place is Zaječar, type is registracija-auta"
  [Place (= "Zaječar" name)]
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
