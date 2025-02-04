package ie.hotelbooking.model.booking;

import java.sql.*;

import ie.hotelbooking.model.Database;
import ie.hotelbooking.model.information.Payment;
import ie.hotelbooking.model.customer.Customer;

public class Booking {
    private int bookingID;
    private Customer customer;
    private Date date;
    private Time time;
    private Payment payment;

    public Booking() {}

    public Booking(Customer customer, Date date, Time time, Payment payment) {
        this.customer = customer;
        this.date = date;
        this.time = time;
        this.payment = payment;
    }

    public int getBookingID() {
        return bookingID;
    }
    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
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
    public void updateBooking() {}
    public void deleteBooking() {}
}