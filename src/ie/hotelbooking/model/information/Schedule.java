package ie.hotelbooking.model.information;

import ie.hotelbooking.model.booking.*;
import java.sql.Date;
import java.sql.Time;

/**
 * The Schedule class represents a schedule for various bookings and reservations.
 * It contains information about the date, time, and different types of bookings.
 */
public class Schedule {
	private Date date;
	private Time time;
	private RoomBooking[] roomBookings;
	private WeddingBooking[] weddingBookings;
	private GymBooking[] gymBookings;
	private SpaBooking[] spaBookings;
	private RestaurantReservation[] restaurantReservations;
	private ConferenceBooking[] conferenceBookings;
	/**
	 * Default constructor
	 */
	public Schedule() {}
	public Schedule(Date date, Time time, RoomBooking[] roomBookings, WeddingBooking[] weddingBookings, GymBooking[] gymBookings, SpaBooking[] spaBookings, RestaurantReservation[] restaurantReservations, ConferenceBooking[] conferenceBookings) {
		this.date = date;
		this.time = time;
		this.roomBookings = roomBookings;
		this.weddingBookings = weddingBookings;
		this.gymBookings = gymBookings;
		this.spaBookings = spaBookings;
		this.restaurantReservations = restaurantReservations;
		this.conferenceBookings = conferenceBookings;
	}
}