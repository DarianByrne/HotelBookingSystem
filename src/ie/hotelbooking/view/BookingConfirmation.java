package ie.hotelbooking.view;

import javax.swing.*;
import java.awt.*;

/**
 * the booking confirmation panel
 */
public class BookingConfirmation extends JPanel{
    private JLabel bookingConfirmationMessage;

    /**
     * generates the booking confirmation panel
     */
    public BookingConfirmation() {
        bookingConfirmationMessage = new JLabel("Booking Confirmed!");
        add(bookingConfirmationMessage);
    }
}
