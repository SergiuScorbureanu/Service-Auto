package ro.pao.model;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import ro.pao.model.abstracts.AbstractEntity;

import java.util.ArrayList;

@SuperBuilder
@Getter
public class Sector extends AbstractEntity {

    private ArrayList<Employee> employeesList;
    private ArrayList<Work> servicesList;

}
