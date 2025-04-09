package ie.hotelbooking.view;

import javax.swing.*;
import java.awt.*;
import static ie.hotelbooking.Main.changeScreen;

/**
 * the main menu of the program
 */
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
	private JButton cancelPassButton;
	private JButton updateCustomerButton;

	/**
	 * generates the main menu panel
	 */
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
		cancelPassButton = new JButton("Cancel Pass");
		updateCustomerButton = new JButton("Update Customer");
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
		add(cancelPassButton);
		add(updateCustomerButton);

		browseRoomsButton.addActionListener(e -> changeScreen(new BrowseRooms()));
		bookRoomButton.addActionListener(e -> changeScreen(new BookRoom()));
		reserveTableButton.addActionListener(e -> changeScreen(new ReserveTable()));
		bookGymButton.addActionListener(e -> underConstruction());
		purchasePassButton.addActionListener(e -> changeScreen(new PurchasePass()));
		bookSpaButton.addActionListener(e -> underConstruction());
		bookWeddingButton.addActionListener(e -> underConstruction());
		bookConferenceButton.addActionListener(e -> underConstruction());
		viewMenuButton.addActionListener(e -> changeScreen(new ViewMenu()));
		viewAvailabilityButton.addActionListener(e -> changeScreen(new ViewAvailability()));
		cancelPassButton.addActionListener(e -> changeScreen(new CancelPass()));
		updateCustomerButton.addActionListener(e -> changeScreen(new UpdateCustomer()));
	}

	/**
	 * small method that displays a message to show that a feature is under construction
	 */
	private void underConstruction() {
		JOptionPane.showMessageDialog(ie.hotelbooking.Main.frame, "This screen is under construction", "Under Construction", JOptionPane.PLAIN_MESSAGE);
	}
}
