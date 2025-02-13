package ie.hotelbooking.model.booking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ie.hotelbooking.model.Database;
import ie.hotelbooking.model.information.Payment;
import ie.hotelbooking.model.customer.Customer;

public class Booking {
    static int bookingIDCounter = 0;
    private final int bookingID;
    private final int paymentID;
    private final int customerID;
    private Payment payment;
    private Customer customer;

    public Booking() {
        this.bookingID = setBookingID();
        this.paymentID = 0;
        this.customerID = 0;
    }

    public Booking(Payment payment, Customer customer) {
        this.bookingID = setBookingID();
        this.payment = payment;
        this.customer = customer;
        this.customerID = setCustomerID();
        this.paymentID = setPaymentID();
    }

    public int getBookingID() {
        return bookingID;
    }
    public int setBookingID() {
        return bookingIDCounter++;
    }
    public int getPaymentID() {
        return paymentID;
    }
    public int getCustomerID() {
        return customerID;
    }
    public int setPaymentID() {
        return payment.getPaymentID();
    }
    public int setCustomerID() {
        return customer.getCustomerID();
    }
    public Payment getPayment() {
        return payment;
    }
    public Customer getCustomer() {
        return customer;
    }
    public void setPayment(Payment payment) {
        this.payment = payment;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
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
            preparedStatement = connection.prepareStatement("UPDATE booking SET paymentID=? customerID=? WHERE bookingID=?");
            preparedStatement.setInt(1, paymentID);
            preparedStatement.setInt(2, customerID);
            preparedStatement.setInt(3, bookingID);
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