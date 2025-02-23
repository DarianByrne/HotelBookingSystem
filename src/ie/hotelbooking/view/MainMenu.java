package ie.hotelbooking.view;

import javax.swing.*;
import java.awt.*;
import static ie.hotelbooking.Main.changeScreen;

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
		setLayout(new GridLayout(0, 1));

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

		browseRoomsButton.addActionListener(e -> changeScreen(new BrowseRooms()));
		bookRoomButton.addActionListener(e -> JOptionPane.showMessageDialog(null, "Book Room", "Book Room", JOptionPane.PLAIN_MESSAGE));
		reserveTableButton.addActionListener(e -> JOptionPane.showMessageDialog(null, "Reserve Table", "Reserve Table", JOptionPane.PLAIN_MESSAGE));
		bookGymButton.addActionListener(e -> JOptionPane.showMessageDialog(null, "Book Gym", "Book Gym", JOptionPane.PLAIN_MESSAGE));
		purchasePassButton.addActionListener(e -> JOptionPane.showMessageDialog(null, "Purchase Pass", "Purchase Pass", JOptionPane.PLAIN_MESSAGE));
		bookSpaButton.addActionListener(e -> JOptionPane.showMessageDialog(null, "Book Spa", "Book Spa", JOptionPane.PLAIN_MESSAGE));
		bookWeddingButton.addActionListener(e -> JOptionPane.showMessageDialog(null, "Book Wedding", "Book Wedding", JOptionPane.PLAIN_MESSAGE));
		bookConferenceButton.addActionListener(e -> JOptionPane.showMessageDialog(null, "Book Conference", "Book Conference", JOptionPane.PLAIN_MESSAGE));
		viewMenuButton.addActionListener(e -> JOptionPane.showMessageDialog(null, "View Menu", "View Menu", JOptionPane.PLAIN_MESSAGE));
		viewAvailabilityButton.addActionListener(e -> changeScreen(new ViewAvailability()));
	}

	public static void main(String[] args) {
		new MainMenu();
	}
}
