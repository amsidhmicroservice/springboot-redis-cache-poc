package com.amsidh.mvc.service;

import com.amsidh.mvc.repository.entity.Employee;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);

    Employee getEmployeeById(String id);

    Employee updateEmployee(@PathVariable String id, @RequestBody Employee employee);

    Iterable<Employee> getAllEmployees();

    void deleteEmployee(String id);
}