package ie.hotelbooking.model.location;


public class Room {
	private String roomNumber;
	private String roomType;
	private float rate;

	public Room() {}
	public Room(String roomNumber, String roomType, float rate) {
		this.roomNumber = roomNumber;
		this.roomType = roomType;
		this.rate = rate;
	}
}