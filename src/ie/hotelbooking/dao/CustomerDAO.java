package ie.hotelbooking.dao;

import ie.hotelbooking.model.Customer.*;
import ie.hotelbooking.util.*;
import ie.hotelbooking.model.Information.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Date;

public class CustomerDAO {
    public void addCustomer(Customer customer) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String name = customer.getName();
        String phoneNumber = customer.getPhoneNumber();
        String email = customer.getEmail();
        Date dateOfBirth = customer.getDateOfBirth();
        String address = customer.getAddress();
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
    public Customer getCustomer(String name) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Customer customer = new Customer();

        try {
            connection = Database.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM customer WHERE name=?");
            preparedStatement.setString(1, name);
            resultSet = preparedStatement.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();

            while(resultSet.next()) {
                customer.setCustomerID(resultSet.getInt(1));
                customer.setName(resultSet.getString(2));
                customer.setPhoneNumber(resultSet.getString(3));
                customer.setEmail(resultSet.getString(4));
                customer.setDateOfBirth(resultSet.getDate(5));
                customer.setAddress(resultSet.getString(6));
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            try {
                if(connection != null) connection.close();
                if(preparedStatement != null) preparedStatement.close();
                if(resultSet != null) resultSet.close();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
        return customer;
    }
    public void updateCustomer(Customer customer, String nameToUpdate) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String name = customer.getName();
        String phoneNumber = customer.getPhoneNumber();
        String email = customer.getEmail();
        Date dateOfBirth = customer.getDateOfBirth();
        String address = customer.getAddress();
        int i = 0;

        try {
            connection = Database.getConnection();
            preparedStatement = connection.prepareStatement("UPDATE customer SET name=?, phoneNumber=?, email=?, dateOfBirth=?, address=? WHERE name=?");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, phoneNumber);
            preparedStatement.setString(3, email);
            preparedStatement.setDate(4, dateOfBirth);
            preparedStatement.setString(5, address);
            preparedStatement.setString(6, nameToUpdate);
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
    public void deleteCustomer(Customer customer)
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String name = "Kyle Purcell";
        int i = 0;

        try {
            connection = Database.getConnection();
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
