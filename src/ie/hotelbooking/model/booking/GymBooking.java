package ie.hotelbooking.model.booking;

import ie.hotelbooking.model.Database;
import ie.hotelbooking.model.gym.*;
import ie.hotelbooking.model.customer.Customer;
import ie.hotelbooking.model.information.Payment;
import java.sql.Date;
import java.sql.Time;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * GymBooking class that extends from the superclass Booking
 */
public class GymBooking extends Booking {
	private GymSession gymSession;
	private double duration;
	private double rate;

	/**
	 * GymBooking constructor method that instantiates a GymBooking object without arguments
	 */
	public GymBooking() {
		super();
	}

	/**
	 * GymBooking constructor method that instantiates a GymBooking object with arguments passed as parameters
	 * @param gymSession an object of the type GymSession
	 * @param duration a duration variable of the type double
	 * @param rate a rate variable of the type double
	 * @param customer a customer object of the type Customer
	 * @param payment a payment object of the type Payment
	 * @param arrivalDate an arrivalDate object of the type Date
	 * @param departureDate a departureDate object of the type Date
	 * @param arrivalTime an arrivalTime object of the type Time
	 * @param departureTime a departureTime object of the type Time
	 */
	public GymBooking(GymSession gymSession, double duration, double rate, Customer customer, Payment payment, Date arrivalDate, Date departureDate, Time arrivalTime, Time departureTime) {
		super(customer, arrivalDate, arrivalTime, departureDate, departureTime, payment);
		setGymSession(gymSession);
		setDuration(duration);
		setRate(rate);
	}

	/**
	 * Getter method for the instance variable gymSession
	 * @return an object of the type GymSession
	 */
	public GymSession getGymSession() {
		return gymSession;
	}

	/**
	 * Setter method for setting the instance variable gymSession
	 * @param gymSession an object of the type GymSession
	 */
	public void setGymSession(GymSession gymSession) {
		this.gymSession = gymSession;
	}

	/**
	 * Getter method for the instance variable duration
	 * @return a duration variable of the type double
	 */
	public double getDuration() {
		return duration;
	}

	/**
	 * Setter method for setting the instance variable duration
	 * @param duration a variable of the type double
	 */
	public void setDuration(double duration) {
		this.duration = duration;
	}

	/**
	 * Getter method for the instance variable rate
	 * @return a rate variable of the type double
	 */
	public double getRate() {
		return rate;
	}

	/**
	 * Setter method for setting the instance variable rate
	 * @param rate a variable of the type double
	 */
	public void setRate(double rate) {
		this.rate = rate;
	}

	/**
	 * CRUD method for inserting a gym booking into the gym_booking table in the database
	 */
	public void addGymBooking() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int i = 0;

		try {
			connection = Database.getConnection();
			preparedStatement = connection.prepareStatement("INSERT INTO gym_booking (bookingID, date, arrivalTime, departureTime, gymSessionID) VALUES (?, ?, ?, ?, ?)");
			preparedStatement.setInt(1, super.getBookingID());
			preparedStatement.setDate(2, super.getArrivalDate());
			preparedStatement.setTime(3, super.getArrivalTime());
			preparedStatement.setTime(4, super.getDepartureTime());
			preparedStatement.setInt(5, gymSession.getGymSessionID());
			i = preparedStatement.executeUpdate();
			System.out.println(i + " record successfully added to the gym booking database");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
				preparedStatement.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * CRUD method for updating a gym booking row in the gym_booking table in the database
	 */
	public void updateGymBooking() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int i = 0;

		try {
			connection = Database.getConnection();
			preparedStatement = connection.prepareStatement("UPDATE gym_booking SET date=?, arrivalTime=?, departureTime=?, gymSessionID=? WHERE bookingID=?");
			preparedStatement.setDate(1, super.getArrivalDate());
			preparedStatement.setTime(2, super.getArrivalTime());
			preparedStatement.setTime(3, super.getDepartureTime());
			preparedStatement.setInt(4, gymSession.getGymSessionID());
			preparedStatement.setInt(5, super.getBookingID());
			i = preparedStatement.executeUpdate();
			System.out.println(i + " record successfully updated to the gym booking database");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
				preparedStatement.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * CRUD method for deleting a gym booking row in the gym_booking table in the database
	 */
	public void deleteGymBooking() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int i = 0;

		try {
			connection = Database.getConnection();
			preparedStatement = connection.prepareStatement("DELETE FROM gym_booking WHERE bookingID=?");
			preparedStatement.setInt(1, super.getBookingID());
			i = preparedStatement.executeUpdate();
			System.out.println(i + " record successfully deleted to the gym booking database");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
				preparedStatement.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}