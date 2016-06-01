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

import Client.Application;
import Client.Resources;
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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.ParseException;

import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;

public class TreatmentPanel extends JPanel {
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JLabel lblResult;
	private JScrollPane scrollPane; 
	private JButton btnSave;
	private JButton btnCancel_1 ;
	private JButton btnAddReport;
	private JButton btnCancel;
	private JTextArea textArea ;
	private JLabel error_lbl;
	private MedicalRecordController mrctrl = new MedicalRecordController();
	/**
	 * Create the panel.
	 */
	
	public TreatmentPanel(Treatment treatment ,DoctorMedicalRecordUI doctorMedicalRecordUI ) {
		
	
		
			super();
			setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Treatment", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
			setBackground(UIManager.getColor("Panel.background"));
			setBounds(new Rectangle(283, 143, 122, 144));
			setLayout(null);
			
			
			textField_1 = new JTextField(DateTime.getDateString(treatment.getStart()));
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
			if(treatment.isEndFlag())
			{
				textField_2.setText(DateTime.getDateString(treatment.getEnd()));
				System.out.printf(DateTime.getDateString(treatment.getEnd()));
				btnCancel_1.setVisible(true);
				scrollPane.setVisible(true);
				textArea.setText(treatment.getStatus());
				lblResult.setVisible(true);
				btnAddReport.setVisible(false);
				btnCancel.setVisible(false);
				
			}
			textField_2.setBackground(Color.WHITE);
			textField_2.setEditable(false);
			textField_2.setBounds(131, 183, 211, 20);
			add(textField_2);
			textField_2.setColumns(10);
			
			JLabel lblDoctorname = new JLabel("DoctorName :");
			lblDoctorname.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblDoctorname.setBounds(9, 86, 119, 27);
			add(lblDoctorname);
			
			textField_3 = new JTextField(treatment.getDoctor().getFirstName()+" "+treatment.getDoctor().getLastName());
			textField_3.setBackground(Color.WHITE);
			textField_3.setEditable(false);
			textField_3.setBounds(131, 90, 211, 20);
			add(textField_3);
			textField_3.setColumns(10);
			
			JLabel lblType = new JLabel("Treatment Type :");
			lblType.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblType.setBounds(9, 48, 144, 27);
			add(lblType);
			
			textField_4 = new JTextField(treatment.gettType());
			textField_4.setBackground(Color.WHITE);
			textField_4.setEditable(false);
			textField_4.setBounds(131, 52, 211, 20);
			add(textField_4);
			textField_4.setColumns(10);
			
			 btnCancel = new JButton("Cancel");
			btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 12));
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
				}
			});
			btnCancel.setBounds(311, 242, 89, 23);
			add(btnCancel);
			
			 btnAddReport = new JButton("Add Report");
			 btnAddReport.setFont(new Font("Tahoma", Font.PLAIN, 12));
			btnAddReport.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					btnCancel_1.setVisible(true);
					btnSave.setVisible(true);
					scrollPane.setVisible(true);
					lblResult.setVisible(true);
					btnAddReport.setVisible(false);
					btnCancel.setVisible(false);
				}
			});
			btnAddReport.setBounds(200, 242, 101, 23);
			add(btnAddReport);
			btnAddReport.setVisible(true);
			btnAddReport.setEnabled(false);
			if(treatment.getDoctor().getSid().equals(Application.user.getSid()))
			{
				btnAddReport.setEnabled(true);
			}
			
		 lblResult = new JLabel("Result : ");
			lblResult.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblResult.setBounds(9, 241, 62, 14);
			add(lblResult);
			lblResult.setVisible(false);
			
			scrollPane = new JScrollPane();
			scrollPane.setBounds(131, 240, 294, 89);
			add(scrollPane);
			scrollPane.setVisible(false);
			
			textArea = new JTextArea();
			scrollPane.setViewportView(textArea);
			
			 btnSave = new JButton("Save");
			 btnSave.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		String str =textArea.getText();
			 	error_lbl.setText("");
			    if (UITests.notEmpty(str) == false)
							error_lbl.setText("* Please enter Results");
			 		else{
			 		treatment.setStatus(str);
			 		treatment.setEndFlag(true);
			 		try {
						treatment.setEnd((DateTime.currentDate()));
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
			 		Messages.successMessage("Treatment Report was added successfully ", "Success", doctorMedicalRecordUI.DoctorMedicalRecord);
			 		setVisible(false);
			 		mrctrl.updatTreatment(treatment);
			 		
			 		
			 		}  
			 		
			 	}
			 });
			 
			 error_lbl = new JLabel("");
			 error_lbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
				error_lbl.setForeground(Color.RED);
				error_lbl.setBounds(131, 214, 269, 27);
			
			add(error_lbl);
			btnSave.setFont(new Font("Tahoma", Font.PLAIN, 12));
			btnSave.setBounds(212, 365, 89, 23);
			add(btnSave);
			btnSave.setVisible(false);
			
			 btnCancel_1 = new JButton("Cancel");
			 btnCancel_1.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		setVisible(false);
			 	}
			 });
			btnCancel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
			btnCancel_1.setBounds(311, 365, 89, 23);
			add(btnCancel_1);
			btnCancel_1.setVisible(false);
			
			
			
		
			
		}
}