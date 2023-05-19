package ro.pao.model;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import ro.pao.model.abstracts.AbstractEntity;
import ro.pao.model.enums.Body;
import ro.pao.model.enums.Fuel;

import java.util.UUID;

@SuperBuilder
@Getter
public class Vehicle extends AbstractEntity {

    private String defect;
    private String chassisSeries;
    private String engineSeries;
    private Body body;
    private Fuel fuel;
    private UUID sectorId;

}
