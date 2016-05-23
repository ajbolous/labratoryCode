package ClientUI;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import java.awt.Color;

import javax.swing.JLabel;

import models.Visit;

import java.awt.Rectangle;
import java.awt.SystemColor;
import java.awt.Font;

public class NewVisitPanel extends VPanel {
	
	// TODO Auto-generated constructor stub
	public NewVisitPanel(Visit visit) {
		super(visit);
		textArea.setEditable(true);
		
	}
	
	/*private JTextField textField;
	private JTextField textField_1;
	

	public NewVisitPanel() {
		super();
		setBackground(new Color(255, 255, 255));
		setBounds(new Rectangle(283, 143, 122, 144));
		setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(90, 38, 91, 20);
		textField.setBackground(new Color(255, 255, 255));
		textField.setEditable(false);
		add(textField);
		textField.setColumns(10);
		
		
		textField_1 = new JTextField();
		textField_1.setBounds(273, 38, 155, 20);
		textField_1.setBackground(new Color(255, 255, 255));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		add(textField_1);

		
		
		
		JLabel lblVisitId = new JLabel("VisitID :");
		lblVisitId.setBounds(10, 40, 80, 14);
		lblVisitId.setFont(new Font("Arial Black", Font.BOLD, 12));
		add(lblVisitId);
		
		JLabel lblDate = new JLabel("Date :");
		lblDate.setBounds(217, 40, 46, 14);
		lblDate.setFont(new Font("Arial Black", Font.BOLD, 12));
		add(lblDate);
		
		JLabel lblComments = new JLabel("Comments : ");
		lblComments.setBounds(10, 95, 104, 20);
		lblComments.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(lblComments);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(100, 70, 328, 73);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 128, 27);
		panel.setBackground(new Color(153, 153, 153));
		add(panel);
		panel.setLayout(null);
		
		JLabel lblVisitDetails = new JLabel("New Visit ");
		lblVisitDetails.setBounds(10, 0, 92, 23);
		lblVisitDetails.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(lblVisitDetails);
		lblVisitDetails.setFont(new Font("Arial Black", Font.BOLD, 12));*/
		
		
	
	}
