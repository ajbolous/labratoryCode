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
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.DropMode;
import javax.swing.border.TitledBorder;

public class NewTreatmentUI extends JPanel  {
	
	private JTextField textField_1;
	private JTextField textField_2;
    private JLabel lblDate ;
	private JLabel lblEndDate;
	private JLabel lblType;
	private JButton btnCancel;
	private JButton btnOk_1;
	private JLabel error_lbl;
	private JTextField textField_4;
	private MedicalRecordController mrctrl = new MedicalRecordController();
	/**
	 * Create the panel.
	 * @param doctorMedicalRecordUI 
	 */
	
	public NewTreatmentUI(Treatment treatment, DoctorMedicalRecordUI doctorMedicalRecordUI ) {
		
		super ();
		
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "New Treatment", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLACK));
		setBackground(UIManager.getColor("Panel.background"));
		setBounds(new Rectangle(283, 143, 571, 300));
		setLayout(null);
		
		
	
		    lblDate = new JLabel("Start Date :");
			lblDate.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblDate.setBounds(9, 109, 101, 20);
	    	add(lblDate);
			
			textField_1 = new JTextField(DateTime.getDateString(treatment.getStart()));
			textField_1.setBackground(Color.WHITE);
			textField_1.setEditable(false);
			
			textField_1.setBounds(120, 110, 215, 20);
			textField_1.setColumns(10);
			add(textField_1);
			
			
			
			 lblEndDate = new JLabel("End Date : ");
			lblEndDate.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblEndDate.setBounds(9, 151, 101, 20);
			add(lblEndDate);
			
			textField_2 = new JTextField();
			textField_2.setEnabled(false);
			textField_2.setBackground(Color.WHITE);
			
			textField_2.setEditable(false);
			textField_2.setBounds(120, 152, 215, 20);
			add(textField_2);
			textField_2.setColumns(10);
			
			 lblType = new JLabel("Treatment Type :");
			lblType.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblType.setBounds(10, 63, 144, 20);
			add(lblType);
			
			textField_4 = new JTextField();
			textField_4.setBackground(Color.WHITE);
			
			textField_4.setBounds(120, 64, 215, 20);
			add(textField_4);
			textField_4.setColumns(10);
			
			 btnCancel = new JButton("Cancel");
			 btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 12));
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0){
					setVisible(false);
					
				}
	
			});
			btnCancel.setBounds(246, 211, 89, 23);
			add(btnCancel);
			
			 btnOk_1 = new JButton("Save");
			 btnOk_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
			btnOk_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String tType=textField_4.getText();
					error_lbl.setText("");
					if (UITests.notEmpty(tType) == false)
						error_lbl.setText("*Please enter treatment Type");
					
					else {
						treatment.settType(tType);
				
						Messages.successMessage("Treatment was added successfully ", "Success", doctorMedicalRecordUI.DoctorMedicalRecord);
						
						Treatment treatmentDB= (Treatment )mrctrl.saveTreatment(treatment); ;
						
						doctorMedicalRecordUI.updateTree(treatmentDB , true);
						setVisible(false);
						
					
				   }
				}
			});
			btnOk_1.setBounds(160, 211, 76, 23);
			add(btnOk_1);
			
			
			error_lbl = new JLabel("");
			error_lbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
			error_lbl.setForeground(Color.RED);
		    error_lbl.setBounds(120, 35, 269, 27);
			add(error_lbl);
			
			
			
			
		}
}