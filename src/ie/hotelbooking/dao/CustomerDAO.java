package ie.hotelbooking.dao;

import ie.hotelbooking.model.Customer.*;
import ie.hotelbooking.util.*;

import java.sql.*;

public class CustomerDAO {
    Database database = new Database();
    Connection connection = null;
    PreparedStatement preparedStatement = null;

    public void addCustomer(Customer customer) {
        String name = customer.getName();
        String phoneNumber = customer.getPhoneNumber();
        String email = customer.getEmail();
        Date dateOfBirth = customer.getDateOfBirth();
        String address = customer.getAddress();
        int i = 0;

        try {
            connection = DriverManager.getConnection(database.getDatabaseURL(), database.getDatabaseUser(), database.getDatabasePassword());
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
    public Customer getCustomer(Customer customer) {
        return customer;
    }
    public void updateCustomer(Customer customer) {}
    public void deleteCustomer(Customer customer) {
        String name = "Kyle Purcell";
        int i = 0;

        try {
            connection = DriverManager.getConnection(database.getDatabaseURL(), database.getDatabaseUser(), database.getDatabasePassword());
            preparedStatement = connection.prepareStatement("DELETE FROM customer WHERE name=?");
            preparedStatement.setString(1, name);
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
