package ro.pao.service;

import ro.pao.model.Bill;
import ro.pao.model.Employee;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BillService {

    void addBill(Bill bill);

    void addAllBillsFromList(List<Bill> billList);

    Optional<Bill> getBillById(UUID id);

    List<Bill> getAllBills();

    void deleteBillById(UUID id);

    void updateBillById(UUID id, Bill newBill);


}
