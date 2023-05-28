package ro.pao.service.implementations;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ro.pao.model.WorkPart;
import ro.pao.repository.implementations.WorkPartRepositoryImpl;
import ro.pao.service.WorkPartService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Getter
public class WorkPartServiceImpl implements WorkPartService {

    private final WorkPartRepositoryImpl workPartRepository;

    @Override
    public Optional<WorkPart> getWorkPartById(UUID id) {
        return workPartRepository.getWorkPartById(id);
    }

    @Override
    public void deleteWorkPart(UUID id) {
        workPartRepository.deleteWorkPart(id);
    }

    @Override
    public void updateWorkPartById(UUID id, WorkPart newWorkPart) {
        workPartRepository.updateWorkPartById(id, newWorkPart);
    }

    @Override
    public void addNewWorkPart(WorkPart workPart) {
        workPartRepository.addNewWorkPart(workPart);
    }

    @Override
    public List<WorkPart> getAllWorkPart() {
        return workPartRepository.getAllWorkPart();
    }

    @Override
    public void addAllFromWorkPartList(List<WorkPart> workPartList) {
        workPartRepository.addAllFromWorkPartList(workPartList);
    }

    @Override
    public List<String[]> getAllWorkPartsByWorkId(UUID workId) {
        return workPartRepository.getAllWorkPartByWorkId(workId);
    }
}
