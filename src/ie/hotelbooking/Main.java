package ie.hotelbooking;

import ie.hotelbooking.dao.CustomerDAO;
import ie.hotelbooking.model.Customer.Customer;
import ie.hotelbooking.model.Information.Payment;
import ie.hotelbooking.model.Information.*;
import java.sql.Date;
import java.sql.Time;

public class Main {
	public static void main(String[] args) {
		System.out.println("Hello world!");

		String name = "Mick Phelan";
		String phoneNumber = "086-1602798";
		String email = "mick.phelan@gmail.com";
		Date dateOfBirth = new Date(10, 10, 2000);
		String address = "Cork";

		String nameToUpdate = "Donald Trump";

		CustomerDAO customerDAO = new CustomerDAO();
		Customer customerOne = new Customer(name, phoneNumber, email, dateOfBirth, address);

		Customer customerTwo = customerDAO.getCustomer("Mick Phelan");
		System.out.println(customerTwo.getCustomerID());
		System.out.println(customerTwo.getName());
		System.out.println(customerTwo.getPhoneNumber());
		System.out.println(customerTwo.getEmail());
		System.out.println(customerTwo.getDateOfBirth());
		System.out.println(customerTwo.getAddress());

		Payment payment = new Payment();
		payment.setCustomerID(customerTwo.getCustomerID());
		int cardNumber = 0;
		int cardCVV = 0;
		Date cardExpiryDate = Date.valueOf("2028-06-01");
		String cardHolderName = "Mick Phelan";
		double amount = 500;
		Date date = Date.valueOf("");
		Time time = new Time(System.currentTimeMillis());
		payment.setCardNumber(cardNumber);
		payment.setCardCVV(cardCVV);
		payment.setCardExpiryDate(cardExpiryDate);
		payment.setCardHolderName(cardHolderName);
		payment.setAmount(amount);
		payment.setDate(date);
		payment.setTime(time);
	}
}