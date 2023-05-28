Service Auto Project

O aplicatie Java care simuleaza un service auto, cu ajutorul principiilor de baza ale programarii orientate pe obiecte.
Proiectul foloseste o baza de date Postgres care are 7 tabele: Clients, Employees, Parts, Sectors, Vehicles, WorkParts si Works

MODELE
Clasa abstracta: Abstract Entity
Clasa Sealed: User

Enum-uri:
1. Body
2. Fuel

SERVICE si REPOSITORY: Fiecare tabela are un service si un repository implementation care implementeaza cate o interfata service si repository; 
THREADS: Proiectul contine o clasa denumita ExecuteWorkWorker care face multi threading la mai multe servisari pe un singur autovehicul
CSV: Factura se scrie in format .csv dupa executarea lucrarilor

METODE:
1. Stergere angajat
2. Inregistrare client
3. Adaugare si diagnosticare vehicul
4. Incepe servisarea vehiculului 
