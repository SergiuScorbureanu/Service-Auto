package ro.pao.repository;

import ro.pao.model.Part;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PartRepository {

    void addNewPart(Part part);

    void addAllPartsFromList(List<Part> partList);

    Optional<Part> getPartById(UUID id);

    Optional<Part> getPartByName(String name);

    List<Part> getAllParts();

    void deletePartById(UUID id);

    void updatePartById(UUID id, Part newPart);
}
