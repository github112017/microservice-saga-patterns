package com.example.stockservice.service;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.stockservice.dto.ConfirmDTO;
import com.example.stockservice.dto.StockDTO;
import com.example.stockservice.entity.UserStock;
import com.example.stockservice.messagebroker.payload.Payload;
import com.example.stockservice.messagebroker.producer.RabbitProducer;
import com.example.stockservice.repository.UserStockRepository;

@Service
public class UserStockService {

	@Autowired
	private UserStockRepository repository;
	
	@Autowired
	private RabbitProducer producer;
	
	@Transactional
	public StockDTO reserveStock(StockDTO stock) {
		
		UserStock entity = new UserStock(stock.getQty(), stock.getItemName());
		entity = repository.save(entity);
		stock.setId(entity.getId());
		
		publishPreparedOrderEvent(stock);
		
		return stock;
	}
	
	private void publishPreparedOrderEvent(StockDTO stock) {
		
		ConfirmDTO confirm = new ConfirmDTO();
		confirm.setOrderId(stock.getOrderId());
		confirm.setOrderStatus("CONFIREMD");
		Payload<ConfirmDTO> payload = new Payload<>();
		payload.setTxId(ThreadLocalRandom.current().nextInt());
		payload.setMessageType("ORDER_CONFIRMED_EVENT");
		payload.setEntity(confirm);
		
		producer.send(payload);
	}
}