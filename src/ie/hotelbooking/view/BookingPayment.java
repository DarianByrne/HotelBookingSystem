package ie.hotelbooking.view;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.zinternaltools.DateChangeEvent;
import ie.hotelbooking.model.booking.Booking;
import ie.hotelbooking.model.booking.RoomBooking;
import ie.hotelbooking.model.customer.Customer;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import java.awt.*;
import java.awt.event.ActionEvent;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;

import static ie.hotelbooking.Main.changeScreen;

public class BookingPayment extends JPanel {
	private RoomBooking roomBooking;
	private JLabel previousCustomerLabel;
	private JCheckBox previousCustomerCheckBox;
	private JLabel customerIdLabel;
	private JSpinner customerIdTextSpinner;
	private JLabel nameLabel;
	private JTextField nameTextField;
	private JLabel phoneLabel;
	private JTextField phoneTextField;
	private JLabel emailLabel;
	private JTextField emailTextField;
	private JLabel dobLabel;
	private DatePicker dobDatePicker;
	private JLabel addressLabel;
	private JTextArea addressTextArea;

	private JLabel cardHolderNameLabel;
	private JTextField cardHolderNameTextField;
	private JLabel cardNumberLabel;
	private JTextField cardNumberTextField;
	private JLabel cardExpiryDateLabel;
	private JTextField cardExpiryDateTextField;
	private JLabel cardCVVLabel;
	private JSpinner cardCVVSpinner;
	private JButton finaliseBookingButton;
	private JButton cancelBookingButton;

	public void initializeUI() {
		setLayout(new GridLayout(0, 2));

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

		cancelBookingButton = new JButton("Cancel Booking");
		cancelBookingButton.addActionListener(this::actionPerformed);
		add(cancelBookingButton);
	}

	public BookingPayment() {
//		TODO nicer layout
		initializeUI();
	}

	public BookingPayment(RoomBooking roomBooking) {
//		TODO use data in roomBooking object
		this.roomBooking = roomBooking;
		initializeUI();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == finaliseBookingButton) {
			addBookingDetails();
			changeScreen(new BookingConfirmation());
		} else if (e.getSource() == cancelBookingButton) {
			changeScreen(new BookRoom());
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

	public void dobDateChanged(DateChangeEvent e) {
		if (e.getSource() == dobDatePicker) {
//			label2.setText(datePicker.getDate() + " selected");
		}
	}

	public void setCustomerDateOfBirth(Customer customer) {
		LocalDate dobDate = dobDatePicker.getDate();
		if (dobDate != null) {
			customer.setDateOfBirth(Date.valueOf(dobDate));
		}
	}

	public Customer createCustomer() {
		Customer customer = new Customer();
		customer.setName(nameTextField.getText());
		customer.setAddress(addressTextArea.getText());
		setCustomerDateOfBirth(customer);
		customer.setPhoneNumber(phoneTextField.getText());
		customer.setEmail(emailTextField.getText());

		return customer;
	}

	public void addBookingDetails() {
		Customer customer = createCustomer();
		this.roomBooking.setCustomer(customer);
	}
}
