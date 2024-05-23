package com.carrental.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarRentalSystem {
	private List<Car> cars;
	private List<Customer> customers;
	private List<Rental> rentals;

	public CarRentalSystem() {
		cars = new ArrayList<Car>();
		customers = new ArrayList<Customer>();
		rentals = new ArrayList<Rental>();
	}

//Adding a Car
	public void addCar(Car car) {
		cars.add(car);
	}

//Adding Customer
	public void addCustomer(Customer customer) {
		customers.add(customer);
	}

//Rent Method 
	public void rentCar(Car car, Customer customer, int days) {
		if (car.isAvailable()) {
			car.rent();
			rentals.add(new Rental(car, customer, days));
		}
	}

//Return Method
	public void returnCar(Car car) {
		car.returncar();
		Rental rentalToRemove = null;
		for (Rental rental : rentals)
			if (rental.getCar() == car) {
				rentalToRemove = rental;
				break;
			}
		if (rentalToRemove != null) {
			rentals.remove(rentalToRemove);
		} else {
			System.out.println("Car Was Not Rented");
		}
	}

	public void menu() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("|__________________________|");
			System.out.println("|                          |");
			System.out.println("|      Car Rental System   |");
			System.out.println("|__________________________|");
			System.out.println("|                          |");
			System.out.println("|      1. Rent a Car       |");
			System.out.println("|      2. Return a Car     |");
			System.out.println("|      3. Exit             |");
			System.out.println("|__________________________|");
			System.out.print("Enter your choice: ");

			int chioce = sc.nextInt();
			sc.nextLine();

			if (chioce == 1) {
				System.out.println("|_______________________________|");
				System.out.println("|                               |");
				System.out.println("|         RENT A CAR            |");
				System.out.println("|_______________________________|");
				System.out.println("|                               |");

				// print Available Cars
				System.out.println("\nAvailable Cars:");
				for (Car car : cars) {
					if (car.isAvailable()) {
						System.out.println(car.getCarId() + " - " + car.getBrand() + " " + car.getModel());
					}
				}

				// Enter Car Id Which Car You Wanted To Take Rent

				System.out.print("\nEnter the car ID you want to rent: ");
				String carId = sc.nextLine();

				// Enter Customer Name To Rent a Car

				System.out.print("Enter your name: ");
				String customerName = sc.nextLine();

				// Enter the Number Of Days Customer Wanted to Take Rent

				System.out.print("Enter the number of days for rental: ");
				int rentalDays = sc.nextInt();
				sc.nextLine(); // Consume newline
				Customer newCustomer = new Customer("CUS" + (customers.size() + 1), customerName);
				addCustomer(newCustomer);

				Car selectedCar = null;
				for (Car car : cars) {
					if (car.getCarId().equals(carId) && car.isAvailable()) {
						selectedCar = car;
						break;
					}
				}

				if (selectedCar != null) {
					double totalPrice = selectedCar.calculatePrice(rentalDays);
					System.out.println("|_______________________________|");
					System.out.println("|                               |");
					System.out.println("|  Rental Information           ");
					System.out.println("|_______________________________|");
					System.out.println("|                               |");
					System.out.println("Customer ID: " + newCustomer.getCustomerId());
					System.out.println("Customer Name: " + newCustomer.getName());
					System.out.println("Car: " + selectedCar.getBrand() + " " + selectedCar.getModel());
					System.out.println("Rental Days: " + rentalDays);
					System.out.printf("Total Price: $%.2f%n", totalPrice);

					System.out.print("\nConfirm rental (Y/N): ");
					String confirm = sc.nextLine();

					if (confirm.equalsIgnoreCase("Y")) {
						rentCar(selectedCar, newCustomer, rentalDays);
						System.out.println("\nCar rented successfully.");
					} else {
						System.out.println("\nRental canceled.");
					}
				} else {
					System.out.println("\nInvalid car selection or car not available for rent.");
				}

			}//choice 1 is Completed!
			else if (chioce == 2) {
                System.out.println("\n== Return a Car ==\n");
                System.out.print("Enter the car ID you want to return: ");
                String carId = sc.nextLine();

                Car carToReturn = null;
                for (Car car : cars) {
                    if (car.getCarId().equals(carId) && !car.isAvailable()) {
                        carToReturn = car;
                        break;
                    }
                }

                if (carToReturn != null) {
                    Customer customer = null;
                    for (Rental rental : rentals) {
                        if (rental.getCar() == carToReturn) {
                            customer = rental.getCustomer();
                            break;
                        }
                    }

                    if (customer != null) {
                        returnCar(carToReturn);
                        System.out.println("Car returned successfully by " + customer.getName());
                    } else {
                        System.out.println("Car was not rented or rental information is missing.");
                    }
                } else {
                    System.out.println("Invalid car ID or car is not rented.");
                }
            } else if (chioce == 3) {
                break;
            } else {
                System.out.println("Invalid choice. Please enter a valid option.");
            }
		}
		 System.out.println("\nThank you for using the Car Rental System!");
	}

}
