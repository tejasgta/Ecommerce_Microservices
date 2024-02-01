package com.product.entity;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "PRODUCT_CATEGORY_TBL")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductCategory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "category_name")
	@NotNull
	private String categoryName;

	@JsonIgnore
	@OneToMany(mappedBy = "category")
	private Set<Product> productSet;

	public void addProduct(Product product) {
		if(product != null){
			if(productSet == null){
				productSet = new HashSet<>();
			}
			productSet.add(product);
			product.setCategory(this);
		}
	}
}
