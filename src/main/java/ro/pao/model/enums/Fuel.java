package ro.pao.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;

@Getter
@AllArgsConstructor
public enum Fuel {

    PETROL("petrol"),
    DIESEL("diesel"),
    ELECTRIC("electric"),
    HYBRID("hybrid");

    private final String type;

    public static Optional<Fuel> getFuelByFieldString(String field) {
        return Arrays.stream(Fuel.values())
                .filter(fuelElement -> fuelElement.type.equals(field))
                .findAny();

    }
}
