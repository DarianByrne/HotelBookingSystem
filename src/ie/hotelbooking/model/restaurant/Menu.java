package ie.hotelbooking.model.restaurant;

/**
 * Menu class
 */
public class Menu {
	private MenuItem[] menuItems;

	/**
	 * Default constructor
	 */
	public Menu() {}

	/**
	 * Default constructor that takes an argument
	 * @param menuItems an array of objects of the type MenuItem
	 */
	public Menu(MenuItem[] menuItems) {
		this.menuItems = menuItems;
	}
}