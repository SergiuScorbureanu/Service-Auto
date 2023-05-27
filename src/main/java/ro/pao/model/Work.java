package ro.pao.model;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import ro.pao.model.abstracts.AbstractEntity;

import java.util.ArrayList;
import java.util.UUID;

@SuperBuilder
@Getter
public class Work extends AbstractEntity {

    private String name;
    private Integer duration;
    private Double price;
    private ArrayList<Part> partsList;
    private UUID vehicleId;
}
