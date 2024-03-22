package com.school.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.dto.Student;
import com.school.serviice.StudentService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	@Autowired
	private SecurityContextLogoutHandler securityContextLogoutHandler;

	@GetMapping("/findall")
	public List<Student> getallstudents() {
		return studentService.findall();
	}

	@GetMapping("/findbystd/{std}")
	public List<Student> findbystd(@PathVariable("std") int std) {
		return studentService.findbystd(std);
	}

	@GetMapping("/findbyid/{id}")
	public ResponseEntity<Student> findbyid(@PathVariable("id") int id) {
		Optional<Student> student = studentService.findbyid(id);
		return student.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PostMapping
	public String savestudent(@RequestBody Student student) {
		studentService.saveStudent(student);
		return "student saved";
	}

//	@PostMapping
//	public ResponseEntity<Student> savestudentt(@RequestBody Student student) {
//		studentService.saveStudent(student);
//		return new ResponseEntity<Student>(HttpStatus.CREATED);
//	}
	@PutMapping("/{id}")
	public ResponseEntity<Student> updatestudent(@PathVariable("id") int id, @RequestBody Student updatedstudent) {
		Optional<Student> existingstudent = studentService.findbyid(id);
		if (existingstudent.isPresent()) {
			Student studenttoupdate = existingstudent.get();
			studenttoupdate.setName(updatedstudent.getName());
			studenttoupdate.setStd(updatedstudent.getStd());
			studenttoupdate.setAge(updatedstudent.getAge());
			Student savedstudent = studentService.saveStudent(studenttoupdate);
			return ResponseEntity.ok(savedstudent);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
		@DeleteMapping("/{id}")
		public ResponseEntity<Student> deletestudent( @PathVariable("id") int id) {
			if (studentService.findbyid(id) != null) {
				studentService.deletebyid(id);
				return ResponseEntity.noContent().build();
			} else {
				return new ResponseEntity<Student>(HttpStatus.BAD_REQUEST);
			}
		}
//		@GetMapping("/studentProfile/logout")
//		public String logout(HttpServletRequest request, HttpServletResponse response) {
//			securityContextLogoutHandler.logout(request, response, null);
//			return "Successfully logged out";
//		}
	}


