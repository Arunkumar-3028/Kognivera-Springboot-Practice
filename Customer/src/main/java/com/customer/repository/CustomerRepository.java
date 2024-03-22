package com.customer.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.customer.beans.Customer;

public interface CustomerRepository extends MongoRepository<Customer, Integer> {
	@Query("{'cus_address' : ?0}")
	List<Customer> findByAddresss(String cus_address);

	@Query("{'email' : ?0}")
	Optional<Customer> findByEmail(String email);

	@Query("{'cus_name' : ?0}")
	List<Customer> findByname(String cus_name);
}
