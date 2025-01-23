package ie.hotelbooking;

import ie.hotelbooking.dao.CustomerDAO;
import ie.hotelbooking.dao.PaymentDAO;
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
		Date dateOfBirth = Date.valueOf("2000-10-10");
		String address = "Cork";

		String nameToUpdate = "Donald Trump";

		CustomerDAO customerDAO = new CustomerDAO();
		Customer customerOne = new Customer(name, phoneNumber, email, dateOfBirth, address);

		customerDAO.displayCustomers();

		Payment paymentOne = new Payment();
		PaymentDAO paymentDAO = new PaymentDAO();
		paymentOne.setCustomer(customerOne);
		paymentOne.setCardHolderName("Donald Trump");
		paymentOne.setCardNumber(0000);
		paymentOne.setCardExpiryDate(Date.valueOf("2000-10-10"));
		paymentOne.setCardCVV(987);
		paymentOne.setTime(Time.from("12:00"));
		paymentOne.setAmount(200);

		paymentDAO.displayPayments();
	}
}