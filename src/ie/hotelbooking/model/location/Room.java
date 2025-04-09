package ie.hotelbooking.model.location;

	/**
	 * Room class represents a room in a hotel.
	 */

public class Room {
	private String roomNumber;
	private String roomType;
	private float rate;
	/**
	 * Default constructor
	 */
	public Room() {}
	public Room(String roomNumber, String roomType, float rate) {
		this.roomNumber = roomNumber;
		this.roomType = roomType;
		this.rate = rate;
	}
}