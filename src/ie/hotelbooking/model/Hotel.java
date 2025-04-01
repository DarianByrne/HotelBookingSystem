package ie.hotelbooking.model;

import ie.hotelbooking.model.information.Schedule;
import ie.hotelbooking.model.location.*;


public class Hotel {
	private String name;
	private String address;
	private int phoneNumber;
	private Room[] rooms;
	private Venue[] venues;
	private Schedule[] schedules;

	public Hotel() {}
	public Hotel(String name, String address, int phoneNumber, Room[] rooms, Venue[] venues, Schedule[] schedules) {
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.rooms = rooms;
		this.venues = venues;
		this.schedules = schedules;
	}
}