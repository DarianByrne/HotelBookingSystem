package ie.hotelbooking.model;

import ie.hotelbooking.model.information.Schedule;
import ie.hotelbooking.model.location.*;

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