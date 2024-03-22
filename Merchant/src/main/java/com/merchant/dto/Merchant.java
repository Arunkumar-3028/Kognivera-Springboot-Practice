package com.merchant.dto;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "merchant")
public class Merchant {
	private int id;
	private String name;
	private String address;
	private long phone;
}
