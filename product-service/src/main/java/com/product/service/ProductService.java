package com.product.service;

import java.util.List;
import java.util.Optional;

import com.product.entity.ProductCategory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.entity.Product;
import com.product.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProductCategoryService categoryService;

	private static Logger logger = LoggerFactory.getLogger(ProductService.class);

	public List<Product> getProducts(){
		logger.info("Inside getProducts of ProductService");
		List<Product> list = productRepository.findAll();
		logger.info("Product List : "+list);
		return list;
	}

	public Product addProduct(Product product) {
		return productRepository.save(product);
	}

    public Optional<Product> getProductById(Long id) { return productRepository.findById(id); }

	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}

    public boolean addProductToCategory(Long productId, Long categoryId) {
		Optional<Product> product = productRepository.findById(productId);
		if(product.isPresent()){
			Optional<ProductCategory> productCategory = categoryService.getProductCategoryById(categoryId);
			if(productCategory.isPresent()){
				ProductCategory productCategory1 = productCategory.get();
				product.get().setCategory(productCategory1);
				productRepository.save(product.get());
//				productCategory1.addProduct(product.get());
//				categoryService.addProductCategory(productCategory1);
				return true;
			}
			else{
				return false;
			}
		}
		else{
			return false;
		}
    }
}
