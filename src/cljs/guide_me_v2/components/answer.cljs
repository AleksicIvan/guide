(ns guide-me-v2.components.answer)

(defn beograd-registracija []
  [:div
   [:p "U Beogradu postoji mnogo firmi koje će vam pored usluge tehničkog pregleda zaršiti i sve neophodne papire neophodne za registraciju vozila."]
   [:p "Vaš automobil morate registrovati Kako registrovati automobilna svakih godinu dana. Po Zakonu o bezbednosti saobraćaja na putevima svaki vozač može učestvovati u saobraćaju na putevima jedino ukoliko ima uredno registrovano vozilo. U Srbiji je potrebno obnoviti registraciju automobila na svakih godinu dana, koliko važi tehnički pregled, osiguranje, a samim tim i saobraćajna dozvola. Budite oprezni i vodite računa o datumu isteka. Najpametnije je da par dana pre isteka roka na koji vam je vozilo registrovano obavite tehnički pregled kako bi imali dovoljno vremena da otklonite eventualne kvarove ukoliko se ispostavi da oni postoje. Ukoliko ne umete da obavite celu proceduru, možete se obratiti ovlašćenim agencijama koje uz povoljne cene obavljaju ove poslove."]
   [:p [:h5 "Šta je neophodno"]]
   [:ol
    [:li [:p "Dokaz o vlasništvu. Ukoliko prvi put registrujete auto na svoje ime najpre je neophodno da posedujete dokaz kako ste postali vlasnik istog (potreban vam je kupoprodajni ugovor, rešenje o nasleđivanju, eventualni račun iz prodavnice novih automobila itd)."]]
    [:li [:p "Tehnički pregled. Nakon toga neophodno je da odete u posebno ovlašćene auto kuće koje obavljaju tehnički pregled vozila, gde će se utvrditi da li je vozilo ispravno za saobraćaj. Neophodno je da ponesete dovoljno novca kako bi platili sve neophodne takse koje su različite visine u zavisnosti od kategorije vozila."]]
    [:li [:p "Saobraćajna dozvola. Nakon obavljenog tehničkog pregleda i svih plaćenih dažbina, treba sa ličnom kartom da odete u policijsku stanicu na teritoriji opštine na kojoj živite i predate uredno popunjen registracioni list i platite taksu za dobijanje obrasca saobraćajne dozvole."]]
    [:li [:p "Obnova registracije. Registracija vozila obavlja se jedanput godišnje i zakon toleriše da zakasnite samo mesec dana po isteku roka na koji je vozilo registrovano. Ukoliko zakasnite više od mesec dana i vozite neregistrovano vozilo kazne su po novom zakonu jako visoke, zato još jednom napominjemo da strogo povedete računa o datumu isteka vaše registracije."]]
    ]
   [:p "U roku od 30 dana pre ili 30 dana posle isteka datuma registracije naznačenog na registracionoj nalepnici možete izvršiti produženje registracije auta. Ako ne izvršite produženje registracije u roku od 30 dana od isteka, vaš auto se automatski prebacuje u pasivni registar što znači da ćete morati da menjate registarske tablice i saobraćajnu dozvolu kada odlučite da produžite registraciju posle tog roka."]
   [:p "Za produženje registracije auta je potrebno da obavite tehnički pregled i zaključite polisu obaveznog osiguranja od autoodgovornosti. Nakon toga je potrebno da izvršite plaćanje dažbina za registraciju (porez na upotrebu motornog vozila, registracionu nalepnicu, komunalna taksa) . Registraciju možete produžiti na samom tehničkom pregledu (ako nema nikakvih promena koje bi se morale evidentirati u dokumentima ili drugih smetnji) ili u policijskoj stanici."]
   ])

