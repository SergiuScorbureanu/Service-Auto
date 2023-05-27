package ro.pao.mapper;

import ro.pao.model.Bill;
import ro.pao.model.Part;
import ro.pao.model.Work;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class BillMapper {

    private static final BillMapper INSTANCE = new BillMapper();

    private BillMapper() {
    }

    public static BillMapper getInstance() {
        return INSTANCE;
    }

    public Optional<Bill> mapToBill(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return Optional.of(
                    Bill.builder()
                            .id(UUID.fromString(resultSet.getString(1)))
                            .worksList((ArrayList<Work>) resultSet.getObject(2))
                            .partsList((ArrayList<Part>) resultSet.getObject(3))
                            .totalPrice(resultSet.getDouble(4))
                            .build()
            );
        } else {
            return Optional.empty();
        }
    }

    public List<Bill> mapToBillsList(ResultSet resultSet) throws SQLException {
        List<Bill> BillsList = new ArrayList<>();
        while (resultSet.next()) {
            BillsList.add(
                    Bill.builder()
                            .id(UUID.fromString(resultSet.getString(1)))
                            .worksList((ArrayList<Work>) resultSet.getObject(2))
                            .partsList((ArrayList<Part>) resultSet.getObject(3))
                            .totalPrice(resultSet.getDouble(4))
                            .build()
            );
        }

        return BillsList;
    }
}
