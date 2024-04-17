package org.example.services;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.models.Employee;
import org.example.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        log.info("Getting all employees");
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        log.info("Getting employee by id: {}", id);
        return employeeRepository.findById(id).orElse(null);
    }

    public Employee saveEmployee(Employee employee) {
        log.info("Saving employee: {}", employee);
        return employeeRepository.save(employee);
    }
}
