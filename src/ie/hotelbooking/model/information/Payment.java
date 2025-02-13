package ie.hotelbooking.model.information;

import ie.hotelbooking.model.Database;
import ie.hotelbooking.model.customer.*;

import java.sql.*;

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

	public Payment() {
		setPaymentID();
	}

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

	public int getPaymentID() {
		return paymentID;
	}

	public void setPaymentID() {
		paymentID = paymentIDCounter++;
	}

	public int getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}

	public int getCardCVV() {
		return cardCVV;
	}

	public void setCardCVV(int cardCVV) {
		this.cardCVV = cardCVV;
	}

	public Date getCardExpiryDate() {
		return cardExpiryDate;
	}

	public void setCardExpiryDate(Date cardExpiryDate) {
		this.cardExpiryDate = cardExpiryDate;
	}

	public String getCardHolderName() {
		return cardHolderName;
	}

	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

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