package com.example.orderservice.messagebroker.producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.orderservice.dto.PaymentDTO;
import com.example.orderservice.messagebroker.payload.Payload;

@Component
public class RabbitProducer {

	@Autowired
	private AmqpTemplate amqpTemplate;
	
	public void send( Payload<PaymentDTO> payload) {
		
		amqpTemplate.convertAndSend(payload);
		 
	}
}