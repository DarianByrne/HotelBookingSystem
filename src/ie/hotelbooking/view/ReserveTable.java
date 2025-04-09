package ie.hotelbooking.view;

import javax.swing.*;

/**
 * the reserve table panel
 */
public class ReserveTable extends JPanel {
	private final JLabel label1;

	/**
	 * generates the reserve table panel
	 */
	public ReserveTable() {
		label1 = new JLabel("Reserve Table");
		add(label1);
	}
}
