package ie.hotelbooking.model.booking;

import ie.hotelbooking.model.restaurant.*;
import ie.hotelbooking.model.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.Time;

/**
 * RestaurantReservation class that extends from the superclass Booking
 */
public class RestaurantReservation extends Booking {
	private int reservationID;
	private Date arrivalDate;
	private Time arrivalTime;
	private Table table;
	private int tableNumber;
	private int numberOfGuests;

	/**
	 * RestaurantReservation constructor method that instantiates a new RestaurantReservation object without arguments
	 */
	public RestaurantReservation() {
		super();
	}

	/**
	 * RestaurantReservation constructor method that instantiates a new RestaurantReservation object with arguments
	 * passed as parameters
	 * @param table a table object of the type Table
	 * @param numberOfGuests a numberOfGuests variable of the type int
	 * @param arrivalDate an arrivalDate object of the type Date
	 * @param arrivalTime an arrivalTime object of the type Time
	 */
	public RestaurantReservation(Table table, int numberOfGuests, Date arrivalDate, Time arrivalTime) {
		super();
		setReservationID();
		setTable(table);
		setNumberOfGuests(numberOfGuests);
		this.setArrivalDate(arrivalDate);
		this.setArrivalTime(arrivalTime);
		this.tableNumber = table.getTableNumber();
	}

	/**
	 * Getter method for the instance variable reservationID
	 * @return the integer variable reservationID
	 */
	public int getReservationID() {
		return reservationID;
	}

	/**
	 * Setter method for setting the instance variable reservationID
	 */
	public void setReservationID() {
		this.reservationID = this.getBookingID();
	}

	/**
	 * Getter method for the instance variable table
	 * @return an object of the type Table
	 */
	public Table getTable() {
		return table;
	}

	/**
	 * Setter method for setting the instance variable table
	 * @param table an object of the type Table
	 */
	public void setTable(Table table) {
		this.table = table;
	}

	/**
	 * Getter method for the instance variable numberOfGuests
	 * @return the numberOfGuests variable of the type int
	 */
	public int getNumberOfGuests() {
		return numberOfGuests;
	}

	/**
	 * Setter method for setting the instance variable numberOfGuests
	 * @param numberOfGuests a variable of the type int
	 */
	public void setNumberOfGuests(int numberOfGuests) {
		this.numberOfGuests = numberOfGuests;
	}

	/**
	 * CRUD method for inserting a restaurant reservation into the restaurant_reservation table in
	 * the database
	 */
	public void addReservation() {
		this.addBooking();
		Connection con = null;
		PreparedStatement ps = null;
		int i = 0;

		try {
			con = Database.getConnection();
			ps = con.prepareStatement("INSERT INTO restaurant_reservation (date, time, numberOfGuests, tableNumber) VALUES (?,?,?,?,?)");
			ps.setDate(1, this.getArrivalDate());
			ps.setTime(2, this.getArrivalTime());
			ps.setInt(3, getNumberOfGuests());
			ps.setInt(4, getTable().getTableNumber());
			i = ps.executeUpdate();
			System.out.println(i + " restaurant reservation added");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
				ps.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * CRUD method for updating a restaurant reservation row in the restaurant_reservation table in
	 * the database
	 */
	public void updateReservation() {
		this.updateBooking();
		Connection con = null;
		PreparedStatement ps = null;
		int i = 0;

		try {
			con = Database.getConnection();
			ps = con.prepareStatement("UPDATE restaurant_reservation SET date=?, time=?, numberOfGuests=?, tableNumber=? WHERE bookingID=?");
			ps.setDate(1, this.getArrivalDate());
			ps.setTime(2, this.getArrivalTime());
			ps.setInt(3, getNumberOfGuests());
			ps.setInt(4, getTable().getTableNumber());
			ps.setInt(5, getReservationID());
			i = ps.executeUpdate();
			System.out.println(i + " restaurant reservation updated");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
				ps.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * CRUD method for deleting a restaurant reservation row in the restaurant_reservation table in
	 * the database
	 */
	public void deleteReservation() {
		this.deleteBooking();
		Connection con = null;
		PreparedStatement ps = null;
		int i = 0;

		try {
			con = Database.getConnection();
			ps = con.prepareStatement("DELETE FROM restaurant_reservation WHERE bookingID=?");
			ps.setInt(1, getReservationID());
			i = ps.executeUpdate();
			System.out.println(i + " restaurant reservation deleted");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
				ps.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}