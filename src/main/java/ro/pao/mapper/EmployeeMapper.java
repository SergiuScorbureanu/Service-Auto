package ro.pao.mapper;

import ro.pao.model.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class EmployeeMapper {

    private static final EmployeeMapper INSTANCE = new EmployeeMapper();

    private EmployeeMapper() {
    }

    public static EmployeeMapper getInstance() {
        return INSTANCE;
    }

    public Optional<Employee> mapToEmployee(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return Optional.of(
                    Employee.builder()
                            .id(UUID.fromString(resultSet.getString(1)))
                            .lastName(resultSet.getString(2))
                            .firstName(resultSet.getString(3))
                            .phone(resultSet.getString(4))
                            .email(resultSet.getString(5))
                            .position(resultSet.getString(6))
                            .salary(resultSet.getDouble(7))
                            .sectorId(UUID.fromString(resultSet.getString(8)))
                            .build()
            );
        } else {
            return Optional.empty();
        }
    }

    public List<Employee> mapToEmployeesList(ResultSet resultSet) throws SQLException {
        List<Employee> EmployeesList = new ArrayList<>();
        while (resultSet.next()) {
            EmployeesList.add(
                    Employee.builder()
                            .id(UUID.fromString(resultSet.getString(1)))
                            .lastName(resultSet.getString(2))
                            .firstName(resultSet.getString(3))
                            .phone(resultSet.getString(4))
                            .email(resultSet.getString(5))
                            .position(resultSet.getString(6))
                            .salary(resultSet.getDouble(7))
                            .sectorId(UUID.fromString(resultSet.getString(8)))
                            .build()
            );
        }

        return EmployeesList;
    }

}
