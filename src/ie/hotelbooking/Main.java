package ie.hotelbooking;
//TODO have stack that tracks navigation, close brings you back through the stack
import ie.hotelbooking.view.MainMenu;
import javax.swing.*;
import java.awt.*;

public class Main {
	private static JFrame frame = new JFrame("Hotel Booking System");
	private static JPanel mainMenuPanel = new MainMenu();
	private static JRootPane rootPane = new JRootPane();

	public static void main(String[] args) {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);
		frame.setMinimumSize(new Dimension(600, 400));
		frame.setLocationRelativeTo(null);
		frame.setLayout(new BorderLayout());

		JLabel label1 = new JLabel("Welcome to Hotel Booking System");
		JPanel panel1 = new JPanel();
		panel1.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel1.add(label1);
		rootPane.setContentPane(panel1);

//		TODO change the main menu to be full screen initially
//		mainMenuPanel.setLayout(new GridLayout(0, 4));
//		frame.add(mainMenuPanel, BorderLayout.CENTER);

		frame.add(mainMenuPanel, BorderLayout.WEST);
		frame.add(rootPane, BorderLayout.CENTER);

		frame.setVisible(true);
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

	public static void changeScreen(JPanel panel) {
//		mainMenuPanel.setLayout(new GridLayout(0, 1));
		rootPane.setContentPane(panel);
		frame.validate();
	}
}