package ie.hotelbooking.model.booking;

import java.sql.Date;
import java.sql.Time;

/**
 *
 */
public class Confirmation {
	private Date date;
	private Time time;
	private Booking bookingDetails;

	public Confirmation(Date date, Time time, Booking bookingDetails) {
		this.date = date;
		this.time = time;
		this.bookingDetails = bookingDetails;
	}
}