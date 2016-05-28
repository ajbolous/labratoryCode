package ClientUI;

import java.awt.EventQueue;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.JButton;

import Client.Resources;

import javax.swing.BoxLayout;

import java.awt.GridLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.FlowLayout;

import javax.swing.SwingConstants;

import models.Treatment;
import models.Visit;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import java.awt.Component;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

public class TreatmentPanel extends JPanel {
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	/**
	 * Create the panel.
	 */
	
	public TreatmentPanel(Treatment treatment) {
		
	
		
			super();
			setBorder(new TitledBorder(null, "Treatment", TitledBorder.CENTER, TitledBorder.ABOVE_TOP, null, Color.BLACK));
			setBackground(UIManager.getColor("Panel.background"));
			setBounds(new Rectangle(283, 143, 122, 144));
			setLayout(null);
			
			
			textField_1 = new JTextField();
			textField_1.setEditable(false);
			textField_1.setBackground(new Color(255, 255, 255));
			textField_1.setBounds(131, 136, 211, 20);
			textField_1.setColumns(10);
			add(textField_1);
			
			JLabel lblDate = new JLabel("Start Date :");
			lblDate.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblDate.setBounds(9, 135, 101, 20);
			add(lblDate);
			
			JLabel lblEndDate = new JLabel("End Date : ");
			lblEndDate.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblEndDate.setBounds(9, 182, 101, 20);
			add(lblEndDate);
			
			textField_2 = new JTextField();
			textField_2.setEditable(false);
			textField_2.setBounds(131, 183, 211, 20);
			add(textField_2);
			textField_2.setColumns(10);
			
			JLabel lblDoctorname = new JLabel("DoctorName :");
			lblDoctorname.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblDoctorname.setBounds(9, 86, 119, 27);
			add(lblDoctorname);
			
			textField_3 = new JTextField(treatment.getDoctor().getFirstName()+treatment.getDoctor().getLastName());
			textField_3.setEditable(false);
			textField_3.setBounds(131, 90, 211, 20);
			add(textField_3);
			textField_3.setColumns(10);
			
			JLabel lblType = new JLabel("Treatment Type :");
			lblType.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblType.setBounds(9, 48, 144, 27);
			add(lblType);
			
			textField_4 = new JTextField(treatment.gettType());
			textField_4.setEditable(false);
			textField_4.setBounds(131, 52, 211, 20);
			add(textField_4);
			textField_4.setColumns(10);
			
			JButton btnCancel = new JButton("Cancel");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
				}
			});
			btnCancel.setBounds(274, 242, 89, 23);
			add(btnCancel);
			
			
			
		
			
		}



}