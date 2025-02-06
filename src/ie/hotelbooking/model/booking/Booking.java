package ie.hotelbooking.model.booking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ie.hotelbooking.model.Database;
import ie.hotelbooking.model.information.Payment;
import ie.hotelbooking.model.customer.Customer;

public class Booking {
    static int bookingIDCounter = 0;
    private int bookingID;
    private int paymentID;
    private int customerID;
    private Payment payment;
    private Customer customer;

    public Booking(Payment payment, Customer customer) {
        bookingIDCounter++;
        this.bookingID = bookingIDCounter;
        this.payment = payment;
        this.customer = customer;
        setPaymentID();
        setCustomerID();
    }

    public int getBookingID() {
        return bookingID;
    }
    public int getPaymentID() {
        return paymentID;
    }
    public int getCustomerID() {
        return customerID;
    }
    public void setPaymentID() {
        paymentID = payment.getPaymentID();
    }
    public void setCustomerID() {
        customerID = customer.getCustomerID();
    }

    public void addBooking() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        int paymentID = getPaymentID();
        int customerID = getCustomerID();
        int i = 0;

        try {
            connection = Database.getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO booking(paymentID, customerID) VALUES(?, ?)");
            preparedStatement.setInt(1, paymentID);
            preparedStatement.setInt(2, customerID);
            i = preparedStatement.executeUpdate();
            System.out.println(i + " record successfully inserted into booking database");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(connection != null) connection.close();
                if(preparedStatement != null) preparedStatement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public void updateBooking() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        int paymentID = getPaymentID();
        int customerID = getCustomerID();
        int i = 0;

        try {
            connection = Database.getConnection();
            preparedStatement = connection.prepareStatement("UPDATE booking SET paymentID=? customerID=?");
            preparedStatement.setInt(1, paymentID);
            preparedStatement.setInt(2, customerID);
            i = preparedStatement.executeUpdate();
            System.out.println(i + " record successfully updated into booking database");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(connection != null) connection.close();
                if(preparedStatement != null) preparedStatement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public void deleteBooking() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        int bookingID = getBookingID();
        int i = 0;

        try {
            connection = Database.getConnection();
            preparedStatement = connection.prepareStatement("DELETE FROM booking WHERE bookingID=?");
            preparedStatement.setInt(1, bookingID);
            i = preparedStatement.executeUpdate();
            System.out.println(i + " record successfully deleted into booking database");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(connection != null) connection.close();
                if(preparedStatement != null) preparedStatement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}