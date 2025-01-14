package ie.hotelbooking.database;

import ie.hotelbooking.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection extends Database {
    public static void main(String[] args) {
        Database database = new Database();

        try(Connection connection = DriverManager.getConnection(database.getDatabaseURL(), database.getDatabaseUser(), database.getDatabasePassword())) {
            System.out.println("Connection successful!");
        } catch(SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
}
