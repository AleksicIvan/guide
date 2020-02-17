# guide (vodi§ in Serbian)

Vodi§ is a lightweight represenatation of a expert system that should provide some assistance and guidence in a legal matters such as registration of a real estate, paying taxes or registering a car. In its core the app is using [Clara-rules][2], expert system implemeneted in clojure programming language.
Being a prototype this is just a glimpse of possible features that this app could provide. Basically, user starts with a  login/register screen, after that you are given a choice of selecting a type of service, than user chooses a city/town. In the end after expert system checks its knowledge base and delievers a rule user is presented a answer/result page with required information.

Screen shots of app flow can be found [here][1].

An excellent lecture on a rule-based expert system by late MIT Professor Patrick H. Winston is available [here][3]

[1]: https://drive.google.com/drive/folders/1mMLEPEl2nAOITlYtO20XorqSc8nE2no7?usp=sharing
[2]: https://github.com/cerner/clara-rules
[3]: https://www.youtube.com/watch?v=leXa7EKUPFk

## Prerequisites

You will need [Leiningen][1] 2.0 or above installed as well as Postgres DB 12. Also, app was build using following libraries/dependencies among others: 
[Luminus][2], [funcool auth library][3], [Cheshire][4], [all Metosin's libraries][5], [re-frame][6] and [reagent][7]

[1]: https://github.com/technomancy/leiningen
[2]: https://luminusweb.com/
[3]: https://github.com/funcool
[4]: https://github.com/dakrone/cheshire
[5]: https://github.com/metosin
[6]: https://github.com/day8/re-frame
[7]: https://github.com/reagent-project/reagent

## Running

In order to run this you need to create a database guide-me-v2 in postgres.
Then run:
    
    lein run migrate

To start a web server for the application, run:

    lein run 
    
In another terminal window you need to run clojurescript runner:

    lein shadow watch app
    
Tests are executed by running:

    lein test-refresh
    
    
