package ro.pao.service.impl;

import lombok.Getter;
import lombok.NoArgsConstructor;
import ro.pao.model.Work;
import ro.pao.service.WorkService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@NoArgsConstructor
@Getter
public class WorkServiceImpl implements WorkService {

    private static List<Work> worksList = new ArrayList<>();

    @Override
    public void createWork(Work work) {

    }

    @Override
    public Optional<Work> getWorkById() {
        return Optional.empty();
    }

    @Override
    public List<Work> getAllWorks() {
        return null;
    }

    @Override
    public void deleteWorkById(UUID id) {

    }

    @Override
    public void updateWorkById(UUID id, Work newWork) {

    }
}
