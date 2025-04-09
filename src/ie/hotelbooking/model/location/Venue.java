package ie.hotelbooking.model.location;


/**
 * Venue class represents a venue in a hotel.
 */
public class Venue {
	private String name;
	private int capacity;

	/**
	 * Default constructor
	 */
	public Venue() {}
	public Venue(String name, int capacity) {
		this.name = name;
		this.capacity = capacity;
	}
	/**
	 * Constructor with parameters
	 * @param name
	 * @param capacity
	 */
	public String getName() {
		return name;
	}
	public int getCapacity() {return capacity;}
	public void setName(String name) {this.name = name;}
	public void setCapacity(int capacity) {this.capacity = capacity;}
}