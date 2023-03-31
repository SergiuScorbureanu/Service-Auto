package ro.pao.model;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.UUID;
import java.util.function.Predicate;

@SuperBuilder
@Getter
public class Client extends User {

    private Long CNP;
    private String address;

    public Client(String email) {
        super(email);
    }

    public Client(UUID id, LocalDate creationDate, LocalDate updateDate, LocalDate deleteDate, String lastName, String firstName, Long phone, String email, Long CNP, String address) {
        super(id, creationDate, updateDate, deleteDate, lastName, firstName, phone, email);
        this.CNP = CNP;
        this.address = address;
    }
}
