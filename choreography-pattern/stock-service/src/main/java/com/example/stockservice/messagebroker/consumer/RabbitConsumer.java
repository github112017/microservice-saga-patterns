package com.example.stockservice.messagebroker.consumer;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.stockservice.dto.StockDTO;
import com.example.stockservice.messagebroker.payload.Payload;
import com.example.stockservice.service.UserStockService;

@Component
public class RabbitConsumer {

	@Autowired
	private UserStockService service;
	
	@RabbitListener(queues = "BILLED_ORDER_EVENT", containerFactory = "commonFactory")
	public void handleMessage(Payload<StockDTO> paylaod) {
		
		System.out.println("Stock Payload Received:: ");
		System.out.println(paylaod);
		
		StockDTO stock = paylaod.getEntity();
		
		
		service.reserveStock(stock);
	}	
}