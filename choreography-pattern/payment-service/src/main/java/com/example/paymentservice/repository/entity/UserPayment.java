package com.example.paymentservice.repository.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserPayment {

	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
	private int id;
	
	private int authAmount;
	
	private int orderId;

	public UserPayment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserPayment(int authAmount, int orderId) {
		super();
		 
		this.authAmount = authAmount;
		this.orderId = orderId;
	}

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

	
	
}