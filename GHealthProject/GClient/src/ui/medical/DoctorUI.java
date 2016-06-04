package ui.medical;

import javax.swing.JPanel;
import javax.swing.JTextField;

import models.Visit;
import java.awt.Rectangle;
import javax.swing.JLabel;

public class DoctorUI extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Create the panel.
	 */
	public DoctorUI(Visit visit) {
		setBounds(new Rectangle(0, 0, 122, 144));
		setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(104, 11, 86, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(277, 11, 86, 20);
		textField_1.setColumns(10);
		add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(104, 42, 86, 20);
		textField_2.setColumns(10);
		add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setBounds(104, 101, 86, 20);
		textField_3.setColumns(10);
		add(textField_3);

		textField.setText("ID: " + visit.getVid());
		textField_1.setText(visit.getComments());
		
		JLabel lblVisitId = new JLabel("Visit ID:");
		lblVisitId.setBounds(28, 14, 46, 14);
		add(lblVisitId);
		
		JLabel label = new JLabel("Visit ID:");
		label.setBounds(201, 14, 46, 14);
		add(label);
		
		JLabel label_1 = new JLabel("Visit ID:");
		label_1.setBounds(23, 41, 46, 14);
		add(label_1);
		
		JLabel label_2 = new JLabel("Visit ID:");
		label_2.setBounds(28, 104, 46, 14);
		add(label_2);
	}
}
