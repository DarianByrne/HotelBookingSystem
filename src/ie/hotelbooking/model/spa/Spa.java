package ie.hotelbooking.model.spa;

/**
 * Spa class
 */
public class Spa {
	private SpaService[] spaServices;
	private int capacity;

	/**
	 * Default constructor
	 */
	public Spa() {}

	/**
	 * Default constructor that takes multiple arguments
	 * @param spaServices an array of objects of the type SpaService
	 * @param capacity a variable of the type int
	 */
	public Spa(SpaService[] spaServices, int capacity) {
		this.spaServices = spaServices;
		this.capacity = capacity;
	}
}