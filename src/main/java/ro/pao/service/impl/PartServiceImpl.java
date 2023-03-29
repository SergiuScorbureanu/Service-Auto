package ro.pao.service.impl;

import lombok.Getter;
import lombok.NoArgsConstructor;
import ro.pao.model.Part;
import ro.pao.service.PartService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@NoArgsConstructor
@Getter
public class PartServiceImpl implements PartService {

    private static List<Part> partsList = new ArrayList<>();

    @Override
    public void createPart(Part part) {

    }

    @Override
    public Optional<Part> getPartByName(String name) {
        return Optional.empty();
    }

    @Override
    public List<Part> getAllParts() {
        return null;
    }

    @Override
    public void deletePartById(UUID id) {

    }

    @Override
    public void updatePartById(UUID id, Part newPart) {

    }
}
