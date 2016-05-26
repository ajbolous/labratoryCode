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
import Controllers.AppointmentsController;
import Controllers.MedicalRecordController;

import javax.swing.BoxLayout;

import java.awt.GridLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.FlowLayout;

import javax.swing.SwingConstants;

import models.Treatment;
import models.Visit;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import Utils.DateTime;

import java.awt.Component;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

public class NewTreatmentUI  {
	
	private JFrame NewTreatment ;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private AppointmentsController apctrl=new AppointmentsController();
	private MedicalRecordController mrctrl = new MedicalRecordController();
	private Treatment treatment ;
	/**
	 * Create the panel.
	 */
	
	public NewTreatmentUI(Treatment treatment) {
		this.treatment = treatment;
		
		Resources res = new Resources();
		NewTreatment = new JFrame();
		NewTreatment.setTitle("<New Treatment> - GHealth");
		NewTreatment.setResizable(false);
		Image icon= new ImageIcon(this.getClass().getResource("/img/" + "icon.png")).getImage();
		NewTreatment.setIconImage(icon);
		NewTreatment.setForeground(Color.BLACK);
		NewTreatment.setFont(new Font("Dialog", Font.PLAIN, 16));
		NewTreatment.setBackground(Color.WHITE);
		NewTreatment.getContentPane().setBackground(Color.WHITE);
		NewTreatment.getContentPane().setLayout(null);
		
		NewTreatment.setSize(353, 283);
		NewTreatment.setVisible(true);
		NewTreatment.setLocationRelativeTo(null);
	
		
			
			
			textField = new JTextField(treatment.getTid());
			textField.setEditable(false);
			textField.setBackground(new Color(255, 255, 255));
			textField.setBounds(124, 38, 107, 20);
			NewTreatment.getContentPane().add(textField);
			textField.setColumns(10);
			
			
			
			
			JLabel lblVisitId = new JLabel("Treatment ID :");
			lblVisitId.setFont(new Font("Arial", Font.BOLD, 12));
			lblVisitId.setBounds(9, 40, 119, 20);
			NewTreatment.getContentPane().add(lblVisitId);
			
			JLabel lblDate = new JLabel("Start Date :");
			lblDate.setFont(new Font("Arial", Font.BOLD, 12));
			lblDate.setBounds(9, 151, 101, 20);
			NewTreatment.getContentPane().add(lblDate);
			
			textField_1 = new JTextField(DateTime.getDateString(treatment.getStart()));
			textField_1.setEditable(false);
			textField_1.setBackground(new Color(255, 255, 255));
			textField_1.setBounds(124, 151, 211, 20);
			textField_1.setColumns(10);
			NewTreatment.getContentPane().add(textField_1);
			
			
			
			JLabel lblEndDate = new JLabel("End Date : ");
			lblEndDate.setFont(new Font("Arial", Font.BOLD, 12));
			lblEndDate.setBounds(9, 182, 101, 20);
			NewTreatment.getContentPane().add(lblEndDate);
			
			textField_2 = new JTextField();
			textField_2.setEditable(false);
			textField_2.setBounds(124, 182, 211, 20);
			NewTreatment.getContentPane().add(textField_2);
			textField_2.setColumns(10);
			
			JLabel lblDoctorname = new JLabel("DoctorName :");
			lblDoctorname.setFont(new Font("Arial", Font.BOLD, 12));
			lblDoctorname.setBounds(9, 120, 119, 20);
			NewTreatment.getContentPane().add(lblDoctorname);
			
			textField_3 = new JTextField(treatment.getDoctor().getFirstName()+ "  " +treatment.getDoctor().getLastName());
			textField_3.setEditable(false);
			textField_3.setBounds(124, 120, 211, 20);
			NewTreatment.getContentPane().add(textField_3);
			textField_3.setColumns(10);
			
			JLabel lblType = new JLabel("Treatment Type :");
			lblType.setFont(new Font("Arial", Font.BOLD, 12));
			lblType.setBounds(10, 89, 144, 20);
			NewTreatment.getContentPane().add(lblType);
			
			textField_4 = new JTextField(treatment.getDoctor().getSpeciality());
			textField_4.setEditable(false);
			textField_4.setBounds(124, 89, 211, 20);
			NewTreatment.getContentPane().add(textField_4);
			textField_4.setColumns(10);
			
			JButton btnOk = new JButton("OK");
			btnOk.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					//save Treatment
					mrctrl.saveTreatment(treatment);
					
				}
			});
			btnOk.setBounds(265, 213, 70, 23);
			NewTreatment.getContentPane().add(btnOk);
			
			JButton btnCancel = new JButton("Cancel");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0){
					NewTreatment.setVisible(false);
					
				}
			});
			btnCancel.setBounds(166, 213, 89, 23);
			NewTreatment.getContentPane().add(btnCancel);
			
			
		
			
		}
}