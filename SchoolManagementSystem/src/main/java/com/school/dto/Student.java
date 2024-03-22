package com.school.dto;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Document
@Getter
@Setter
public class Student {
	private int id;
	private String name;
	private int age;
	private int std;
}
