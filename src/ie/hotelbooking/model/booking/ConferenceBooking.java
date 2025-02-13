package ie.hotelbooking.model.booking;

import ie.hotelbooking.model.location.*;
import ie.hotelbooking.model.customer.Customer;
import ie.hotelbooking.model.information.Payment;

import java.sql.Time;
import java.sql.Date;

/**
 *
 */
public class ConferenceBooking extends Booking {
	private int bookingID;
	private Venue venue;
	private String venueName;
	private int numberOfAttendees;
	private String eventType;

	public ConferenceBooking() {
		super();
		bookingID = super.getBookingID();
	}

	public ConferenceBooking(Customer customer, Payment payment, Venue venue, String venueName, Date arrivalDate, Date departureDate, Time arrivalTime, Time departureTime, int numberOfAttendees, String eventType) {
		super.setCustomer(customer);
		super.setPayment(payment);
		setVenue(venue);
		setVenueName(venueName);
		super.setArrivalDate(arrivalDate);
		super.setDepartureDate(departureDate);
		super.setArrivalTime(arrivalTime);
		super.setDepartureTime(departureTime);
		setNumberOfAttendees(numberOfAttendees);
		setEventType(eventType);
	}

	public int getBookingID() {
		return bookingID;
	}
	public void setBookingID() {
		super.setBookingID();
	}
	public Venue getVenue() {
		return venue;
	}
	public void setVenue(Venue venue) {
		this.venue = venue;
	}
	public String getVenueName() {
		return venueName;
	}
	public void setVenueName(String venueName) { this.venueName = venueName; }
	public int getNumberOfAttendees() { return numberOfAttendees; }
	public void setNumberOfAttendees(int numberOfAttendees) {
		this.numberOfAttendees = numberOfAttendees;
	}
	public String getEventType() { return eventType; }
	public void setEventType(String eventType) { this.eventType = eventType; }

	public void addConferenceBooking(ConferenceBooking conferenceBooking) {}
	public ConferenceBooking getConferenceBooking(ConferenceBooking conferenceBooking) {
		return conferenceBooking;
	}
	public void updateConferenceBooking(ConferenceBooking conferenceBooking) {}
	public void deleteConferenceBooking(ConferenceBooking conferenceBooking) {}
}