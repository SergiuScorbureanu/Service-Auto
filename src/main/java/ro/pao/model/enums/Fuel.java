package ro.pao.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Fuel {

    PETROL("petrol"),
    DIESEL("diesel"),
    ELECTRIC("electric"),
    HYBRID("hybrid");

    private final String type;

}
