package com.order.service;

import com.order.dto.Product;
import com.order.entity.Order;
import com.order.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	private static Logger logger = LoggerFactory.getLogger(OrderService.class);

	public List<Product> getProducts() {
		logger.info("Inside getProducts of OrderService");
		List<Product> productList=template.getForObject("http://PRODUCT-SERVICE/products", List.class);
		logger.info("Product List : "+productList);
		return productList;
	}

	private static String generateOrderTrackingNumber() {

//		generate a random UUID number (UUID version-4)
//		https://en.wikipedia.org/wiki/Universally_unique_identifier

		return UUID.randomUUID().toString();
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
