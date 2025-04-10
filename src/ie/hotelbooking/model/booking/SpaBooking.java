package ie.hotelbooking.model.booking;

import ie.hotelbooking.model.Database;
import ie.hotelbooking.model.spa.SpaService;
import java.sql.Date;
import java.sql.Time;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * SpaBooking class that extends from the superclass Booking
 */
public class SpaBooking extends Booking {
	private SpaService spaService;
	private int numberOfGuests;

	/**
	 * SpaBooking constructor method that instantiates a new SpaBooking object without arguments
	 */
	public SpaBooking() {
		super();
	}

	/**
	 * SpaBooking constructor method that instantiates a new SpaBooking object with arguments
	 * passed as parameters
	 * @param spaService an object of the type SpaService
	 * @param arrivalDate an object of the type Date
	 * @param arrivalTime an object of the type Time
	 * @param departureTime an object of the type Time
	 * @param numberOfGuests a variable of the type int
	 */
	public SpaBooking(SpaService spaService, Date arrivalDate, Time arrivalTime, Time departureTime, int numberOfGuests) {
		super();
		this.spaService = spaService;
		this.setArrivalDate(arrivalDate);
		this.setArrivalTime(arrivalTime);
		this.setDepartureTime(departureTime);
		this.numberOfGuests = numberOfGuests;
	}

	/**
	 * Getter method for the instance variable spaService
	 * @return the spaService object of the type SpaService
	 */
	public SpaService getSpaService() {
		return spaService;
	}

	/**
	 * Setter method for setting the instance variable spaService
	 * @param spaService an object of the type SpaService
	 */
	public void setSpaService(SpaService spaService) {
		this.spaService = spaService;
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
	 * CRUD method for inserting a spa booking into the spa_booking table in the database
	 */
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

	/**
	 * CRUD method for updating a spa booking row in the spa_booking table in the database
	 */
	public void updateSpaBooking() {
		this.updateBooking();
		Connection con = null;
		PreparedStatement ps = null;
		int i = 0;

		try {
			con = Database.getConnection();
			ps = con.prepareStatement("UPDATE spa_booking SET date=?, arrivalTime=?, departureTime=?, numberOfGuests=?, spaServiceID=? WHERE bookingID=?");
			ps.setDate(1, this.getArrivalDate());
			ps.setTime(2, this.getArrivalTime());
			ps.setTime(3, this.getDepartureTime());
			ps.setInt(4, getNumberOfGuests());
			ps.setInt(5, getSpaService().getSpaServiceID());
			ps.setInt(6, this.getBookingID());
			i = ps.executeUpdate();
			System.out.println(i + " rows updated");
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
				ps.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * CRUD method for deleting a spa booking row in the spa_booking table in the database
	 */
	public void deleteSpaBooking() {
		this.deleteBooking();
		Connection con = null;
		PreparedStatement ps = null;
		int i = 0;

		try {
			con = Database.getConnection();
			ps = con.prepareStatement("DELETE FROM spa_booking WHERE bookingID=?");
			ps.setInt(1, this.getBookingID());
			i = ps.executeUpdate();
			System.out.println(i + " rows deleted");
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
				ps.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}