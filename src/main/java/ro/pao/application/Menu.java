package ro.pao.application;

import ro.pao.exceptions.CustomFileNotFoundException;
import ro.pao.model.*;
import ro.pao.model.abstracts.AbstractEntity;
import ro.pao.repository.implementations.*;
import ro.pao.service.*;
import ro.pao.service.implementations.*;

import java.time.LocalDate;
import java.util.*;

public class Menu {

    private static Menu INSTANCE;

    private final EmployeeService employeeService = new EmployeeServiceImpl(new EmployeeRepositoryImpl());
    private final WorkService workService = new WorkServiceImpl(new WorkRepositoryImpl());
    private final SectorService sectorService = new SectorServiceImpl(new SectorRepositoryImpl());
    private final PartService partService = new PartServiceImpl(new PartRepositoryImpl());
    private final ClientService clientService = new ClientServiceImpl(new ClientRepositoryImpl());
    private final VehicleService vehicleService = new VehicleServiceImpl(new VehicleRepositoryImpl());
    private final WorkPartService workPartService = new WorkPartServiceImpl(new WorkPartRepositoryImpl());
    private final ThreadingServiceImpl threadingService = new ThreadingServiceImpl();

    public static Menu getInstance() {
        return (INSTANCE == null ? new Menu() : INSTANCE);
    }

    public void application() throws CustomFileNotFoundException {

        // *** MENIU ***

        createObjects(); // adaug obiectele deja existente

        Scanner scanner = new Scanner(System.in);
        String intro = """
                ***** MENIU *****
                1. Stergere angajat
                2. Inregistrare client
                3. Adaugare si diagnosticare vehicul
                4. Pune osu' la munca
                """;

        System.out.println("\n\t" + intro);
        System.out.println();


        while (true) {

            System.out.print("\nOptiunea: ");
            int optiune = scanner.nextInt();
            System.out.println();

            switch (optiune) {
                case 1:
                    deleteEmployee();
                    System.out.println("\n\t" + intro);
                case 2:
                    addNewClient();
                    System.out.println("\n\t" + intro);
                    break;
                case 3:
                    addNewVehicle();
                    System.out.println("\n\t" + intro);
                    break;
                case 4:
                    executeWork();
                    break;
                default:
                    System.out.println("Optiune invalida!");
                    return;
            }
        }
    }

