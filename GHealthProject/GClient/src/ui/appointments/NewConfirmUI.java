package ui.appointments;

import java.awt.EventQueue;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;

import Client.Resources;
import Controllers.AppointmentsController;
import Controllers.ConfirmationController;
import Controllers.ReferralController;

import javax.swing.BoxLayout;

import java.awt.GridLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.FlowLayout;

import javax.swing.SwingConstants;

import models.Confirmation;
import models.Examination;
import models.Patient;
import models.Referral;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import ui.utils.MyTableModel;
import ui.utils.UITests;

import java.awt.Component;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JTabbedPane;
import javax.swing.JEditorPane;

public class NewConfirmUI {

	private JFrame NewConfirmUI; 
	private AppointmentsController app_ctrl = new AppointmentsController();
	private ReferralController RefCtrl = new ReferralController(); 
	private JTextField field_Name;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JButton btnNext;
	private JTable tblToday; 
	private JComboBox speciality_cbox; 
	private JEditorPane editorPane; 
	private JLabel msqlbl_1; 
	private JLabel msqlbl_2; 
	private JLabel msqlbl_3; 

	
	
	public NewConfirmUI(Patient p ) {
		initialize(p);
		NewConfirmUI.setVisible(true);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Patient p) {
		Resources res = new Resources();
		NewConfirmUI = new JFrame();
		NewConfirmUI.setTitle("New Conformation - GHealth");
		NewConfirmUI.setResizable(false);
		Image icon= new ImageIcon(this.getClass().getResource("/img/" + "icon.png")).getImage();
		NewConfirmUI.setIconImage(icon);
		NewConfirmUI.setForeground(Color.BLACK);
		NewConfirmUI.setFont(new Font("Dialog", Font.PLAIN, 16));
		NewConfirmUI.setBackground(Color.WHITE);
		NewConfirmUI.getContentPane().setBackground(Color.WHITE);
		NewConfirmUI.getContentPane().setLayout(null);
		
		JLabel logo = new JLabel("New Refferal and conformation");
		logo.setBounds(-33, -11, 412, 80);
		logo.setForeground(SystemColor.textHighlight);
		logo.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 17));
		logo.setBackground(Color.WHITE);
		logo.setIcon(res.getIcon("logo.png"));
		NewConfirmUI.getContentPane().add(logo);
		
		JButton btnFinish = new JButton("Finish");
		btnFinish.setEnabled(false);
		btnFinish.setBounds(211, 385, 89, 23);
		NewConfirmUI.getContentPane().add(btnFinish);
		
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(10, 385, 89, 23);
		NewConfirmUI.getContentPane().add(btnCancel);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 100, 290, 270);
		NewConfirmUI.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Add Referral", null, panel, null);
		tabbedPane.setEnabledAt(0, false);
		
		panel.setLayout(null);
		
		JLabel label_1 = new JLabel("Description:");
		label_1.setBounds(6, 79, 71, 14);
		panel.add(label_1);
		
		field_Name = new JTextField();
		field_Name.setColumns(10);
		field_Name.setBounds(75, 47, 200, 25);
		panel.add(field_Name);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(75, 79, 200, 141);
		panel.add(scrollPane);
		
		 editorPane = new JEditorPane();
		 scrollPane.setViewportView(editorPane);
		
		speciality_cbox = new JComboBox(app_ctrl.getSpecialties());
		speciality_cbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		speciality_cbox.setName("");
		speciality_cbox.setBounds(75, 11, 200, 25);
		panel.add(speciality_cbox);
		
		JLabel label_2 = new JLabel("Doctor Name:");
		label_2.setBounds(2, 52, 79, 14);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("speciality");
		label_3.setBounds(6, 16, 71, 14);
		panel.add(label_3);
		
		JLabel note = new JLabel("");
		note.setForeground(Color.RED);
		note.setFont(new Font("Tahoma", Font.PLAIN, 10));
		note.setBounds(10, 218, 203, 13);
		panel.add(note);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Add confirm", null, panel_1, null);
		tabbedPane.setEnabledAt(1, false);
		panel_1.setLayout(null);
		
		JLabel label_5 = new JLabel("Refferal Num:");
		label_5.setBounds(2, 59, 69, 14);
		panel_1.add(label_5);
		
		JLabel label_6 = new JLabel("Approval Num:");
		label_6.setBounds(0, 90, 71, 14);
		panel_1.add(label_6);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(78, 25, 200, 25);
		panel_1.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(78, 87, 200, 25);
		panel_1.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(78, 56, 200, 25);
		panel_1.add(textField_3);
		
		JLabel label_7 = new JLabel("HMO ID : ");
		label_7.setBounds(2, 28, 66, 14);
		panel_1.add(label_7);
		
		JLabel lblPatientId = new JLabel("Patient ID:");
		lblPatientId.setBounds(24, 69, 66, 14);
		NewConfirmUI.getContentPane().add(lblPatientId);
		
		JLabel label_id = new JLabel((String) p.getSid());
		label_id.setBounds(85, 64, 113, 25);
		NewConfirmUI.getContentPane().add(label_id);
		

		
		JButton btnPrev = new JButton("prev");
		btnPrev.setVisible(false);
		btnPrev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(0);	
				btnNext.setVisible(true);
				btnPrev.setVisible(false);


				
			}
		});
		btnPrev.setBounds(109, 385, 89, 23);
		NewConfirmUI.getContentPane().add(btnPrev);
		
		 btnNext = new JButton("Next");
		btnNext.setBounds(109, 385, 89, 23);
		NewConfirmUI.getContentPane().add(btnNext);
		
		msqlbl_1 = new JLabel("");
		msqlbl_1.setBounds(305, 139, 127, 14);
		NewConfirmUI.getContentPane().add(msqlbl_1);
		
		msqlbl_2 = new JLabel("");
		msqlbl_2.setBounds(305, 175, 127, 14);
		NewConfirmUI.getContentPane().add(msqlbl_2);
		
		msqlbl_3 = new JLabel("");
		msqlbl_3.setBounds(305, 236, 127, 14);
		NewConfirmUI.getContentPane().add(msqlbl_3);
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				field_Name.setText("");
				editorPane.setText(""); 
				msqlbl_1.setText("");
				msqlbl_2.setText("");
				msqlbl_3.setText("");
				
				note.setText(""); 
				field_Name.setEditable(true);
				editorPane.setEditable(true);	
				Referral ref;
			

				if((ref=referalExit())!= null){
					field_Name.setText(ref.getDoctor_name());
					editorPane.setText(ref.getDescription()); 
					field_Name.setEditable(false);
					editorPane.setEditable(false);	
					return;
				}
			
					
				if (!isvalidRef())
					return ; 
				btnFinish.setEnabled(true);
				btnNext.setVisible(false);
				btnPrev.setVisible(true);
				tabbedPane.setEnabledAt(1, true);
				tabbedPane.setSelectedIndex(1);
		
				
				

			}
			private Referral referalExit() {
			 	for(Referral ref : p.getReferrals()){
						   if (ref.isActive()== true && 
								   ref.getSpeciality().compareTo((String) speciality_cbox.getSelectedItem())== 0 ){
							   note.setText("there is refferal exist to speical and approval ");
							   return ref ; 
						   }
						}
					return null ; 
					}
					
		});
		btnFinish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				msqlbl_1.setText("");
				msqlbl_2.setText("");
				msqlbl_3.setText("");
			
			
				if (!isvalidconf())
					return ; 
				 Referral ref =new Referral(); 
				ref.setDoctor_name(field_Name.getText());
				ref.setSpeciality((String) speciality_cbox.getSelectedItem());
				ref.setDescription(editorPane.getText());
				ref.setPatient(p);		
				Confirmation conf = new Confirmation(); 
				conf.setRefferal_id(textField_3.getText());
				conf.setApproval_id(textField_2.getText());
				conf.setHmo_id(textField_1.getText());
				ref.setConfirmation(conf);
				ref.setActive(true); 
				RefCtrl.addReferralHMO(ref);
				 
				/* {
					 
					
				 
				 }
					 
	

				if (!isvalid()){
					addPatient.setBounds(addPatient.getX(), addPatient.getY(), 500, addPatient.getHeight());
					return;
				}

			//	addPatient.setBounds(addPatient.getX(), addPatient.getY(), 350, addPatient.getHeight());*/

		
			
			
			
			}

	
				
		

		});
		NewConfirmUI.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{logo}));
		NewConfirmUI.setBounds(100, 100, 370, 444);
		NewConfirmUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	private Boolean isvalidRef() {
		boolean flag = true;
	
		if (UITests.notEmpty((String)speciality_cbox.getSelectedItem())== false) {
			msqlbl_1.setText("isempty");
			flag=false; 			
		}
		if (UITests.notEmpty(field_Name.getText()) == false) {
			msqlbl_2.setText("isempty");
			flag=false; 			
		} 
		if (UITests.notEmpty(editorPane.getText()) == false) {
			msqlbl_3.setText("isempty");
			flag=false; 			
		}
	
		return flag;
	}
	private Boolean isvalidconf() {
		boolean flag = true;
	
		if (UITests.notEmpty(textField_1.getText()) == false) {
			msqlbl_1.setText("isempty");
			flag=false; 			
		}
		if (UITests.notEmpty(textField_2.getText()) == false) {
			msqlbl_3.setText("isempty");

			flag=false; 			
		} 
		if (UITests.notEmpty(textField_3.getText()) == false) {
			msqlbl_2.setText("isempty");

			flag=false; 			
		}
			
		return flag;
	}
}


