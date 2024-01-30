package com.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.entity.Product;
import com.product.service.ProductService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService service;

	@GetMapping("/hello")
	public String hello() {
		return "Hello from Product Service";
	}
	
	@GetMapping
	public ResponseEntity<List<Product>> getProducts(){
		return new ResponseEntity<List<Product>>(service.getProducts(),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Product> addProduct(@RequestBody Product product){
		return new ResponseEntity<Product>(service.addProduct(product),HttpStatus.CREATED);
	}
}
