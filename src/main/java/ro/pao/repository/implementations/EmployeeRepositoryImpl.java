package ro.pao.repository.implementations;

import ro.pao.configuration.DatabaseConfiguration;
import ro.pao.mapper.EmployeeMapper;
import ro.pao.model.Employee;
import ro.pao.repository.EmployeeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


public class EmployeeRepositoryImpl implements EmployeeRepository {

    private static final EmployeeMapper employeeMapper = EmployeeMapper.getInstance();

    @Override
    public Optional<Employee> getEmployeeById(UUID id) {
        String selectSql = "SELECT * FROM Employee WHERE id=?";
        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            preparedStatement.setString(1, id.toString());

            ResultSet resultSet = preparedStatement.executeQuery();
            return employeeMapper.mapToEmployee(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public void deleteEmployeeById(UUID id) {
        String deleteNameSql = "DELETE FROM Employee WHERE id=?";
        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteNameSql)) {
            preparedStatement.setString(1, id.toString());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateEmployeeById(UUID id, Employee newEmployee) {
        String updateNameSql = "UPDATE Employee \n" +
                "SET firstName=?, \n" +
                "lastName=?, \n" +
                "phone=?, \n" +
                "email=?, \n" +
                "position=?, \n" +
                "salary=?, \n" +
                "sectorId=?, \n" +
                "WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql)) {
            preparedStatement.setString(1, newEmployee.getFirstName());
            preparedStatement.setString(2, newEmployee.getLastName());
            preparedStatement.setString(3, newEmployee.getPhone());
            preparedStatement.setString(4, newEmployee.getEmail());
            preparedStatement.setString(5, newEmployee.getPosition());
            preparedStatement.setDouble(6, newEmployee.getSalary());
            preparedStatement.setObject(6, newEmployee.getSectorId());
            preparedStatement.setObject(7, id.toString());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addNewEmployee(Employee employee) {
        String insertSql = "INSERT INTO Employee (id, firstName, lastName, phone, email, position, salary, sectorId) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertSql)) {
            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setString(3, employee.getPhone());
            preparedStatement.setString(4, employee.getEmail());
            preparedStatement.setString(5, employee.getPosition());
            preparedStatement.setDouble(6, employee.getSalary());
            preparedStatement.setString(6, employee.getSectorId().toString());
            preparedStatement.setString(7, employee.getId().toString());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Employee> getAllEmployees() {
        String selectSql = "SELECT * FROM Employee";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            return employeeMapper.mapToEmployeesList(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return List.of();
    }

    @Override
    public void addAllFromEmployeesList(List<Employee> employeeList) {
        employeeList.forEach(this::addNewEmployee);
    }

}
