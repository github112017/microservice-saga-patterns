package com.example.paymentservice.messagebroker.payload;

import com.example.paymentservice.dto.PaymentDTO;

public class Payload<T> {

	private int txId;
	
	private String messageType;
	
	private T entity;

	public int getTxId() {
		return txId;
	}

	public void setTxId(int txId) {
		this.txId = txId;
	}

	public String getMessageType() {
		return messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

	public T getEntity() {
		return entity;
	}

	public void setEntity(T entity) {
		this.entity = entity;
	}

	@Override
	public String toString() {
		
		PaymentDTO payment = (PaymentDTO)entity;
		return "Payload [txId=" + txId + ", messageType=" + messageType + ", payment=" + payment + "]";
	}
	
}