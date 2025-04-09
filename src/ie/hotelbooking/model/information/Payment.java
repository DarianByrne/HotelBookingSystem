package ie.hotelbooking.model.information;

import ie.hotelbooking.model.Database;
import ie.hotelbooking.model.customer.*;

import java.sql.*;

/**
 * Payment class represents a payment made by a customer.
 * It contains information about the payment such as card details, amount, date, and time.
 * It also provides methods to add, update, and delete payment records in the database.
 */
public class Payment {
	private int paymentID;
	private static int paymentIDCounter = 0;
	private int customerID;
	private int cardNumber;
	private int cardCVV;
	private Date cardExpiryDate;
	private String cardHolderName;
	private double amount;
	private Date date;
	private Time time;
	private Customer customer;

	/**
	 * Default constructor
	 */
	public Payment() {
		setPaymentID();
	}

	/**
	 * Constructor with parameters
	 * @param cardNumber
	 * @param cardCVV
	 * @param cardExpiryDate
	 * @param cardHolderName
	 * @param amount
	 * @param date
	 * @param time
	 * @param customer
	 */

	public Payment(int cardNumber, int cardCVV, Date cardExpiryDate, String cardHolderName, double amount, Date date, Time time, Customer customer) {
		setPaymentID();
		this.customer = customer;
		this.cardNumber = cardNumber;
		this.cardCVV = cardCVV;
		this.cardExpiryDate = cardExpiryDate;
		this.cardHolderName = cardHolderName;
		this.amount = amount;
		this.date = date;
		this.time = time;
		customerID = customer.getCustomerID();
	}
	/**
	 * Getter method for the instance variable paymentID
	 * @return the Payment ID of the Payment object
	 */
	public int getPaymentID() {
		return paymentID;
	}
	/**
	 * Setter method for the instance variable paymentID
	 */
	public void setPaymentID() {
		paymentID = paymentIDCounter++;
	}
	/**
	 * Getter method for the instance variable paymentIDCounter
	 * @return the Payment ID Counter of the Payment object
	 */
	public int getCardNumber() {
		return cardNumber;
	}
	/**
	 * Setter method for the instance variable paymentIDCounter
	 */
	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}
	/**
	 * Getter method for the instance variable cardCVV
	 * @return the Card CVV of the Payment object
	 */
	public int getCardCVV() {
		return cardCVV;
	}
	/**
	 * Setter method for the instance variable cardCVV
	 */
	public void setCardCVV(int cardCVV) {
		this.cardCVV = cardCVV;
	}
	/**
	 * Getter method for the instance variable cardExpiryDate
	 * @return the Card Expiry Date of the Payment object
	 */
	public Date getCardExpiryDate() {
		return cardExpiryDate;
	}
	/**
	 * Setter method for the instance variable cardExpiryDate
	 */
	public void setCardExpiryDate(Date cardExpiryDate) {
		this.cardExpiryDate = cardExpiryDate;
	}
	/**
	 * Getter method for the instance variable cardHolderName
	 * @return the Card Holder Name of the Payment object
	 */
	public String getCardHolderName() {
		return cardHolderName;
	}
	/**
	 * Setter method for the instance variable cardHolderName
	 */
	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}
	/**
	 * Getter method for the instance variable amount
	 * @return the Amount of the Payment object
	 */
	public double getAmount() {
		return amount;
	}
	/**
	 * Setter method for the instance variable amount
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}
	/**
	 * Getter method for the instance variable date
	 * @return the Date of the Payment object
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * Setter method for the instance variable date
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * Getter method for the instance variable time
	 * @return the Time of the Payment object
	 */
	public Time getTime() {
		return time;
	}
	/**
	 * Setter method for the instance variable time
	 */
	public void setTime(Time time) {
		this.time = time;
	}
	/**
	 * Getter method for the instance variable customerID
	 * @return the Customer ID of the Payment object
	 */
	public Customer getCustomer() {
		return customer;
	}
	/**
	 * Setter method for the instance variable customerID
	 * @param customer an object of the type Customer
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	/**
	 * CRUD method to add payment details to the database
	 */
	public void addPayment() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int i = 0;

		try {
			connection = Database.getConnection();
			preparedStatement = connection.prepareStatement("INSERT INTO payment(customerID, cardNumber, cardCVV, cardExpiryDate, cardHolderName, amount, date, time) VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
			preparedStatement.setInt(1, customer.getCustomerID());
			preparedStatement.setInt(2, cardNumber);
			preparedStatement.setInt(3, cardCVV);
			preparedStatement.setDate(4, cardExpiryDate);
			preparedStatement.setString(5, cardHolderName);
			preparedStatement.setDouble(6, amount);
			preparedStatement.setDate(7, date);
			preparedStatement.setTime(8, time);
			i = preparedStatement.executeUpdate();
			System.out.println(i + " record successfully added to the payment table");
		} catch(SQLException sqlException) {
			sqlException.printStackTrace();
		} finally {
			try {
				if(connection != null) connection.close();
				if(preparedStatement != null) preparedStatement.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * CRUD method to retrieve payment details from the database
	 */

	public void updatePayment(int paymentID) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int customerID = customer.getCustomerID();
		int cardNumber = getCardNumber();
		int cardCVV = getCardCVV();
		Date cardExpiryDate = getCardExpiryDate();
		String cardHolderName = getCardHolderName();
		double amount = getAmount();
		Date date = getDate();
		Time time = getTime();
		int i = 0;

		try {
			connection = Database.getConnection();
			preparedStatement = connection.prepareStatement("UPDATE payment SET customerID=?, cardNumber=?, cardCVV=?, cardExpiryDate=?, cardHolderName=?, amount=?, date=?, time=? WHERE paymentID=?");
			preparedStatement.setInt(1, customerID);
			preparedStatement.setInt(2, cardNumber);
			preparedStatement.setInt(3, cardCVV);
			preparedStatement.setDate(4, cardExpiryDate);
			preparedStatement.setString(5, cardHolderName);
			preparedStatement.setDouble(6, amount);
			preparedStatement.setDate(7, date);
			preparedStatement.setTime(8, time);
			preparedStatement.setInt(9, paymentID);
			i = preparedStatement.executeUpdate();
			System.out.println(i + " record successfully updated in the payment table");
		} catch(SQLException sqlException) {
			sqlException.printStackTrace();
		} finally {
			try {
				connection.close();
				preparedStatement.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * CRUD method to delete payment details from the database
	 */
	public void deletePayment() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int i = 0;

		try {
			connection = Database.getConnection();
			preparedStatement = connection.prepareStatement("DELETE FROM payment WHERE paymentID=?");
			preparedStatement.setInt(1, getPaymentID());
			i = preparedStatement.executeUpdate();
			System.out.println(i + " record successfully deleted from the payment table");
		} catch(SQLException sqlException) {
			sqlException.printStackTrace();
		} finally {
			try {
				connection.close();
				preparedStatement.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}