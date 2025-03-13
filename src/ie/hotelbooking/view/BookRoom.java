package ie.hotelbooking.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import ie.hotelbooking.model.booking.*;

import static ie.hotelbooking.Main.changeScreen;

public class BookRoom extends JPanel {
	private final JLabel label1;
	private final JComboBox<String> roomTypeComboBox;
	private final JLabel label2;
	private final JLabel label3;
	private final JSpinner numberOfGuestsSpinner;
	private final JButton continueToBookingButton;

	public BookRoom() {
		label1 = new JLabel("Select a room type");
		add(label1);

		String[] roomTypes = {"Single", "Double", "King"};
		roomTypeComboBox = new JComboBox<>(roomTypes);
		roomTypeComboBox.addItemListener(this::itemStateChanged);
		add(roomTypeComboBox);

		label2 = new JLabel("Room Type");
		add(label2);

		label3 = new JLabel("Number of guests");
		add(label3);

		numberOfGuestsSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 2, 1));
		add(numberOfGuestsSpinner);

		continueToBookingButton = new JButton("Continue to Booking");
		continueToBookingButton.addActionListener(this::actionPerformed);
		add(continueToBookingButton);
	}

	public void itemStateChanged(ItemEvent e) {
//		TODO change property in booking object
		if (e.getSource() == roomTypeComboBox) {
			label2.setText(roomTypeComboBox.getSelectedItem() + " selected");
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == continueToBookingButton) {
			RoomBooking roomBooking = createRoomBooking();
			changeScreen(new BookingPayment(roomBooking));
		}
	}
	public RoomBooking createRoomBooking() {
		RoomBooking roomBooking = new RoomBooking();
		roomBooking.setRoomType((String) roomTypeComboBox.getSelectedItem());
		roomBooking.setNumberOfGuests(Integer.parseInt(numberOfGuestsSpinner.getValue().toString()));
		return roomBooking;
	}
}
