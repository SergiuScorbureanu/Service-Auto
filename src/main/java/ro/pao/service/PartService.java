package ro.pao.service;

import ro.pao.model.Part;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PartService {

    void addPart(Part part);

    void addAllParts(List<Part> partList);

    Optional<Part> getPartByName(UUID id);

    List<Part> getAllParts(UUID id);

    void deletePartById(UUID id);

    void updatePartById(UUID id, Part newPart);


}
