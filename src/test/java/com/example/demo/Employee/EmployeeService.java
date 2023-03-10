package com.example.demo.Employee;

import jakarta.transaction.Transactional;
import org.assertj.core.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    public void addNewEmployee(Employee employee) {
        Optional<Employee> employeeOptional = employeeRepository
                .findEmployeeByLastName(employee.getLastName());
        if (employeeOptional.isPresent()){
            throw new IllegalStateException("Lastname already present");
        }
        employeeRepository.save(employee);
    }

    public void deleteEmployee(Long employeeId) {
        boolean exist = employeeRepository.existsById(employeeId);
        if (!exist){
            throw new IllegalStateException("Employee with id" + employeeId + "does not exists ");
        }
        employeeRepository.deleteById(employeeId);
    }

    @Transactional
    public void updateEmployee(Long employeeId,
                               String firstName,
                               String lastName) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new IllegalStateException(
                        "Employee with id" + employeeId + "Does not exist");

        if (firstName != null &&
                firstName.length() > 0 &&
                !Objects.equals(employee.getFirstName(), firstName)){
            employee.setFirstName(firstName);
        }
        if (lastName != null &&
        lastName.length() > 0 &&
        !Objects.equals(employee.getLastName(), lastName)){
            Optional<Employee> employeeOptional = employeeRepository.
                    findEmployeeByLastName(lastName);
            if (employeeOptional.isPresent()){
                throw new IllegalStateException("Last Name Exist");
            }
            employee.setLastName((lastName));
        }
    }
}
