package ie.hotelbooking.model.booking;

import ie.hotelbooking.model.Database;
import ie.hotelbooking.model.spa.SpaService;
import java.sql.Date;
import java.sql.Time;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;


public class SpaBooking extends Booking {
	private SpaService spaService;
	private int numberOfGuests;

	public SpaBooking() {
		super();
	}
	public SpaBooking(SpaService spaService, Date arrivalDate, Time arrivalTime, Time departureTime, int numberOfGuests) {
		super();
		this.spaService = spaService;
		this.setArrivalDate(arrivalDate);
		this.setArrivalTime(arrivalTime);
		this.setDepartureTime(departureTime);
		this.numberOfGuests = numberOfGuests;
	}
	public SpaService getSpaService() {
		return spaService;
	}
	public void setSpaService(SpaService spaService) {
		this.spaService = spaService;
	}
	public int getNumberOfGuests() {
		return numberOfGuests;
	}
	public void setNumberOfGuests(int numberOfGuests) {
		this.numberOfGuests = numberOfGuests;
	}

	public void addSpaBooking() {
		this.addBooking();
		Connection con = null;
		PreparedStatement ps = null;
		int i = 0;

		try {
			con = Database.getConnection();
			ps = con.prepareStatement("INSERT INTO spa_booking (date, arrivalTime, departureTime, numberOfGuests, spaServiceID) VALUES (?, ?, ?, ?, ?)");
			ps.setDate(1, this.getArrivalDate());
			ps.setTime(2, this.getArrivalTime());
			ps.setTime(3, this.getDepartureTime());
			ps.setInt(4, this.getNumberOfGuests());
			ps.setInt(5, getSpaService().getSpaServiceID());
			i = ps.executeUpdate();
			System.out.println(i + " rows inserted");
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
	public void updateSpaBooking() {
		this.updateBooking();
		Connection con = null;
		PreparedStatement ps = null;
		int i = 0;
	}
	public void deleteSpaBooking() {
		this.deleteBooking();
		Connection con = null;
		PreparedStatement ps = null;
		int i = 0;
	}
}