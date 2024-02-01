package com.product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.entity.ProductCategory;
import com.product.repository.ProductCategoryRepository;

@Service
public class ProductCategoryService {

	@Autowired
	private ProductCategoryRepository categoryRepository;
	
	public List<ProductCategory> getProductCategories(){
		return categoryRepository.findAll();
	}

	public ProductCategory addProductCategory(ProductCategory category) {
		return categoryRepository.save(category);
	}


	public void deleteCategory(Long id) {
		categoryRepository.deleteById(id);
	}

	public Optional<ProductCategory> getProductCategoryById(Long id) {
		return categoryRepository.findById(id);
	}
	
}
