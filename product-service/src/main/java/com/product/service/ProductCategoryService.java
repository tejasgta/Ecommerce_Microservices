package com.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.entity.ProductCategory;
import com.product.repository.ProductCategoryRepository;

@Service
public class ProductCategoryService {

	@Autowired
	private ProductCategoryRepository repo;
	
	public List<ProductCategory> getProductCategories(){
		return repo.findAll();
	}

	public ProductCategory addProductCategory(ProductCategory category) {
		return repo.save(category);
	}


	public void deleteCategory(Long id) {
		repo.deleteById(id);
	}
}
