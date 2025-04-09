package ie.hotelbooking.model.booking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Date;

import ie.hotelbooking.model.Database;
import ie.hotelbooking.model.information.Payment;
import ie.hotelbooking.model.customer.Customer;

/**
 * The booking class for all booking objects
 */
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

    /**
     * Booking constructor method for instantiating a Booking type object without arguments
     */
    public Booking() {
        setBookingID();
    }

    /**
     * Booking constructor method for instantiating a Booking type object with arguments passed as parameters
     * @param customer an object of the type Customer
     * @param arrivalDate an object of the type Date
     * @param arrivalTime an object of the type Time
     * @param departureDate an object of the type Date
     * @param departureTime an object of the type Time
     * @param payment an object of the type Payment
     */
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

    /**
     * Getter method for the instance variable bookingID
     * @return the Booking ID of the Booking object
     */
    public int getBookingID() {
        return bookingID;
    }

    /**
     * Setter method for setting the instance variable bookingID
     */
    public void setBookingID() {
        bookingID = bookingIDCounter++;
    }

    /**
     * Getter method for the instance variable paymentID
     * @return the Payment ID associated with the Payment object
     */
    public int getPaymentID() {
        return paymentID;
    }

    /**
     * Getter method for the instance variable customerID
     * @return the Customer ID associated with the Booking object
     */
    public int getCustomerID() {
        return customerID;
    }

    /**
     * Setter method for setting the instance variable customerID
     */
    public void setCustomerID() {
        customerID = customer.getCustomerID();
    }

    /**
     * Setter method for setting the instance variable paymentID
     */
    public void setPaymentID() {
        paymentID = payment.getPaymentID();
    }

    /**
     * Getter method for the instance variable customer
     * @return the Customer object
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Setter method for setting the instance variable customer
     * @param customer an object of the type Customer
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * Getter method for the instance variable payment
     * @return the Payment object
     */
    public Payment getPayment() {
        return payment;
    }

    /**
     * Setter method for setting the instance variable payment
     * @param payment an object of the type Payment
     */
    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    /**
     * Getter method for the instance variable arrivalDate
     * @return the arrivalDate object
     */
    public Date getArrivalDate() {
        return arrivalDate;
    }

    /**
     * Setter method for setting the instance variable arrivalDate
     * @param arrivalDate an object of the type arrivalDate
     */
    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    /**
     * Getter method for the instance variable arrivalTime
     * @return an arrivalTime object of the type Time
     */
    public Time getArrivalTime() {
        return arrivalTime;
    }

    /**
     * Setter method for setting the instance variable arrivalTime
     * @param arrivalTime an object of the type Time
     */
    public void setArrivalTime(Time arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    /**
     * Getter method for the instance variable departureDate
     * @return a departureDate object of the type Date
     */
    public Date getDepartureDate() {
        return departureDate;
    }

    /**
     * Setter method for setting the instance variable departureDate
     * @param departureDate a departureDate object of the type Date
     */
    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    /**
     * Getter method for the instance variable departureTime
     * @return a departureTime object of the type Time
     */
    public Time getDepartureTime() {
        return departureTime;
    }

    /**
     * Setter method for setting the instance variable departureTime
     * @param departureTime a departureTime object of the type Time
     */
    public void setDepartureTime(Time departureTime) {
        this.departureTime = departureTime;
    }

    /**
     * CRUD method for adding a booking into the booking table in the database
     */
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

    /**
     * CRUD method for updating a booking row in the booking table in the database
     */
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

    /**
     * CRUD method for deleting a booking row in the booking table in the database
     */
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