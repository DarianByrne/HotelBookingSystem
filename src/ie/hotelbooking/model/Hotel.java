package ie.hotelbooking.model;

import ie.hotelbooking.model.Information.Schedule;
import ie.hotelbooking.model.Location.*;

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