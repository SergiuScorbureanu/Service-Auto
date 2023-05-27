package ro.pao.service.implementations;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ro.pao.model.WorkParts;
import ro.pao.repository.implementations.WorkPartsRepositoryImpl;
import ro.pao.service.WorkPartsService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Getter
public class WorkPartsServiceImpl implements WorkPartsService {

    private final WorkPartsRepositoryImpl workPartsRepository;

    @Override
    public Optional<WorkParts> getWorkPartsById(UUID id) {
        return workPartsRepository.getWorkPartsById(id);
    }

    @Override
    public void deleteWorkParts(UUID id) {
        workPartsRepository.deleteWorkParts(id);
    }

    @Override
    public void updateWorkPartsById(UUID id, WorkParts newWorkParts) {
        workPartsRepository.updateWorkPartsById(id, newWorkParts);
    }

    @Override
    public void addNewWorkParts(WorkParts workParts) {
        workPartsRepository.addNewWorkParts(workParts);
    }

    @Override
    public List<WorkParts> getAllWorkParts() {
        return workPartsRepository.getAllWorkParts();
    }

    @Override
    public void addAllFromWorkPartsList(List<WorkParts> workPartsList) {
        workPartsRepository.addAllFromWorkPartsList(workPartsList);
    }
}
