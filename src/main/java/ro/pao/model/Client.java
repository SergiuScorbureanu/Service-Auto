package ro.pao.model;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class Client extends User {

    private Long CNP;
    private String address;
    private Long phone;
    private String email;

}
