package com.order.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

	private Long id;

	private ProductCategory category;

	private String name;

	private String description;

	private BigDecimal unitPrice;

	private String imageUrl;

	private boolean active;

	private int unitsInStock;

	private Date dateCreated;

	private Date lastUpdated;
}

