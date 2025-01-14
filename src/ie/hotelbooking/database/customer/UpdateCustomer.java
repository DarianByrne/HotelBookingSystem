package ie.hotelbooking.database.customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Date;

public class UpdateCustomer {
    public static void main(String[] args) {
        final String databaseURL = "jdbc:mysql://localhost/hotel_booking_system";
        final String user = "root";
        final String password = "#UiCM5I84evek@";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        String name = "Max Rudolf";
        String phoneNumber = "083-9876543";
        String email = "max.rudolf@hotmail.com";
        Date dateOfBirth = Date.valueOf("2000-10-12");
        String address = "Kilkenny";
        int i = 0;

        try {
            connection = DriverManager.getConnection(databaseURL, user, password);
            preparedStatement = connection.prepareStatement("UPDATE customer SET name=?, phoneNumber=?, email=?, dateOfBirth=?, address=?");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, phoneNumber);
            preparedStatement.setString(3, email);
            preparedStatement.setDate(4, dateOfBirth);
            preparedStatement.setString(5, address);
            i = preparedStatement.executeUpdate();
            System.out.println(i + " records successfuly updated in the table");
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
