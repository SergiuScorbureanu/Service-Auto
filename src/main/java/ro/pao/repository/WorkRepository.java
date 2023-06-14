package ro.pao.repository;

import ro.pao.model.Work;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface WorkRepository {

    Optional<Work> getWorkById(UUID id);

    void deleteWork(UUID id);

    void updateWorksById(UUID id, Work newWork);

    void addNewWork(Work Work);

    List<Work> getAllWorks();

    void addAllFromWorksList(List<Work> WorkList);
}
