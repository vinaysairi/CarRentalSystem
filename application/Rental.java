package com.carrental.application;

public class Rental {
  
	private Car car;
	private Customer customer;
	private int date;
	
	//Constructor
	
	public Rental(Car car, Customer customer, int date) {
		
		this.car = car;
		this.customer = customer;
		this.date = date;
	}

	   //GetMethods 

	
	public Car getCar() {
		return car;
	}

	public Customer getCustomer() {
		return customer;
	}

	public int getDate() {
		return date;
	}


}
