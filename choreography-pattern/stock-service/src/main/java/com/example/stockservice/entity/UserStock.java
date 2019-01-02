package com.example.stockservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserStock {

	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
	private int id;
	
	private int qty;
	
	private String itemName;

	public UserStock() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserStock(int qty, String itemName) {
		super();
		 
		this.qty = qty;
		this.itemName = itemName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	
	
}
