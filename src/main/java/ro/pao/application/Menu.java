package ro.pao.application;

import ro.pao.model.*;
import ro.pao.model.abstracts.AbstractEntity;
import ro.pao.model.enums.Body;
import ro.pao.model.enums.Fuel;
import ro.pao.repository.implementations.ClientRepositoryImpl;
import ro.pao.repository.implementations.EmployeeRepositoryImpl;
import ro.pao.repository.implementations.PartRepositoryImpl;
import ro.pao.repository.implementations.VehicleRepositoryImpl;
import ro.pao.service.*;
import ro.pao.service.implementations.*;

import java.time.LocalDate;
import java.util.*;

public class Menu {

    private static Menu INSTANCE;

    private final EmployeeService employeeService = new EmployeeServiceImpl(new EmployeeRepositoryImpl());
    private final WorkService workService = new WorkServiceImpl();
    private final SectorService sectorService = new SectorServiceImpl();
    private final PartService partService = new PartServiceImpl(new PartRepositoryImpl());
    private final ClientService clientService = new ClientServiceImpl(new ClientRepositoryImpl());
    private final VehicleService vehicleService = new VehicleServiceImpl(new VehicleRepositoryImpl());

    public static Menu getInstance() {
        return (INSTANCE == null ? new Menu() : INSTANCE);
    }

    public void application() {

        // *** MENIU ***

        createObjects(); // adaug obiectele deja existente

        Scanner scanner = new Scanner(System.in);
        String intro = """
                ***** MENIU *****
                1. Inregistrare client
                2. Adaugare si diagnosticare vehicul
                """;

        System.out.println("\n\t" + intro);
        System.out.println();


        while (true) {

            System.out.print("\nOptiunea: ");
            int optiune = scanner.nextInt();
            System.out.println();

            switch (optiune) {
                case 1:
                    addNewClient();
                    break;
                case 2:
                    addNewVehicle();
                    break;
                default:
                    System.out.println("Optiune invalida!");
                    return;
            }
        }
    }

