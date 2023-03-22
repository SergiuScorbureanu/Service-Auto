package ro.pao.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Body {

    SEDAN("sedan"),
    COMBI("combi"),
    HATCHBACK("hatchback"),
    MONOVOLUM("monovolum"),
    SUV("suv");

    private final String type;

}
