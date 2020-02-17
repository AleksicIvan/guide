# guide (vodi§ in Serbian)

Vodi§ is a lightweight represenatation of a expert system that should give some assistance and guidence in a legal matter such as registration of real estate, pay tax or register a car. In its core the app is using clara-rules and expert system implemeneted in clojure programming language.
Being a prototype this is just a glimpse of possible features that this app could provide. Basically, user starts with a  login/register screen, after that you are given a choice of selecting a type of service, than user chooses a city/town. In the end after expert system checks its knowledge base and delievers a rule user is presented a answer/result page with required information.

## Prerequisites

You will need [Leiningen][1] 2.0 or above installed as well as Postgres DB 12. Also, app was build using following libraries among others: 
[Luminus][2], [funcool auth library][3], [Cheshire][4], [all Metosin's libraries][5], [re-frame][6], [reagent][7]

[1]: https://github.com/technomancy/leiningen
[2]: https://luminusweb.com/
[3]: https://github.com/funcool
[4]: https://github.com/dakrone/cheshire
[5]: https://github.com/metosin
[6]: https://github.com/day8/re-frame
[7]: https://github.com/reagent-project/reagent

## Running

To start a web server for the application, run:

    lein run 

## License

Copyright © 2020 FIXME
