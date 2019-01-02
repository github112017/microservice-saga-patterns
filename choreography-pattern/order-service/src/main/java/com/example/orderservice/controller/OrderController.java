package com.example.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.orderservice.dto.OrderDTO;
import com.example.orderservice.service.OrderService;

@RestController
@RequestMapping("/orders/")
public class OrderController {

	@Autowired
	private OrderService service;
	
	@PutMapping("order")
	public OrderDTO create(@RequestBody OrderDTO dto) {
		
		return service.placeOrder(dto);
		
	}
}
