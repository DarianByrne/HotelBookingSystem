package ie.hotelbooking.model.booking;

import ie.hotelbooking.model.Database;
import ie.hotelbooking.model.location.*;
import ie.hotelbooking.model.customer.Customer;
import ie.hotelbooking.model.information.Payment;

import java.sql.*;

/**
 * Conference booking class that extends from the superclass Booking
 */
public class ConferenceBooking extends Booking {
	private Venue venue;
	private int numberOfAttendees;
	private String eventType;

	/**
	 * ConferenceBooking constructor method that instantiates a new ConferenceBooking object without arguments
	 */
	public ConferenceBooking() {
		super();
	}

	/**
	 * ConferenceBooking constructor method that instantiates a new ConferenceBooking object with
	 * arguments passed as parameters
	 * @param customer a customer object of the type Customer
	 * @param payment a payment object of the type Payment
	 * @param venue a venue object of the type Venue
	 * @param arrivalDate an arrivalDate object of the type Date
	 * @param departureDate a departureDate object of the type Date
	 * @param arrivalTime an arrivalTime object of the type Time
	 * @param departureTime a departureTime object of the type Time
	 * @param numberOfAttendees a numberOfAttendees variable of the type int
	 * @param eventType an eventType variable of the type String
	 */
	public ConferenceBooking(Customer customer, Payment payment, Venue venue,  Date arrivalDate, Date departureDate, Time arrivalTime, Time departureTime, int numberOfAttendees, String eventType) {
		super.setBookingID();
		super.setCustomer(customer);
		super.setPayment(payment);
		setVenue(venue);
		super.setArrivalDate(arrivalDate);
		super.setDepartureDate(departureDate);
		super.setArrivalTime(arrivalTime);
		super.setDepartureTime(departureTime);
		setNumberOfAttendees(numberOfAttendees);
		setEventType(eventType);
	}

	/**
	 * Getter method for the instance variable venue
	 * @return an object of the type Venue
	 */
	public Venue getVenue() {
		return venue;
	}

	/**
	 * Setter method for setting the instance variable venue
	 * @param venue
	 */
	public void setVenue(Venue venue) {
		this.venue = venue;
	}

	/**
	 * Getter method for the instance variable numberOfAttendees
	 * @return a numberOfAttendees variable of the type int
	 */
	public int getNumberOfAttendees() { return numberOfAttendees; }

	/**
	 * Setter method for setting the instance variable numberOfAttendees
	 * @param numberOfAttendees a numberOfAttendees variable of the type int
	 */
	public void setNumberOfAttendees(int numberOfAttendees) {
		this.numberOfAttendees = numberOfAttendees;
	}

	/**
	 * Getter method for the instance variable eventType
	 * @return an eventType variable of the type String
	 */
	public String getEventType() { return eventType; }

	/**
	 * Setter method for setting the instance variable eventType
	 * @param eventType a variable of the type String
	 */
	public void setEventType(String eventType) { this.eventType = eventType; }

	/**
	 * CRUD method for inserting a conference booking into the conference_booking table in the database
	 */
	public void addConferenceBooking() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int i = 0;

		try {
			connection = Database.getConnection();
			preparedStatement = connection.prepareStatement("INSERT INTO conference_booking (bookingID, venueName, arrivalDate, departureDate, arrivalTime, departureTime, eventType, numberOfAttendees) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
			preparedStatement.setInt(1, super.getBookingID());
			preparedStatement.setString(2, venue.getName());
			preparedStatement.setDate(3, super.getArrivalDate());
			preparedStatement.setDate(4, super.getDepartureDate());
			preparedStatement.setTime(5, super.getArrivalTime());
			preparedStatement.setTime(6, super.getDepartureTime());
			preparedStatement.setString(7, getEventType());
			preparedStatement.setInt(8, getNumberOfAttendees());
			i = preparedStatement.executeUpdate();
			System.out.println(i + " booking added successfully to the conference booking table");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
				preparedStatement.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * CRUD method for updating a conference booking row in the conference_booking table in the database
	 */
	public void updateConferenceBooking() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int i = 0;

		try {
			connection = Database.getConnection();
			preparedStatement = connection.prepareStatement("UPDATE conference_booking SET bookingID=?, venueName=?, arrivalDate=?, departureDate=?, arrivalTime=?, departureTime=?, eventType=?, numberOfAttendees=? WHERE bookingID=?");
			preparedStatement.setInt(1, super.getBookingID());
			preparedStatement.setString(2, venue.getName());
			preparedStatement.setDate(3, super.getArrivalDate());
			preparedStatement.setDate(4, super.getDepartureDate());
			preparedStatement.setTime(5, super.getArrivalTime());
			preparedStatement.setTime(6, super.getDepartureTime());
			preparedStatement.setString(7, getEventType());
			preparedStatement.setInt(8, getNumberOfAttendees());
			preparedStatement.setInt(9, super.getBookingID());
			i = preparedStatement.executeUpdate();
			System.out.println(i + " booking updated successfully to the conference booking table");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
				preparedStatement.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * CRUD method for deleting a conference booking row from the conference_booking table in the database
	 */
	public void deleteConferenceBooking() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int i = 0;

		try {
			connection = Database.getConnection();
			preparedStatement = connection.prepareStatement("DELETE FROM conference_booking WHERE bookingID=?");
			preparedStatement.setInt(1, super.getBookingID());
			i = preparedStatement.executeUpdate();
			System.out.println(i + " booking deleted successfully to the conference booking table");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
				preparedStatement.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}