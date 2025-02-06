package ie.hotelbooking;

import ie.hotelbooking.controller.CustomerController;
import ie.hotelbooking.controller.PaymentController;
import ie.hotelbooking.model.customer.Customer;
import ie.hotelbooking.model.information.Payment;

import java.sql.Date;
import java.sql.Time;

public class Main {
	public static void main(String[] args) {
		Customer customer = new Customer();
		String name = "Marco Polo";
		String dateOfBirth = "01/01/1990";
		String address = "Swaziland";
		String phone = "123456789";
		String email = "marcopolo@gmail.com";

		Payment payment = new Payment();
		payment.setCustomer(customer);
		payment.setCustomerID();
		int cardNumber = 12345678;
		int cardCVV = 321;
		String cardHolderName = "Marco Polo";
		Date cardExpiryDate = Date.valueOf("01/01/2028");
		Date paymentDate =
	}
}