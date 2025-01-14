package ie.hotelbooking.database.customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Date;

public class InsertCustomer {
    public static void main(String[] args) {
        final String databaseUrl = "jdbc:mysql://localhost/hotel_booking_system";
        final String user = "root";
        final String password = "#UiCM5I84evek@";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String name = "Anne Frank";
        String phoneNumber = "1273";
        String email = "anne.freak@hotmail.com";
        Date dateOfBirth = Date.valueOf("1929-06-12");
        String address = "Amsterdam";
        int i = 0;

        try {
            // Establish connection to database
            connection = DriverManager.getConnection(databaseUrl, user, password);
            // Create prepared statement for inserting data into table
            preparedStatement = connection.prepareStatement("INSERT INTO customer(name, phoneNumber, email, dateOfBirth, address) VALUES(?, ?, ?, ?, ?);");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, phoneNumber);
            preparedStatement.setString(3, email);
            preparedStatement.setDate(4, dateOfBirth);
            preparedStatement.setString(5, address);
            i = preparedStatement.executeUpdate();
            System.out.println(i + " records successfully added to the table");
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
