package ro.pao.model;

import lombok.*;
import lombok.experimental.SuperBuilder;
import ro.pao.model.abstracts.AbstractEntity;


@SuperBuilder
@Getter
public class Sector extends AbstractEntity {

    private String name;

}
