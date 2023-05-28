package ro.pao.service.implementations;

import ro.pao.model.Work;
import ro.pao.repository.implementations.WorkRepositoryImpl;
import ro.pao.service.ThreadingService;
import ro.pao.service.WorkService;
import ro.pao.threads.ExecuteWorkWorker;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadingServiceImpl implements ThreadingService {

    private final WorkService workService = new WorkServiceImpl(new WorkRepositoryImpl());

    // Define number of maximum threads that can be used
    private static final int MAX_THREADS = 10;

    @Override
    public void executeWork() {

        ExecutorService executorService = Executors.newFixedThreadPool(MAX_THREADS);

        List<Work> works = workService.getAllWorks().stream().filter(work -> work.getDuration() > 0).toList();
        // Thread-safe ArrayList to store results
        for (int i = 0; i < (long) works.size(); i++) {
            Work work = works.get(i);
            Runnable worker = new ExecuteWorkWorker(work);
            executorService.execute(worker);
        }
        // Shut down the executor service
        executorService.shutdown();
    }
}
