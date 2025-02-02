package ie.hotelbooking.view;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.zinternaltools.DateChangeEvent;

import javax.swing.*;

public class ViewAvailability extends JFrame {
	private final JPanel panel1;
	private final JLabel label1;
	private final DatePicker datePicker;
	private final JLabel label2;

	public ViewAvailability(String type) {
		panel1 = new JPanel();
		setContentPane(panel1);
		setTitle("View Availability");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		setLocationRelativeTo(null);
//		setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));

		label1 = new JLabel("View " + type + " Availability");
		panel1.add(label1);

		datePicker = new DatePicker();
		datePicker.addDateChangeListener(this::dateChanged);
		panel1.add(datePicker);

		label2 = new JLabel("Select A Date");
		panel1.add(label2);

		setVisible(true);
	}

	public ViewAvailability() {
		this("");
	}

	public static void main(String[] args) {
		new ViewAvailability();
	}

	public void dateChanged(DateChangeEvent e) {
		if (e.getSource() == datePicker) {
			label2.setText(datePicker.getDate() + " selected");
		}
	}
}
