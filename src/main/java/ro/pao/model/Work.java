package ro.pao.model;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import ro.pao.model.abstracts.AbstractEntity;

import java.util.ArrayList;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

@SuperBuilder
@Getter
public class Work extends AbstractEntity {

    private String name;
    private Integer duration;
    private Double price;
    private ArrayList<Part> partsList;
    private UUID vehicleId;

    private static final Logger logger = Logger.getGlobal();


    public void decreaseTime() {
        this.duration = this.getDuration() - 5;
        logger.log(Level.INFO, () -> Thread.currentThread().getName() + " " + this.getName() + " mai dureaza: " + this.getDuration() + " secunde");
    }
}
