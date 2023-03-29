package ro.pao.service;

import ro.pao.model.Part;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PartService {

    void createPart(Part part);

    Optional<Part> getPartByName(String name);

    List<Part> getAllParts();

    void deletePartById(UUID id);

    void updatePartById(UUID id, Part newPart);


}
