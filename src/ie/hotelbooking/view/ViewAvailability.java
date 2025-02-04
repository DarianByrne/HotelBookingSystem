package ie.hotelbooking.view;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.zinternaltools.DateChangeEvent;

import javax.swing.*;

public class ViewAvailability extends JPanel {
	private final JLabel label1;
	private final DatePicker datePicker;
	private final JLabel label2;

	public ViewAvailability(String type) {
		MainMenu.frame.setTitle("View Availability");
		MainMenu.frame.setContentPane(this);
		updateUI();

		label1 = new JLabel("View " + type + " Availability");
		add(label1);

		datePicker = new DatePicker();
		datePicker.addDateChangeListener(this::dateChanged);
		add(datePicker);

		label2 = new JLabel("Select A Date");
		add(label2);
	}

	public ViewAvailability() {
		this("");
	}

	public void dateChanged(DateChangeEvent e) {
		if (e.getSource() == datePicker) {
			label2.setText(datePicker.getDate() + " selected");
		}
	}
}
