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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VisitPanel extends JPanel {
	protected JTextField textField_1;
	protected JTextArea textArea = new JTextArea();


	/**
	 * Create the panel.
	 */
	public VisitPanel(Visit visit) {
		super();
		setBackground(new Color(255, 255, 255));
		setBounds(new Rectangle(283, 143, 122, 144));
		setLayout(null);
		//Date vdate= DateTime.getDate(visit.getVisitDate().getYear(), visit.getVisitDate().getMonth(), visit.getVisitDate().getDay());
		textField_1 = new JTextField(DateTime.getDateString(visit.getVisitDate()));
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
	
		
		textField_1.setBounds(90, 53, 158, 20);
		textField_1.setBackground(new Color(255, 255, 255));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		add(textField_1);
		
		JLabel lblDate = new JLabel("Date :");
		lblDate.setBounds(10, 56, 46, 14);
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		add(lblDate);
		
		JLabel lblComments = new JLabel("Comments : ");
		lblComments.setBounds(10, 111, 104, 20);
		lblComments.setFont(new Font("Tahoma", Font.PLAIN, 12));
		add(lblComments);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(90, 111, 328, 73);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		add(scrollPane);
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textArea.setText(visit.getComments());
		textArea.setEditable(false);

		scrollPane.setViewportView(textArea);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 450, 27);
		
		add(panel);
		panel.setLayout(null);
		
		JLabel lblVisitDetails = new JLabel("Visit Details");
		lblVisitDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblVisitDetails.setBounds(159, 0, 118, 27);
		panel.add(lblVisitDetails);
		lblVisitDetails.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JButton btnNewButton = new JButton("Cancel ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeAll();
                revalidate();
                repaint();
			}
		});
		btnNewButton.setBounds(278, 231, 89, 23);
		add(btnNewButton);
	
		
		
	
		
	}
}
