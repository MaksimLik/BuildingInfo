# BuildingInfo
## Opis projektu:
Dla administratorów budynków, którzy pragną optymalizować koszty zarządzania budynkami nasza aplikacja Building Info umożliwi pozyskanie informacji o parametrach budynku na poziomie pomieszczeń, kondygnacji oraz całych budynków. Aplikacja będzie dostępna poprzez GUI a także jako zdalne API dzięki czemu można ją zintegrować z istniejącymi narzędziami.
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
 ## Krótko o projekcie:
 Projekt - to jest strona internetowa:
 ![web1](https://user-images.githubusercontent.com/72620745/222795234-dfad51d8-5f37-4405-b996-23f13b9f0ada.png)
Aplikacja pozwala na wyświetlenie budynków i pokojów, dodanie, usunięcie. Oprócz tego dla każdego budynku można wpisać kubaturę, limit na energię i ogrzewanie - te ograncizenia podajemy dla każdego pokoju w budynku. 
![web2](https://user-images.githubusercontent.com/72620745/222797113-7b8543e8-55fc-4b16-becb-663102d915f0.png)
GUI jest zrobione za pomocą JAVA Spring z dodatkiem javascript, CSS. Oprócz tego projekt posiada:
1. Dokumentację
2. UML diagram
3. Testy jednostkowe
4. Testy jednostkowe objektów mock

 ### Niezbędne informacje dotyczące projektu:
 ##
1. Informacja o ocenie czasochłonności projektu i wybranych zadań do implementacji znajduje się niżej z linkiem na Google Docks:
 [*Nacisnij na mnie*](https://docs.google.com/spreadsheets/d/1hf-mf7IO9Z-v3826LD75ZTwRdHropKfN/edit#gid=795588837)
2. Schemat UML:

![UML diagram](https://user-images.githubusercontent.com/72620745/209119575-3ccbf8af-4b1b-433f-87fe-60eef96d8c41.png)

---

## Product Backlog:

<html>
<body>
<!--StartFragment--><google-sheets-html-origin><meta name="sheets-banding" data-sheets-range="A1:E7" data-sheets-banding-properties="{&quot;1&quot;:{&quot;1&quot;:{&quot;2&quot;:18434,&quot;4&quot;:{&quot;1&quot;:3,&quot;3&quot;:4},&quot;14&quot;:{&quot;1&quot;:3,&quot;3&quot;:4},&quot;17&quot;:1},&quot;2&quot;:{&quot;2&quot;:18434,&quot;4&quot;:{&quot;1&quot;:2,&quot;2&quot;:12111076},&quot;14&quot;:{&quot;1&quot;:2,&quot;2&quot;:12111076},&quot;17&quot;:0},&quot;3&quot;:1,&quot;4&quot;:{&quot;2&quot;:18434,&quot;4&quot;:{&quot;1&quot;:2,&quot;2&quot;:14411249},&quot;14&quot;:{&quot;1&quot;:2,&quot;2&quot;:14411249},&quot;17&quot;:0},&quot;5&quot;:1}}"><!--td {border: 1px solid #cccccc;}br {mso-data-placement:same-cell;}-->

Element rejestru produktu | Ważność | Pracochłonność [h] | Business Value (BV) | Kryteria akceptacji
-- | -- | -- | -- | --
Jako twórca oprogramowania do zarządzania budynkami mogę korzystać z dostępnych funkcji zdalnie poprzez REST, aby móc  zintegrować narzędzie z moimi innymi aplikacjami | 20 | 12 | 1 | o Wejście w formacie JSON odpowiadające strukturze budynku (listy, słowniki)o Wejście transformowane do postaci modelu obiektowego o Wyjście w formacie JSONo REST API umożliwia uruchomienie dowolnej aktualnie zaimplementowanej funkcji.
Jako zarządca budynku mogę sprawdzić łączną powierzchnie budynku, poziomu lub pomieszczenia, aby móc prowadzić wyliczenia bazujące na powierzchni | 15 | 2 | 1 | o Prawidłowo podawane dla pomieszczeniao Dla poziomu wyliczane jako suma powierzchni pomieszczeń na poziomieo Dla budynku wyliczane jako suma powierzchni poziomów
Jako zarządca budynku mogę sprawdzić łączną kubaturę pomieszczeń w budynku, na poziomu czy też pobrać kubaturę pomieszczenia, aby móc prowadzić wyliczenia bazujące na kubaturze pomieszczeń | 12 | 2 | 1 | o Prawidłowo podawane dla pomieszczeniao Dla poziomu wyliczane jako suma kubatury pomieszczeń na poziomieo Dla budynku wyliczane jako suma kubatury poziomów
Jako zarządca budynku mogę obliczyć moc oświetlenia w przeliczeniu na jednostkę powierzchni dla budynku, poziomu, pomieszczenia | 10 | 3,5 | 1 | o Prawidłowo podawane dla pomieszczeniao Dla poziomu wyliczane jako średnia moc na m^2 na poziomieo Dla budynku wyliczane jako średnia moc na poziomach
Jako zarządca budynku mogę obliczyć zużycie energii na ogrzewanie w przeliczeniu na jednostkę objętości dla budynku, poziomu, pomieszczenia | 10 | 2,5 | 1 | o Prawidłowo podawane dla pomieszczeniao Dla poziomu wyliczane jako średnie zużycie na m^3 na poziomieo Dla budynku wyliczane jako średnie zużycie na poziomach
Jako użytkownik mogę skorzystać z aplikacji za pomocą interfejsu użytkownika | 10 | 7 | 2 | Ładnie graficznie i funkcjonalnie

<!--EndFragment-->
</body>
</html>
 
-----
 
## Sprint Backlog:

1. Jako twórca oprogramowania do zarządzania budynkami mogę korzystać z dostępnych funkcji zdalnie poprzez REST, aby móc  zintegrować narzędzie z moimi innymi aplikacjami [12 h]:
####
1.1. Dowiedzieć się jak się robi REST [3 h]
####
1.2. Zainstalować MySQL i zrobić BD [2 h]
####
1.3. Sprawdzić zależności i dodać ich [0.5 h]
####
1.4. Implementacja API REST [3 h]
####
1.5. Łączenie tego i sprawdzenie, naprawianie [3.5]
______________________________________________________________________________
2. Jako zarządca budynku mogę sprawdzić łączną powierzchnie budynku, poziomu lub pomieszczenia, aby móc prowadzić wyliczenia bazujące na powierzchni [2.0 h]:
####
2.1. Schemat teoretyczny [0.5 h]
####
2.2. Implementacja kodu i sprawdzenie [1.5 h]
______________________________________________________________________________
3. Jako zarządca budynku mogę obliczyć moc oświetlenia w przeliczeniu na jednostkę powierzchni dla budynku, poziomu, pomieszczenia [3.5 h]:
####
3.1. Przypomnieć formuły obliczeniowe [1 h]
####
3.2. Schemat teoretyczny [0.5 h]
####
3.3. Implementacja kodu i sprawdzenie [2.0 h]
______________________________________________________________________________
4. Jako zarządca budynku mogę otrzymać informację o pomieszczeniach w budynku, które przekraczają określony poziom zużycia energii cieplnej / m^3 podany jako parametr, aby znaleźć miejsca do poprawy w infrastrukturze [2.0 h]:
####
4.1. Przypomnieć formuły obliczeniowe [0.5 h]
####
4.2. Przemyśleć jak zaimplementować kod [1.0 h]
####
4.3. Implementacja kodu [0.5 h] 
______________________________________________________________________________
5. Jako użytkownik mogę skorzystać z aplikacji za pomocą interfejsu użytkownika [7.0 h]: 
####
5.1. Layout [1.0 h]
####
5.2. Wybrać technologię implementacji [1.0 h]
####
5.3. Dokumentacja technologii [1.0 h]
####
5.4 Implementacja [3.0 h]
####
5.5 Testowanie [1.0 h]
______________________________________________________________________________
6. Jako zarządca budynku mogę sprawdzić łączną kubaturę pomieszczeń w budynku, na poziomu czy też pobrać kubaturę pomieszczenia, aby móc prowadzić wyliczenia bazujące na kubaturze pomieszczeń [2.0 h]:
####
6.1. Przemyśleć jak zaimplementować kod dla kilku klas [0.5 h]
####
6.2 Implementacja kodu [1.5 h]
______________________________________________________________________________
7. Dodanie Sprint Backloga [30 min]:
####
7.1. Sprawdzenie co już się udało zrobić i ile to zajęło czasu [20 min]
####
7.2 Dodanie otrzymanej informacji do Sprint Backloga [10 min]
______________________________________________________________________________
8. Zaktualizowanie Product Backloga [30 min]:
####
8.1. Sprawdzenie co już mamy [20 min]
####
8.2. Dodanie informacji do Product Backloga [10 min]
______________________________________________________________________________
9. Rozmowa ze wszystkimi członkami dotycząca optymalizacji pracy (Jak nie marnować czas na rozmowy podczas spotkania i co robić jak przestała działać aplikacja) [1 h]
Było przeprowadzono kilka spotkań około 10-20 min każde, suma tych wszystkich spotkań dotyczących analizy pracy zespołowej i optymalizacji czasu pracy ~ 1h

## Uruchomienie projektu:
1. Pobieramy Projekt
2. Musimy mieć zainstalowane: Intellij IDEA, MySQL Workbench 8.0 CE,  Node.js
3. Włączamy MySQL Workbench 8.0 CE i tworzymy połączenie gdzie wpisujemy następne komendy, żeby stworzyć BD: 
####
 3.1. create schema test;
####
 3.2. use test;
####
4. Odpalamy program w Intellij IDEA i kompilujemy projekt - można skorzystać z pliku JAR;
5. Odpalamy terminal i przechodzimy do pliku w projekcie /frontend/buildings i wpisujemy następne komendy:
####
 5.1. npm start









