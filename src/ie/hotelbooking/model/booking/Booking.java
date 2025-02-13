package ie.hotelbooking.model.booking;

import java.sql.*;

import ie.hotelbooking.model.Database;
import ie.hotelbooking.model.information.Payment;
import ie.hotelbooking.model.customer.Customer;

public class Booking {
    private int bookingID;
    private static int bookingIDCounter = 0;
    private int paymentID;
    private int customerID;
    private Customer customer;
    private Date date;
    private Time time;
    private Payment payment;

    public Booking() {
        setBookingID();
    }

    public Booking(Customer customer, Date date, Time time, Payment payment) {
        setBookingID();
        this.customer = customer;
        this.date = date;
        this.time = time;
        this.payment = payment;
        setPaymentID();
        setCustomerID();
    }

    public int getBookingID() {
        return bookingID;
    }
    public void setBookingID() {
        bookingID = bookingIDCounter++;
    }
    public int getPaymentID() {
        return paymentID;
    }
    public int getCustomerID() {
        return customerID;
    }
    public void setCustomerID() {
        customerID = customer.getCustomerID();
    }
    public void setPaymentID() {
        paymentID = payment.getPaymentID();
    }
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public Time getTime() {
        return time;
    }
    public void setTime(Time time) {
        this.time = time;
    }

    public void addBooking() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        int i = 0;

        try {
            connection = Database.getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO booking(paymentID, customerID) VALUES(?, ?)");
            preparedStatement.setInt(1, payment.getPaymentID());
            preparedStatement.setInt(2, customer.getCustomerID());
            i = preparedStatement.executeUpdate();
            System.out.println(i + " record successfully added to the booking table");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                preparedStatement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public void updateBooking() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int i = 0;

        try {
            connection = Database.getConnection();
            preparedStatement = connection.prepareStatement("UPDATE booking SET paymentID=?, customerID=? WHERE bookingID=?");
            preparedStatement.setInt(1, getPaymentID());
            preparedStatement.setInt(2, getCustomerID());
            preparedStatement.setInt(3, getBookingID());
            i = preparedStatement.executeUpdate();
            System.out.println(i + " record successfully updated to the booking table");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                preparedStatement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public void deleteBooking() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int i = 0;

        try {
            connection = Database.getConnection();
            preparedStatement = connection.prepareStatement("DELETE FROM booking WHERE bookingID=?");
            preparedStatement.setInt(1, getBookingID());
            i = preparedStatement.executeUpdate();
            System.out.println(i + " record successfully deleted to the booking table");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                preparedStatement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}