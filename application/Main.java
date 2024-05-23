package com.carrental.application;

public class Main {

	public static void main(String[] args) {
		CarRentalSystem rentalSystem = new CarRentalSystem();

		Car car1 = new Car("C001", "Toyota", "Camry", 1000);
		Car car2 = new Car("C002", "Honda", "Accord", 1200);
		Car car3 = new Car("C003", "Mahindra", "Thar", 1500);
		Car car4 = new Car("C004", "Tata", "Nexon", 1100);
		Car car5 = new Car("C005", "Mahindra", "XUV 300", 1300);
		Car car6 = new Car("C006", "Maruthi", "Swift", 900);
		Car car7 = new Car("C007", "Mahindra", "Baleno", 1200);
		Car car8 = new Car("C008", "Mercedes-Benz", "Maybach GLS", 2000);
		rentalSystem.addCar(car1);
		rentalSystem.addCar(car2);
		rentalSystem.addCar(car3);
		rentalSystem.addCar(car4);
		rentalSystem.addCar(car5);
		rentalSystem.addCar(car6);
		rentalSystem.addCar(car7);
		rentalSystem.addCar(car8);

		rentalSystem.menu();
	}

}
