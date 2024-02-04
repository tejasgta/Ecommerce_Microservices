package com.order.controller;

import com.order.dto.Product;
import com.order.entity.Order;
import com.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@GetMapping
	public ResponseEntity<List<Order>> getOrders() {
		return new ResponseEntity<>(orderService.getOrders(), HttpStatus.OK);
	}

	@GetMapping("/products")
	public ResponseEntity<List<Product>> getProducts() {
		return new ResponseEntity<>(orderService.getProducts(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity getOrders(@PathVariable Long id) {
		Optional<Order> order = orderService.getOrderById(id);
		if (order.isPresent()) {
			return new ResponseEntity<>(order.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Order with Id: "+id+" not found!", HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping
	public ResponseEntity<Order> addOrder(@RequestBody Order order){
		return new ResponseEntity<>(orderService.addOrder(order),HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public String deleteOrder(@PathVariable Long id){
		if(orderService.getOrderById(id).isEmpty()){
			return "Order with Id: " + id + " not found";
		}
		else{
			orderService.deleteOrder(id);
			return "Order with Id: " + id + " deleted successfully";
		}
	}



}
