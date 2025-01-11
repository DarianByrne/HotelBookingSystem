package database.customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class DeleteCustomer {
    public static void main(String[] args) {
        final String databaseURL = "jdbc:mysql://localhost/hotel_booking_system";
        final String user = "root";
        final String password = "#UiCM5I84evek@";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int i = 0;
        int customerID = 1;

        try {
            connection = DriverManager.getConnection(databaseURL, user, password);
            preparedStatement = connection.prepareStatement("DELETE FROM customer WHERE customerID=?");
            preparedStatement.setInt(1, customerID);
            i = preparedStatement.executeUpdate();
            System.out.println(i + " records successfully deleted from the table");
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
