package ie.hotelbooking.view;

import javax.swing.*;

/**
 * the update customer panel
 */
public class UpdateCustomer extends JPanel {
	private final JLabel label1;
	private final JComboBox<String> comboBox;
	private final JLabel label2;
	private final JLabel label3;
	private final JTextField textField1;
	private final JButton button1;

	/**
	 * generates the update customer panel
	 */
	public UpdateCustomer() {
		label1 = new JLabel("Update Customer");
		add(label1);

//		TODO retrieve customers from database, this will be done in model, the array will be passed into the constructor
		String[] customers = new String[]{"C1 Joe Bloggs", "C2 Darian Byrne", "C3 Milosz Cwynar", "C4 Kyle Purcell", "C5", "C6", "C7", "C8", "C9"};
		comboBox = new JComboBox<>(customers);
		add(comboBox);

		label2 = new JLabel("Customer: Joe Bloggs");
		add(label2);

		label3 = new JLabel("Update their details below");
		add(label3);

		textField1 = new JTextField(15);
		add(textField1);

		button1 = new JButton("Update");
		add(button1);

//		TODO update customer in database, this will be done in model
		button1.addActionListener(e -> JOptionPane.showConfirmDialog(null, "Are you sure you want to update this customer?", "Update Customer", JOptionPane.YES_NO_OPTION));
	}
}