(defn beograd-porez-na-dohodak []
  [:div
   [:p "Prijava godišnjeg poreza na dohodak građana nadležnom poreskom organu, prema mestu prebivališta obveznika (Beogradske opštine), vrši se putem obrasca PPDG-2R – Poreska prijava za utvrđivanje godišnjeg poreza na dohodak građana. Rok za predaju obrasca PPDG-2R je 15. maj tekuće godine, elektronskim putem."]
   [:p "Porez na dohodak je dodatni porez na zaradu ili na neku ostvarenu dobit. Predaje se najkasnije do 15. maja tekuće godine, za ostvarenu dobit iz prethodne godine. Ovaj porez nije obavezan za sve koji ostvaruju neku dobit. Obavezan je samo za lica čija dobit prelazi određen neoporezivi iznos, pa se i plaća preko tog iznosa."]
   [:p "Za 2018. godinu neoporezivi iznos je 2.375.136 dinara i jednak je trostrukom iznosu prosečne godišnje zarade po zaposlenom, koja je isplaćena u Republici Srbiji u 2017. godini. Na iznos preko toga plaća se porez na dohodak."]
   [:p "Prema definiciji, neoporezivi iznos dohotka je trostruki iznos prosečne godišnje zarade po zaposlenom, koja je isplaćena u Republici Srbiji. Prema podacima Republičkog zavoda za statistiku, prosečna godišnja zarada po zaposlenom u Republici Srbiji, isplaćena u 2017. godini iznosi 791.712 dinara. Na osnovu toga, neoporeziv iznos za 2017. godinu je 2.375.136 dinara."]
   [:p "Lica postaju obveznici poreza na dohodak građana tek kada u tekućoj godini ostvare dohodak trostruko veći od iznosa prosečne mesečne zarade jednog zaposlenog. U obzir se uzima njegova zarada, isplaćena u Republici Srbiji u onoj godini za koju se utvrđuje porez. Glavni uslov je da u toku jedne kalendarske godine ostvari dohodak veći od trostrukog iznosa prosečne godišnje zarade."]
   [:p "Godišnji porez na dohodak građana plaćaju njegovi obveznici:"]
   [:ul
    [:li "fizička lica koja su ostvarila dohodak veći od neoporezivog iznosa,"]
    [:li "rezidenti, za dohodak ostveren u Republici Srbiji i u inostranstvu,"]
    [:li "nerezidenti, za dohodak ostvaren u Republici Srbiji."]]
   [:p "Rezidenti su lica koja imaju prebivalište u Srbiji, kao i lica koja svoju poslovnu delatnost obavljaju na teritoriji Republike Srbije. Rezidenti su takođe i lica koja borave u našoj zemlji 183 dana ili više, u periodu od 12 meseci."]
   [:p "Fizička lica koja idu da rade u inostranstvo postaju rezidenti, ali samo ako ispunjavaju određene uslove, u skladu sa Zakonom. U suprotnom, ne postaju rezidenti. Fizička lica koja idu u inostranstvo na rad u diplomatskom ili konzularnom predstavništvu su rezidenti."]
   [:p "Nerezident je fizičko lice koje ostvaruje dohodak u Republici Srbiji, a ne ispunjava uslove da postane rezident. Obavezan je da podnese poresku prijavu i da plati porez na dohodak građana."]])

