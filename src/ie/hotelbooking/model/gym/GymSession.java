package ie.hotelbooking.model.gym;

/**
 * GymSession class represents a gym session in the hotel booking system.
 */
public class GymSession {
	private int gymSessionID;
	private static int gymSessionIDCounter = 0;
	private String name;
	private double rate;
	/**
	 * Default constructor
	 */
	public GymSession() {}
	public GymSession(String name, double rate) {
		setName(name);
		setRate(rate);
	}
	/**
	 * Getter method for the instance variable gymSessionID
	 * @return the Gym Session ID of the GymSession object
	 */
	public int getGymSessionID() {
		return gymSessionID;
	}
	/**
	 * Setter method for the instance variable gymSessionID
	 */
	public void setGymSessionID() {
		gymSessionID = gymSessionIDCounter++;
	}
	/**
	 * Getter method for the instance variable gymSessionIDCounter
	 * @return the Gym Session ID Counter of the GymSession object
	 */
	public String getName() {
		return name;
	}
	/**
	 * Setter method for the instance variable gymSessionIDCounter
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Getter method for the instance variable rate
	 * @return the Rate of the GymSession object
	 */
	public double getRate() {
		return rate;
	}
	/**
	 * Setter method for the instance variable rate
	 */
	public void setRate(double rate) {
		this.rate = rate;
	}
}