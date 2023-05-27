package ro.pao.model;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import ro.pao.model.abstracts.User;

import java.time.LocalDate;
import java.util.UUID;

@SuperBuilder
@Getter
public class Client extends User {

    private String CNP;
    private String address;

    public Client(String email) {
        super(email);
    }

    public Client(UUID id, LocalDate creationDate, LocalDate updateDate, LocalDate deleteDate, String lastName, String firstName, String phone, String email, String CNP, String address) {
        super(id, creationDate, updateDate, deleteDate, lastName, firstName, phone, email);
        this.CNP = CNP;
        this.address = address;
    }
}
