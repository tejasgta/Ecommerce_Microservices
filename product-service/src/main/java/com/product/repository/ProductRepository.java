package com.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.entity.Product;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "product",path = "products")
public interface ProductRepository extends JpaRepository<Product, Long> {

}