    void createObjects() {
        List<Sector> sectors = List.of(
                Sector.builder()
                        .id(UUID.randomUUID())
                        .creationDate(LocalDate.now())
                        .updateDate(LocalDate.now())
                        .name("Tinichigerie")
                        .build(),
                Sector.builder()
                        .id(UUID.randomUUID())
                        .creationDate(LocalDate.now())
                        .updateDate(LocalDate.now())
                        .name("Mecanica")
                        .build(),
                Sector.builder()
                        .id(UUID.randomUUID())
                        .creationDate(LocalDate.now())
                        .updateDate(LocalDate.now())
                        .name("Vopsitorie")
                        .build()
        );
        sectorService.addAllSectorsFromList(sectors);

        Optional<Sector> sector1 = sectorService.getSectorByName("Tinichigerie");
        Optional<Sector> sector2 = sectorService.getSectorByName("Mecanica");
        Optional<Sector> sector3 = sectorService.getSectorByName("Vopsitorie");

        List<Employee> employees = List.of(
                Employee.builder()
                        .id(UUID.randomUUID())
                        .creationDate(LocalDate.of(2023, 3, 31))
                        .updateDate(LocalDate.now())
                        .firstName("Mircea")
                        .lastName("Popescu")
                        .phone("0742635688")
                        .email("mircea.popescu@yahoo.com")
                        .salary(3500.00)
                        .position("Tinichigiu")
                        .sectorId(getSectorUuid(sector1))
                        .build(),
                Employee.builder()
                        .id(UUID.randomUUID())
                        .creationDate(LocalDate.now())
                        .updateDate(LocalDate.now())
                        .firstName("Jenel")
                        .lastName("Popa")
                        .phone("0742635808")
                        .email("jenel.popa@yahoo.com")
                        .salary(4500.00)
                        .position("Mecanic")
                        .sectorId(getSectorUuid(sector2))
                        .build(),
                Employee.builder()
                        .id(UUID.randomUUID())
                        .creationDate(LocalDate.now())
                        .updateDate(LocalDate.now())
                        .firstName("Mrian")
                        .lastName("Vanghelie")
                        .phone("0735795623")
                        .email("marian.vanghelie@gmail.com")
                        .salary(4500.00)
                        .sectorId(getSectorUuid(sector2))
                        .position("Mecanic")
                        .build(),
                Employee.builder()
                        .id(UUID.randomUUID())
                        .creationDate(LocalDate.now())
                        .updateDate(LocalDate.now())
                        .firstName("Alexandru")
                        .lastName("Petrescu")
                        .phone("0725481623")
                        .email("alexandru.petrescu@gmail.com")
                        .salary(4000.00)
                        .sectorId(getSectorUuid(sector3))
                        .position("Vopsitor")
                        .build(),
                Employee.builder()
                        .id(UUID.randomUUID())
                        .creationDate(LocalDate.now())
                        .updateDate(LocalDate.now())
                        .firstName("Viorel")
                        .lastName("Talpan")
                        .phone("0735791209")
                        .email("viorel.talpan@gmail.com")
                        .salary(6200.00)
                        .sectorId(getSectorUuid(sector2))
                        .position("Mecanic sef")
                        .build()
        );
        employeeService.addAllFromEmployeesList(employees);

        List<Part> parts = List.of(
                Part.builder()
                        .id(UUID.randomUUID())
                        .creationDate(LocalDate.now())
                        .updateDate(LocalDate.now())
                        .code("1e01")
                        .name("Aripa dreapta")
                        .price(300.00)
                        .build(),
                Part.builder()
                        .id(UUID.randomUUID())
                        .creationDate(LocalDate.now())
                        .updateDate(LocalDate.now())
                        .code("1e02")
                        .name("Aripa stanga")
                        .price(300.00)
                        .build(),
                Part.builder()
                        .id(UUID.randomUUID())
                        .creationDate(LocalDate.now())
                        .updateDate(LocalDate.now())
                        .code("2e01")
                        .name("Curea distributie")
                        .price(250.00)
                        .build(),
                Part.builder()
                        .id(UUID.randomUUID())
                        .creationDate(LocalDate.now())
                        .updateDate(LocalDate.now())
                        .code("2e02")
                        .name("Pompa benzina")
                        .price(800.00)
                        .build(),
                Part.builder()
                        .id(UUID.randomUUID())
                        .creationDate(LocalDate.now())
                        .updateDate(LocalDate.now())
                        .code("2e12")
                        .name("Planetara")
                        .price(300.00)
                        .build(),
                Part.builder()
                        .id(UUID.randomUUID())
                        .creationDate(LocalDate.now())
                        .updateDate(LocalDate.now())
                        .code("2e01")
                        .name("Injector")
                        .price(400.00)
                        .build(),
                Part.builder()
                        .id(UUID.randomUUID())
                        .creationDate(LocalDate.now())
                        .updateDate(LocalDate.now())
                        .code("2e01")
                        .name("Amortizor")
                        .price(320.00)
                        .build()
        );
        partService.addAllPartsFromList(parts);
    }

     UUID getSectorUuid(Optional<Sector> sector) {
         return sector.map(AbstractEntity::getId).orElse(null);
     }

    void addNewClient() {
        Scanner addClientScanner = new Scanner(System.in);
        System.out.println("*** Introduceti datele dumneavoastra ***");

        System.out.println("Nume de familie");
        String lastName = addClientScanner.next();

        System.out.println("Prenume:");
        String firstName = addClientScanner.next();

        System.out.println("Nr. de telefon:");
        String phone = addClientScanner.next();

        System.out.println("E-mail:");
        String email = addClientScanner.next();

        System.out.println("CNP:");
        String cnp = addClientScanner.next();

        System.out.println("Adresa:");
        String address = addClientScanner.next();

        Client newClient = Client.builder()
                .id(UUID.randomUUID())
                .creationDate(LocalDate.now())
                .updateDate(LocalDate.now())
                .lastName(lastName)
                .firstName(firstName)
                .phone(phone)
                .email(email)
                .CNP(cnp)
                .address(address)
                .build();
        clientService.addClient(newClient);
        System.out.println("Cont inregistrat cu succes!");
    }

