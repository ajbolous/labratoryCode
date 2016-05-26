package ClientUI;

import javax.swing.JPanel;
import javax.swing.JTextField;

import models.Visit;

import java.awt.Panel;
import java.awt.Rectangle;

import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;

import Utils.DateTime;

import java.awt.Font;
import java.awt.Color;
import java.text.ParseException;
import java.util.Date;

import javax.swing.SwingConstants;
import javax.swing.DropMode;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;

public class VisitPanel extends JPanel {
	
	protected JTextField textField;
	protected JTextField textField_1;
	protected JTextArea textArea = new JTextArea();


	/**
	 * Create the panel.
	 */
	public VisitPanel(Visit visit) {
		super();
		setBackground(new Color(192, 192, 192));
		setBounds(new Rectangle(283, 143, 122, 144));
		setLayout(null);
		
		textField = new JTextField(""+visit.getVid());
		textField.setBounds(90, 38, 91, 20);
		textField.setBackground(new Color(255, 255, 255));
		textField.setEditable(false);
		add(textField);
		textField.setColumns(10);
		//Date vdate= DateTime.getDate(visit.getVisitDate().getYear(), visit.getVisitDate().getMonth(), visit.getVisitDate().getDay());
		textField_1 = new JTextField(DateTime.getDateString(visit.getVisitDate()));
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
	
		
		textField_1.setBounds(273, 38, 143, 20);
		textField_1.setBackground(new Color(255, 255, 255));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		add(textField_1);

		
		
		
		JLabel lblVisitId = new JLabel("VisitID :");
		lblVisitId.setBounds(10, 40, 52, 14);
		lblVisitId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		add(lblVisitId);
		
		JLabel lblDate = new JLabel("Date :");
		lblDate.setBounds(217, 40, 46, 14);
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		add(lblDate);
		
		JLabel lblComments = new JLabel("Comments : ");
		lblComments.setBounds(10, 95, 104, 20);
		lblComments.setFont(new Font("Tahoma", Font.PLAIN, 12));
		add(lblComments);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(90, 69, 328, 73);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		add(scrollPane);
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textArea.setText(visit.getComments());
		textArea.setEditable(false);

		scrollPane.setViewportView(textArea);
		
		JPanel panel = new JPanel();
		panel.setBounds(90, 0, 328, 20);
		panel.setBackground(new Color(153, 153, 153));
		add(panel);
		
		JLabel lblVisitDetails = new JLabel("Visit Details");
		lblVisitDetails.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(lblVisitDetails);
		lblVisitDetails.setFont(new Font("Tahoma", Font.PLAIN, 12));
	
		
		
	
		
	}
}
