                            Documentatie proiect Dealership
                                                                                    Sirbu Andrei
                                                                                    
                                                                                    
                                                                                    
    Principalele tabele ale proiectului
        -tabela User
        -tabela Role
        -tabela Vehicle
        -tabela Order
        -Guest(bonus); nu e nevoie de o tabela deoarece vizitatorii nu raman in baza de date si nu au functionalitati
        
    Functionalitatile proiectului
    Guest - nu are nevoie sa se logheze 
          - nu poate decat sa vizualizeze date despre vehicule
    User  - trebuie sa isi creeze cont <=> este adaugat in baza de date
          - se logheaza pe site
          - poate efectua o inchiriere 
          - poate sa anuleze o inchiriere
    Admin - poate modifica baza de date(ex. sa puna pretul pe o anumita masina)
    
    Role - rolurile pe care le poate avea un utilizator: admin, buyer

    Vehicle - detaliile despre masina de inchiriat
    Order - detalii despre comanda

Clase noi adaugate:
    - interfata Offer, are 2 metode: discount si increasePrice;
    - clasa VehicleManagement, creste pretul pentru toate vehiculele din baza de date si adauga un discount la pret pentru brandul dat
    - clasa Vehicle implementeaza interfata Offer

Functionalitati noi adaugate:
    - am adaugat 2 endpointuri pentru clasa Vehicle, caut dupa brand
    - tuturor vehiculele care au brandul dat in request primesc un discount de 10%
    - tuturor vehiculelor le creste pretul cu 10%
    - am implementat patternul Observer



Codul pentru generarea diagramei bazei de date:
 
 
Table User {
  id int [pk, increment, not null]
  name varchar [not null]
  email varchar [not null]
  password varchar [not null]
  int id_role
}

Table Order {
  id int [pk, increment, unique]
  id_user int
  id_vehicle int 
  rent_date datetime [not null]
  return_date datetime [not null]
}

Table Vehicle {
  id int [pk, increment, unique]
  brand varchar [not null]
  name varchar [not null]
  class varchar [not null]
  chassis varchar [not null]
  top_speed varchar [not null]
  price varchar
}

Table Role {
  id int [pk, increment, not null]
  role varchar [not null]
  description varchar
}
Ref: Order.(id_user) < User.(id)
Ref: Order.(id_vehicle) - Vehicle.(id)
