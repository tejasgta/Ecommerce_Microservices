package com.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.entity.ProductCategory;
import com.product.service.ProductCategoryService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/products-category")
public class ProductCategoryController {

	@Autowired
	private ProductCategoryService service;

	@GetMapping
	public ResponseEntity<List<ProductCategory>> getProductCategories() {
		return new ResponseEntity<List<ProductCategory>>(service.getProductCategories(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<ProductCategory> addCategory(@Valid @RequestBody ProductCategory category){
		System.out.println();
		return new ResponseEntity<ProductCategory>(service.addProductCategory(category),HttpStatus.CREATED);
	}

}
