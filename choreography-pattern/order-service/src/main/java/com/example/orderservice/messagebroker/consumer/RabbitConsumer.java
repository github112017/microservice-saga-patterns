package com.example.orderservice.messagebroker.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.orderservice.dto.ConfirmDTO;
import com.example.orderservice.messagebroker.payload.Payload;
import com.example.orderservice.service.OrderService;

@Component
public class RabbitConsumer {

	@Autowired
	private OrderService service;
	
	@RabbitListener(queues = "ORDER_CONFIRMED_EVENT", containerFactory = "commonFactory")
	public void handleMessage(Payload<ConfirmDTO> payload) {
		
		System.out.println("Confirm Payload Received:: ");
		System.out.println(payload);
	
		service.update(payload.getEntity());
	}
}