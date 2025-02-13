package ie.hotelbooking.model.booking;

import ie.hotelbooking.model.Database;
import ie.hotelbooking.model.location.*;
import ie.hotelbooking.model.customer.Customer;
import ie.hotelbooking.model.information.Payment;

import java.sql.*;

/**
 *
 */
public class ConferenceBooking extends Booking {
	private Venue venue;
	private int numberOfAttendees;
	private String eventType;

	public ConferenceBooking() {
		super();
	}

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
	public Venue getVenue() {
		return venue;
	}
	public void setVenue(Venue venue) {
		this.venue = venue;
	}
	public int getNumberOfAttendees() { return numberOfAttendees; }
	public void setNumberOfAttendees(int numberOfAttendees) {
		this.numberOfAttendees = numberOfAttendees;
	}
	public String getEventType() { return eventType; }
	public void setEventType(String eventType) { this.eventType = eventType; }

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