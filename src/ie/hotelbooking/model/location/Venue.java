package ie.hotelbooking.model.location;

/**
 *
 */
public class Venue {
	private String name;
	private int capacity;

	public Venue() {}
	public Venue(String name, int capacity) {
		this.name = name;
		this.capacity = capacity;
	}

	public String getName() {
		return name;
	}
	public int getCapacity() {return capacity;}
	public void setName(String name) {this.name = name;}
	public void setCapacity(int capacity) {this.capacity = capacity;}
}