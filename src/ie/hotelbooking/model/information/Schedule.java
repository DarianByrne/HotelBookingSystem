package ie.hotelbooking.model.information;

import ie.hotelbooking.model.booking.*;
import java.sql.Date;
import java.sql.Time;

/**
 *
 */
public class Schedule {

	/**
	 * Default constructor
	 */
	public Schedule() {
	}

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
	private Booking[] roomBookings;

	/**
	 *
	 */
	private Booking[] weddingBookings;

	/**
	 *
	 */
	private Booking[] gymBookings;

	/**
	 *
	 */
	private Booking[] spaBookings;

	/**
	 *
	 */
	private Booking[] restaurantReservations;

	/**
	 *
	 */
	private Booking[] conferenceBookings;

}