package ClientUI;

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

import models.Patient;
import models.Referral;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import java.awt.Component;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JComboBox;

public class NewConfirmUI {

	private JFrame NewConfirmUI;
	private JTextField HMOId_field;
	private JTextField doctor_name;
	private JTextField AproveNum_field;
	private JTextField RefNum_field;
	private JComboBox spec_comboBox; 
	private JTextPane des_textPane; 
	private AppointmentsController app_ctrl = new AppointmentsController();
	private ConfirmationController ConformCtrl= new ConfirmationController();
	private ReferralController RefCtrl = new ReferralController(); 

	
	
	
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
		
		JLabel logo = new JLabel("New Conformation");
		logo.setBounds(-11, 0, 377, 80);
		logo.setForeground(SystemColor.textHighlight);
		logo.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 17));
		logo.setBackground(Color.WHITE);
		logo.setIcon(res.getIcon("logo.png"));
		NewConfirmUI.getContentPane().add(logo);
		
		JLabel lblPatientId = new JLabel("Patient ID");
		lblPatientId.setBounds(20, 100, 66, 14);
		NewConfirmUI.getContentPane().add(lblPatientId);
		
		JLabel lblRefferalNum = new JLabel("Refferal Num:");
		lblRefferalNum.setBounds(20, 362, 69, 14);
		NewConfirmUI.getContentPane().add(lblRefferalNum);
		
		JLabel lblApprovalNum = new JLabel("Approval Num:");
		lblApprovalNum.setBounds(18, 393, 71, 14);
		NewConfirmUI.getContentPane().add(lblApprovalNum);
		
		JLabel lblOther = new JLabel("Description:");
		lblOther.setBounds(18, 193, 71, 14);
		NewConfirmUI.getContentPane().add(lblOther);
		
		HMOId_field = new JTextField();
		HMOId_field.setColumns(10);
		HMOId_field.setBounds(96, 328, 200, 25);
		NewConfirmUI.getContentPane().add(HMOId_field);
		
		doctor_name = new JTextField();
		doctor_name.setColumns(10);
		doctor_name.setBounds(96, 125, 200, 25);
		NewConfirmUI.getContentPane().add(doctor_name);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(96, 192, 200, 117);
		NewConfirmUI.getContentPane().add(scrollPane);
		
		JTextPane des_textPane = new JTextPane();
		scrollPane.setViewportView(des_textPane);
		des_textPane.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		
		JComboBox spec_comboBox = new JComboBox();
		spec_comboBox.setName("");
		spec_comboBox.setModel(new DefaultComboBoxModel(app_ctrl.getSpecialties()));
		spec_comboBox.setBounds(96, 156, 200, 25);
		NewConfirmUI.getContentPane().add(spec_comboBox);
		
		AproveNum_field = new JTextField();
		AproveNum_field.setColumns(10);
		AproveNum_field.setBounds(96, 390, 200, 25);
		NewConfirmUI.getContentPane().add(AproveNum_field);
		
		JLabel lblDoctorName = new JLabel("Doctor Name:");
		lblDoctorName.setBounds(20, 128, 69, 14);
		NewConfirmUI.getContentPane().add(lblDoctorName);
		
		JLabel lblSpeciality = new JLabel("speciality");
		lblSpeciality.setBounds(18, 161, 71, 14);
		NewConfirmUI.getContentPane().add(lblSpeciality);
		
		RefNum_field = new JTextField();
		RefNum_field.setColumns(10);
		RefNum_field.setBounds(96, 359, 200, 25);
		NewConfirmUI.getContentPane().add(RefNum_field);
		
		JLabel lblHmoId = new JLabel("HMO ID : ");
		lblHmoId.setBounds(20, 331, 66, 14);
		NewConfirmUI.getContentPane().add(lblHmoId);
		
		JLabel label = new JLabel(p.getSid());
		label.setBounds(96, 95, 200, 25);
		NewConfirmUI.getContentPane().add(label);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(110, 465, 89, 23);
		NewConfirmUI.getContentPane().add(btnSave);
		
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(211, 465, 89, 23);
		NewConfirmUI.getContentPane().add(btnCancel);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 Referral ref =new Referral(); 
				 
				ref.setDoctor_name(doctor_name.getText());
				ref.setSpeciality((String) spec_comboBox.getSelectedItem());
				ref.setDescription(des_textPane.getText());
				ref.setPatient(p);
				

				// HMOId_field.getText();
				// AproveNum_field.getText();;
				// RefNum_field.getText();
				 
				 RefCtrl.addReferralHMO(ref);
				/*id = FieldID.getText();
				Fname = FnameField.getText();
				Lname = LnameField.getText();
				phone = PhoneField.getText();
				email = EmailField.getText();
				address = AddressField.getText();
			

				/*if (!isvalid()){
					addPatient.setBounds(addPatient.getX(), addPatient.getY(), 500, addPatient.getHeight());
					return;
				}*/

			//	addPatient.setBounds(addPatient.getX(), addPatient.getY(), 350, addPatient.getHeight());

				/*Patient patient = new Patient();
				patient.setSid(id);
				patient.setFirstName(Fname);
				patient.setLastName(Lname);
				patient.setEmail(email);
				patient.setPhone(phone);
				patient.setBirthDate(chooser.getDate());
				patient.setGender((String) comboBox_gender.getSelectedItem());
				patient.setAddress(address);
			
			
				Cctrl.AddNewPatient(patient);
			*/
			}

		});
		NewConfirmUI.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{logo}));
		NewConfirmUI.setBounds(100, 100, 316, 528);
		NewConfirmUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
