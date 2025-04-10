package ie.hotelbooking.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Database class
 */
public class Database {
    private static final String databaseURL = "jdbc:mysql://localhost:3306/hotel_booking_system";
    private static final String databaseUser = "root";
    private static final String databasePassword = "#UiCM5I84evek@";
    private static Connection connection;

    /**
     * Default constructor
     */
    private Database() {}

    /**
     * Method that attempts to connect to the database using the static variables
     * @return an object of the type Connection
     * @throws SQLException an object of the type SQLException that extends from the superclass Exception
     */
    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(databaseURL, databaseUser, databasePassword);
        }
        return connection;
    }
}
