package ro.pao.repository;

import ro.pao.model.WorkPart;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface WorkPartRepository {

    Optional<WorkPart> getWorkPartById(UUID id);

    void deleteWorkPart(UUID id);

    void updateWorkPartById(UUID id, WorkPart newWorkPart);

    void addNewWorkPart(WorkPart WorkPart);

    List<WorkPart> getAllWorkPart();

    void addAllFromWorkPartList(List<WorkPart> workPartList);

    List<String[]> getAllWorkPartByWorkId(UUID workId);
}
