package ie.hotelbooking.model.Booking;

import ie.hotelbooking.model.Customer.*;
import ie.hotelbooking.model.Information.Payment;
import java.sql.Date;
import java.sql.Time;

/**
 *
 */
public class Booking {

	/**
	 * Default constructor
	 */
	public Booking() {
	}

	/**
	 *
	 */
	private int bookingID;

	/**
	 *
	 */
	private Customer customer;

	/**
	 *
	 */
	private Date date;

	/**
	 *
	 */
	private Time time;

	/**
	 *
	 */
	private Payment payment;

}