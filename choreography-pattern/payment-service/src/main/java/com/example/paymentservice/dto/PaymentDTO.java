package com.example.paymentservice.dto;

public class PaymentDTO {

	private int id;
	
	private int authAmount;
	
	private int orderId;

	private String itemName;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAuthAmount() {
		return authAmount;
	}

	public void setAuthAmount(int authAmount) {
		this.authAmount = authAmount;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	@Override
	public String toString() {
		return "PaymentDTO [id=" + id + ", authAmount=" + authAmount + ", orderId=" + orderId + "]";
	}
	
	
}
