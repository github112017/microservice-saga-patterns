package com.example.paymentservice.service;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.paymentservice.dto.PaymentDTO;
import com.example.paymentservice.dto.StockDTO;
import com.example.paymentservice.messagebroker.payload.Payload;
import com.example.paymentservice.messagebroker.producer.RabbitProducer;
import com.example.paymentservice.repository.UserPaymentRepository;
import com.example.paymentservice.repository.entity.UserPayment;

@Service
public class UserPaymentService {

	@Autowired
	private UserPaymentRepository repository;
	
	@Autowired
	private RabbitProducer producer;
	
	@Transactional
	public PaymentDTO authorization(PaymentDTO dto) {
		
		UserPayment entity = new UserPayment(dto.getAuthAmount(), dto.getOrderId());
		
		entity = repository.save(entity);
		dto.setId(entity.getId());
		
		publishBilledOrderEvent(dto);
		
		return dto;
	}
	
	private void publishBilledOrderEvent(PaymentDTO dto) {
		
		StockDTO stock = new StockDTO();
		stock.setOrderId(dto.getOrderId());
		stock.setQty(1);
		stock.setItemName(dto.getItemName());
		
		Payload<StockDTO> payload = new Payload<>();
		payload.setTxId(ThreadLocalRandom.current().nextInt());
		payload.setMessageType("BILLED_ORDER_EVENT");
		payload.setEntity(stock);
		
		producer.send(payload);
	}
}
