package ro.pao.service;

import ro.pao.model.Bill;
import ro.pao.model.Employee;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BillService {

    void writeCSVBill(List<String[]> bill);


}
