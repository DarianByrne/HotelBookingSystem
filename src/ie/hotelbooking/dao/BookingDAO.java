package ie.hotelbooking.dao;

import ie.hotelbooking.model.Booking.Booking;
import ie.hotelbooking.util.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class BookingDAO {
    public void addBooking(Booking booking) {
        Database database = new Database();
        Connection connection = null;
        PreparedStatement preparedStatement = null;


    }
    public void displayBooking(Booking booking) {
    }
    public void updateBooking(Booking booking) {}
    public void deleteBooking(Booking booking) {}
}
