package ro.pao.model;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import ro.pao.model.Employee;
import ro.pao.model.abstracts.AbstractEntity;

import java.time.LocalDate;
import java.util.UUID;
import java.util.function.Predicate;

@SuperBuilder
@Getter
public sealed class User extends AbstractEntity permits Employee, Client {

    private String lastName;
    private String firstName;
    private String phone;
    private String email;

    private final Predicate<String> emailCondition = email -> email.contains("@yahoo.com") || email.contains("@gmail.com");

    public User(String email) {
        if (!emailCondition.test(email)) {
            System.out.println("E-mail introdus incorect");
        }
    }

    public User(UUID id, LocalDate creationDate, LocalDate updateDate, LocalDate deleteDate, String lastName, String firstName, String phone, String email) {
        super(id, creationDate, updateDate, deleteDate);
        this.lastName = lastName;
        this.firstName = firstName;
        this.phone = phone;
        this.email = email;

        if(!emailCondition.test(email)) {
            System.out.println("E-mail introdus incorect");
        } else {
            this.email = email;
        }
    }
}
