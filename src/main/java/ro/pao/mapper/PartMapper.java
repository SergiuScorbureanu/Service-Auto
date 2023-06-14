package ro.pao.mapper;


import ro.pao.model.Part;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class PartMapper {

    private static final PartMapper INSTANCE = new PartMapper();

    private PartMapper() {
    }

    public static PartMapper getInstance() {
        return INSTANCE;
    }

    public Optional<Part> mapToPart(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return Optional.of(
                    Part.builder()
                            .id(UUID.fromString(resultSet.getString(1)))
                            .code(resultSet.getString(2))
                            .name(resultSet.getString(3))
                            .price(resultSet.getDouble(4))
                            .build()
            );
        } else {
            return Optional.empty();
        }
    }

    public List<Part> mapToPartsList(ResultSet resultSet) throws SQLException {
        List<Part> PartsList = new ArrayList<>();
        while (resultSet.next()) {
            PartsList.add(
                    Part.builder()
                            .id(UUID.fromString(resultSet.getString(1)))
                            .code(resultSet.getString(2))
                            .name(resultSet.getString(3))
                            .price(resultSet.getDouble(4))
                            .build()
            );
        }

        return PartsList;
    }
}
