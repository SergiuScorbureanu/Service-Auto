package ro.pao.service.impl;

import lombok.Getter;
import lombok.NoArgsConstructor;
import ro.pao.model.Bill;
import ro.pao.service.BillService;

import java.util.Optional;
import java.util.UUID;

@NoArgsConstructor
@Getter
public class BillServiceImpl implements BillService {


    @Override
    public Optional<Bill> getById(UUID id) {
        return Optional.empty();
    }
}
