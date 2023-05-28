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

    Role - rolurile pe care le poate avea un utilizator: admin, client

    Vehicle - detaliile despre masina de inchiriat
    Order - detalii despre comanda

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

    Lista de requesturi:
    	Entitatea role: - getUserRoleById() (returneaza numele rolului pe care il are un anumit user, adminul poate sa faca acest request)
    					- getAllRoles() (returneaza toate rolurile din baza de date)
    					- deleteAllRoles() (sterge toate rolurile din baza de date)
    	Entitatea user: - getAllUsers() {returneaza totii useri, admin request}
    					- getUserById() {returneaza un user dupa id, admin request}
    					- updateById() {modifica entitatea user cu un id dat, ex: cazul in care utilizatorul vrea sa isi modifice adresa de email}
    					- deleteAll() {goleste baza de date de toti userii}
    					- deleteById() {sterge un user dupa id, ex: cazul in care utilizatorul vrea sa isi stearga contul}
    					- insertNewUser() {insereaza un utilizator nou in baza de date, request facut cand un utilizator isi creaza cont}
    	Entitatea vehicle: - getAllVehicles() (returneaza toate vehiculele din baza de date)
    					   - getVehicleById() (returneaza un vehicul dupa id)
    					   - getVehicleByBrand (rerturneaza un vehicul dupa brand)
    					   - getBrandModelName (returneaza lista de vehicule inchiriate de un utilizator)
    					   - deleteAll() (goleste baza de date de toate vehiculele)
    					   - deleteVehicleById() (sterge un vehicul cu un id dat din baza de date)
    					   - insertNewVehicle() (insereaza un nou vehicul in baza de date)
    					   - updateVehicleById() (modifica un vehicul cu un id dat, ex: adminul vrea sa modifice pretul)
    					   - discount() (aplica discount de 10% la vehicule)
    					   - increasePrice() (creste pretul cu 10% la vehicule)
    	Entitatea rentavehicle: - getAllOrders() (returneaza toate comenzile)
    							- getOrderById() (returneaza o comanda dupa id)
    							- getOrderByUserId (returneaza o comanda dupa id-ul utilizatorului)
    							- getOrderByVehicleId (returneaza o comanda dupa id-ul unui vehicul)
    							- deleteAll() (goleste baza de date de toate comenzile)

    Schimbari:
    	- pentru tema 3 am eliminat patternul Observer pentru a scapa de complexitatea codului, si am reimplementat metodele de discount si increasePrice
    		cu doua query-uri care actualizeaza in mod direct baza de date(a trebuit scoasa optiunea de safe update din mySQL)
    	- am actualizat javadoc pentru toate clasele din proiect
    	- am testat toate metodele din service-urile fiecarei entitati(nu am avut logica suplimentara de testat, unul din motivele pentru care am eliminat
    		patternul, mi s-a parut mult mai greu de testat logica)

Manual utilizator interfata:
-aplicatia porneste in fereastra login
-utilizatorul se poate loga sau inregistra
-un buton de login as admin care trimite catre fereastra admin
-utilizatorul poate sa faca un request sa ceara toate masinile din baza de date sau doar cele cu brandul specificat
-utilizatorul poate face comenzi introducand numarul masinii
-adminul poate sa faca update la datele utilizatorului sau sa ii stearga o comanda
