package ro.pao.application;

import ro.pao.model.*;
import ro.pao.service.EmployeeService;
import ro.pao.service.WorkService;
import ro.pao.service.impl.EmployeeServiceImpl;
import ro.pao.service.impl.WorkServiceImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

/**
 * In Meniu se fac operatiile care pot lua informatii din toate dintre servicile definite.
 * De exemplu, avem definit mai jos `private final ExampleService exampleService = new ExampleServiceImpl();`
 *
 * In cazul in care aveam definit mai multe servicii, la fel, faceam o initializare a serviciile si astfel apelam metode din serviciu.
 */
public class Menu {

    private static Menu INSTANCE;

   // private final ExampleService exampleService = new ExampleServiceImpl();
    private final EmployeeService employeeService = new EmployeeServiceImpl();
    private final WorkService workService = new WorkServiceImpl();

    public static Menu getInstance() {
        return (INSTANCE == null ? new Menu() : INSTANCE);
    }

    public void intro() {

        List<Employee> employees = List.of(
                Employee.builder()
                        .id(UUID.randomUUID())
                        .creationDate(LocalDate.of(2023, 3, 31))
                        .updateDate(LocalDate.now())
                        .firstName("Mircea")
                        .lastName("Popescu")
                        .salary(3500.00)
                        .position("Tinichigerist")
                        .build(),
                Employee.builder()
                        .id(UUID.randomUUID())
                        .creationDate(LocalDate.of(2023, 3, 31))
                        .updateDate(LocalDate.now())
                        .firstName("Jenel")
                        .lastName("Popa")
                        .salary(4500.00)
                        .position("Mecanic")
                        .build(),
                Employee.builder()
                        .id(UUID.randomUUID())
                        .creationDate(LocalDate.of(2023, 3, 31))
                        .updateDate(LocalDate.now())
                        .firstName("Viorel")
                        .lastName("Talpan")
                        .salary(7000.00)
                        .position("Mecanic sef")
                        .build()
        );
        employeeService.addAllEmployeesFromList(employees);

        System.out.println("Employees inainte de update:");
        employeeService.getAllEmployees()
                .forEach(employee -> System.out.println(employee.getId() + ", " + employee.getLastName()));


        Employee e1 = Employee.builder()
                .id(UUID.randomUUID())
                .creationDate(LocalDate.of(2023, 3, 31))
                .updateDate(LocalDate.now())
                .firstName("Mircea")
                .lastName("Ionescu")
                .salary(3500.00)
                .position("Tinichigerist")
                .build();

        employeeService.updateEmployeeById(employees.stream().findFirst().get().getId(), e1);

        System.out.println("Dupa update:");
        employeeService.getAllEmployees()
                .forEach(employee -> System.out.println(employee.getId() + ", " + employee.getLastName()));


        employeeService.deleteEmployeeById(e1.getId());

        System.out.println("Dupa stergere:");
        employeeService.getAllEmployees()
                .forEach(employee -> System.out.println(employee.getId() + ", " + employee.getLastName()));

        List<Work> works = List.of(
                Work.builder()
                        .id(UUID.randomUUID())
                        .creationDate(LocalDate.now())
                        .updateDate(LocalDate.now())
                        .name("Revizie")
                        .duration(2)
                        .price(200.0)
                        .build(),
                Work.builder()
                        .id(UUID.randomUUID())
                        .creationDate(LocalDate.now())
                        .updateDate(LocalDate.now())
                        .name("Vopsit elemente plastic")
                        .duration(3)
                        .price(100.0)
                        .build(),
                Work.builder()
                        .id(UUID.randomUUID())
                        .creationDate(LocalDate.now())
                        .updateDate(LocalDate.now())
                        .name("Interventie parte mecanica")
                        .duration(6)
                        .price(350.0)
                        .build()
        );
        workService.addAllWorksFromList(works);


//        EmployeeServiceImpl.getAllEmployeeNames();

//        String intro = """
//                Intro example
//                """;
//
//        System.out.println(intro);
//
//        ExampleClass exampleClass = ExampleClass.builder()
//                .id(UUID.randomUUID())
//                .creationDate(LocalDate.now()) // data de azi
//                .updateDate(LocalDate.now())
//                .deleteDate(LocalDate.now())
//                .build();
//
//        exampleService.addOnlyOne(exampleClass);
//
//        List<ExampleClass> exampleServiceList = List.of(
//                ExampleClass.builder()
//                        .id(UUID.randomUUID())
//                        .creationDate(LocalDate.of(2023, 03, 22))
//                        .updateDate(LocalDate.now()) // aici vin restul de intrari
//                        .build(),
//                ExampleClass.builder()
//                        .id(UUID.randomUUID())
//                        .creationDate(LocalDate.of(2023, 03, 22))
//                        .updateDate(LocalDate.now())
//                        .build()
//        );
//
//        exampleService.addAllFromGivenList(exampleServiceList);
//
//        System.out.println("Inainte de stergere: ");
//        exampleService.getAllFromList()
//                .forEach(elementFromList -> System.out.println(elementFromList));
//
//
//        System.out.println("Dupa modificare: ");
//        exampleClass.setUpdateDate(LocalDate.of(2, 2, 2));
//        exampleService.updateElementById(exampleClass.getId(), exampleClass);
//        exampleService.getAllFromList()
//                .forEach(elementFromList -> System.out.println(elementFromList));
//
//        System.out.println("Dupa stergere: ");
//        exampleService.removeElementById(exampleClass.getId());
//        exampleService.getAllFromList()
//                .forEach(elementFromList -> System.out.println(elementFromList));
    }
}
