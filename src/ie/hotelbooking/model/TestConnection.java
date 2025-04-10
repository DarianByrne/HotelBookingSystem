package ie.hotelbooking.model;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * TestConnection class
 */
public class TestConnection {
    public static void main(String[] args) {
        try {
            Connection connection = Database.getConnection();
            System.out.println("Connected to database");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
