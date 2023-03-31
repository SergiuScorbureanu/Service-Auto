package ro.pao.model;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import ro.pao.model.abstracts.AbstractEntity;

@SuperBuilder
@Getter
public class Vehicle extends AbstractEntity {

    private String defect;
    private String chassisSeries;
    private String engineSeries;

}
