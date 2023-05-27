package ro.pao.service.implementations;

import lombok.Getter;
import lombok.NoArgsConstructor;
import ro.pao.model.Bill;
import ro.pao.service.BillService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter
public class BillServiceImpl implements BillService {

    private static List<Bill> billsList = new ArrayList<>();

    @Override
    public void addBill(Bill bill) {
        billsList.add(bill);
    }

    @Override
    public void addAllBillsFromList(List<Bill> billList) {
        billsList.addAll(billList);
    }

    @Override
    public Optional<Bill> getBillById(UUID id) {
        return billsList.stream()
                .filter(bill -> id.equals(bill.getId()))
                .findFirst();
    }

    @Override
    public List<Bill> getAllBills() {
        return billsList;
    }

    @Override
    public void deleteBillById(UUID id) {
        billsList = billsList.stream()
                .filter(object -> !id.equals(object.getId()))
                .collect(Collectors.toList());
    }

    @Override
    public void updateBillById(UUID id, Bill newBill) {
        Optional<Bill> employee = this.getBillById(id);
        if(employee.isPresent()) {
            deleteBillById(id);
            newBill.setId(id);
            addBill(newBill);
        }
    }
}
