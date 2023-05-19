package ro.pao.model;

import lombok.*;
import lombok.experimental.SuperBuilder;
import ro.pao.model.abstracts.AbstractEntity;

import java.util.ArrayList;

@SuperBuilder
@Getter
public class Sector extends AbstractEntity {

    private String name;
    private ArrayList<Employee> employeesList;
    private ArrayList<Work> worksList;

}
