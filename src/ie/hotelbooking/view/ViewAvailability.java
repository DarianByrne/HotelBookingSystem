package ie.hotelbooking.view;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.zinternaltools.DateChangeEvent;
import javax.swing.*;

import ie.hotelbooking.model.Database;
import ie.hotelbooking.model.booking.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * the view availability panel
 */
public class ViewAvailability extends JPanel {
	private final JLabel label1;
	private final DatePicker datePicker;
	private final JLabel label2;

	/**
	 * generates the view availability panel with a given type
	 * @param type the type of availability to view
	 */
	public ViewAvailability(String type) {
		label1 = new JLabel("View " + type + " Availability");
		add(label1);

		datePicker = new DatePicker();
		datePicker.addDateChangeListener(this::dateChanged);
		add(datePicker);

		label2 = new JLabel("Select A Date");
		add(label2);
	}

	/**
	 * generates a default view availability panel
	 */
	public ViewAvailability() {
		this("");
	}

	/**
	 * handles when the date changes in the date picker
	 * @param e the event
	 */
	public void dateChanged(DateChangeEvent e) {
		if (e.getSource() == datePicker) {
			label2.setText(datePicker.getDate() + " selected");
		}
	}

	/**
	 * queries if the date is available
	 * @return if the date is available
	 * @throws SQLException
	 */
	public boolean dateAvailable() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = Database.getConnection();
			ps = con.prepareStatement("SELECT * FROM booking WHERE arrivalDate=?");
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
				ps.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
        try {
            return !rs.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
