package com.customer.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.beans.Customer;
import com.customer.service.CustomerService;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@PostMapping
	public String createcustomer(@RequestBody Customer customer) {
		customerService.save(customer);
		return "customer created";
	}

	@GetMapping("/allrecords")
	public List<Customer> getall() {
		List<Customer> customers = customerService.fetchall();
		return customers;
	}

	@GetMapping("/{cus_id}")
	public Optional<Customer> getbyid(@PathVariable("cus_id") Integer cus_id) {
		Optional<Customer> customer = customerService.findbyid(cus_id);
		return customer;
	}

	@DeleteMapping("/{cus_id}")
	public String deletebyid(@PathVariable("cus_id") Integer cus_id) {
		customerService.deletebyid(cus_id);
		return "Customer deleted";
	}

	@GetMapping("/address/{cus_address}")
	public List<Customer> findbyaddress(@PathVariable("cus_address") String cus_address) {
		List<Customer> customers = customerService.findbyaddress(cus_address);
		return customers;
	}

	@GetMapping("/email/{email}")
	public Optional<Customer> getbyid(@PathVariable("email") String email) {
		Optional<Customer> customer = customerService.findbyemail(email);
		return customer;
	}

	@GetMapping("/name/{cus_name}")
	public List<Customer> findbyname(@PathVariable("cus_name") String cus_name) {
		List<Customer> customers = customerService.findbyname(cus_name);
		return customers;
	}

}
