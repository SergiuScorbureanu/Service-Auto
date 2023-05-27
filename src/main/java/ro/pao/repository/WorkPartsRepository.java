package ro.pao.repository;

import ro.pao.model.WorkParts;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface WorkPartsRepository {

    Optional<WorkParts> getWorkPartsById(UUID id);

    void deleteWorkParts(UUID id);

    void updateWorkPartsById(UUID id, WorkParts newWorkParts);

    void addNewWorkParts(WorkParts WorkParts);

    List<WorkParts> getAllWorkParts();

    void addAllFromWorkPartsList(List<WorkParts> WorkPartsList);
}
