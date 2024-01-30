package com.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.product.entity.ProductCategory;
import com.product.service.ProductCategoryService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/products-category")
public class ProductCategoryController {

	@Autowired
	private ProductCategoryService service;

	@GetMapping
	public ResponseEntity<List<ProductCategory>> getProductCategories() {
		return new ResponseEntity<>(service.getProductCategories(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<ProductCategory> addCategory(@Valid @RequestBody ProductCategory category){
		System.out.println(category.getCategoryName());
		return new ResponseEntity<>(service.addProductCategory(category),HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public String deleteCategory(@PathVariable Long id){
		service.deleteCategory(id);
		return "Category with Id: " + id + "deleted successfully";
	}

}
