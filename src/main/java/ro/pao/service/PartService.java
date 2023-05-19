package ro.pao.service;

import ro.pao.model.Part;
import ro.pao.model.Sector;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PartService {

    void addPart(Part part);

    void addAllPartsFromList(List<Part> partList);

    Optional<Part> getPartById(UUID id);

    Optional<Part> getPartByName(String name);

    List<Part> getAllParts(UUID id);

    void deletePartById(UUID id);

    void updatePartById(UUID id, Part newPart);


}
