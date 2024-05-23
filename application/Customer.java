package com.carrental.application;

public class Customer {

	//Variables
	
	private String customerId;
	private String name;
	
	//constructor

	public Customer(String customerId, String name) {
		
		this.customerId = customerId;
		this.name = name;
	}


	//Getter Methods 
	
	public String getCustomerId() {
		return customerId;
	}

	public String getName() {
		return name;
	}
	
}