(defn beograd-uknjizba-stana []
  [:div
   [:p "Centar za katastar nepokretnosti Beograd se nalazi u ulici 27. marta 43-45."]
   [:p "Novi Zakon o postupku upisa u katastar nepokretnosti i vodova (Sl. glasnik RS, br. 41/2018 i 95/2018) stupio je na snagu 8. juna 2018. godine. Nove tehnologije ubrzavaju i olakšavaju proces prometa nepokretnosti. Ubrzavanje procesa upisa u katastar nepokretnosti je bio jedan od razloga za donošenja ovog Zakona."]
   [:p "Podnesci, dokazi i akta se u postupku upisa u katastar nepokretnosti dostavljaju u formi elektronskog dokumenta, kroz e-šalter. Postupak upisa u katastar nepokretnosti pokreće nadležna služba za katastar nepokretnosti po službenoj dužnosti odmah po prijemu isprave koju joj po službenoj dužnosti preko e-šaltera dostave sudovi, javni beležnici, javni izvršitelji, organi javne uprave i drugi organi i organizacije koji u vršenju javnih ovlašćenja donose odluke koje predstavljaju osnov za upis u katastar nepokretnosti."]
   [:p "Izuzetno od pravila da se postupak upisa u katastar nepokretnosti pokreće po službenoj dužnosti, stranka može samostalno podneti zahtev za upis u katastar nepokretnosti u formi papirnog dokumenta. Ova usluga će biti omogućena do 31. decembra 2020. godine."]
   [:p "Zakonom su propisani rokovi u kojim su obveznici dostave (sudovi, javni beležnici, javni izvršitelji, organi javne uprave i drugi organi i organizacije) dužni da nadležnoj službi za katastar nepokretnosti dostave dokumentaciju, i to:"]
   [:ol
    [:li "javni beležnik, u roku od 24 časa od trenutka sastavljanja, potvrđivanja, odnosno overavanja javno beležničke isprave, o čemu izdaje potvrdu strankama;"]
    [:li "sud, u roku od tri radna dana od izvršnosti odluke koju je doneo;"]
    [:li "javni izvršitelj, u roku propisanom zakonom kojim se uređuje izvršenje i obezbeđenje;"]
    [:li "državni organ, organ jedinice lokalne samouprave i drugi subjekti, u roku od 24 časa od dana izvršnosti odluke koja je osnov za upis."]]
   [:p "Ako dostavu isprave vrši javni beležnik, on nadležnoj službi za katatsatr nepokretnosti dostavlja i poresku prijavu radi utvrđivanja poreza na prenos apsolutnih prava, odnosno poreza na nasleđe i poklon i poresku prijavu radi utvrđivanja poreza na imovinu. Međutim, obveznik podnošenja tih prijava može odbiti da iste budu dostavljene preko javnog beležnika, u kom slučaju javni beležnik dostavlja belešku koju je sačinio o tome. Služba ih potom prosleđuje poreskom organu, odnosno organu jedinice lokalne samouprave nadležnom za utvrđivanje, naplatu i kontrolu izvornih prihoda jedinice lokalne samouprave."]
   [:p "Pored toga što su sada Zakonom skraćeni rokovi za podnošenje zahteva za upis u katastar, skraćeni su rokovi i za donošenje rešenja o upisu: "]
   [:ul
    [:li "Ako isprave za upis dostave obveznici dostave, rok za donošenje rešenja je 5 radnih dana."]
    [:li "Ako stranka lično pokrene postupak upisa, rok za donošenje rešenja je 15 radnih dana, osim u slučaju upisa hipoteke kada je rok za donošenje rešenja 5 radnih dana od dana prijema zahteva."]
    ]
   [:p "Ono što dodatno ubrzava proces upisa je to da nadležna služba za katatstra nepokretnosti, ukoliko su ispunjeni formalni uslovi za upis, ne proverava zakonitost promene koja se sprovodi u skladu sa dostavljenom ispravom, već donosi rešenje kojim sprovodi upis te promene. O zakonitosti je vodio računa obveznik dostave u postupku donošenja, sastavljanja, potvrđivanja, odnosno overavanja te isprave. Međutim, ako Služba nađe da je raspolaganje nepokretnošću u ispravi koja je osnov za upis očigledno protivno prinudnim propisima, Služba vrši upis na osnovu te isprave u katastar i odmah obaveštava organ koji je nadležan da po službenoj dužnosti pokrene odgovarajući postupak za poništavanje, odnosno ukidanje takve isprave, kao i javnog tužioca i istovremeno o tome upisuje zabeležbu."]
   [:p "Novi Zakon o postupku upisa u katastar nepokretnosti i vodova između ostalog menja i proces upisa zajedničke svojine. Ako je kupac u braku u trenutku kupovine stana, taj stan će u katastru nepokretnosti biti upisan kao zajednička svojina. Međutim, ako kupac želi da stan koji kupuje tokom trajanja braka ne bude zajednička svojina, neophodno je da oba supružnika daju svoju saglasnost da se ne radi o zajedničkoj imovini, već o posebnoj imovini kupca. Ta saglasnost može se dati u posebnim izjavama koje moraju biti potvrđene (solemnizovane) od strane nadležnog javnog beležnika, ili tako što će oba supružnika potpisati ugovor kojim kupac stiče stan."]
   ])

