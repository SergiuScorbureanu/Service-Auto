package ro.pao.model.abstracts;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString
@EqualsAndHashCode
public abstract class AbstractEntity {

    private UUID id;

    private LocalDate creationDate = LocalDate.now();

    private LocalDate updateDate = LocalDate.now();

    private LocalDate deleteDate;
}
