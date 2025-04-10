package ie.hotelbooking.model;

import ie.hotelbooking.model.information.Schedule;
import ie.hotelbooking.model.location.*;

/**
 * Hotel class
 */
public class Hotel {
	private String name;
	private String address;
	private int phoneNumber;
	private Room[] rooms;
	private Venue[] venues;
	private Schedule[] schedules;

	/**
	 * Default constructor
	 */
	public Hotel() {}

	/**
	 * Default constructor that takes multiple arguments
	 * @param name a variable of the type String
	 * @param address a variable of the type String
	 * @param phoneNumber a variable of the type int
	 * @param rooms an array of objects of the type Room
	 * @param venues an array of objects of the type Venue
	 * @param schedules an array of objects of the type Schedule
	 */
	public Hotel(String name, String address, int phoneNumber, Room[] rooms, Venue[] venues, Schedule[] schedules) {
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.rooms = rooms;
		this.venues = venues;
		this.schedules = schedules;
	}
}