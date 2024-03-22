package com.spring.employee.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.spring.employee.beans.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, Integer>{

}
