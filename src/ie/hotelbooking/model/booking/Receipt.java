package ie.hotelbooking.model.booking;

import java.sql.Date;
import java.sql.Time;

/**
 * Receipt class for presenting the user with a receipt of their booking payment
 */
public class Receipt {
	private Date date;
	private Time time;
	private double paymentAmount;

	/**
	 * Receipt constructor method that instantiates a new Receipt object with arguments passed as parameters
	 * @param date an object of the type Date
	 * @param time an object of the type Time
	 * @param paymentAmount a variable of the type double
	 */
	public Receipt(Date date, Time time, double paymentAmount) {
		this.date = date;
		this.time = time;
		this.paymentAmount = paymentAmount;
	}
}