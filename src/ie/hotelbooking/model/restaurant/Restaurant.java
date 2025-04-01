package ie.hotelbooking.model.restaurant;


public class Restaurant {
	private Table[] tables;
	private int capacity;

	public Restaurant() {}
	public Restaurant(Table[] tables, int capacity) {
		this.tables = tables;
		this.capacity = capacity;
	}
}