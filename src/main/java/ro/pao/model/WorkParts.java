package ro.pao.model;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@SuperBuilder
@Getter
public class WorkParts extends Part {

    private UUID workId;
}
