package ro.pao.service;

import ro.pao.model.Work;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface WorkService {

    void createWork(Work work);

    Optional<Work> getWorkById();

    List<Work> getAllWorks();

    void deleteWorkById(UUID id);

    void updateWorkById(UUID id, Work newWork);
}
