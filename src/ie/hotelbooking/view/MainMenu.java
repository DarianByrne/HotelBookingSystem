package ie.hotelbooking.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame {
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
		setContentPane(panel1);
		setTitle("Hotel Booking System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		setLocationRelativeTo(null);
		setVisible(true);

		browseRoomsButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(MainMenu.this, "Browse Rooms", "Browse Rooms", JOptionPane.PLAIN_MESSAGE);
			}
		});
		bookRoomButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(MainMenu.this, "Book Room", "Book Room", JOptionPane.PLAIN_MESSAGE);
			}
		});
		reserveTableButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(MainMenu.this, "Reserve Table", "Reserve Table", JOptionPane.PLAIN_MESSAGE);
			}
		});
		bookGymButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(MainMenu.this, "Book Gym", "Book Gym", JOptionPane.PLAIN_MESSAGE);
			}
		});
		purchasePassButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(MainMenu.this, "Purchase Pass", "Purchase Pass", JOptionPane.PLAIN_MESSAGE);
			}
		});
		bookSpaButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(MainMenu.this, "Book Spa", "Book Spa", JOptionPane.PLAIN_MESSAGE);
			}
		});
		bookWeddingButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(MainMenu.this, "Book Wedding", "Book Wedding", JOptionPane.PLAIN_MESSAGE);
			}
		});
		bookConferenceButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(MainMenu.this, "Book Conference", "Book Conference", JOptionPane.PLAIN_MESSAGE);
			}
		});
		viewMenuButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(MainMenu.this, "View Menu", "View Menu", JOptionPane.PLAIN_MESSAGE);
			}
		});
		viewAvailabilityButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(MainMenu.this, "View Availability", "View Availability", JOptionPane.PLAIN_MESSAGE);
			}
		});
	}

	public static void main(String[] args) {
		new MainMenu();
	}
}