(defn uzice-registracija []
  [:div
   [:p "U Užicu postoji osam firmi registrovanih za tehničke pregleda vozila. Pored same usluge tehničkog pregleda sve one nude i uslugu regulisanja sve neophodne papirologija za registraciju vozila."]
   [:p "Vaš automobil morate registrovati Kako registrovati automobilna svakih godinu dana. Po Zakonu o bezbednosti saobraćaja na putevima svaki vozač može učestvovati u saobraćaju na putevima jedino ukoliko ima uredno registrovano vozilo. U Srbiji je potrebno obnoviti registraciju automobila na svakih godinu dana, koliko važi tehnički pregled, osiguranje, a samim tim i saobraćajna dozvola. Budite oprezni i vodite računa o datumu isteka. Najpametnije je da par dana pre isteka roka na koji vam je vozilo registrovano obavite tehnički pregled kako bi imali dovoljno vremena da otklonite eventualne kvarove ukoliko se ispostavi da oni postoje. Ukoliko ne umete da obavite celu proceduru, možete se obratiti ovlašćenim agencijama koje uz povoljne cene obavljaju ove poslove."]
   [:p [:h5 "Šta je neophodno"]]
   [:ol
    [:li [:p "Dokaz o vlasništvu. Ukoliko prvi put registrujete auto na svoje ime najpre je neophodno da posedujete dokaz kako ste postali vlasnik istog (potreban vam je kupoprodajni ugovor, rešenje o nasleđivanju, eventualni račun iz prodavnice novih automobila itd)."]]
    [:li [:p "Tehnički pregled. Nakon toga neophodno je da odete u posebno ovlašćene auto kuće koje obavljaju tehnički pregled vozila, gde će se utvrditi da li je vozilo ispravno za saobraćaj. Neophodno je da ponesete dovoljno novca kako bi platili sve neophodne takse koje su različite visine u zavisnosti od kategorije vozila."]]
    [:li [:p "Saobraćajna dozvola. Nakon obavljenog tehničkog pregleda i svih plaćenih dažbina, treba sa ličnom kartom da odete u policijsku stanicu na teritoriji opštine na kojoj živite i predate uredno popunjen registracioni list i platite taksu za dobijanje obrasca saobraćajne dozvole."]]
    [:li [:p "Obnova registracije. Registracija vozila obavlja se jedanput godišnje i zakon toleriše da zakasnite samo mesec dana po isteku roka na koji je vozilo registrovano. Ukoliko zakasnite više od mesec dana i vozite neregistrovano vozilo kazne su po novom zakonu jako visoke, zato još jednom napominjemo da strogo povedete računa o datumu isteka vaše registracije."]]
    ]
   [:p "U roku od 30 dana pre ili 30 dana posle isteka datuma registracije naznačenog na registracionoj nalepnici možete izvršiti produženje registracije auta. Ako ne izvršite produženje registracije u roku od 30 dana od isteka, vaš auto se automatski prebacuje u pasivni registar što znači da ćete morati da menjate registarske tablice i saobraćajnu dozvolu kada odlučite da produžite registraciju posle tog roka."]
   [:p "Za produženje registracije auta je potrebno da obavite tehnički pregled i zaključite polisu obaveznog osiguranja od autoodgovornosti. Nakon toga je potrebno da izvršite plaćanje dažbina za registraciju (porez na upotrebu motornog vozila, registracionu nalepnicu, komunalna taksa) . Registraciju možete produžiti na samom tehničkom pregledu (ako nema nikakvih promena koje bi se morale evidentirati u dokumentima ili drugih smetnji) ili u policijskoj stanici."]
   ])

(defn uzice-porez-na-dohodak []
  [:div
   [:p "Prijava godišnjeg poreza na dohodak građana nadležnom poreskom organu, prema mestu prebivališta obveznika (Poreska uprava Užice), vrši se putem obrasca PPDG-2R – Poreska prijava za utvrđivanje godišnjeg poreza na dohodak građana. Rok za predaju obrasca PPDG-2R je 15. maj tekuće godine, elektronskim putem."]
   [:p "Porez na dohodak je dodatni porez na zaradu ili na neku ostvarenu dobit. Predaje se najkasnije do 15. maja tekuće godine, za ostvarenu dobit iz prethodne godine. Ovaj porez nije obavezan za sve koji ostvaruju neku dobit. Obavezan je samo za lica čija dobit prelazi određen neoporezivi iznos, pa se i plaća preko tog iznosa."]
   [:p "Za 2018. godinu neoporezivi iznos je 2.375.136 dinara i jednak je trostrukom iznosu prosečne godišnje zarade po zaposlenom, koja je isplaćena u Republici Srbiji u 2017. godini. Na iznos preko toga plaća se porez na dohodak."]
   [:p "Prema definiciji, neoporezivi iznos dohotka je trostruki iznos prosečne godišnje zarade po zaposlenom, koja je isplaćena u Republici Srbiji. Prema podacima Republičkog zavoda za statistiku, prosečna godišnja zarada po zaposlenom u Republici Srbiji, isplaćena u 2017. godini iznosi 791.712 dinara. Na osnovu toga, neoporeziv iznos za 2017. godinu je 2.375.136 dinara."]
   [:p "Lica postaju obveznici poreza na dohodak građana tek kada u tekućoj godini ostvare dohodak trostruko veći od iznosa prosečne mesečne zarade jednog zaposlenog. U obzir se uzima njegova zarada, isplaćena u Republici Srbiji u onoj godini za koju se utvrđuje porez. Glavni uslov je da u toku jedne kalendarske godine ostvari dohodak veći od trostrukog iznosa prosečne godišnje zarade."]
   [:p "Godišnji porez na dohodak građana plaćaju njegovi obveznici:"]
   [:ul
    [:li "fizička lica koja su ostvarila dohodak veći od neoporezivog iznosa,"]
    [:li "rezidenti, za dohodak ostveren u Republici Srbiji i u inostranstvu,"]
    [:li "nerezidenti, za dohodak ostvaren u Republici Srbiji."]]
   [:p "Rezidenti su lica koja imaju prebivalište u Srbiji, kao i lica koja svoju poslovnu delatnost obavljaju na teritoriji Republike Srbije. Rezidenti su takođe i lica koja borave u našoj zemlji 183 dana ili više, u periodu od 12 meseci."]
   [:p "Fizička lica koja idu da rade u inostranstvo postaju rezidenti, ali samo ako ispunjavaju određene uslove, u skladu sa Zakonom. U suprotnom, ne postaju rezidenti. Fizička lica koja idu u inostranstvo na rad u diplomatskom ili konzularnom predstavništvu su rezidenti."]
   [:p "Nerezident je fizičko lice koje ostvaruje dohodak u Republici Srbiji, a ne ispunjava uslove da postane rezident. Obavezan je da podnese poresku prijavu i da plati porez na dohodak građana."]
   ])

