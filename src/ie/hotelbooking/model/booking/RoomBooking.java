package ie.hotelbooking.model.booking;

import ie.hotelbooking.model.Database;
import ie.hotelbooking.model.location.*;

import java.util.Date;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * RoomBooking class that extends from the superclass Booking
 */
public class RoomBooking extends Booking {
	private int roomBookingID;
	private String roomNumber;
	private String roomType;
	private int numberOfGuests;

	/**
	 * RoomBooking constructor method that instantiates a new RoomBooking object without arguments
	 */
	public RoomBooking() {
		super();
	}

	/**
	 * RoomBooking constructor method that instantiates a new RoomBooking object with arguments passed
	 * as parameters
	 * @param roomNumber a variable of the type String
	 * @param roomType a variable of the type String
	 * @param arrivalDate an object of the type Date
	 * @param departureDate an object of the type Date
	 * @param numberOfGuests a variable of the type int
	 */
	public RoomBooking(String roomNumber, String roomType, Date arrivalDate, Date departureDate, int numberOfGuests) {
		super();
		this.roomBookingID = this.getBookingID();
		this.roomNumber = roomNumber;
		this.roomType = roomType;
		this.setArrivalDate((java.sql.Date) arrivalDate);
		this.setDepartureDate((java.sql.Date) departureDate);
		this.numberOfGuests = numberOfGuests;
	}

	/**
	 * Getter method for the instance variable roomNumber
	 * @return the roomNumber variable of the type String
	 */
	public String getRoomNumber() {
		return roomNumber;
	}

	/**
	 * Setter method for setting the instance variable roomNumber
	 * @param roomNumber a variable of the type String
	 */
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	/**
	 * Getter method for the instance variable roomType
	 * @return the roomType variable of the type String
	 */
	public String getRoomType() {
		return roomType;
	}

	/**
	 * Setter method for setting the instance variable roomType
	 * @param roomType a variable of the type String
	 */
	public void setRoomType(String roomType) {
		this.roomType = roomType;
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
	 * CRUD method for inserting a room booking into the room_booking table in the database
	 */
	public void addRoomBooking() {
		this.addBooking();
		Connection con = null;
		PreparedStatement ps = null;
		int i = 0;

		try {
			con = Database.getConnection();
			ps = con.prepareStatement("INSERT INTO  room_booking (roomNumber, arrivalDate, departureDate, numberOfGuests) VALUES (?, ?, ?, ?)");
			ps.setString(1, this.getRoomNumber());
			ps.setDate(2, this.getArrivalDate());
			ps.setDate(3, this.getDepartureDate());
			ps.setInt(4, this.getNumberOfGuests());
			i = ps.executeUpdate();
			System.out.println(i + " record(s) added to the database");
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
	 * CRUD method for updating a room booking row in the room_booking table in the database
	 */
	public void updateRoomBooking() {
		this.updateBooking();
		Connection con = null;
		PreparedStatement ps = null;
		int i = 0;

		try {
			con = Database.getConnection();
			ps = con.prepareStatement("UPDATE room_booking SET roomNumber=?, arrivalDate=?, departureDate=?, numberOfGuests=? WHERE bookingID=?");
			ps.setString(1, this.getRoomNumber());
			ps.setDate(2, this.getArrivalDate());
			ps.setDate(3, this.getDepartureDate());
			ps.setInt(4, this.getNumberOfGuests());
			ps.setInt(5, this.getBookingID());
			i = ps.executeUpdate();
			System.out.println(i + " record(s) updated in the database");
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
	 * CRUD method for deleting a room booking row in the room_booking table in the database
	 */
	public void deleteRoomBooking() {
		this.deleteBooking();
		Connection con = null;
		PreparedStatement ps = null;
		int i = 0;

		try {
			con = Database.getConnection();
			ps = con.prepareStatement("DELETE FROM room_booking WHERE bookingID=?");
			ps.setInt(1, this.getBookingID());
			i = ps.executeUpdate();
			System.out.println(i + " record(s) deleted from the database");
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