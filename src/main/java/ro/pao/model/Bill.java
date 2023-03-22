package ro.pao.model;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import ro.pao.model.abstracts.AbstractEntity;

import java.util.ArrayList;

@SuperBuilder
@Getter
public class Bill extends AbstractEntity {

    private ArrayList<Service> servicesList;
    private ArrayList<Part> materialsList;
    private Double totalPrice;
}
