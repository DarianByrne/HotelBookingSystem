package ie.hotelbooking.view;

import javax.swing.*;
import java.awt.*;
import static ie.hotelbooking.Main.frame;

public class MainMenu extends JPanel {
	private JButton browseRoomsButton;
	private JButton bookRoomButton;
	private JButton reserveTableButton;
	private JButton bookGymButton;
	private JButton purchasePassButton;
	private JButton bookSpaButton;
	private JButton bookWeddingButton;
	private JButton bookConferenceButton;
	private JButton viewMenuButton;
	private JButton viewAvailabilityButton;

	public MainMenu() {
		frame.setTitle("Main Menu");
		frame.setContentPane(this);
		updateUI();

		setLayout(new GridLayout(3, 4));
		setVisible(true);

		browseRoomsButton = new JButton("Browse Rooms");
		bookRoomButton = new JButton("Book Room");
		reserveTableButton = new JButton("Reserve Table");
		bookGymButton = new JButton("Book Gym");
		purchasePassButton = new JButton("Purchase Pass");
		bookSpaButton = new JButton("Book Spa");
		bookWeddingButton = new JButton("Book Wedding");
		bookConferenceButton = new JButton("Book Conference");
		viewMenuButton = new JButton("View Menu");
		viewAvailabilityButton = new JButton("View Availability");
		add(browseRoomsButton);
		add(bookRoomButton);
		add(reserveTableButton);
		add(bookGymButton);
		add(purchasePassButton);
		add(bookSpaButton);
		add(bookWeddingButton);
		add(bookConferenceButton);
		add(viewMenuButton);
		add(viewAvailabilityButton);

		browseRoomsButton.addActionListener(e -> new BrowseRooms());
		bookRoomButton.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Book Room", "Book Room", JOptionPane.PLAIN_MESSAGE));
		reserveTableButton.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Reserve Table", "Reserve Table", JOptionPane.PLAIN_MESSAGE));
		bookGymButton.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Book Gym", "Book Gym", JOptionPane.PLAIN_MESSAGE));
		purchasePassButton.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Purchase Pass", "Purchase Pass", JOptionPane.PLAIN_MESSAGE));
		bookSpaButton.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Book Spa", "Book Spa", JOptionPane.PLAIN_MESSAGE));
		bookWeddingButton.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Book Wedding", "Book Wedding", JOptionPane.PLAIN_MESSAGE));
		bookConferenceButton.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Book Conference", "Book Conference", JOptionPane.PLAIN_MESSAGE));
		viewMenuButton.addActionListener(e -> JOptionPane.showMessageDialog(frame, "View Menu", "View Menu", JOptionPane.PLAIN_MESSAGE));
		viewAvailabilityButton.addActionListener(e -> new ViewAvailability());

		frame.setContentPane(this);
	}

	public static void main(String[] args) {
		new MainMenu();
	}
}
