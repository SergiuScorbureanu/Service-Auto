package ro.pao.threads;

import lombok.AllArgsConstructor;
import ro.pao.model.Work;
import ro.pao.repository.implementations.WorkPartRepositoryImpl;
import ro.pao.service.implementations.BillServiceImpl;
import ro.pao.service.implementations.WorkPartServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

@AllArgsConstructor
public class ExecuteWorkWorker implements Runnable{

    private Work work;
    private static final Logger logger = Logger.getGlobal();
    private static final BillServiceImpl billService = new BillServiceImpl();
    private static final WorkPartServiceImpl workPartService = new WorkPartServiceImpl(new WorkPartRepositoryImpl());

    @Override
    public void run() {
        try {
            while (work.getDuration() > 0) {
                Thread.sleep(5000);
                work.decreaseTime();
            };
            logger.log(Level.INFO, work.getName() + " finalizat");
            List<String[]> bill = new ArrayList<>();
            String[] workCosts = extractWorkCosts();
            bill.add(workCosts);
            List<String[]> workParts = workPartService.getAllWorkPartsByWorkId(work.getId());
            if (Objects.nonNull(workParts)) {
                bill.addAll(workParts);
            }
            billService.writeCSVBill(bill);
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
    }

    private String[] extractWorkCosts() {
        String[] workCosts = new String[2];
        workCosts[0] = work.getName();
        workCosts[1] = work.getPrice().toString();
        return workCosts;
    }
}
