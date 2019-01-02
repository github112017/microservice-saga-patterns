package com.example.paymentservice.messagebroker.producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.paymentservice.dto.StockDTO;
import com.example.paymentservice.messagebroker.payload.Payload;

@Component
public class RabbitProducer {

	@Autowired
	private AmqpTemplate amqpTemplate;
	
	public void send( Payload<StockDTO> payload) {
		
		amqpTemplate.convertAndSend(payload);
		 
	}
}