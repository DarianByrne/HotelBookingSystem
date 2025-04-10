package ie.hotelbooking.model.restaurant;

/**
 * Table class
 */
public class Table {
	private int tableNumber;
	private static int tableCounter = 0;

	/**
	 * Default constructor
	 */
	public Table() {
		setTableNumber();
	}

	/**
	 * Getter method for the instance variable tableNumber
	 * @return the tableNumber variable of the type int
	 */
	public int getTableNumber() {
		return tableNumber;
	}

	/**
	 * Setter method for setting the instance variable tableNumber
	 */
	public void setTableNumber() {
		tableCounter++;
		this.tableNumber = tableCounter;
	}
}