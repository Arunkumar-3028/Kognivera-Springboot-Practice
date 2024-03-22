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

import com.school.dto.Teacher;
import com.school.serviice.TeacherService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/teacher")
public class TeacherController {
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private SecurityContextLogoutHandler securityContextLogoutHandler;

	@GetMapping("/findall")
	public List<Teacher> getallTeachers() {
		return teacherService.findall();
	}

	@GetMapping("/findbystd")
	public List<Teacher> findbysubject(@PathVariable String subject) {
		return teacherService.findbysubject(subject);
	}

	@GetMapping("/findbyid/{id}")
	public ResponseEntity<Teacher> findbyid(@PathVariable int id) {
		Optional<Teacher> Teacher = Optional.ofNullable(teacherService.findbyid(id));
		return Teacher.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PostMapping
	public String saveTeacher(@RequestBody Teacher Teacher) {
		teacherService.saveteacher(Teacher);
		return "Teacher saved";
	}

//	@PostMapping
//	public ResponseEntity<Teacher> saveTeachert(@RequestBody Teacher Teacher) {
//		TeacherService.saveTeacher(Teacher);
//		return new ResponseEntity<Teacher>(HttpStatus.CREATED);
//	}
	@PutMapping("/{id}")
	public ResponseEntity<Teacher> updateTeacher(@PathVariable int id, @RequestBody Teacher updatedTeacher) {
		Optional<Teacher> existingTeacher = Optional.ofNullable(teacherService.findbyid(id));
		if (existingTeacher.isPresent()) {
			Teacher Teachertoupdate = existingTeacher.get();
			Teachertoupdate.setName(updatedTeacher.getName());
			Teachertoupdate.setSubject(updatedTeacher.getSubject());
			Teachertoupdate.setExperience(updatedTeacher.getExperience());
			Teachertoupdate.setEmail(updatedTeacher.getEmail());
			Teacher savedTeacher = teacherService.saveteacher(Teachertoupdate);
			return ResponseEntity.ok(savedTeacher);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Teacher> deleteTeacher(@PathVariable int id) {
		if (teacherService.findbyid(id) != null) {
			teacherService.deletebyid(id);
			return ResponseEntity.noContent().build();
		} else {
			return new ResponseEntity<Teacher>(HttpStatus.BAD_REQUEST);
		}
	}
//	@GetMapping("/teacherProfile/logout")
//	public String logout(HttpServletRequest request, HttpServletResponse response) {
//		securityContextLogoutHandler.logout(request, response, null);
//		return "Successfully logged out";
//	}
}
