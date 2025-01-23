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
    public void displayCustomers() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = Database.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM customer");
            resultSet = preparedStatement.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int numberOfColumns = metaData.getColumnCount();
            System.out.println("Hotel -> Customer Table\n");

            for(int i = 1; i <= 3; i++) {
                System.out.printf("%-15s", metaData.getColumnName(i));
            }
            for(int i = 4; i < 5; i++) {
                System.out.printf("%-30s", metaData.getColumnName(i));
            }
            for(int i = 5; i <= numberOfColumns; i++) {
                System.out.printf("%-15s", metaData.getColumnName(i));
            }
            System.out.println();
            for(int i = 1; i <= numberOfColumns; i++) {
                System.out.print("-----------------");
            }
            System.out.println();

            while(resultSet.next()) {
                for(int i = 1; i <= 3; i++) {
                    System.out.printf("%-15s", resultSet.getObject(i));
                }
                for(int i = 4; i < 5; i++) {
                    System.out.printf("%-30s", resultSet.getObject(i));
                }
                for(int i = 5; i <= numberOfColumns; i++) {
                    System.out.printf("%-15s", resultSet.getObject(i));
                }
            }
        } catch(SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            try {
                connection.close();
                preparedStatement.close();
                resultSet.close();
            } catch(Exception exception) {
                exception.printStackTrace();
            }
        }
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
