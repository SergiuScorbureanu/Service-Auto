package ro.pao.service.impl;

import lombok.Getter;
import lombok.NoArgsConstructor;
import ro.pao.model.Employee;
import ro.pao.model.Part;
import ro.pao.service.PartService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter
public class PartServiceImpl implements PartService {

    private static List<Part> partsList = new ArrayList<>();

    @Override
    public void addPart(Part part) {
        partsList.add(part);
    }

    @Override
    public void addAllParts(List<Part> partList) {
        partsList.addAll(partList);
    }

    @Override
    public Optional<Part> getPartByName(UUID id) {
        return partsList.stream()
                .filter(part -> id.equals(part.getName()))
                .findFirst();
    }

    @Override
    public List<Part> getAllParts(UUID id) {
        return partsList;
    }

    @Override
    public void deletePartById(UUID id) {
        partsList = partsList.stream()
                .filter(object -> !id.equals(object.getId()))
                .collect(Collectors.toList());
    }

    @Override
    public void updatePartById(UUID id, Part newPart) {
        Optional<Part> employee = this.getPartByName(id);
        if(employee.isPresent()) {
            deletePartById(id);
            newPart.setId(id);
            addPart(newPart);
        }
    }
}
