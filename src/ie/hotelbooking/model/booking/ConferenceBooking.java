package ie.hotelbooking.model.booking;

import ie.hotelbooking.model.location.*;

import java.sql.Time;
import java.sql.Date;

/**
 *
 */
public class ConferenceBooking extends Booking {
	private int bookingID;
	private Booking booking;
	private Venue venue;
	private String venueName;
	private Date arrivalDate;
	private Time arrivalTime;
	private Time departureTime;
	private int numberOfAttendees;
	private String eventType;

	public ConferenceBooking() {}

	public ConferenceBooking() {}

	public void addConferenceBooking(ConferenceBooking conferenceBooking) {}
	public ConferenceBooking getConferenceBooking(ConferenceBooking conferenceBooking) {
		return conferenceBooking;
	}
	public void updateConferenceBooking(ConferenceBooking conferenceBooking) {}
	public void deleteConferenceBooking(ConferenceBooking conferenceBooking) {}
}