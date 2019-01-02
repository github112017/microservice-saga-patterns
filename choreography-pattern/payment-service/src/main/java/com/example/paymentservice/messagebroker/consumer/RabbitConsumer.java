package com.example.paymentservice.messagebroker.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.paymentservice.dto.PaymentDTO;
import com.example.paymentservice.messagebroker.payload.Payload;
import com.example.paymentservice.service.UserPaymentService;

@Component
public class RabbitConsumer {

	@Autowired
	private UserPaymentService service;
	
	@RabbitListener(queues = "ORDER_CREATED_EVENT", containerFactory = "commonFactory")
	public void handleMessage(Payload<PaymentDTO> paylaod) {
		
		System.out.println("Payment Payload Received:: ");
		System.out.println(paylaod);
		
		PaymentDTO payemnt = paylaod.getEntity();
		service.authorization(payemnt);
	}
}