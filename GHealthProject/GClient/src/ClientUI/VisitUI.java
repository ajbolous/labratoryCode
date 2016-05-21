package ClientUI;

import javax.swing.JPanel;
import javax.swing.JTextField;

import models.Visit;
import java.awt.Rectangle;
import javax.swing.JLabel;

public class VisitUI extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Create the panel.
	 */
	public VisitUI(Visit visit) {
		setBounds(new Rectangle(0, 0, 122, 144));
		setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(104, 11, 86, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(248, 11, 280, 20);
		textField_1.setColumns(10);
		add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(104, 42, 424, 20);
		textField_2.setColumns(10);
		add(textField_2);

		textField.setText("ID: " + visit.getVid());
		textField_1.setText(visit.getComments());
		
		JLabel lblVisitId = new JLabel("Visit ID");
		lblVisitId.setBounds(23, 14, 46, 14);
		add(lblVisitId);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(221, 14, 46, 14);
		add(lblDate);
		
		JLabel lblComments = new JLabel("Comments");
		lblComments.setBounds(23, 41, 71, 14);
		add(lblComments);
		
		JPanel panel = new JPanel();
		panel.setBounds(23, 79, 503, 141);
		add(panel);
		
	}
}
