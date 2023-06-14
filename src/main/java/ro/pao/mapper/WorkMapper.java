package ro.pao.mapper;

import ro.pao.model.Part;
import ro.pao.model.Work;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class WorkMapper {

    private static final WorkMapper INSTANCE = new WorkMapper();

    private WorkMapper() {
    }

    public static WorkMapper getInstance() {
        return INSTANCE;
    }

    public static Optional<Work> mapToWork(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return Optional.of(
                    Work.builder()
                            .id(UUID.fromString(resultSet.getString(1)))
                            .name(resultSet.getString(2))
                            .duration(resultSet.getInt(3))
                            .price(resultSet.getDouble(4))
                            .vehicleId(UUID.fromString(resultSet.getString(5)))
                            .build()
            );
        } else {
            return Optional.empty();
        }
    }

    public static List<Work> mapToWorksList(ResultSet resultSet) throws SQLException {
        List<Work> WorksList = new ArrayList<>();
        while (resultSet.next()) {
            WorksList.add(
                    Work.builder()
                            .id(UUID.fromString(resultSet.getString(1)))
                            .name(resultSet.getString(2))
                            .duration(resultSet.getInt(3))
                            .price(resultSet.getDouble(4))
                            .vehicleId(UUID.fromString(resultSet.getString(5)))
                            .build()
            );
        }

        return WorksList;
    }
}
