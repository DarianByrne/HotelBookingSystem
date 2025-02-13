package ie.hotelbooking.model.gym;

/**
 *
 */
public class GymSession {
	private int gymSessionID;
	private static int gymSessionIDCounter = 0;
	private String name;
	private double rate;

	public GymSession() {}
	public GymSession(String name, double rate) {
		setName(name);
		setRate(rate);
	}
	public int getGymSessionID() {
		return gymSessionID;
	}
	public void setGymSessionID() {
		gymSessionID = gymSessionIDCounter++;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
}