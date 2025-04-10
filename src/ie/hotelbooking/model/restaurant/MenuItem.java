package ie.hotelbooking.model.restaurant;

/**
 * MenuItem class
 */
public class MenuItem {
	private String name;
	private float price;

	/**
	 * Default constructor
	 */
	public MenuItem() {}

	/**
	 * Default constructor that takes multiple arguments
	 * @param name a variable of the type String
	 * @param price a variable of the type float
	 */
	public MenuItem(String name, float price) {
		this.name = name;
		this.price = price;
	}
}