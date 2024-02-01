package com.order.service;

import com.order.entity.Order;
import com.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private RestTemplate template;

	public void getProducts() {
		template.getForObject("", null);
	}

	private static String generateOrderTrackingNumber() {

//		generate a random UUID number (UUID version-4)
//		https://en.wikipedia.org/wiki/Universally_unique_identifier

		return UUID.randomUUID().toString();
	}

	public void saveOrder() {

//		OrderItem item1 = new OrderItem();
//		item1.setImageUrl("https://www.google.com");
//		item1.setQuantity(1);
//		item1.setUnitPrice(BigDecimal.valueOf(12000.00));
//		item1.setProductId(1L);
//
//		OrderItem item2 = new OrderItem();
//		item2.setImageUrl("https://www.google.com");
//		item2.setQuantity(1);
//		item2.setUnitPrice(BigDecimal.valueOf(13499));
//		item2.setProductId(1L);
//
//		Order order = new Order();
//		order.setOrderTrackingNumber(generateOrderTrackingNumber());
//		order.setTotalQuantity(2);
//		order.setTotalPrice(BigDecimal.valueOf(12000));
//		order.setStatus("SHIPPED");
//
//		orderRepository.save(order);
	}

	public List<Order> getOrders() {
		return orderRepository.findAll();
	}

	public Optional<Order> getOrderById(Long id) {
		return orderRepository.findById(id);
	}

	public Order addOrder(Order order) {
		order.setOrderTrackingNumber(generateOrderTrackingNumber());
		return orderRepository.save(order);
	}

	public void deleteOrder(Long id) {
		orderRepository.deleteById(id);
	}
}
