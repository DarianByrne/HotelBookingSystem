package ie.hotelbooking.view;

import javax.swing.*;

public class MainMenu {
	public static JFrame frame = new JFrame("Hotel Booking System");
	private JPanel panel1;
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
		frame.setContentPane(panel1);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		browseRoomsButton.addActionListener(e -> new BrowseRooms());
		bookRoomButton.addActionListener(e -> JOptionPane.showMessageDialog(MainMenu.frame, "Book Room", "Book Room", JOptionPane.PLAIN_MESSAGE));
		reserveTableButton.addActionListener(e -> JOptionPane.showMessageDialog(MainMenu.frame, "Reserve Table", "Reserve Table", JOptionPane.PLAIN_MESSAGE));
		bookGymButton.addActionListener(e -> JOptionPane.showMessageDialog(MainMenu.frame, "Book Gym", "Book Gym", JOptionPane.PLAIN_MESSAGE));
		purchasePassButton.addActionListener(e -> JOptionPane.showMessageDialog(MainMenu.frame, "Purchase Pass", "Purchase Pass", JOptionPane.PLAIN_MESSAGE));
		bookSpaButton.addActionListener(e -> JOptionPane.showMessageDialog(MainMenu.frame, "Book Spa", "Book Spa", JOptionPane.PLAIN_MESSAGE));
		bookWeddingButton.addActionListener(e -> JOptionPane.showMessageDialog(MainMenu.frame, "Book Wedding", "Book Wedding", JOptionPane.PLAIN_MESSAGE));
		bookConferenceButton.addActionListener(e -> JOptionPane.showMessageDialog(MainMenu.frame, "Book Conference", "Book Conference", JOptionPane.PLAIN_MESSAGE));
		viewMenuButton.addActionListener(e -> JOptionPane.showMessageDialog(MainMenu.frame, "View Menu", "View Menu", JOptionPane.PLAIN_MESSAGE));
		viewAvailabilityButton.addActionListener(e -> new ViewAvailability());
	}

	public static void main(String[] args) {
		new MainMenu();
	}
}
