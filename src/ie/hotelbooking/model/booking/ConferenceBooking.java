package ie.hotelbooking.model.booking;

import ie.hotelbooking.model.location.*;

/**
 *
 */
public class ConferenceBooking extends Booking {
	private Venue venue;
	private int numberOfPeople;
	private String eventType;
	private float rate;

	public void addConferenceBooking(ConferenceBooking conferenceBooking) {}
	public ConferenceBooking getConferenceBooking(ConferenceBooking conferenceBooking) {
		return conferenceBooking;
	}
	public void updateConferenceBooking(ConferenceBooking conferenceBooking) {}
	public void deleteConferenceBooking(ConferenceBooking conferenceBooking) {}
}