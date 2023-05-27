package ro.pao.service.implementations;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ro.pao.model.Part;
import ro.pao.repository.implementations.PartRepositoryImpl;
import ro.pao.service.PartService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Getter
public class PartServiceImpl implements PartService {

    private final PartRepositoryImpl partRepository;

    @Override
    public void addPart(Part part) {
        partRepository.addNewPart(part);
    }

    @Override
    public void addAllPartsFromList(List<Part> partList) {
        partRepository.addAllPartsFromList(partList);
    }

    @Override
    public Optional<Part> getPartById(UUID id) {
        return partRepository.getPartById(id);
    }

    @Override
    public Optional<Part> getPartByName(String name) {
        return partRepository.getPartByName(name);
    }

    @Override
    public List<Part> getAllParts(UUID id) {
        return partRepository.getAllParts(id);
    }

    @Override
    public void deletePartById(UUID id) {
        partRepository.deletePartById(id);
    }

    @Override
    public void updatePartById(UUID id, Part newPart) {
        partRepository.updatePartById(id, newPart);
    }
}
