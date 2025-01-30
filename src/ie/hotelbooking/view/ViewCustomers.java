package ie.hotelbooking.view;

import ie.hotelbooking.model.Database;

import java.sql.*;

public class ViewCustomers {
    private ViewCustomers() {}
    public static void displayCustomers() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = Database.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM customer");
            resultSet = preparedStatement.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int numberOfColumns = metaData.getColumnCount();
            System.out.println("Hotel -> customer Table\n");

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
}
