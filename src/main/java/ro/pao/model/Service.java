package ro.pao.model;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import ro.pao.model.abstracts.AbstractEntity;

import java.util.ArrayList;

@SuperBuilder
@Getter
public class Service extends AbstractEntity {

    private String name;
    private Integer duration;
    private Double price;
    private ArrayList<Part> materialsList;
}
