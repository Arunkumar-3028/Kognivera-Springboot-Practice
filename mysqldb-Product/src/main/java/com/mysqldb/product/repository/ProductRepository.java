package com.mysqldb.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mysqldb.product.beans.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
