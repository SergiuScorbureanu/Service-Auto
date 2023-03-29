package ro.pao.service.impl;

import lombok.Getter;
import lombok.NoArgsConstructor;
import ro.pao.model.Employee;
import ro.pao.service.EmployeeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter
public class EmployeeServiceImpl implements EmployeeService {

    private static List<Employee> employeesList = new ArrayList<>();


    @Override
    public void addEmployee(Employee employee) {
        employeesList.add(employee);
    }

    @Override
    public void addAllEmployeesFromList(List<Employee> employeeList) {
        employeeList.addAll(employeeList);
    }

    @Override
    public Optional<Employee> getEmployeeById(UUID id) {
        return employeesList.stream()
                .filter(object -> id.equals(object.getId()))
                .findAny();
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeesList;
    }

    @Override
    public void deleteEmployeeById(UUID id) {
        employeesList = employeesList.stream()
                .filter((object -> !id.equals((object.getId()))))
                .collect((Collectors.toList()));
    }

    @Override
    public void updateEmployeeById(UUID id, Employee newEmployee) {
        deleteEmployeeById(id);
        addEmployee(newEmployee);

    }
}
