package ro.pao.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;

@Getter
@AllArgsConstructor
public enum Body {

    SEDAN("sedan"),
    COMBI("combi"),
    HATCHBACK("hatchback"),
    MONOVOLUM("monovolum"),
    SUV("suv");

    private final String type;

    public static Optional<Body> getFuelByFieldString(String field) {
        return Arrays.stream(Body.values())
                .filter(bodyElement -> bodyElement.type.equals(field))
                .findAny();

    }
}
