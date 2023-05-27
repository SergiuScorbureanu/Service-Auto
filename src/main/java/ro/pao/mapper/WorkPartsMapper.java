package ro.pao.mapper;

import ro.pao.model.WorkParts;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class WorkPartsMapper {

    private static final WorkPartsMapper INSTANCE = new WorkPartsMapper();

    private WorkPartsMapper() {
    }

    public static WorkPartsMapper getInstance() {
        return INSTANCE;
    }

    public static Optional<WorkParts> mapToWorkParts(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return Optional.of(
                    WorkParts.builder()
                            .id(UUID.fromString(resultSet.getString(1)))
                            .code(resultSet.getString(2))
                            .name(resultSet.getString(3))
                            .price(resultSet.getDouble(4))
                            .workId(UUID.fromString(resultSet.getString(5)))
                            .build()
            );
        } else {
            return Optional.empty();
        }
    }

    public static List<WorkParts> mapToWorkPartsList(ResultSet resultSet) throws SQLException {
        List<WorkParts> WorkPartsList = new ArrayList<>();
        while (resultSet.next()) {
            WorkPartsList.add(
                    WorkParts.builder()
                            .id(UUID.fromString(resultSet.getString(1)))
                            .code(resultSet.getString(2))
                            .name(resultSet.getString(3))
                            .price(resultSet.getDouble(4))
                            .workId(UUID.fromString(resultSet.getString(5)))
                            .build()
            );
        }

        return WorkPartsList;
    }
}
