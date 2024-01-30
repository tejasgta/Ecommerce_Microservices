package com.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.product.entity.Product;
import com.product.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repo;

	public List<Product> getProducts(){
		return repo.findAll();
	}

	public Product addProduct(Product product) {
		return repo.save(product);
	}
}
