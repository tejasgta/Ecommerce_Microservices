package com.product.entity;

import java.math.BigDecimal;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PRODUCT_TBL")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "category_fk", nullable = false)
	private ProductCategory category;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "unit_price")
	private BigDecimal unitPrice;

	@Column(name = "image_url")
	private String imageUrl;

	@Column(name = "active")
	private boolean active;

	@Column(name = "units_in_stock")
	private int unitsInStock;

	@Column(name = "date_created")
	@CreationTimestamp
	private Date dateCreated;

	@Column(name = "last_updated")
	@UpdateTimestamp
	private Date lastUpdated;

	@Override
	public String toString() {
		return "Product [id=" + id + ", category=" + category + ", name=" + name + ", description="
				+ description + ", unitPrice=" + unitPrice + ", imageUrl=" + imageUrl + ", active=" + active
				+ ", unitsInStock=" + unitsInStock + ", dateCreated=" + dateCreated + ", lastUpdated=" + lastUpdated
				+ "]";
	}

}

