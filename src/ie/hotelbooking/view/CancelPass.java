package ie.hotelbooking.view;

import javax.swing.*;

public class CancelPass extends JPanel {
	private final JLabel label1;
	private final JComboBox<String> comboBox;
	private final JLabel label2;
	private final JButton cancelButton;
	private final JLabel label3;

	public CancelPass() {
		label1 = new JLabel("Cancel Pass");
		add(label1);

//		TODO retrieve passes from database, this will be done in model, the array will be passed into the constructor
		String[] passes = new String[]{"P1 Joe Bloggs", "P2 Darian Byrne", "P3 Milosz Cwynar", "P4 Kyle Purcell", "P5", "P6", "P7", "P8", "P9"};
		comboBox = new JComboBox<>(passes);
		add(comboBox);

		label2 = new JLabel("Customer: Joe Bloggs\nDate: 2025");
		add(label2);

		cancelButton = new JButton("Cancel this pass");
		add(cancelButton);

		label3 = new JLabel("");
		add(label3);

//		TODO delete pass from database, this will be done in model
		cancelButton.addActionListener(e -> label3.setText(JOptionPane.showConfirmDialog(null, "Are you sure you want to cancel this pass?", "Cancel Pass", JOptionPane.YES_NO_OPTION) + " cancel"));
	}
}
