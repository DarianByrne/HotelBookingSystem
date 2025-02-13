package ie.hotelbooking;

import ie.hotelbooking.view.MainMenu;
import javax.swing.*;
import java.awt.*;

public class Main {
	public static JFrame frame = new JFrame("Hotel Booking System");

	public static void main(String[] args) {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setLayout(new FlowLayout(FlowLayout.CENTER));
		new MainMenu();

//		LocalDate today = LocalDate.now();
//		LocalTime time = LocalTime.now().truncatedTo(ChronoUnit.MINUTES);
//
//		Customer customer = new Customer();
//		String name = "Marco Polo";
//		Date dateOfBirth = Date.valueOf("01/01/1990");
//		String address = "Swaziland";
//		String phone = "123456789";
//		String email = "marcopolo@gmail.com";
//		customer.setName(name);
//		customer.setDateOfBirth(dateOfBirth);
//		customer.setAddress(address);
//		customer.setPhoneNumber(phone);
//		customer.setEmail(email);
//
//		Payment payment = new Payment();
//		payment.setCustomer(customer);
//		payment.setCustomerID();
//		int cardNumber = 12345678;
//		int cardCVV = 321;
//		String cardHolderName = "Marco Polo";
//		Date cardExpiryDate = Date.valueOf("01/01/2028");
//		Date paymentDate = Date.valueOf(today);
//		Time paymentTime = Time.valueOf(time);
//		double amount = 200;
//		payment.setCardNumber(cardNumber);
//		payment.setCardCVV(cardCVV);
//		payment.setCardHolderName(cardHolderName);
//		payment.setCardExpiryDate(cardExpiryDate);
//		payment.setCustomerID();
//		payment.setDate(paymentDate);
//		payment.setTime(paymentTime);
//		payment.setAmount(amount);
//
//		Booking booking = new Booking(payment, customer);
//
//		customer.addCustomer();
//		payment.addPayment();
//		booking.addBooking();
	}
}