package com.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.beans.Product;
import com.product.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;

	public void saveproduct(Product product) {
		productRepository.save(product);
	}

	public List<Product> getallproducts() {
		return productRepository.findAll();
	}

	public Product findbyid(Long id) {
		return productRepository.findById(id).orElse(null);
	}

	public List<Product> findbyname(String name) {
		return productRepository.findbyname(name);
	}

	public void deletebyid(Long id) {
		productRepository.deleteById(id);
	}

	public String update(Long id, Product product) {
		Product p = productRepository.findById(id).get();
		if (p != null) {
			productRepository.save(product);
			return "product updated";
		} else {
			return "product not found";
		}
	}

}
