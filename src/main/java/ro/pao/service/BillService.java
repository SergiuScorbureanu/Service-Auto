package ro.pao.service;

import ro.pao.model.Bill;

import java.util.Optional;
import java.util.UUID;

public interface BillService {

    Optional<Bill> getById(UUID id);


}
