package com.amsidh.mvc.controller;


import com.amsidh.mvc.repository.entity.Employee;
import com.amsidh.mvc.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/employees")
@Slf4j
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        log.info("Inside createEmployee method of EmployeeController class");
        final Employee savedEmployee = employeeService.saveEmployee(employee);
        log.info("Ending createEmployee method of EmployeeController class");
        return savedEmployee;
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        log.info("Inside getEmployeeById method of EmployeeController class");
        final Employee employee = employeeService.getEmployeeById(id);
        log.info("Ending getEmployeeById method of EmployeeController class");
        return employee;
    }

    @GetMapping
    public Iterable<Employee> getAllEmployees() {
        log.info("Inside getAllEmployees method of EmployeeController class");
        final Iterable<Employee> employees = employeeService.getAllEmployees();
        log.info("Ending getAllEmployees method of EmployeeController class");
        return employees;
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        return employeeService.updateEmployee(id, employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }
}

