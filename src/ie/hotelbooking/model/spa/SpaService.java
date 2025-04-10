package ie.hotelbooking.model.spa;

/**
 * SpaService class
 */
public class SpaService {
	private int spaServiceID;
	private static int spaServiceCounter = 0;
	private String name;
	private float rate;

	/**
	 * Default constructor
	 */
	public SpaService() {}

	/**
	 * Default constructor that takes multiple arguments
	 * @param name a variable of the type String
	 * @param rate a variable of the type float
	 */
	public SpaService(String name, float rate) {
		this.name = name;
		this.rate = rate;
	}

	/**
	 * Getter method for the instance variable spaServiceID
	 * @return the spaServiceID variable of the type int
	 */
	public int getSpaServiceID() {
		return spaServiceID;
	}

	/**
	 * Setter method for setting the instance variable spaServiceID
	 */
	public void setSpaServiceID() {
		spaServiceID = spaServiceCounter++;
	}

	/**
	 * Getter method for the instance variable name
	 * @return the name variable of the type String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter method for setting the instance variable name
	 * @param name a variable of the type String
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Getter method for the instance variable rate
	 * @return the rate variable of the type float
	 */
	public float getRate() {
		return rate;
	}

	/**
	 * Setter method for setting the instance variable rate
	 * @param rate a variable of the type float
	 */
	public void setRate(float rate) {
		this.rate = rate;
	}
}