(defn uzice-uknjizba-stana []
  [:div
   [:p "Republički geodetski zavod Služba za katastar nepokretnosti Užice se nalazi u ulici Jug Bogdanova 1/B."]
   [:p "Novi Zakon o postupku upisa u katastar nepokretnosti i vodova (Sl. glasnik RS, br. 41/2018 i 95/2018) stupio je na snagu 8. juna 2018. godine. Nove tehnologije ubrzavaju i olakšavaju proces prometa nepokretnosti. Ubrzavanje procesa upisa u katastar nepokretnosti je bio jedan od razloga za donošenja ovog Zakona."]
   [:p "Podnesci, dokazi i akta se u postupku upisa u katastar nepokretnosti dostavljaju u formi elektronskog dokumenta, kroz e-šalter. Postupak upisa u katastar nepokretnosti pokreće nadležna služba za katastar nepokretnosti po službenoj dužnosti odmah po prijemu isprave koju joj po službenoj dužnosti preko e-šaltera dostave sudovi, javni beležnici, javni izvršitelji, organi javne uprave i drugi organi i organizacije koji u vršenju javnih ovlašćenja donose odluke koje predstavljaju osnov za upis u katastar nepokretnosti."]
   [:p "Izuzetno od pravila da se postupak upisa u katastar nepokretnosti pokreće po službenoj dužnosti, stranka može samostalno podneti zahtev za upis u katastar nepokretnosti u formi papirnog dokumenta. Ova usluga će biti omogućena do 31. decembra 2020. godine."]
   [:p "Zakonom su propisani rokovi u kojim su obveznici dostave (sudovi, javni beležnici, javni izvršitelji, organi javne uprave i drugi organi i organizacije) dužni da nadležnoj službi za katastar nepokretnosti dostave dokumentaciju, i to:"]
   [:ol
    [:li "javni beležnik, u roku od 24 časa od trenutka sastavljanja, potvrđivanja, odnosno overavanja javno beležničke isprave, o čemu izdaje potvrdu strankama;"]
    [:li "sud, u roku od tri radna dana od izvršnosti odluke koju je doneo;"]
    [:li "javni izvršitelj, u roku propisanom zakonom kojim se uređuje izvršenje i obezbeđenje;"]
    [:li "državni organ, organ jedinice lokalne samouprave i drugi subjekti, u roku od 24 časa od dana izvršnosti odluke koja je osnov za upis."]]
   [:p "Ako dostavu isprave vrši javni beležnik, on nadležnoj službi za katatsatr nepokretnosti dostavlja i poresku prijavu radi utvrđivanja poreza na prenos apsolutnih prava, odnosno poreza na nasleđe i poklon i poresku prijavu radi utvrđivanja poreza na imovinu. Međutim, obveznik podnošenja tih prijava može odbiti da iste budu dostavljene preko javnog beležnika, u kom slučaju javni beležnik dostavlja belešku koju je sačinio o tome. Služba ih potom prosleđuje poreskom organu, odnosno organu jedinice lokalne samouprave nadležnom za utvrđivanje, naplatu i kontrolu izvornih prihoda jedinice lokalne samouprave."]
   [:p "Pored toga što su sada Zakonom skraćeni rokovi za podnošenje zahteva za upis u katastar, skraćeni su rokovi i za donošenje rešenja o upisu: "]
   [:ul
    [:li "Ako isprave za upis dostave obveznici dostave, rok za donošenje rešenja je 5 radnih dana."]
    [:li "Ako stranka lično pokrene postupak upisa, rok za donošenje rešenja je 15 radnih dana, osim u slučaju upisa hipoteke kada je rok za donošenje rešenja 5 radnih dana od dana prijema zahteva."]]
   [:p "Ono što dodatno ubrzava proces upisa je to da nadležna služba za katatstra nepokretnosti, ukoliko su ispunjeni formalni uslovi za upis, ne proverava zakonitost promene koja se sprovodi u skladu sa dostavljenom ispravom, već donosi rešenje kojim sprovodi upis te promene. O zakonitosti je vodio računa obveznik dostave u postupku donošenja, sastavljanja, potvrđivanja, odnosno overavanja te isprave. Međutim, ako Služba nađe da je raspolaganje nepokretnošću u ispravi koja je osnov za upis očigledno protivno prinudnim propisima, Služba vrši upis na osnovu te isprave u katastar i odmah obaveštava organ koji je nadležan da po službenoj dužnosti pokrene odgovarajući postupak za poništavanje, odnosno ukidanje takve isprave, kao i javnog tužioca i istovremeno o tome upisuje zabeležbu."]
   [:p "Novi Zakon o postupku upisa u katastar nepokretnosti i vodova između ostalog menja i proces upisa zajedničke svojine. Ako je kupac u braku u trenutku kupovine stana, taj stan će u katastru nepokretnosti biti upisan kao zajednička svojina. Međutim, ako kupac želi da stan koji kupuje tokom trajanja braka ne bude zajednička svojina, neophodno je da oba supružnika daju svoju saglasnost da se ne radi o zajedničkoj imovini, već o posebnoj imovini kupca. Ta saglasnost može se dati u posebnim izjavama koje moraju biti potvrđene (solemnizovane) od strane nadležnog javnog beležnika, ili tako što će oba supružnika potpisati ugovor kojim kupac stiče stan."]])

