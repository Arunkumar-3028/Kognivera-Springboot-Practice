package com.school.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.school.dto.Student;

public interface StudentRepository extends MongoRepository<Student, Integer> {

	@Query(value = "{'std':?0}", fields = "{'age':0}")
	public List<Student> findbystd(int std);
	
}
