package ro.pao.service.impl;

import ro.pao.model.Bill;
import ro.pao.service.BillService;

import java.util.Optional;
import java.util.UUID;

public class BillServiceImpl implements BillService {


    @Override
    public Optional<Bill> getById(UUID id) {
        return Optional.empty();
    }
}
