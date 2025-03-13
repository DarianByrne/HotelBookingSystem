package ie.hotelbooking.view;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.zinternaltools.DateChangeEvent;
import ie.hotelbooking.model.booking.RoomBooking;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import java.awt.*;
import java.awt.event.ActionEvent;

public class BookingPayment extends JPanel {
	private final JLabel bookingDateLabel;
	private final DatePicker bookingDatePicker;
	private final JLabel previousCustomerLabel;
	private final JCheckBox previousCustomerCheckBox;
	private final JLabel customerIdLabel;
	private final JSpinner customerIdTextSpinner;
	private final JLabel nameLabel;
	private final JTextField nameTextField;
	private final JLabel phoneLabel;
	private final JTextField phoneTextField;
	private final JLabel emailLabel;
	private final JTextField emailTextField;
	private final JLabel dobLabel;
	private final DatePicker dobDatePicker;
	private final JLabel addressLabel;
	private final JTextArea addressTextArea;

	private final JLabel cardHolderNameLabel;
	private final JTextField cardHolderNameTextField;
	private final JLabel cardNumberLabel;
	private final JTextField cardNumberTextField;
	private final JLabel cardExpiryDateLabel;
	private final JTextField cardExpiryDateTextField;
	private final JLabel cardCVVLabel;
	private final JSpinner cardCVVSpinner;
	private final JButton finaliseBookingButton;

	public BookingPayment() {
//		TODO nicer layout
		setLayout(new GridLayout(0, 2));

		bookingDateLabel = new JLabel("Booking date: ");
		add(bookingDateLabel);
		bookingDatePicker = new DatePicker();
		bookingDatePicker.addDateChangeListener(this::bookingDateChanged);
		add(bookingDatePicker);

		previousCustomerLabel = new JLabel("Previous customer: ");
		add(previousCustomerLabel);
		previousCustomerCheckBox = new JCheckBox();
		previousCustomerCheckBox.addChangeListener(this::checkChanged);
		add(previousCustomerCheckBox);

		customerIdLabel = new JLabel("Customer ID: ");
		add(customerIdLabel);
		customerIdTextSpinner = new JSpinner(new SpinnerNumberModel(0, 0, null, 1));
		customerIdTextSpinner.setEnabled(false);
		customerIdTextSpinner.addChangeListener(this::customerIdChanged);
		add(customerIdTextSpinner);

		nameLabel = new JLabel("Customer name: ");
		add(nameLabel);
		nameTextField = new JTextField();
		add(nameTextField);

		phoneLabel = new JLabel("Customer Phone number: ");
		add(phoneLabel);
		phoneTextField = new JTextField();
		add(phoneTextField);

		emailLabel = new JLabel("Customer email: ");
		add(emailLabel);
		emailTextField = new JTextField();
		add(emailTextField);

		dobLabel = new JLabel("Customer date of birth: ");
		add(dobLabel);
		dobDatePicker = new DatePicker();
		dobDatePicker.addDateChangeListener(this::dobDateChanged);
		add(dobDatePicker);

		addressLabel = new JLabel("Customer address: ");
		add(addressLabel);
		addressTextArea = new JTextArea(4, 0);
		add(addressTextArea);

		cardHolderNameLabel = new JLabel("Card holder name: ");
		add(cardHolderNameLabel);
		cardHolderNameTextField = new JTextField();
		add(cardHolderNameTextField);

		cardNumberLabel = new JLabel("Card number: ");
		add(cardNumberLabel);
		cardNumberTextField = new JTextField();
		add(cardNumberTextField);

		cardExpiryDateLabel = new JLabel("Card expiry date: ");
		add(cardExpiryDateLabel);
		cardExpiryDateTextField = new JTextField();
		add(cardExpiryDateTextField);

		cardCVVLabel = new JLabel("Card cvv: ");
		add(cardCVVLabel);
		cardCVVSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 9999, 1));
		add(cardCVVSpinner);

		finaliseBookingButton = new JButton("Finalise Booking");
		finaliseBookingButton.addActionListener(this::actionPerformed);
		add(finaliseBookingButton);
	}

	public BookingPayment(RoomBooking roomBooking) {
//		TODO use data in roomBooking object
		this();
		add(new JLabel("Room Booking"));
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == finaliseBookingButton) {
//			TODO create booking, show confirmation screen, print receipt
		}
	}

	public void customerIdChanged(ChangeEvent e) {
		if (e.getSource() == customerIdTextSpinner) {
//			TODO get customer details from DB
		}
	}

	public void checkChanged(ChangeEvent e) {
		if (e.getSource() == previousCustomerCheckBox) {
			if (previousCustomerCheckBox.isSelected()) {
				customerIdTextSpinner.setEnabled(true);

				nameTextField.setEnabled(false);
				phoneTextField.setEnabled(false);
				emailTextField.setEnabled(false);
				dobDatePicker.setEnabled(false);
				addressTextArea.setEnabled(false);
				nameTextField.setText("");
				phoneTextField.setText("");
				emailTextField.setText("");
				dobDatePicker.setDate(null);
			} else {
				customerIdTextSpinner.setEnabled(false);
				customerIdTextSpinner.setValue(0);

				nameTextField.setEnabled(true);
				phoneTextField.setEnabled(true);
				emailTextField.setEnabled(true);
				dobDatePicker.setEnabled(true);
				addressTextArea.setEnabled(true);
			}
		}
	}

	public void bookingDateChanged(DateChangeEvent e) {
		if (e.getSource() == bookingDatePicker) {
//			label2.setText(datePicker.getDate() + " selected");
		}
	}

	public void dobDateChanged(DateChangeEvent e) {
		if (e.getSource() == dobDatePicker) {
//			label2.setText(datePicker.getDate() + " selected");
		}
	}
}
