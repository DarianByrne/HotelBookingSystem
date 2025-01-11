package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/hotel_booking_system";
        String user = "root";
        String password = "#UiCM5I84evek@";

        try(Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connection successful!");
        } catch(SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
}
