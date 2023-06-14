package ro.pao.service.implementations;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ro.pao.model.Employee;
import ro.pao.repository.implementations.EmployeeRepositoryImpl;
import ro.pao.service.EmployeeService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Getter
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepositoryImpl employeeRepository;

    @Override
    public void addEmployee(Employee employee) {
        employeeRepository.addNewEmployee(employee);
    }

    @Override
    public void addAllFromEmployeesList(List<Employee> employeeList) {
        employeeRepository.addAllFromEmployeesList(employeeList);
    }

    @Override
    public Optional<Employee> getEmployeeById(UUID id) {
        return employeeRepository.getEmployeeById(id);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.getAllEmployees();
    }

    @Override
    public void deleteEmployeeById(UUID id) {
        employeeRepository.deleteEmployeeById(id);
    }

    @Override
    public void updateEmployeeById(UUID id, Employee newEmployee) {
        employeeRepository.updateEmployeeById(id, newEmployee);
    }

    @Override
    public UUID getEmployeeIdByName(String firstName, String lastName) {
        return employeeRepository.getEmployeeIdByName(firstName, lastName);
    }

}
