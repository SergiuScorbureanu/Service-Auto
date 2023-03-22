package ro.pao.model;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class Employee extends User {

    private String position;
    private Double salary;

}
