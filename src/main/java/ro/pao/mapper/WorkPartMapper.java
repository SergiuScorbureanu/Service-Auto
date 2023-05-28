package ro.pao.mapper;

import ro.pao.model.WorkPart;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class WorkPartMapper {

    private static final WorkPartMapper INSTANCE = new WorkPartMapper();

    private WorkPartMapper() {
    }

    public static WorkPartMapper getInstance() {
        return INSTANCE;
    }

    public static Optional<WorkPart> mapToWorkPart(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return Optional.of(
                    WorkPart.builder()
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

    public static List<WorkPart> mapToWorkPartList(ResultSet resultSet) throws SQLException {
        List<WorkPart> workPartList = new ArrayList<>();
        while (resultSet.next()) {
            workPartList.add(
                    WorkPart.builder()
                            .id(UUID.fromString(resultSet.getString(1)))
                            .code(resultSet.getString(2))
                            .name(resultSet.getString(3))
                            .price(resultSet.getDouble(4))
                            .workId(UUID.fromString(resultSet.getString(5)))
                            .build()
            );
        }

        return workPartList;
    }
}
