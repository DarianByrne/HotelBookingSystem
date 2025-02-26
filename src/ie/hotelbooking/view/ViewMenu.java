package ie.hotelbooking.view;

import javax.swing.*;

public class ViewMenu extends JPanel {
	private final JLabel label1;
	private final JComboBox<String> menuComboBox;
	private final JList<String> menuList;

	public ViewMenu() {
		label1 = new JLabel("View Menu");
		add(label1);

		String[] items = new String[]{"Bolognese", "Lasagne", "Pizza"};
		menuComboBox = new JComboBox<>(items);
		add(menuComboBox);

		menuList = new JList<>(items);
		add(menuList);
	}
}
