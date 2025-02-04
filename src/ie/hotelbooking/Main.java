package ie.hotelbooking;

import ie.hotelbooking.model.customer.Customer;
import ie.hotelbooking.model.information.Payment;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;

import ie.hotelbooking.view.*;

public class Main {
	public static void main(String[] args) {
		System.out.println("Hello world!");

		String name = "Mick Phelan";
		String phoneNumber = "086-1602798";
		String email = "mick.phelan@gmail.com";
		Date dateOfBirth = Date.valueOf("2000-10-10");
		String address = "Cork";
		int cardNumber = 1234432156;
		int cardCVV = 689;
		Date cardExpiryDate = Date.valueOf("2000-10-10");
		String cardHolderName = "Mick Phelan";
		double amount = 100.00;
		Date date =Date.valueOf("2000-10-10");
		LocalTime localTime = LocalTime.now();
		Time time = Time.valueOf(localTime);

		Customer customerOne = new Customer(name, phoneNumber, email, dateOfBirth, address);
		Payment paymentOne = new Payment(cardNumber, cardCVV, cardExpiryDate, cardHolderName, amount, date, time, customerOne);
		paymentOne.addPayment();
	}
}