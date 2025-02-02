package ie.hotelbooking.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

public class BrowseRooms extends JFrame {
	private final JPanel panel1;
	private final JLabel label1;
	private final JComboBox<String> roomTypeComboBox;
	private final JLabel label2;
	private final JButton viewAvailabilityButton;

	public BrowseRooms() {
		panel1 = new JPanel();
		setContentPane(panel1);
		setTitle("Browse Rooms");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		setLocationRelativeTo(null);
//		setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));

		label1 = new JLabel("Select a room type");
		panel1.add(label1);

		String[] roomTypes = {"Single", "Double", "King"};
		roomTypeComboBox = new JComboBox<>(roomTypes);
		roomTypeComboBox.addItemListener(this::itemStateChanged);
		panel1.add(roomTypeComboBox);

		label2 = new JLabel("Room Type");
		panel1.add(label2);

		viewAvailabilityButton = new JButton("View Availability");
		viewAvailabilityButton.addActionListener(this::actionPerformed);
		panel1.add(viewAvailabilityButton);

		setVisible(true);
	}

	public static void main(String[] args) {
		new BrowseRooms();
	}

	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == roomTypeComboBox) {
			label2.setText(roomTypeComboBox.getSelectedItem() + " selected");
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == viewAvailabilityButton) {
			new ViewAvailability(roomTypeComboBox.getSelectedItem() + " size bedroom");
		}
	}
}
