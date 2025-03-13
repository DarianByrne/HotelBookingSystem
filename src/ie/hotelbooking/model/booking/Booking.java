package ie.hotelbooking.model.booking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Date;

import ie.hotelbooking.model.Database;
import ie.hotelbooking.model.information.Payment;
import ie.hotelbooking.model.customer.Customer;

public class Booking {
    
    private int bookingID;
    private static int bookingIDCounter = 0;
    private int paymentID;
    private int customerID;
    private Customer customer;
    private Date arrivalDate;
    private Time arrivalTime;
    private Date departureDate;
    private Time departureTime;
    private Payment payment;

    public Booking() {
        setBookingID();
    }

    public Booking(Customer customer, Date arrivalDate, Time arrivalTime, Date departureDate, Time departureTime, Payment payment) {
        setBookingID();
        setCustomer(customer);
        setArrivalDate(arrivalDate);
        setArrivalTime(arrivalTime);
        setDepartureDate(departureDate);
        setDepartureTime(departureTime);
        setPayment(payment);
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
    public Payment getPayment() {
        return payment;
    }
    public void setPayment(Payment payment) {
        this.payment = payment;
    }
    public Date getArrivalDate() {
        return arrivalDate;
    }
    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }
    public Time getArrivalTime() {
        return arrivalTime;
    }
    public void setArrivalTime(Time arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
    public Date getDepartureDate() {
        return departureDate;
    }
    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }
    public Time getDepartureTime() {
        return departureTime;
    }
    public void setDepartureTime(Time departureTime) {
        this.departureTime = departureTime;
    }

    public void addBooking() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        int i = 0;

        try {
            connection = Database.getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO booking(paymentID, customerID, arrivalDate, departureDate, arrivalTime, departureTime) VALUES(?, ?, ?, ?, ?, ?)");
            preparedStatement.setInt(1, payment.getPaymentID());
            preparedStatement.setInt(2, customer.getCustomerID());
            preparedStatement.setDate(3, getArrivalDate());
            preparedStatement.setDate(4, getDepartureDate());
            preparedStatement.setTime(5, getArrivalTime());
            preparedStatement.setTime(6, getDepartureTime());
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
            preparedStatement = connection.prepareStatement("UPDATE booking SET paymentID=?, customerID=?, arrivalDate=?, departureDate=?, arrivalTime=?, departureTime=? WHERE bookingID=?");
            preparedStatement.setInt(1, getPaymentID());
            preparedStatement.setInt(2, getCustomerID());
            preparedStatement.setDate(3, getArrivalDate());
            preparedStatement.setDate(4, getDepartureDate());
            preparedStatement.setTime(5, getArrivalTime());
            preparedStatement.setTime(6, getDepartureTime());
            preparedStatement.setInt(7, getBookingID());
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