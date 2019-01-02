package com.example.stockservice.messagebroker.producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.stockservice.dto.ConfirmDTO;
import com.example.stockservice.messagebroker.payload.Payload;

@Component
public class RabbitProducer {

	@Autowired
	private AmqpTemplate amqpTemplate;
	
	public void send( Payload<ConfirmDTO> payload) {
		
		amqpTemplate.convertAndSend(payload);
		 
	}	
}