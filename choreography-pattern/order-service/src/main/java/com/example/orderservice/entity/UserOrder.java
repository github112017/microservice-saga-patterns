package com.example.orderservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserOrder {

	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
	private int id;

	private int amount;

	private String itemName;
	
	private String orderStatus;
	
	public UserOrder() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserOrder( String itemName, int amount, String orderStatus) {
		super();
		this.itemName = itemName;
		this.amount = amount;
		this.orderStatus = orderStatus;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	
}
