package com.product.entity;

import java.util.Set;

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
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "product_fk",referencedColumnName = "id")
	private Set<Product> products;

	@Override
	public String toString() {
		return "ProductCategory [id=" + id + ", categoryName=" + categoryName + ", products=" + products + "]";
	}
}
