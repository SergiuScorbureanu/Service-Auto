package ro.pao.model;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import ro.pao.model.abstracts.AbstractEntity;

@SuperBuilder
@Getter
public class User extends AbstractEntity {

    private String lastName;
    private String firstName;
}
