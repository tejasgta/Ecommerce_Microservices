package com.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {
	
	@Autowired
	private RestTemplate template;

	public void getProducts() {
		template.getForObject("", null);
	}
}
