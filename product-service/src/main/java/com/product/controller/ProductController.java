package com.product.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.product.entity.Product;
import com.product.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping
	public ResponseEntity<List<Product>> getProducts(){
		return new ResponseEntity<List<Product>>(productService.getProducts(),HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity getProductById(@PathVariable Long id){
		Optional<Product> productById = productService.getProductById(id);
		if(productById.isPresent()){
			return new ResponseEntity<Product>(productById.get(),HttpStatus.OK);
		}else {
            return new ResponseEntity<String>("Product with Id: " + id + " not found",HttpStatus.NOT_FOUND);
        }
	}
	
	@PostMapping
	public ResponseEntity<Product> addProduct(@RequestBody Product product){
		return new ResponseEntity<Product>(productService.addProduct(product),HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public String deleteProduct(@PathVariable Long id){
		if(productService.getProductById(id).isEmpty()){
			return "Product with Id: " + id + " not found";
		}
		else {
            productService.deleteProduct(id);
			return "Product with Id: " + id + " deleted successfully";
        }
	}

	@PutMapping("/{productId}/category/{categoryId}")
	public ResponseEntity addProductToCategory(@PathVariable Long productId, @PathVariable Long categoryId){
		if(productService.addProductToCategory(productId, categoryId)){
			return new ResponseEntity<>("Product with Id: " + productId + " added to category with Id: " + categoryId,HttpStatus.OK);
		}
		else{
			return new ResponseEntity<>("Product with Id: " + productId + " or category with Id: " + categoryId + " not found!",HttpStatus.NOT_FOUND);
		}
	}
}
