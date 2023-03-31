package ro.pao.model;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.UUID;

@SuperBuilder
@Getter
public class Employee extends User {

    private String position;
    private Double salary;

    public Employee(String email) {
        super(email);
    }

    public Employee(UUID id, LocalDate creationDate, LocalDate updateDate, LocalDate deleteDate, String lastName, String firstName, Long phone, String email, String position, Double salary) {
        super(id, creationDate, updateDate, deleteDate, lastName, firstName, phone, email);
        this.position = position;
        this.salary = salary;
    }
}
