package com.customer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//Service class for business logic

import com.customer.beans.Customer;
import com.customer.repository.CustomerRepository;

@Service

public class CustomerService {
	@Autowired
	CustomerRepository customerRepository;

	public void save(Customer customer) {
		customerRepository.save(customer);
	}

	public List<Customer> fetchall() {
		List<Customer> list = customerRepository.findAll();
		return list;
	}

	public Optional<Customer> findbyid(Integer cus_id) {
		Optional<Customer> customer = customerRepository.findById(cus_id);
		return customer;
	}

	public void deletebyid(Integer cus_id) {
		customerRepository.deleteById(cus_id);
	}

	public List<Customer> findbyaddress(String cus_address) {
		List<Customer> customers = customerRepository.findByAddresss(cus_address);
		return customers;
	}

	public Optional<Customer> findbyemail(String email) {
		Optional<Customer> customer = customerRepository.findByEmail(email);
		return customer;
	}

	public List<Customer> findbyname(String cus_name) {
		List<Customer> customers = customerRepository.findByname(cus_name);
		return customers;
	}

}
