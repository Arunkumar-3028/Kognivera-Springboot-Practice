package com.school.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.school.dto.Teacher;

public interface TeacherRepository extends MongoRepository<Teacher, Integer> {

	@Query(value = "{'subject':?0}", fields = "{'experience':0,'email':0}")
	public List<Teacher> findbysubject(String subject); 

}
