//package com.product.controller;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import com.product.entity.ProductCategory;
//import com.product.service.ProductCategoryService;
//import jakarta.validation.Valid;
//
//@RestController
//@RequestMapping("/products-category")
//public class ProductCategoryController {
//
//	@Autowired
//	private ProductCategoryService categoryService;
//
//	@GetMapping
//	public ResponseEntity<List<ProductCategory>> getProductCategories() {
//		return new ResponseEntity<>(categoryService.getProductCategories(), HttpStatus.OK);
//	}
//
//	@GetMapping("/{id}")
//	public ResponseEntity getProductCategoryById(@PathVariable Long id) {
//		Optional<ProductCategory> productCategory = categoryService.getProductCategoryById(id);
//		if (productCategory.isPresent()) {
//			return new ResponseEntity<ProductCategory>(productCategory.get(), HttpStatus.OK);
//		} else {
//			return new ResponseEntity<String>("Product Category with Id: "+ id+ " not found!",HttpStatus.NOT_FOUND);
//		}
//	}
//
//	@PostMapping
//	public ResponseEntity<ProductCategory> addProductCategory(@Valid @RequestBody ProductCategory category){
//		return new ResponseEntity<>(categoryService.addProductCategory(category),HttpStatus.CREATED);
//	}
//
//	@DeleteMapping("/{id}")
//	public String deleteCategory(@PathVariable Long id){
//		Optional<ProductCategory> productCategory = categoryService.getProductCategoryById(id);
//		if(productCategory.isEmpty()){
//			return "Product Category with Id: " + id + " not found";
//		}
//		else{
//			categoryService.deleteCategory(id);
//			return "Product Category with Id: " + id + " deleted successfully";
//		}
//	}
//
//}
