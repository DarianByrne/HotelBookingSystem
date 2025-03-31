package ie.hotelbooking.model.spa;


public class SpaService {
	private int spaServiceID;
	private static int spaServiceCounter = 0;
	private String name;
	private float rate;

	public SpaService() {}
	public SpaService(String name, float rate) {
		this.name = name;
		this.rate = rate;
	}
	public int getSpaServiceID() {
		return spaServiceID;
	}
	public void setSpaServiceID() {
		spaServiceID = spaServiceCounter++;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getRate() {
		return rate;
	}
	public void setRate(float rate) {
		this.rate = rate;
	}
}