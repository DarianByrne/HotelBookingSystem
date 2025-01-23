package ie.hotelbooking.model.Information;

import ie.hotelbooking.model.Customer.*;
import java.sql.Date;
import java.sql.Time;

public class Payment {
	private int paymentID;
	private int customerID;
	private int cardNumber;
	private int cardCVV;
	private Date cardExpiryDate;
	private String cardHolderName;
	private double amount;
	private Date date;
	private Time time;
	private Customer customer;

	public Payment() {}

	public Payment(int paymentID, int cardNumber, int cardCVV, Date cardExpiryDate, String cardHolderName, double amount, Date date, Time time, Customer customer) {
		this.paymentID = paymentID;
		this.customer = customer;
		this.cardNumber = cardNumber;
		this.cardCVV = cardCVV;
		this.cardExpiryDate = cardExpiryDate;
		this.cardHolderName = cardHolderName;
		this.amount = amount;
		this.date = date;
		this.time = time;
	}

	public int getPaymentID() {
		return paymentID;
	}

	public void setPaymentID(int paymentID) {
		this.paymentID = paymentID;
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
}