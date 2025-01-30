package ie.hotelbooking.view;

import ie.hotelbooking.model.Database;

import java.sql.*;

public class ViewPayments {
    private ViewPayments() {}
    public static void displayPayments() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = Database.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM payment");
            resultSet = preparedStatement.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int numberOfColumns = metaData.getColumnCount();
            System.out.println("Hotel -> Payment Table");

            for(int i = 1; i <= numberOfColumns; i++) {
                System.out.printf("%-15s", metaData.getColumnName(i));
            }
            System.out.println();
            for(int i = 1; i <= numberOfColumns; i++) {
                System.out.print("-------------");
            }
            System.out.println();
            while(resultSet.next()) {
                for (int i = 1; i <= numberOfColumns; i++) {
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
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
}
