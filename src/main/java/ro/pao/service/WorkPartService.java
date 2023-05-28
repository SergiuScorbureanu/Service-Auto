package ro.pao.service;

import ro.pao.model.WorkPart;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface WorkPartService {

    Optional<WorkPart> getWorkPartById(UUID id);

    void deleteWorkPart(UUID id);

    void updateWorkPartById(UUID id, WorkPart newWorkPart);

    void addNewWorkPart(WorkPart workPart);

    List<WorkPart> getAllWorkPart();

    void addAllFromWorkPartList(List<WorkPart> workPartList);

    List<String[]> getAllWorkPartsByWorkId(UUID workId);
}
