package ie.hotelbooking.view;

import javax.swing.*;

/**
 * the purchase pass panel
 */
public class PurchasePass extends JPanel {
	private final JLabel label1;

	/**
	 * generates the purchase pass panel
	 */
	public PurchasePass() {
		label1 = new JLabel("Purchase Pass");
		add(label1);
	}
}
