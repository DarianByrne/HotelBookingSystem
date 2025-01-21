package ie.hotelbooking.dao;


import ie.hotelbooking.model.Information.Payment;
import ie.hotelbooking.util.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.Time;

public class PaymentDAO {
    public void addPayment(Payment payment) {
        Database database = new Database();
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        int customerID = payment.getCustomerID();
        int cardNumber = payment.getCardNumber();
        int cardCVV = payment.getCardCVV();
        Date cardExpiryDate = payment.getCardExpiryDate();
        String cardHolderName = payment.getCardHolderName();
        double amount = payment.getAmount();
        Date date = payment.getDate();
        Time time = payment.getTime();
        int i = 0;

        try {
            connection = DriverManager.getConnection(database.getDatabaseURL(), database.getDatabaseUser(), database.getDatabasePassword());
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
    public void displayPayment(Payment payment) {}
    public void updatePayment(Payment payment) {}
    public void deletePayment(Payment payment) {}
}
