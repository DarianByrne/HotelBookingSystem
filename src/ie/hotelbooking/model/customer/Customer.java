package ie.hotelbooking.model.customer;

import ie.hotelbooking.model.Database;

import java.sql.*;

/**
 * Customer class represents a customer in the hotel booking system.
 */
public class Customer {
	private int customerID;
	private static int customerIDCounter = 0;
	private String name;
	private String phoneNumber;
	private String email;
	private Date dateOfBirth;
	private String address;

	/**
	 * Default constructor
	 */
	public Customer() {
		setCustomerID();
	}

	/**
	 * Constructor with parameters
	 * @param name
	 * @param phoneNumber
	 * @param email
	 * @param dateOfBirth
	 * @param address
	 */
	public Customer(String name, String phoneNumber, String email, Date dateOfBirth, String address) {
		setCustomerID();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
	}
	/**
	 * Getter method for the instance variable customerID
	 * @return the Customer ID of the Customer object
	 */
	public int getCustomerID() {
		return customerID;
	}
	/**
	 * Setter method for the instance variable customerID
	 */
	public void setCustomerID() {
		customerID = customerIDCounter++;
	}
	/**
	 * Getter method for the instance variable customerIDCounter
	 * @return the Customer ID Counter of the Customer object
	 */
	public String getName() {
		return name;
	}
	/**
	 * Setter method for the instance variable customerIDCounter
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Getter method for the instance variable customerIDCounter
	 * @return the Customer ID Counter of the Customer object
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * Setter method for the instance variable customerIDCounter
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	/**
	 * Getter method for the instance variable customerIDCounter
	 * @return the Customer ID Counter of the Customer object
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * Setter method for the instance variable customerIDCounter
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * Getter method for the instance variable customerIDCounter
	 * @return the Customer ID Counter of the Customer object
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	/**
	 * Setter method for the instance variable customerIDCounter
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	/**
	 * Getter method for the instance variable customerIDCounter
	 * @return the Customer ID Counter of the Customer object
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * Setter method for the instance variable customerIDCounter
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * CRUD method to add customer detials into the database
	 */

	public void addCustomer() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int i = 0;

		try {
			connection = Database.getConnection();
			preparedStatement = connection.prepareStatement("INSERT INTO customer(name, phoneNumber, email, dateOfBirth, address) VALUES(?, ?, ?, ?, ?);");
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, phoneNumber);
			preparedStatement.setString(3, email);
			preparedStatement.setDate(4, dateOfBirth);
			preparedStatement.setString(5, address);
			i = preparedStatement.executeUpdate();
			System.out.println(i + " record successfully added to the customer table");
		} catch(SQLException sqlException) {
			sqlException.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch(Exception exception) {
				exception.printStackTrace();
			}
		}
	}

	/**
	 * CRUD method to retrieve customer details from the database
	 */
	public void updateCustomer() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int i = 0;

		try {
			connection = Database.getConnection();
			preparedStatement = connection.prepareStatement("UPDATE customer SET name=?, phoneNumber=?, email=?, dateOfBirth=?, address=? WHERE customerID=?");
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, phoneNumber);
			preparedStatement.setString(3, email);
			preparedStatement.setDate(4, dateOfBirth);
			preparedStatement.setString(5, address);
			preparedStatement.setInt(6, customerID);
			i = preparedStatement.executeUpdate();
			System.out.println(i + " record successfully updated in the customer table");
		} catch(SQLException sqlException) {
			sqlException.printStackTrace();
		} finally {
			try {
				connection.close();
				preparedStatement.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * CRUD method to delete customer details from the database
	 */
	public void deleteCustomer()
	{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int i = 0;

		try {
			connection = Database.getConnection();
			preparedStatement = connection.prepareStatement("DELETE FROM customer WHERE customerID=?");
			preparedStatement.setInt(1, customerID);
			i = preparedStatement.executeUpdate();
			System.out.println(i + " record successfully deleted from the customer table");
		} catch(SQLException sqlException) {
			sqlException.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch(Exception exception) {
				exception.printStackTrace();
			}
		}
	}
}