(defn zajecar-registracija []
  [:div
   [:p "U Zaječaru postoji jedanaest firmi registrovanih za tehničke pregleda vozila. Pored same usluge tehničkog pregleda sve one nude i uslugu regulisanja sve neophodne papirologija za registraciju vozila."]
   [:p "Vaš automobil morate registrovati Kako registrovati automobilna svakih godinu dana. Po Zakonu o bezbednosti saobraćaja na putevima svaki vozač može učestvovati u saobraćaju na putevima jedino ukoliko ima uredno registrovano vozilo. U Srbiji je potrebno obnoviti registraciju automobila na svakih godinu dana, koliko važi tehnički pregled, osiguranje, a samim tim i saobraćajna dozvola. Budite oprezni i vodite računa o datumu isteka. Najpametnije je da par dana pre isteka roka na koji vam je vozilo registrovano obavite tehnički pregled kako bi imali dovoljno vremena da otklonite eventualne kvarove ukoliko se ispostavi da oni postoje. Ukoliko ne umete da obavite celu proceduru, možete se obratiti ovlašćenim agencijama koje uz povoljne cene obavljaju ove poslove."]
   [:p [:h5 "Šta je neophodno"]]
   [:ol
    [:li [:p "Dokaz o vlasništvu. Ukoliko prvi put registrujete auto na svoje ime najpre je neophodno da posedujete dokaz kako ste postali vlasnik istog (potreban vam je kupoprodajni ugovor, rešenje o nasleđivanju, eventualni račun iz prodavnice novih automobila itd)."]]
    [:li [:p "Tehnički pregled. Nakon toga neophodno je da odete u posebno ovlašćene auto kuće koje obavljaju tehnički pregled vozila, gde će se utvrditi da li je vozilo ispravno za saobraćaj. Neophodno je da ponesete dovoljno novca kako bi platili sve neophodne takse koje su različite visine u zavisnosti od kategorije vozila."]]
    [:li [:p "Saobraćajna dozvola. Nakon obavljenog tehničkog pregleda i svih plaćenih dažbina, treba sa ličnom kartom da odete u policijsku stanicu na teritoriji opštine na kojoj živite i predate uredno popunjen registracioni list i platite taksu za dobijanje obrasca saobraćajne dozvole."]]
    [:li [:p "Obnova registracije. Registracija vozila obavlja se jedanput godišnje i zakon toleriše da zakasnite samo mesec dana po isteku roka na koji je vozilo registrovano. Ukoliko zakasnite više od mesec dana i vozite neregistrovano vozilo kazne su po novom zakonu jako visoke, zato još jednom napominjemo da strogo povedete računa o datumu isteka vaše registracije."]]
    ]
   [:p "U roku od 30 dana pre ili 30 dana posle isteka datuma registracije naznačenog na registracionoj nalepnici možete izvršiti produženje registracije auta. Ako ne izvršite produženje registracije u roku od 30 dana od isteka, vaš auto se automatski prebacuje u pasivni registar što znači da ćete morati da menjate registarske tablice i saobraćajnu dozvolu kada odlučite da produžite registraciju posle tog roka."]
   [:p "Za produženje registracije auta je potrebno da obavite tehnički pregled i zaključite polisu obaveznog osiguranja od autoodgovornosti. Nakon toga je potrebno da izvršite plaćanje dažbina za registraciju (porez na upotrebu motornog vozila, registracionu nalepnicu, komunalna taksa) . Registraciju možete produžiti na samom tehničkom pregledu (ako nema nikakvih promena koje bi se morale evidentirati u dokumentima ili drugih smetnji) ili u policijskoj stanici."]
   ])

