package ie.hotelbooking.model.spa;


public class Spa {
	private SpaService[] spaServices;
	private int capacity;

	public Spa() {}
	public Spa(SpaService[] spaServices, int capacity) {
		this.spaServices = spaServices;
		this.capacity = capacity;
	}
}