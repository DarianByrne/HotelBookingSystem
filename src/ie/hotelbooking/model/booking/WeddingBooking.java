package ie.hotelbooking.model.booking;

import ie.hotelbooking.model.Database;
import ie.hotelbooking.model.location.*;
import javafx.scene.chart.PieChart.Data;

import java.sql.*;

public class WeddingBooking extends Booking {

	private int bookingID;
	private String venue;
	private Date date;
	private int numOfGuests;
	private boolean civil;
	private boolean indoor;
	private boolean afterParty;
	private boolean dinner;
	private String groomName;
	private String brideName;

	public WeddingBooking() {}


	public WeddingBooking(int bookingID, String venue, Date date, int numOfGuests, boolean civil, boolean indoor, boolean afterParty, boolean dinner, String groomName, String brideName) {
		this.bookingID = bookingID;
		this.venue = venue;
		this.date = date;
		this.numOfGuests = numOfGuests;
		this.civil = civil;
		this.indoor = indoor;
		this.afterParty = afterParty;
		this.dinner = dinner;
		this.groomName = groomName;
		this.brideName = brideName;
	}

	public int getBookingID() {
		return bookingID;
	}

	public void setBookingID(int bookingID) {
		this.bookingID = bookingID;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getNumOfGuests() {
		return numOfGuests;
	}

	public void setNumOfGuests(int numOfGuests) {
		this.numOfGuests = numOfGuests;
	}

	public boolean isCivil() {
		return civil;
	}

	public void setCivil(boolean civil) {
		this.civil = civil;
	}

	public boolean isIndoor() {
		return indoor;
	}

	public void setIndoor(boolean indoor) {
		this.indoor = indoor;
	}

	public boolean isAfterParty() {
		return afterParty;
	}

	public void setAfterParty(boolean afterParty) {
		this.afterParty = afterParty;
	}

	public boolean isDinner() {
		return dinner;
	}

	public void setDinner(boolean dinner) {
		this.dinner = dinner;
	}

	public String getGroomName() {
		return groomName;
	}

	public void setGroomName(String groomName) {
		this.groomName = groomName;
	}

	public String getBrideName() {
		return brideName;
	}

	public void setBrideName(String brideName) {
		this.brideName = brideName;
	}
	//wedding_booking
	public void addWeddingBooking(WeddingBooking weddingbooking) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int bookingID = weddingbooking.getBookingID();
		String venue = weddingbooking.getVenue();
		Date date = weddingbooking.getDate();
		int numOfGuests = weddingbooking.getNumOfGuests();
		boolean civil = weddingbooking.isCivil();
		boolean indoor = weddingbooking.isIndoor();
		boolean afterParty = weddingbooking.isAfterParty();
		boolean dinner = weddingbooking.isDinner();
		String groomName = weddingbooking.getGroomName();
		String brideName = weddingbooking.getBrideName();
		int i = 0;

		try {
			connection = Database.getConnection();
			preparedStatement = connection.prepareStatement("INSERT INTO wedding_booking (bookingID, venue, date, numOfGuests, civil, indoor, afterParty, dinner, groomName, brideName) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			preparedStatement.setInt(1, bookingID);
			preparedStatement.setString(2, venue);
			preparedStatement.setDate(3, date);
			preparedStatement.setInt(4, numOfGuests);
			preparedStatement.setBoolean(5, civil);
			preparedStatement.setBoolean(6, indoor);
			preparedStatement.setBoolean(7, afterParty);
			preparedStatement.setBoolean(8, dinner);
			preparedStatement.setString(9, groomName);
			preparedStatement.setString(10, brideName);
			i = preparedStatement.executeUpdate();
			System.out.println(i + " record successfully added to the wedding_booking table");
		} catch(SQLException sqlException) {
			sqlException.printStackTrace();
		} finally {
			try {
				if(connection != null) connection.close();
				if(preparedStatement != null) preparedStatement.close();
			} catch(Exception exception) {
				exception.printStackTrace();
			}
		}
	}

	public void updateWeddingBooking(WeddingBooking weddingbooking) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int bookingID = weddingbooking.getBookingID();
		String venue = weddingbooking.getVenue();
		Date date = weddingbooking.getDate();
		int numOfGuests = weddingbooking.getNumOfGuests();
		boolean civil = weddingbooking.isCivil();
		boolean indoor = weddingbooking.isIndoor();
		boolean afterParty = weddingbooking.isAfterParty();
		boolean dinner = weddingbooking.isDinner();
		String groomName = weddingbooking.getGroomName();
		String brideName = weddingbooking.getBrideName();
		int i = 0;

		try {
			connection = Database.getConnection();
			preparedStatement = connection.prepareStatement("UPDATE wedding_booking SET venue=?, date=?, numOfGuests=?, civil=?, indoor=?, afterParty=?, dinner=?, groomName=?, brideName=? WHERE bookingID=?");
			preparedStatement.setString(1, venue);
			preparedStatement.setDate(2, date);
			preparedStatement.setInt(3, numOfGuests);
			preparedStatement.setBoolean(4, civil);
			preparedStatement.setBoolean(5, indoor);
			preparedStatement.setBoolean(6, afterParty);
			preparedStatement.setBoolean(7, dinner);
			preparedStatement.setString(8, groomName);
			preparedStatement.setString(9, brideName);
			preparedStatement.setInt(10, bookingID);
			i = preparedStatement.executeUpdate();
			System.out.println(i + " record successfully updated in the wedding_booking table");
		} catch(SQLException sqlException) {
			sqlException.printStackTrace();
		} finally {
			try {
				if(connection != null) connection.close();
				if(preparedStatement != null) preparedStatement.close();
			} catch(Exception exception) {
				exception.printStackTrace();
			}
		}
	}

	public void deleteWeddingBooking(WeddingBooking weddingBooking) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int bookingID = weddingBooking.getBookingID();
		int i = 0;

		try{
			connection = Database.getConnection();
			preparedStatement = connection.prepareStatement("DELETE FROM wedding_booking WHERE bookingID=?");
			preparedStatement.setInt(1, bookingID);
			i = preparedStatement.executeUpdate();
			System.out.println(i + " record successfully deleted from the wedding_booking table");
		} catch(SQLException sqlException) {
			sqlException.printStackTrace();
		} finally {
			try {
				if(connection != null) connection.close();
				if(preparedStatement != null) preparedStatement.close();
			} catch(Exception exception) {
				exception.printStackTrace();
			}
		}
	}

}