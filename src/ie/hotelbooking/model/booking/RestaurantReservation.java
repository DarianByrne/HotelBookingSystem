package ie.hotelbooking.model.booking;

import ie.hotelbooking.model.restaurant.*;
import ie.hotelbooking.model.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.Time;

public class RestaurantReservation extends Booking {
	private int reservationID;
	private Date arrivalDate;
	private Time arrivalTime;
	private Table table;
	private int tableNumber;
	private int numberOfGuests;

	public RestaurantReservation() {
		super();
	}

	public RestaurantReservation(Table table, int numberOfGuests, Date arrivalDate, Time arrivalTime) {
		super();
		setReservationID();
		setTable(table);
		setNumberOfGuests(numberOfGuests);
		this.setArrivalDate(arrivalDate);
		this.setArrivalTime(arrivalTime);
		this.tableNumber = table.getTableNumber();
	}

	public int getReservationID() {
		return reservationID;
	}
	public void setReservationID() {
		this.reservationID = this.getBookingID();
	}
	public Table getTable() {
		return table;
	}
	public void setTable(Table table) {
		this.table = table;
	}
	public int getNumberOfGuests() {
		return numberOfGuests;
	}
	public void setNumberOfGuests(int numberOfGuests) {
		this.numberOfGuests = numberOfGuests;
	}

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