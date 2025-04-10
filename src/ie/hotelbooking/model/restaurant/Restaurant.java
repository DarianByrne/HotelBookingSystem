package ie.hotelbooking.model.restaurant;

/**
 * Restaurant class
 */
public class Restaurant {
	private Table[] tables;
	private int capacity;

	/**
	 * Default constructor
	 */
	public Restaurant() {}

	/**
	 * Default constructor that takes multiple arguments
	 * @param tables an array of objects of the type Table
	 * @param capacity a variable of the type int
	 */
	public Restaurant(Table[] tables, int capacity) {
		this.tables = tables;
		this.capacity = capacity;
	}
}