    void addNewVehicle() {
        Scanner addVehicleScanner = new Scanner(System.in);
        System.out.println("*** Introduceti datele autovehiculului ***");

        System.out.println("Defect:");
        String defect = addVehicleScanner.next();

        System.out.println("Seria de sasiu:");
        String chassisSeries = addVehicleScanner.next();

        System.out.println("Seria de motor:");
        String engineSeries = addVehicleScanner.next();

        System.out.println("Tipul de caroserie:");
        System.out.println("1. Sedan");
        System.out.println("2. Combi");
        System.out.println("3. Hatchback");
        System.out.println("4. Monovolum");
        System.out.println("5. Suv");
        int intBody = addVehicleScanner.nextInt();
        Body caroserie = switch (intBody) {
            case 1 -> Body.SEDAN;
            case 2 -> Body.COMBI;
            case 3 -> Body.HATCHBACK;
            case 4 -> Body.MONOVOLUM;
            case 5 -> Body.SUV;
            default -> Body.SEDAN;
        };

        System.out.println("Timpul de combustibil:");
        System.out.println("1. Benzina");
        System.out.println("2. Diesel");
        System.out.println("3. Electric");
        System.out.println("4. Hybrid");
        int intFuel = addVehicleScanner.nextInt();
        Fuel combustibil = switch (intFuel) {
            case 1 -> Fuel.PETROL;
            case 2 -> Fuel.DIESEL;
            case 3 -> Fuel.ELECTRIC;
            case 4 -> Fuel.HYBRID;
            default -> Fuel.PETROL;
        };


        System.out.println("Introduceti sectorul in care va fi directionat vehiculul");

        System.out.println("""
                Sectoare:
                1. Tinichigerie
                2. Mecanica
                3. Vopsitorie
                """);

        System.out.println("Introduceti sectorul:");
        int optiuneSector = addVehicleScanner.nextInt();

        switch (optiuneSector) {
            case 1: {
                Optional<Sector> sector1 = sectorService.getSectorByName("Tinichigerie");
                Vehicle newVehicle = Vehicle.builder()
                        .id(UUID.randomUUID())
                        .creationDate(LocalDate.now())
                        .updateDate(LocalDate.now())
                        .defect(defect)
                        .chassisSeries(chassisSeries)
                        .engineSeries(engineSeries)
                        .sectorId(sector1.get().getId())
                        .build();
                vehicleService.addVehicle(newVehicle);
                break;
            }
            case 2: {
                Optional<Sector> sector2 = sectorService.getSectorByName("Mecanica");
                Vehicle newVehicle = Vehicle.builder()
                        .id(UUID.randomUUID())
                        .creationDate(LocalDate.now())
                        .updateDate(LocalDate.now())
                        .defect(defect)
                        .chassisSeries(chassisSeries)
                        .engineSeries(engineSeries)
                        .sectorId(sector2.get().getId())
                        .build();
                vehicleService.addVehicle(newVehicle);
                break;
            }
            case 3: {
                Optional<Sector> sector3 = sectorService.getSectorByName("Vopsitorie");
                Vehicle newVehicle = Vehicle.builder()
                        .id(UUID.randomUUID())
                        .creationDate(LocalDate.now())
                        .updateDate(LocalDate.now())
                        .defect(defect)
                        .chassisSeries(chassisSeries)
                        .engineSeries(engineSeries)
                        .sectorId(sector3.get().getId())
                        .build();
                vehicleService.addVehicle(newVehicle);
                break;
            }

        }
        System.out.println("Introduceti datele servisarii:");

        System.out.println("Nume:");
        String name = addVehicleScanner.next();

        System.out.println("Durata:");
        int duration = addVehicleScanner.nextInt();

        System.out.println("Pret manopera:");
        double price = addVehicleScanner.nextDouble();

        System.out.println("Piese (separate prin virgula):");
        String part = addVehicleScanner.next();

        String[] requiredPartsList = part.split(",");
        ArrayList<Part> allRequiredParts = new ArrayList<>();

        for (String requiredPartName : requiredPartsList) {

            if (partService.getPartByName(requiredPartName).isEmpty()) {
                System.out.println("Piesa " + requiredPartName + " nu exista in stoc.");
                System.out.println("Se cumpara piesa...");
                Part newPart = Part.builder()
                        .id(UUID.randomUUID())
                        .creationDate(LocalDate.now())
                        .updateDate(LocalDate.now())
                        .code("1234d")
                        .name(requiredPartName)
                        .price(50.0)
                        .build();

                partService.addPart(newPart);
                allRequiredParts.add(newPart);

            } else allRequiredParts.add(partService.getPartByName(requiredPartName).orElse(null));
        }

        Work works = Work.builder()
                .id(UUID.randomUUID())
                .creationDate(LocalDate.now())
                .updateDate(LocalDate.now())
                .name(name)
                .duration(duration)
                .price(price)
                .partsList(allRequiredParts)
                .build();

        System.out.println();
        System.out.println("Masina a fost inregistrata cu succes!");

    }

}
