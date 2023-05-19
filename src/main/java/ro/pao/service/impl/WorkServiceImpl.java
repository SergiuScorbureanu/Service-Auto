package ro.pao.service.impl;

import lombok.Getter;
import lombok.NoArgsConstructor;
import ro.pao.model.Employee;
import ro.pao.model.Work;
import ro.pao.service.WorkService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter
public class WorkServiceImpl implements WorkService {

    private static List<Work> worksList = new ArrayList<>();

    @Override
    public void addWork(Work work) {
        worksList.add(work);
    }

    @Override
    public void addAllWorksFromList(List<Work> workList) {
        worksList.addAll(workList);
    }

    @Override
    public Optional<Work> getWorkById(UUID id) {
        return worksList.stream()
                .filter(work -> id.equals(work.getId()))
                .findFirst();
    }

    @Override
    public List<Work> getAllWorks() {
        return worksList;
    }

    @Override
    public void deleteWorkById(UUID id) {
        worksList = worksList.stream()
                .filter(object -> !id.equals(object.getId()))
                .collect(Collectors.toList());
    }

    @Override
    public void updateWorkById(UUID id, Work newWork) {
        Optional<Work> employee = this.getWorkById(id);
        if(employee.isPresent()) {
            deleteWorkById(id);
            newWork.setId(id);
            addWork(newWork);
        }
    }
}
