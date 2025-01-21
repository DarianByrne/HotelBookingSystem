package ie.hotelbooking.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String databaseURL = "jdbc:mysql://localhost:3306/hotel_booking_system";
    private static final String databaseUser = "root";
    private static final String databasePassword = "#UiCM5I84evek@";
    private Connection connection;

    private Database() {}

    public Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(databaseURL, databaseUser, databasePassword);
        }
        return connection;
    }
}
