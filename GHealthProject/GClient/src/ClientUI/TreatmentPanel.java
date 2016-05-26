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

public class TreatmentPanel extends JPanel {
	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	/**
	 * Create the panel.
	 */
	
	public TreatmentPanel(Treatment treatment) {
		
	
		
			super();
			setBackground(new Color(255, 255, 255));
			setBounds(new Rectangle(283, 143, 122, 144));
			setLayout(null);
			
			textField = new JTextField(treatment.getTid());
			textField.setEditable(false);
			textField.setBackground(new Color(255, 255, 255));
			textField.setBounds(152, 38, 107, 20);
			add(textField);
			textField.setColumns(10);
			
			
			textField_1 = new JTextField();
			textField_1.setEditable(false);
			textField_1.setBackground(new Color(255, 255, 255));
			textField_1.setBounds(152, 136, 211, 20);
			textField_1.setColumns(10);
			add(textField_1);

			
			
			
			JLabel lblVisitId = new JLabel("TreatmentID :");
			lblVisitId.setFont(new Font("Arial Black", Font.BOLD, 12));
			lblVisitId.setBounds(9, 40, 119, 14);
			add(lblVisitId);
			
			JLabel lblDate = new JLabel("Start Date :");
			lblDate.setFont(new Font("Arial Black", Font.BOLD, 12));
			lblDate.setBounds(9, 135, 101, 20);
			add(lblDate);
			
			JPanel panel = new JPanel();
			panel.setBackground(new Color(153, 153, 153));
			panel.setBounds(-21, 0, 119, 27);
			add(panel);
			panel.setLayout(null);
			
			JLabel lblVisitDetails = new JLabel("Treatment");
			lblVisitDetails.setBounds(24, 0, 85, 29);
			panel.add(lblVisitDetails);
			lblVisitDetails.setHorizontalAlignment(SwingConstants.LEFT);
			lblVisitDetails.setFont(new Font("Arial Black", Font.BOLD, 12));
			
			JLabel lblEndDate = new JLabel("End Date : ");
			lblEndDate.setFont(new Font("Arial Black", Font.BOLD, 12));
			lblEndDate.setBounds(9, 182, 101, 20);
			add(lblEndDate);
			
			textField_2 = new JTextField();
			textField_2.setEditable(false);
			textField_2.setBounds(152, 183, 211, 20);
			add(textField_2);
			textField_2.setColumns(10);
			
			JLabel lblDoctorname = new JLabel("DoctorName :");
			lblDoctorname.setFont(new Font("Arial Black", Font.BOLD, 12));
			lblDoctorname.setBounds(9, 233, 119, 27);
			add(lblDoctorname);
			
			textField_3 = new JTextField(treatment.getDoctor().getFirstName()+treatment.getDoctor().getLastName());
			textField_3.setEditable(false);
			textField_3.setBounds(152, 237, 211, 20);
			add(textField_3);
			textField_3.setColumns(10);
			
			JLabel lblType = new JLabel("Treatment Type :");
			lblType.setFont(new Font("Arial Black", Font.BOLD, 12));
			lblType.setBounds(10, 82, 144, 27);
			add(lblType);
			
			textField_4 = new JTextField(treatment.getDoctor().getSpeciality());
			textField_4.setEditable(false);
			textField_4.setBounds(152, 86, 211, 20);
			add(textField_4);
			textField_4.setColumns(10);
			
			
			
		
			
		}



}