# IOD-I51-Alpha-BuildingInfo
## Projekt: Building Info
## Opis projektu:

Dla administratorów budynków, którzy pragną optymalizować koszty zarządzania budynkami  nasza aplikacja Building Info umożliwi pozyskanie informacji o parametrach budynku na poziomie pomieszczeń, kondygnacji oraz całych budynków. Aplikacja będzie dostępna poprzez GUI a także jako zdalne API dzięki czemu można ją zintegrować z istniejącymi narzędziami.
 ## Struktura danych:
* Lokacja to budynek, poziom, lub pomieszczenie
##
* Budynek może składać się z poziomów a te z pomieszczeń
##
* Każda lokalizacja jest charakteryzowana przez:
  *  id – unikalny identyfikator
  *  name – opcjonalna nazwa lokalizacji
##
* Pomieszczenie dodatkowo jest charakteryzowane przez:
  *    area = powierzchnia w m^2
  *    cube = kubatura pomieszczenia w m^3
  *    heating = poziom zużycia energii ogrzewania (float)
  *    light – łączna moc oświetlenia
 ### Niezbędne informacje dotyczące projektu:
 ##
1. Informacja o ocenie czasochłonności projektu i wybranych zadań do implementacji znajduje się niżej z linkiem na Google Docks:
 [*Nacisnij na mnie*](https://docs.google.com/spreadsheets/d/1hf-mf7IO9Z-v3826LD75ZTwRdHropKfN/edit#gid=795588837)
2. Schemat UML:

![UML diagram](https://user-images.githubusercontent.com/72620745/209119129-4e573feb-e92b-4d95-ae06-6745f2b1a778.png)





