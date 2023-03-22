package ro.pao.model;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class Vehicle {

    private String defect;
    private String chassisSeries;
    private String engineSeries;

}
