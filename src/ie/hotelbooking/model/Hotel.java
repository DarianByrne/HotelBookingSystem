package ie.hotelbooking.model;

import ie.hotelbooking.Information.Schedule;
import ie.hotelbooking.Location.Room;
import ie.hotelbooking.Location.Venue;

/**
 *
 */
public class Hotel {

	/**
	 * Default constructor
	 */
	public Hotel() {
	}

	/**
	 *
	 */
	private String name;

	/**
	 *
	 */
	private String address;

	/**
	 *
	 */
	private int phoneNumber;

	/**
	 *
	 */
	private Room[] rooms;

	/**
	 *
	 */
	private Venue[] venues;

	/**
	 *
	 */
	private Schedule[] schedules;

}