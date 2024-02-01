package com.order.entity;

import java.math.BigDecimal;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ORDER_ITEM_TBL")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Item_Id")
	private Long id;
	
	@Column(name = "image_url")
	private String imageUrl;
	
	@Column(name = "unit_price")
	private BigDecimal unitPrice;
	
	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "product_id")
	private Long productId;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "order_id",referencedColumnName = "id")
	private Order order;
}

