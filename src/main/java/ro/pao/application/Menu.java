package ro.pao.application;

import ro.pao.model.*;
import ro.pao.service.*;
import ro.pao.service.impl.*;

import java.time.LocalDate;
import java.util.*;

public class Menu {

    private static Menu INSTANCE;

    private final EmployeeService employeeService = new EmployeeServiceImpl();
    private final WorkService workService = new WorkServiceImpl();
    private final SectorService sectorService = new SectorServiceImpl();
    private final PartService partService = new PartServiceImpl();
    private final ClientService clientService = new ClientServiceImpl();
    private final VehicleService vehicleService = new VehicleServiceImpl();



    public static Menu getInstance() {
        return (INSTANCE == null ? new Menu() : INSTANCE);
    }

    public void application() {


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
                        .sectorId(sector1.get().getId())
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
                        .sectorId(sector2.get().getId())
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
                        .sectorId(sector2.get().getId())
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
                        .sectorId(sector3.get().getId())
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
                        .sectorId(sector2.get().getId())
                        .position("Mecanic sef")
                        .build()
        );
        employeeService.addAllEmployeesFromList(employees);

//        List<Work> works = List.of(
//                Work.builder()
//                        .id(UUID.randomUUID())
//                        .creationDate(LocalDate.now())
//                        .updateDate(LocalDate.now())
//                        .name("Revizie")
//                        .duration(2)
//                        .price(200.0)
//                        .sectorId(sector2.get().getId())
//                        .build(),
//                Work.builder()
//                        .id(UUID.randomUUID())
//                        .creationDate(LocalDate.now())
//                        .updateDate(LocalDate.now())
//                        .name("Vopsit elemente plastic")
//                        .duration(3)
//                        .price(100.0)
//                        .sectorId(sector3.get().getId())
//                        .build(),
//                Work.builder()
//                        .id(UUID.randomUUID())
//                        .creationDate(LocalDate.now())
//                        .updateDate(LocalDate.now())
//                        .name("Interventie parte mecanica")
//                        .duration(5)
//                        .price(350.0)
//                        .sectorId(sector2.get().getId())
//                        .build(),
//                Work.builder()
//                        .id(UUID.randomUUID())
//                        .creationDate(LocalDate.now())
//                        .updateDate(LocalDate.now())
//                        .name("Interventie parte electrica")
//                        .duration(6)
//                        .price(500.0)
//                        .sectorId(sector2.get().getId())
//                        .build(),
//                Work.builder()
//                        .id(UUID.randomUUID())
//                        .creationDate(LocalDate.now())
//                        .updateDate(LocalDate.now())
//                        .name("Schimbare chedere")
//                        .duration(3)
//                        .price(250.0)
//                        .sectorId(sector1.get().getId())
//                        .build()
//        );
//        workService.addAllWorksFromList(works);

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



        // *** MENIU ***

        Scanner scanner = new Scanner(System.in);
        String intro = """
                ***** MENIU *****
                1. Inregistrare client
                2. Adaugare vehicul
                3. Creare factura
                """;

        System.out.println("\n\t" + intro);
        System.out.println();


        while(true) {


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
                case 3:
                    createBill();
                    break;
                default:
                    System.out.println("Optiune invalida!");
                    return;
            }
        }

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
        String body = addVehicleScanner.next();

        System.out.println("Timpul de combustibil:");
        String fuel = addVehicleScanner.next();


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
                Vehicle vehicles = Vehicle.builder()
                        .id(UUID.randomUUID())
                        .creationDate(LocalDate.now())
                        .updateDate(LocalDate.now())
                        .defect(defect)
                        .chassisSeries(chassisSeries)
                        .engineSeries(engineSeries)
                        .sectorId(sector1.get().getId())
                        .build();
                break;
            }
            case 2: {
                Optional<Sector> sector2 = sectorService.getSectorByName("Mecanica");
                Vehicle vehicles = Vehicle.builder()
                        .id(UUID.randomUUID())
                        .creationDate(LocalDate.now())
                        .updateDate(LocalDate.now())
                        .defect(defect)
                        .chassisSeries(chassisSeries)
                        .engineSeries(engineSeries)
                        .sectorId(sector2.get().getId())
                        .build();
                break;
            }
            case 3: {
                Optional<Sector> sector3 = sectorService.getSectorByName("Vopsitorie");
                Vehicle vehicles = Vehicle.builder()
                        .id(UUID.randomUUID())
                        .creationDate(LocalDate.now())
                        .updateDate(LocalDate.now())
                        .defect(defect)
                        .chassisSeries(chassisSeries)
                        .engineSeries(engineSeries)
                        .sectorId(sector3.get().getId())
                        .build();
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

//        System.out.println("Piese:");
//        ArrayList<Part> parts = new ArrayList<>();
//        String part = addVehicleScanner.next();
//        partService.getPartByName(part);
//
//        Work works = Work.builder()
//                .id(UUID.randomUUID())
//                .creationDate(LocalDate.now())
//                .updateDate(LocalDate.now())
//                .name(name)
//                .duration(duration)
//                .price(price)
//                .partsList(new ArrayList<Part>(Arrays.asList(parts)))
//                .build();

    }

    void createBill() {
        System.out.println("Afisare factura");
    }


}
