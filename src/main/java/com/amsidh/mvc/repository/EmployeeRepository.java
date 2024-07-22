package com.amsidh.mvc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.amsidh.mvc.repository.entity.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, String> {
}