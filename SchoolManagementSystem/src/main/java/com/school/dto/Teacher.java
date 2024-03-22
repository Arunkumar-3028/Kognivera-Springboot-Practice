package com.school.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Document(collection = "Teacher")
@Getter
@Setter
public class Teacher {
	@Id
	private int id;
	private String name;
	private String subject;
	private int experience;
	private String email;

}
