package ie.hotelbooking.model.booking;

import java.sql.Date;
import java.sql.Time;


public class Receipt {
	private Date date;
	private Time time;
	private double paymentAmount;

	public Receipt(Date date, Time time, double paymentAmount) {
		this.date = date;
		this.time = time;
		this.paymentAmount = paymentAmount;
	}
}