package ie.hotelbooking;

import ie.hotelbooking.model.customer.Customer;

import java.sql.Date;

import ie.hotelbooking.view.*;

public class Main {
	public static void main(String[] args) {
		System.out.println("Hello world!");

		String name = "Mick Phelan";
		String phoneNumber = "086-1602798";
		String email = "mick.phelan@gmail.com";
		Date dateOfBirth = Date.valueOf("2000-10-10");
		String address = "Cork";
		Customer customerOne = new Customer(name, phoneNumber, email, dateOfBirth, address);
		ViewCustomers.displayCustomers();
		ViewPayments.displayPayments();
	}
}