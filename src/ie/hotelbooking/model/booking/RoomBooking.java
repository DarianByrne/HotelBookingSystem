package ie.hotelbooking.model.booking;

import ie.hotelbooking.model.Database;
import ie.hotelbooking.model.location.*;

import java.util.Date;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class RoomBooking extends Booking {
	private int roomBookingID;
	private String roomNumber;
	private String roomType;
	private Date arrivalDate;
	private Date departureDate;
	private int numberOfGuests;

	public RoomBooking() {
		super();
	}
	public RoomBooking(int roomBookingID, String roomNumber, String roomType, Date arrivalDate, Date departureDate, int numberOfGuests) {
		super();
		this.roomBookingID = this.getBookingID();
		this.roomNumber = roomNumber;
		this.roomType = roomType;
		this.arrivalDate = this.getArrivalDate();
		this.departureDate = this.getDepartureDate();
		this.numberOfGuests = numberOfGuests;
	}
	public String getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public int getNumberOfGuests() {
		return numberOfGuests;
	}
	public void setNumberOfGuests(int numberOfGuests) {
		this.numberOfGuests = numberOfGuests;
	}

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
	public void updateRoomBooking() {
		this.updateBooking();
	}
	public void deleteRoomBooking() {
		this.deleteBooking();
	}
}