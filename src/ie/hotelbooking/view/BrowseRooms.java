package ie.hotelbooking.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import static ie.hotelbooking.Main.changeScreen;

/**
 * the browse rooms panel
 */
public class BrowseRooms extends JPanel {
	private final JLabel label1;
	private final JComboBox<String> roomTypeComboBox;
	private final JLabel label2;
	private final JButton viewAvailabilityButton;

	/**
	 * generates the browse rooms panel
	 */
	public BrowseRooms() {
		label1 = new JLabel("Select a room type");
		add(label1);

		String[] roomTypes = {"Single", "Double", "King"};
		roomTypeComboBox = new JComboBox<>(roomTypes);
		roomTypeComboBox.addItemListener(this::itemStateChanged);
		add(roomTypeComboBox);

		label2 = new JLabel("Room Type");
		add(label2);

		viewAvailabilityButton = new JButton("View Availability");
		viewAvailabilityButton.addActionListener(this::actionPerformed);
		add(viewAvailabilityButton);
	}

	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == roomTypeComboBox) {
			label2.setText(roomTypeComboBox.getSelectedItem() + " selected");
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == viewAvailabilityButton) {
			changeScreen(new ViewAvailability(roomTypeComboBox.getSelectedItem() + " size bedroom"));
		}
	}
}