    private void executeWork() {
        this.threadingService.executeWork();

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
                        .firstName("Marian")
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

    void deleteEmployee() throws CustomFileNotFoundException {

        List<Employee> employees = employeeService.getAllEmployees();
        System.out.println("Numar total de angajati: " + employees.size());
        System.out.println("Lista angajati: ");
        for (Employee employee : employees) {
            System.out.println("ID: " + employee.getId());
            System.out.println("Nume: " + employee.getFirstName() + " " + employee.getLastName());
            System.out.println("Telefon: " + employee.getPhone());
            System.out.println("Email: " + employee.getEmail());
            System.out.println("Salariu: " + employee.getSalary());
            System.out.println("Poziție: " + employee.getPosition());
            System.out.println("Sector ID: " + employee.getSectorId());
            System.out.println("----------------------------------");
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceți numele angajatului pe care doriti sa il stergeti:");
        System.out.print("Prenume: ");
        String firstName = scanner.nextLine();
        System.out.print("Nume de familie: ");
        String lastName = scanner.nextLine();

        UUID employeeId = employeeService.getEmployeeIdByName(firstName, lastName);
        if (employeeId != null) {
            employeeService.deleteEmployeeById(employeeId);
            System.out.println("Angajatul a fost concediat cu succes.");
        } else {
            throw new  CustomFileNotFoundException ("Angajatul nu exista in baza de date");
        }

        System.out.println("Numar total de angajati: " + employees.size());
        System.out.println("Lista angajati: ");
        for (Employee employee : employees) {
            System.out.println("ID: " + employee.getId());
            System.out.println("Nume: " + employee.getFirstName() + " " + employee.getLastName());
            System.out.println("Telefon: " + employee.getPhone());
            System.out.println("Email: " + employee.getEmail());
            System.out.println("Salariu: " + employee.getSalary());
            System.out.println("Poziție: " + employee.getPosition());
            System.out.println("Sector ID: " + employee.getSectorId());
            System.out.println("----------------------------------");
        }
        System.out.println("Numar total de angajati: " + employees.size());
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


        System.out.println("Introduceti sectorul in care va fi directionat vehiculul");

        System.out.println("""
                Sectoare:
                1. Tinichigerie
                2. Mecanica
                3. Vopsitorie
                """);

        System.out.println("Introduceti sectorul:");

        int optiuneSector = addVehicleScanner.nextInt();
        UUID vehicleUuid = null;
        switch (optiuneSector) {
            case 1 -> {
                Optional<Sector> sector1 = sectorService.getSectorByName("Tinichigerie");
                Vehicle newVehicle = Vehicle.builder()
                        .id(UUID.randomUUID())
                        .creationDate(LocalDate.now())
                        .updateDate(LocalDate.now())
                        .defect(defect)
                        .chassisSeries(chassisSeries)
                        .engineSeries(engineSeries)
                        .sectorId(getSectorUuid(sector1))
                        .build();
                vehicleService.addVehicle(newVehicle);
                vehicleUuid = newVehicle.getId();
            }
            case 2 -> {
                Optional<Sector> sector2 = sectorService.getSectorByName("Mecanica");
                Vehicle newVehicle = Vehicle.builder()
                        .id(UUID.randomUUID())
                        .creationDate(LocalDate.now())
                        .updateDate(LocalDate.now())
                        .defect(defect)
                        .chassisSeries(chassisSeries)
                        .engineSeries(engineSeries)
                        .sectorId(getSectorUuid(sector2))
                        .build();
                vehicleService.addVehicle(newVehicle);
                vehicleUuid = newVehicle.getId();
            }
            case 3 -> {
                Optional<Sector> sector3 = sectorService.getSectorByName("Vopsitorie");
                Vehicle newVehicle = Vehicle.builder()
                        .id(UUID.randomUUID())
                        .creationDate(LocalDate.now())
                        .updateDate(LocalDate.now())
                        .defect(defect)
                        .chassisSeries(chassisSeries)
                        .engineSeries(engineSeries)
                        .sectorId(getSectorUuid(sector3))
                        .build();
                vehicleService.addVehicle(newVehicle);
                vehicleUuid = newVehicle.getId();
            }
        }

        System.out.println("Introduceti datele servisarii:");


        System.out.println("Nume:");
        String name = addVehicleScanner.next();

        System.out.println("Durata:");
        int duration = addVehicleScanner.nextInt();

        System.out.println("Pret manopera:");
        double price = addVehicleScanner.nextDouble();

        Work work = Work.builder()
                .id(UUID.randomUUID())
                .creationDate(LocalDate.now())
                .updateDate(LocalDate.now())
                .name(name)
                .duration(duration)
                .price(price)
                .vehicleId(vehicleUuid)
                .build();
        workService.addWork(work);

        String intro = """
                ***** Piese *****
                1. Amortizor
                2. Injector
                3. Planetara
                4. Pompa benzina
                5. Curea distributie
                6. Aripa stanga
                7. Aripa dreapta
                8. Incepe munca
                """;

        System.out.println("\n\t" + intro);
        System.out.println();


        while (true) {

            System.out.print("\nOptiunea: ");
            Scanner scanner = new Scanner(System.in);
            int optiune = scanner.nextInt();
            System.out.println();

            switch (optiune) {
                case 1:
                    workPartService.addNewWorkPart(WorkPart.builder()
                            .id(UUID.randomUUID())
                            .creationDate(LocalDate.now())
                            .updateDate(LocalDate.now())
                            .code("2e01")
                            .name("Amortizor")
                            .price(320.00)
                            .workId(work.getId())
                            .build());
                    System.out.println("\n\t" + intro);
                    break;
                case 2:
                    workPartService.addNewWorkPart(WorkPart.builder()
                            .id(UUID.randomUUID())
                            .creationDate(LocalDate.now())
                            .updateDate(LocalDate.now())
                            .code("2e01")
                            .name("Injector")
                            .price(400.00)
                            .workId(work.getId())
                            .build());
                    System.out.println("\n\t" + intro);
                    break;
                case 3:
                    workPartService.addNewWorkPart(WorkPart.builder()
                            .id(UUID.randomUUID())
                            .creationDate(LocalDate.now())
                            .updateDate(LocalDate.now())
                            .code("2e12")
                            .name("Planetara")
                            .price(300.00)
                            .workId(work.getId())
                            .build());
                    System.out.println("\n\t" + intro);
                    break;
                case 4:
                    workPartService.addNewWorkPart(WorkPart.builder()
                            .id(UUID.randomUUID())
                            .creationDate(LocalDate.now())
                            .updateDate(LocalDate.now())
                            .code("2e02")
                            .name("Pompa benzina")
                            .price(800.00)
                            .workId(work.getId())
                            .build());
                    System.out.println("\n\t" + intro);
                    break;
                case 5:
                    workPartService.addNewWorkPart(WorkPart.builder()
                            .id(UUID.randomUUID())
                            .creationDate(LocalDate.now())
                            .updateDate(LocalDate.now())
                            .code("2e01")
                            .name("Curea distributie")
                            .price(250.00)
                            .workId(work.getId())
                            .build());
                    System.out.println("\n\t" + intro);
                    break;
                case 6:
                    workPartService.addNewWorkPart(WorkPart.builder()
                            .id(UUID.randomUUID())
                            .creationDate(LocalDate.now())
                            .updateDate(LocalDate.now())
                            .code("1e02")
                            .name("Aripa stanga")
                            .price(300.00)
                            .workId(work.getId())
                            .build());
                    System.out.println("\n\t" + intro);
                    break;
                case 7:
                    workPartService.addNewWorkPart(WorkPart.builder()
                            .id(UUID.randomUUID())
                            .creationDate(LocalDate.now())
                            .updateDate(LocalDate.now())
                            .code("1e01")
                            .name("Aripa dreapta")
                            .price(300.00)
                            .workId(work.getId())
                            .build());
                    System.out.println("\n\t" + intro);
                    break;
                case 8:
                    executeWork();
                    break;
                default:
                    return;
            }
        }

    }

}
