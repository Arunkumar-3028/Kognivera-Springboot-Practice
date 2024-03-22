package com.school.serviice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.dto.Student;
import com.school.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;

	public Student saveStudent(Student Student) {
		return studentRepository.save(Student);
	}

	public Optional<Student> findbyid(int id) {
		return Optional.ofNullable(studentRepository.findById(id).orElse(null));
	}

	public String updateStudent(int id, Student Student) {
		Student dbtStudent = studentRepository.findById(id).get();
		if (dbtStudent != null) {
			studentRepository.save(Student);
			return "Student Saved";
		} else {
			return "Student Not Found";
		}
	}

	public List<Student> findbystd(int std) {
		return studentRepository.findbystd(std);
	}

	public List<Student> findall() {
		return studentRepository.findAll();
	}

	public void deletebyid(int id) {
		studentRepository.deleteById(id);
	}

}
