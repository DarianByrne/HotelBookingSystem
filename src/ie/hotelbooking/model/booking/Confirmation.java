package ie.hotelbooking.model.booking;

import java.sql.Date;
import java.sql.Time;

/**
 * Confirmation class for presenting the user with a confirmation of their booking
 */
public class Confirmation {
	private Date date;
	private Time time;
	private Booking bookingDetails;

	/**
	 * Confirmation constructor method that instantiates a Confirmation object with arguments passed as parameters
	 * @param date an object of the type Date
	 * @param time an object of the type Time
	 * @param bookingDetails an object of the type Booking
	 */
	public Confirmation(Date date, Time time, Booking bookingDetails) {
		this.date = date;
		this.time = time;
		this.bookingDetails = bookingDetails;
	}
}