(defn zajecar-porez-na-dohodak []
  [:div
   [:p "Prijava godišnjeg poreza na dohodak građana nadležnom poreskom organu, prema mestu prebivališta obveznika (Poreska uprava Zaječar), vrši se putem obrasca PPDG-2R – Poreska prijava za utvrđivanje godišnjeg poreza na dohodak građana. Rok za predaju obrasca PPDG-2R je 15. maj tekuće godine, elektronskim putem."]
   [:p "Porez na dohodak je dodatni porez na zaradu ili na neku ostvarenu dobit. Predaje se najkasnije do 15. maja tekuće godine, za ostvarenu dobit iz prethodne godine. Ovaj porez nije obavezan za sve koji ostvaruju neku dobit. Obavezan je samo za lica čija dobit prelazi određen neoporezivi iznos, pa se i plaća preko tog iznosa."]
   [:p "Za 2018. godinu neoporezivi iznos je 2.375.136 dinara i jednak je trostrukom iznosu prosečne godišnje zarade po zaposlenom, koja je isplaćena u Republici Srbiji u 2017. godini. Na iznos preko toga plaća se porez na dohodak."]
   [:p "Prema definiciji, neoporezivi iznos dohotka je trostruki iznos prosečne godišnje zarade po zaposlenom, koja je isplaćena u Republici Srbiji. Prema podacima Republičkog zavoda za statistiku, prosečna godišnja zarada po zaposlenom u Republici Srbiji, isplaćena u 2017. godini iznosi 791.712 dinara. Na osnovu toga, neoporeziv iznos za 2017. godinu je 2.375.136 dinara."]
   [:p "Lica postaju obveznici poreza na dohodak građana tek kada u tekućoj godini ostvare dohodak trostruko veći od iznosa prosečne mesečne zarade jednog zaposlenog. U obzir se uzima njegova zarada, isplaćena u Republici Srbiji u onoj godini za koju se utvrđuje porez. Glavni uslov je da u toku jedne kalendarske godine ostvari dohodak veći od trostrukog iznosa prosečne godišnje zarade."]
   [:p "Godišnji porez na dohodak građana plaćaju njegovi obveznici:"]
   [:ul
    [:li "fizička lica koja su ostvarila dohodak veći od neoporezivog iznosa,"]
    [:li "rezidenti, za dohodak ostveren u Republici Srbiji i u inostranstvu,"]
    [:li "nerezidenti, za dohodak ostvaren u Republici Srbiji."]]
   [:p "Rezidenti su lica koja imaju prebivalište u Srbiji, kao i lica koja svoju poslovnu delatnost obavljaju na teritoriji Republike Srbije. Rezidenti su takođe i lica koja borave u našoj zemlji 183 dana ili više, u periodu od 12 meseci."]
   [:p "Fizička lica koja idu da rade u inostranstvo postaju rezidenti, ali samo ako ispunjavaju određene uslove, u skladu sa Zakonom. U suprotnom, ne postaju rezidenti. Fizička lica koja idu u inostranstvo na rad u diplomatskom ili konzularnom predstavništvu su rezidenti."]
   [:p "Nerezident je fizičko lice koje ostvaruje dohodak u Republici Srbiji, a ne ispunjava uslove da postane rezident. Obavezan je da podnese poresku prijavu i da plati porez na dohodak građana."]
   ])

