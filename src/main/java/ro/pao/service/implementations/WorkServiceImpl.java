package ro.pao.service.implementations;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import ro.pao.model.Work;
import ro.pao.repository.implementations.WorkRepositoryImpl;
import ro.pao.service.WorkService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Getter
public class WorkServiceImpl implements WorkService {

    private final WorkRepositoryImpl workRepository;

    @Override
    public void addWork(Work work) {
        workRepository.addNewWork(work);
    }

    @Override
    public void addAllWorksFromList(List<Work> workList) {
        workRepository.addAllFromWorksList(workList);
    }

    @Override
    public Optional<Work> getWorkById(UUID id) {
        return workRepository.getWorkById(id);
    }

    @Override
    public List<Work> getAllWorks() {
        return workRepository.getAllWorks();
    }

    @Override
    public void deleteWorkById(UUID id) {
        workRepository.deleteWork(id);
    }

    @Override
    public void updateWorkById(UUID id, Work newWork) {
        workRepository.updateWorksById(id, newWork);
    }
}
