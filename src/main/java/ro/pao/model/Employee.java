package ro.pao.model;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.UUID;

@SuperBuilder
@Getter
public non-sealed class Employee extends User {

    private String position;
    private Double salary;
    private UUID sectorId;

    public Employee(String email) {
        super(email);
    }

    public Employee(UUID id, LocalDate creationDate, LocalDate updateDate, LocalDate deleteDate, String lastName, String firstName, String phone, String email, String position, Double salary, UUID sectorId) {
        super(id, creationDate, updateDate, deleteDate, lastName, firstName, phone, email);
        this.position = position;
        this.salary = salary;
        this.sectorId = sectorId;
    }
}