(defn zajecar-uknjizba-stana []
  [:div
   [:p "Republički geodetski zavod Služba za katastar nepokretnosti Zahečar se nalazi na u ulici Nikole Pašića 91."]
   [:p "Novi Zakon o postupku upisa u katastar nepokretnosti i vodova (Sl. glasnik RS, br. 41/2018 i 95/2018) stupio je na snagu 8. juna 2018. godine. Nove tehnologije ubrzavaju i olakšavaju proces prometa nepokretnosti. Ubrzavanje procesa upisa u katastar nepokretnosti je bio jedan od razloga za donošenja ovog Zakona."]
   [:p "Podnesci, dokazi i akta se u postupku upisa u katastar nepokretnosti dostavljaju u formi elektronskog dokumenta, kroz e-šalter. Postupak upisa u katastar nepokretnosti pokreće nadležna služba za katastar nepokretnosti po službenoj dužnosti odmah po prijemu isprave koju joj po službenoj dužnosti preko e-šaltera dostave sudovi, javni beležnici, javni izvršitelji, organi javne uprave i drugi organi i organizacije koji u vršenju javnih ovlašćenja donose odluke koje predstavljaju osnov za upis u katastar nepokretnosti."]
   [:p "Izuzetno od pravila da se postupak upisa u katastar nepokretnosti pokreće po službenoj dužnosti, stranka može samostalno podneti zahtev za upis u katastar nepokretnosti u formi papirnog dokumenta. Ova usluga će biti omogućena do 31. decembra 2020. godine."]
   [:p "Zakonom su propisani rokovi u kojim su obveznici dostave (sudovi, javni beležnici, javni izvršitelji, organi javne uprave i drugi organi i organizacije) dužni da nadležnoj službi za katastar nepokretnosti dostave dokumentaciju, i to:"]
   [:ol
    [:li "javni beležnik, u roku od 24 časa od trenutka sastavljanja, potvrđivanja, odnosno overavanja javno beležničke isprave, o čemu izdaje potvrdu strankama;"]
    [:li "sud, u roku od tri radna dana od izvršnosti odluke koju je doneo;"]
    [:li "javni izvršitelj, u roku propisanom zakonom kojim se uređuje izvršenje i obezbeđenje;"]
    [:li "državni organ, organ jedinice lokalne samouprave i drugi subjekti, u roku od 24 časa od dana izvršnosti odluke koja je osnov za upis."]]
   [:p "Ako dostavu isprave vrši javni beležnik, on nadležnoj službi za katatsatr nepokretnosti dostavlja i poresku prijavu radi utvrđivanja poreza na prenos apsolutnih prava, odnosno poreza na nasleđe i poklon i poresku prijavu radi utvrđivanja poreza na imovinu. Međutim, obveznik podnošenja tih prijava može odbiti da iste budu dostavljene preko javnog beležnika, u kom slučaju javni beležnik dostavlja belešku koju je sačinio o tome. Služba ih potom prosleđuje poreskom organu, odnosno organu jedinice lokalne samouprave nadležnom za utvrđivanje, naplatu i kontrolu izvornih prihoda jedinice lokalne samouprave."]
   [:p "Pored toga što su sada Zakonom skraćeni rokovi za podnošenje zahteva za upis u katastar, skraćeni su rokovi i za donošenje rešenja o upisu: "]
   [:ul
    [:li "Ako isprave za upis dostave obveznici dostave, rok za donošenje rešenja je 5 radnih dana."]
    [:li "Ako stranka lično pokrene postupak upisa, rok za donošenje rešenja je 15 radnih dana, osim u slučaju upisa hipoteke kada je rok za donošenje rešenja 5 radnih dana od dana prijema zahteva."]
    ]
   [:p "Ono što dodatno ubrzava proces upisa je to da nadležna služba za katatstra nepokretnosti, ukoliko su ispunjeni formalni uslovi za upis, ne proverava zakonitost promene koja se sprovodi u skladu sa dostavljenom ispravom, već donosi rešenje kojim sprovodi upis te promene. O zakonitosti je vodio računa obveznik dostave u postupku donošenja, sastavljanja, potvrđivanja, odnosno overavanja te isprave. Međutim, ako Služba nađe da je raspolaganje nepokretnošću u ispravi koja je osnov za upis očigledno protivno prinudnim propisima, Služba vrši upis na osnovu te isprave u katastar i odmah obaveštava organ koji je nadležan da po službenoj dužnosti pokrene odgovarajući postupak za poništavanje, odnosno ukidanje takve isprave, kao i javnog tužioca i istovremeno o tome upisuje zabeležbu."]
   [:p "Novi Zakon o postupku upisa u katastar nepokretnosti i vodova između ostalog menja i proces upisa zajedničke svojine. Ako je kupac u braku u trenutku kupovine stana, taj stan će u katastru nepokretnosti biti upisan kao zajednička svojina. Međutim, ako kupac želi da stan koji kupuje tokom trajanja braka ne bude zajednička svojina, neophodno je da oba supružnika daju svoju saglasnost da se ne radi o zajedničkoj imovini, već o posebnoj imovini kupca. Ta saglasnost može se dati u posebnim izjavama koje moraju biti potvrđene (solemnizovane) od strane nadležnog javnog beležnika, ili tako što će oba supružnika potpisati ugovor kojim kupac stiče stan."]
   ])


(defn render-answer [type]
  (case type
    111 [beograd-registracija]
    112 [beograd-porez-na-dohodak]
    113 [beograd-uknjizba-stana]
    311 [uzice-registracija]
    312 [uzice-porez-na-dohodak]
    313 [uzice-uknjizba-stana]
    191 [zajecar-registracija]
    192 [zajecar-porez-na-dohodak]
    193 [zajecar-uknjizba-stana]
    [:div]))
