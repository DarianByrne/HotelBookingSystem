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
 *
 */
public class GymBooking extends Booking {
	private GymSession gymSession;
	private double duration;
	private double rate;

	public GymBooking() {
		super();
	}

	public GymBooking(GymSession gymSession, double duration, double rate, Customer customer, Payment payment, Date arrivalDate, Date departureDate, Time arrivalTime, Time departureTime) {
		super(customer, arrivalDate, arrivalTime, departureDate, departureTime, payment);
		setGymSession(gymSession);
		setDuration(duration);
		setRate(rate);
	}

	public GymSession getGymSession() {
		return gymSession;
	}
	public void setGymSession(GymSession gymSession) {
		this.gymSession = gymSession;
	}
	public double getDuration() {
		return duration;
	}
	public void setDuration(double duration) {
		this.duration = duration;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}

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