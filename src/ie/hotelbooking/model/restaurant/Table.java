package ie.hotelbooking.model.restaurant;


public class Table {
	private int tableNumber;
	private static int tableCounter = 0;
	public Table() {
		setTableNumber();
	}

	public int getTableNumber() {
		return tableNumber;
	}
	public void setTableNumber() {
		tableCounter++;
		this.tableNumber = tableCounter;
	}
}