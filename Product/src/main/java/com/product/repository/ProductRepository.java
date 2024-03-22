package com.product.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.product.beans.Product;

public interface ProductRepository extends MongoRepository<Product, Long> {

	@Query("{'name':?0}")
	public List<Product> findbyname(String name);
}
