package ro.pao.repository;

import ro.pao.model.Employee;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EmployeeRepository {

    void addNewEmployee(Employee employee);

    void addAllFromEmployeesList(List<Employee> employeeList);

    Optional<Employee> getEmployeeById(UUID id);

    List<Employee> getAllEmployees();

    void deleteEmployeeById(UUID id);

    UUID getEmployeeIdByName(String firstName, String lastName);

    void updateEmployeeById(UUID id, Employee newEmployee);
}
