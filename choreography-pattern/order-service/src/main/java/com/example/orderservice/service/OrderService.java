package com.example.orderservice.service;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.orderservice.dto.ConfirmDTO;
import com.example.orderservice.dto.OrderDTO;
import com.example.orderservice.dto.PaymentDTO;
import com.example.orderservice.entity.UserOrder;
import com.example.orderservice.messagebroker.payload.Payload;
import com.example.orderservice.messagebroker.producer.RabbitProducer;
import com.example.orderservice.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repository;
	
	@Autowired
	private RabbitProducer producer;
	
	@Transactional
	public OrderDTO placeOrder(OrderDTO dto) {
		
		UserOrder entity = new UserOrder(dto.getItemName(), dto.getAmount(),"PENDING");
		
		entity = repository.save(entity);
		dto.setId(entity.getId());
		dto.setOrderStatus(entity.getOrderStatus());
		
		publishOrderCreatedEvent(dto);
		
		return dto;
		
	}
	
	private void publishOrderCreatedEvent(OrderDTO dto) {
		
		PaymentDTO payment = new PaymentDTO();
		payment.setItemName(dto.getItemName());
		payment.setOrderId(dto.getId());
		payment.setAuthAmount(dto.getAmount());
		
		Payload<PaymentDTO> payload = new Payload<>();
		
		payload.setTxId(ThreadLocalRandom.current().nextInt());
		payload.setMessageType("ORDER_CREATED_EVENT");
		payload.setEntity(payment);
		
		producer.send(payload);
	}
	
	@Transactional
	public void update(ConfirmDTO dto) {
		
		repository.findById(dto.getOrderId()).ifPresent(order -> {
			
			order.setOrderStatus(dto.getOrderStatus());
			order = repository.save(order);
			
		});
		
		System.out.println("Order status is updated...");
		
	}
}