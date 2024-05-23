package com.carrental.application;

public class Car {
	
	//Variables

	private String carId;
	private String brand;
	private String model;
	private double pricePerDay;
	private boolean isAvailable;
	
	//constructor
	
	public Car(String carId, String brand, String model, double pricePerDay) {
		
		this.carId = carId;
		this.brand = brand;
		this.model = model;
		this.pricePerDay = pricePerDay;
		this.isAvailable = true;
	}

	//Getter Methods
	
	public String getCarId() {
		return carId;
	}

	public String getBrand() {
		return brand;
	}

	public String getModel() {
		return model;
	}

	public double calculatePrice(int rentalDays) {
		return pricePerDay * rentalDays;
	}

	public boolean isAvailable() {
		return isAvailable;
	}
	
	//When Car On Rent Then is Not Available
	
	public void rent() {
		isAvailable = false;
	}
   
	//When Car is Returned by Customer Car is Available
	
	public void returncar() {
		isAvailable = true;
	}
	
}
