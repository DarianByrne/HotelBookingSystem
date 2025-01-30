package ie.hotelbooking.controller;


import ie.hotelbooking.model.information.Payment;
import ie.hotelbooking.model.Database;

import java.sql.*;

public class PaymentController {
    public void addPayment(Payment payment) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        int customerID = payment.getCustomer().getCustomerID();
        int cardNumber = payment.getCardNumber();
        int cardCVV = payment.getCardCVV();
        Date cardExpiryDate = payment.getCardExpiryDate();
        String cardHolderName = payment.getCardHolderName();
        double amount = payment.getAmount();
        Date date = payment.getDate();
        Time time = payment.getTime();
        int i = 0;

        try {
            connection = Database.getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO payment(customerID, cardNumber, cardCVV, cardExpiryDate, cardHolderName, amount, date, time) VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setInt(1, customerID);
            preparedStatement.setInt(2, cardNumber);
            preparedStatement.setInt(3, cardCVV);
            preparedStatement.setDate(4, cardExpiryDate);
            preparedStatement.setString(5, cardHolderName);
            preparedStatement.setDouble(6, amount);
            preparedStatement.setDate(7, date);
            preparedStatement.setTime(8, time);
            i = preparedStatement.executeUpdate();
            System.out.println(i + " record successfully added to the payment table");
        } catch(SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            try {
                if(connection != null) connection.close();
                if(preparedStatement != null) preparedStatement.close();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
    public void displayPayments() {
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
    public void updatePayment(Payment payment) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        int customerID = payment.getCustomer().getCustomerID();
        int cardNumber = payment.getCardNumber();
        int cardCVV = payment.getCardCVV();
        Date cardExpiryDate = payment.getCardExpiryDate();
        String cardHolderName = payment.getCardHolderName();
        double amount = payment.getAmount();
        Date date = payment.getDate();
        Time time = payment.getTime();
        int i = 0;

        try {
            connection = Database.getConnection();
            preparedStatement = connection.prepareStatement("UPDATE payment SET customerID=?, cardNumber=?, cardCVV=?, cardExpiryDate=?, cardHolderName=?, amount=?, date=?, time=?");
            preparedStatement.setInt(1, customerID);
            preparedStatement.setInt(2, cardNumber);
            preparedStatement.setInt(3, cardCVV);
            preparedStatement.setDate(4, cardExpiryDate);
            preparedStatement.setString(5, cardHolderName);
            preparedStatement.setDouble(6, amount);
            preparedStatement.setDate(7, date);
            preparedStatement.setTime(8, time);
            i = preparedStatement.executeUpdate();
            System.out.println(i + " record successfully updated in the payment table");
        } catch(SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            try {
                connection.close();
                preparedStatement.close();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
    public void deletePayment(Payment payment) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        int paymentID = payment.getPaymentID();
        int i = 0;

        try {
            connection = Database.getConnection();
            preparedStatement = connection.prepareStatement("DELETE FROM payment WHERE paymentID=?");
            preparedStatement.setInt(1, paymentID);
            i = preparedStatement.executeUpdate();
            System.out.println(i + " record successfully deleted from the payment table");
        } catch(SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            try {
                connection.close();
                preparedStatement.close();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
}
