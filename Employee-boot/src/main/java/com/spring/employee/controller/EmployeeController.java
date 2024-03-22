package com.spring.employee.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.employee.beans.Employee;
import com.spring.employee.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	@Autowired
	private EmployeeRepository employeeRepository;

	@GetMapping
	public List<Employee> getallemployee() {
		return employeeRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Employee> getemployeebyid(@PathVariable Integer id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		return employee.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PostMapping("/{id}")
	public ResponseEntity<Employee> createemployee(@RequestBody Employee employee) {
		Employee savEmployee = employeeRepository.save(employee);
//		return ResponseEntity.ok(savEmployee);
		return new ResponseEntity<Employee>(HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Employee> updateemployee(@PathVariable Integer id, @RequestBody Employee updatedemployee) {
		Optional<Employee> existingemployee = employeeRepository.findById(id);
		if (existingemployee.isPresent()) {
			Employee employeetoupdate = existingemployee.get();
			employeetoupdate.setName(updatedemployee.getName());
			employeetoupdate.setSalary(updatedemployee.getSalary());
			Employee savedEmployee = employeeRepository.save(employeetoupdate);
			return ResponseEntity.ok(savedEmployee);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Employee> deleteemployee(@PathVariable Integer id) {
		if (employeeRepository.existsById(id)) {
			employeeRepository.deleteById(id);
			return ResponseEntity.noContent().build();
		} else {
			return new ResponseEntity<Employee>(HttpStatus.BAD_REQUEST);
		}
	}

}
