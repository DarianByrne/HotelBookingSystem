package ie.hotelbooking.model.customer;

import ie.hotelbooking.model.Database;

import java.sql.*;

public class Customer {
	private int customerID;
	private static int customerIDCounter = 0;
	private String name;
	private String phoneNumber;
	private String email;
	private Date dateOfBirth;
	private String address;

	public Customer() {
		setCustomerID();
	}

	public Customer(String name, String phoneNumber, String email, Date dateOfBirth, String address) {
		setCustomerID();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
	}

	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID() {
		customerID = customerIDCounter++;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

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