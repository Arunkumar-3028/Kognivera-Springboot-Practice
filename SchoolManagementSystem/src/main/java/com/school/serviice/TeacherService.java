package com.school.serviice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.dto.Teacher;
import com.school.repository.TeacherRepository;

@Service
public class TeacherService {
	@Autowired
	private TeacherRepository teacherRepository;

	public Teacher saveteacher(Teacher teacher) {
		return teacherRepository.save(teacher);
	}

	public Teacher findbyid(int id) {
		return teacherRepository.findById(id).orElse(null);
	}

	public String updateteacher(int id, Teacher teacher) {
		Teacher dbtTeacher = teacherRepository.findById(id).get();
		if (dbtTeacher != null) {
			teacherRepository.save(teacher);
			return "Teacher Saved";
		} else {
			return "Teacher Not Found";
		}
	}

	public List<Teacher> findall() {
		return teacherRepository.findAll();
	}

	public void deletebyid(int id) {
		teacherRepository.deleteById(id);
	}

	public List<Teacher> findbysubject(String subject) {
		return teacherRepository.findbysubject(subject);
	}
}
