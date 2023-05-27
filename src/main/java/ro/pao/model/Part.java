package ro.pao.model;

import lombok.*;
import lombok.experimental.SuperBuilder;
import ro.pao.model.abstracts.AbstractEntity;

import java.util.UUID;

@SuperBuilder
@Getter
public class Part extends AbstractEntity {

    private String code;
    private String name;
    private Double price;
    private UUID workId;

}
