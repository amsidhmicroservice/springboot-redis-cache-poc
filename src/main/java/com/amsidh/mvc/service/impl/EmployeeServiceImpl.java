package com.amsidh.mvc.service.impl;

import com.amsidh.mvc.repository.EmployeeRepository;
import com.amsidh.mvc.repository.entity.Employee;
import com.amsidh.mvc.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @CachePut(cacheNames = "shortLivedCache", key = "#employee.id")
    //Updates the cache with the result of the method execution.
    //Useful for updating or creating new entries in the cache.
    @Override
    public Employee saveEmployee(Employee employee) {
        log.info("Saving employee with employee details {}", employee);
        return employeeRepository.save(employee);
    }

    @Cacheable(cacheNames  = "shortLivedCache", key = "#id")
    //Caches the result of the method.If the method is called with the same parameters,
    // the result is retrieved from the cache rather than executing the method.
    @Override
    public Employee getEmployeeById(Long id) {
        log.info("Fetching employee with employee id {}", id);
        return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("Employee with id %snot found", id)));
    }

    @CachePut(cacheNames = "shortLivedCache", key = "#id")
    @Override
    public Employee updateEmployee(Long id, Employee employee) {
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
    @Cacheable(cacheNames  = "longLivedCache", key = "#root.methodName")
    public Iterable<Employee> getAllEmployees() {
        log.info("Fetching all the employees");
        return employeeRepository.findAll();
    }

    @CacheEvict(cacheNames = "shortLivedCache", key = "#id")
    //Removes the cache entry. Useful for removing entries when they are updated or deleted.
    @Override
    public void deleteEmployee(Long id) {
        log.info("Delete employee with employee id {}", id);
        employeeRepository.deleteById(id);
    }
}
