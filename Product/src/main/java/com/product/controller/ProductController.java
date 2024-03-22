package com.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.beans.Product;
import com.product.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {
	@Autowired
	private ProductService productService;

	@PostMapping
	public String saveproduct(@RequestBody Product product) {
		productService.saveproduct(product);
		return "product saved";
	}

	@GetMapping("/getall")
	public List<Product> getallproducts() {
		return productService.getallproducts();
	}

	@GetMapping("/findbyid/{id}")
	public Product findbyid(@PathVariable("id") Long id) {
		return productService.findbyid(id);
	}

	@GetMapping("/findbyname/{name}")
	public List<Product> findbyname(@PathVariable("name") String name) {
		return productService.findbyname(name);
	}

	@DeleteMapping("deletebyid/{id}")
	public String deletebyid(@PathVariable("id") Long id) {
		productService.deletebyid(id);
		return "product deleted";
	}

	@PutMapping("updatebyid/{id}")
	public String updatebyid(@PathVariable("id") Long id, @RequestBody Product product) {
		return productService.update(id, product);
	}
}
