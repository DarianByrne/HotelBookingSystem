package ie.hotelbooking.model.booking;

import ie.hotelbooking.model.gym.*;

/**
 *
 */
public class GymBooking extends Booking {
	private GymSession gymSession;
	private double duration;
	private double rate;

	public GymBooking(GymSession gymSession, double duration, double rate) {
		this.gymSession = gymSession;
		this.duration = duration;
		this.rate = rate;
	}
}