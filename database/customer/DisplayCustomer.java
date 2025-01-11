package database.customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class DisplayCustomer {
    public static void main(String[] args) {
        final String databaseURL = "jdbc:mysql://localhost/hotel_booking_system";
        final String user = "root";
        final String password = "#UiCM5I84evek@";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(databaseURL, user, password);
            preparedStatement = connection.prepareStatement("SELECT * FROM customer");
            resultSet = preparedStatement.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int numberOfColumns = metaData.getColumnCount();
            System.out.println("Customer table of hotel_booking_system database\n");

            for(int i = 1; i <= numberOfColumns; i++) {
                System.out.printf("%-15s", metaData.getColumnName(i));
            }
            System.out.println();
            for(int i = 1; i <= numberOfColumns; i++) {
                System.out.print("--------------");
            }
            System.out.println();
            while(resultSet.next()) {
                for(int i = 1; i <= numberOfColumns; i++) {
                    System.out.printf("%-15s", resultSet.getObject(i));
                }
                System.out.println();
            }
        } catch(SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
                connection.close();
                resultSet.close();
            } catch(Exception exception) {
                exception.printStackTrace();
            }
        }
    }
}
