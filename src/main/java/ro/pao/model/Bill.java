package ro.pao.model;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import ro.pao.model.abstracts.AbstractEntity;

import java.util.ArrayList;

@SuperBuilder
@Getter
public class Bill extends AbstractEntity {

    private ArrayList<Work> worksList;
    private ArrayList<Part> partsList;
    private Double totalPrice;
}
