package com.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.entity.ProductCategory;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {

}
