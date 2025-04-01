package ie.hotelbooking.view;

import javax.swing.*;
import java.awt.*;

public class BookingConfirmation extends JPanel{
    private JLabel bookingConfirmationMessage;

    public BookingConfirmation() {
        bookingConfirmationMessage = new JLabel("Booking Confirmed!");
        add(bookingConfirmationMessage);
    }
}
