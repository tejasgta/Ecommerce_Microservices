package com.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.entity.ProductCategory;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "productCategory",path = "product-category")
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {

}
