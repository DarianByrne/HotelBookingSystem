package ie.hotelbooking.model.booking;

import ie.hotelbooking.model.Database;
import ie.hotelbooking.model.location.*;

import java.sql.*;

/**
 * WeddingBooking class that extends from the superclass Booking
 */
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

	/**
	 * WeddingBooking constructor method that instantiates a new WeddingBooking object without arguments
	 */
	public WeddingBooking() {}

	/**
	 * WeddingBooking constructor method that instantiates a new WeddingBooking object with arguments
	 * passed as parameters
	 * @param bookingID a variable of the type int
	 * @param venue an object of the type Venue
	 * @param date an object of the type Date
	 * @param numOfGuests a variable of the type int
	 * @param civil a variable of the type boolean
	 * @param indoor a variable of the type boolean
	 * @param afterParty a variable of the type boolean
	 * @param dinner a variable of the type boolean
	 * @param groomName a variable of the type String
	 * @param brideName a variable of the type String
	 */
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

	/**
	 * Getter method for the instance variable bookingID
	 * @return the bookingID variable of the type int
	 */
	public int getBookingID() {
		return bookingID;
	}

	/**
	 * Setter method for setting the instance variable bookingID
	 * @param bookingID a variable of the type int
	 */
	public void setBookingID(int bookingID) {
		this.bookingID = bookingID;
	}

	/**
	 * Getter method for the instance variable venue
	 * @return the venue object of the type Venue
	 */
	public String getVenue() {
		return venue;
	}

	/**
	 * Setter method for setting the instance variable venue
	 * @param venue an object of the type Venue
	 */
	public void setVenue(String venue) {
		this.venue = venue;
	}

	/**
	 * Getter method for the instance variable date
	 * @return the date object of the type Date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Setter method for setting the instance variable date
	 * @param date an object of the type Date
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * Getter method for the instance variable numOfGuests
	 * @return the numOfGuests variable of the type int
	 */
	public int getNumOfGuests() {
		return numOfGuests;
	}

	/**
	 * Setter method for setting the instance variable numOfGuests
	 * @param numOfGuests a variable of the type int
	 */
	public void setNumOfGuests(int numOfGuests) {
		this.numOfGuests = numOfGuests;
	}

	/**
	 * Getter method for the instance variable civil
	 * @return the civil variable of the type boolean
	 */
	public boolean isCivil() {
		return civil;
	}

	/**
	 * Setter method for setting the instance variable civil
	 * @param civil a variable of the type boolean
	 */
	public void setCivil(boolean civil) {
		this.civil = civil;
	}

	/**
	 * Getter method for the instance variable indoor
	 * @return the indoor variable of the type boolean
	 */
	public boolean isIndoor() {
		return indoor;
	}

	/**
	 * Setter method for setting the instance variable indoor
	 * @param indoor a variable of the type indoor
	 */
	public void setIndoor(boolean indoor) {
		this.indoor = indoor;
	}

	/**
	 * Getter method for the instance variable afterParty
	 * @return the afterParty variable of the type boolean
	 */
	public boolean isAfterParty() {
		return afterParty;
	}

	/**
	 * Setter method for setting the instance variable afterParty
	 * @param afterParty a variable of the type boolean
	 */
	public void setAfterParty(boolean afterParty) {
		this.afterParty = afterParty;
	}

	/**
	 * Getter method for the instance variable dinner
	 * @return the dinner variable of the type boolean
	 */
	public boolean isDinner() {
		return dinner;
	}

	/**
	 * Setter method for setting the instance variable dinner
	 * @param dinner a variable of the type boolean
	 */
	public void setDinner(boolean dinner) {
		this.dinner = dinner;
	}

	/**
	 * Getter method for the instance variable groomName
	 * @return the groomName variable of the type String
	 */
	public String getGroomName() {
		return groomName;
	}

	/**
	 * Setter method for setting the instance variable groomName
	 * @param groomName a variable of the type String
	 */
	public void setGroomName(String groomName) {
		this.groomName = groomName;
	}

	/**
	 * Getter method for the instance variable brideName
	 * @return the brideName variable of the type String
	 */
	public String getBrideName() {
		return brideName;
	}

	/**
	 * Setter method for setting the instance variable brideName
	 * @param brideName a variable of the type String
	 */
	public void setBrideName(String brideName) {
		this.brideName = brideName;
	}

	/**
	 * CRUD methodd for inserting a wedding booking into the wedding_booking table in
	 * the database
	 * @param weddingbooking an object of the type WeddingBoooking
	 */
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

	/**
	 * CRUD method for updating a wedding booking row in the wedding_booking table in
	 * the database
	 * @param weddingbooking an object of the type WeddingBooking
	 */
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

	/**
	 * CRUD method for deleting a wedding booking row in the wedding_booking table in
	 * the database
	 * @param weddingBooking an object of the type WeddingBooking
	 */
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