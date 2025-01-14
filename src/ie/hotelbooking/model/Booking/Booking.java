package ie.hotelbooking.model.Booking;

import ie.hotelbooking.model.Customer.*;
import ie.hotelbooking.model.Information.Date;
import ie.hotelbooking.model.Information.Payment;
import ie.hotelbooking.model.Information.Time;

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