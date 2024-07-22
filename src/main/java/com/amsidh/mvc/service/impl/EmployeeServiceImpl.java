package com.amsidh.mvc.service.impl;

import com.amsidh.mvc.repository.EmployeeRepository;
import com.amsidh.mvc.repository.entity.Employee;
import com.amsidh.mvc.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(Employee employee) {
        log.info("Saving employee with employee details {}", employee);
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(String id) {
        log.info("Fetching employee with employee id {}", id);
        return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("Employee with id %snot found", id)));
    }

    @Override
    public Employee updateEmployee(String id, Employee employee) {
        log.info("Checking employee is exists with id {}", id);
        if (employeeRepository.existsById(id)) {
            employee.setId(id);
            final Employee savedEmployee = employeeRepository.save(employee);
            log.info("Employee updated {}", savedEmployee);
            return savedEmployee;
        } else {
            log.info("Employee with employee id {} not found", id);
            return null;
        }

    }

    @Override
    public Iterable<Employee> getAllEmployees() {
        log.info("Fetching all the employees");
        return employeeRepository.findAll();
    }

    @Override
    public void deleteEmployee(String id) {
        log.info("Delete employee with employee id {}", id);
        employeeRepository.deleteById(id);
    }
}
