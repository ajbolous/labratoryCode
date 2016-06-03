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

import javax.swing.BoxLayout;

import java.awt.GridLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.FlowLayout;

import javax.swing.SwingConstants;

import models.Patient;

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
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private AppointmentsController app_ctrl = new AppointmentsController();
	private ConfirmationController ConformCtrl= new ConfirmationController(); 
	private JTextField textField_3;
	private JTextField textField_4;
	
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
		logo.setBounds(0, 0, 377, 80);
		logo.setForeground(SystemColor.textHighlight);
		logo.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 17));
		logo.setBackground(Color.WHITE);
		logo.setIcon(res.getIcon("logo.png"));
		NewConfirmUI.getContentPane().add(logo);
		
		JLabel lblPatientId = new JLabel("Patient ID");
		lblPatientId.setBounds(20, 100, 66, 14);
		NewConfirmUI.getContentPane().add(lblPatientId);
		
		JLabel lblRefferalNum = new JLabel("Refferal Num");
		lblRefferalNum.setBounds(20, 362, 66, 14);
		NewConfirmUI.getContentPane().add(lblRefferalNum);
		
		JLabel lblApprovalNum = new JLabel("Approval Num:");
		lblApprovalNum.setBounds(15, 387, 71, 14);
		NewConfirmUI.getContentPane().add(lblApprovalNum);
		
		JLabel lblOther = new JLabel("Description:");
		lblOther.setBounds(15, 193, 71, 14);
		NewConfirmUI.getContentPane().add(lblOther);
		
		textField = new JTextField(p.getSid());
		textField.setBounds(100, 100, 200, 20);
		NewConfirmUI.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(100, 328, 200, 20);
		NewConfirmUI.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(100, 125, 200, 20);
		NewConfirmUI.getContentPane().add(textField_2);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(110, 465, 89, 23);
		NewConfirmUI.getContentPane().add(btnSave);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

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
		
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(211, 465, 89, 23);
		NewConfirmUI.getContentPane().add(btnCancel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(101, 192, 200, 101);
		NewConfirmUI.getContentPane().add(scrollPane);
		
		JTextPane textPane = new JTextPane();
		scrollPane.setViewportView(textPane);
		textPane.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		
		JComboBox comboBox = new JComboBox();
		comboBox.setName("");
		comboBox.setModel(new DefaultComboBoxModel(app_ctrl.getSpecialties()));
		comboBox.setBounds(100, 156, 200, 25);
		NewConfirmUI.getContentPane().add(comboBox);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(101, 390, 200, 20);
		NewConfirmUI.getContentPane().add(textField_3);
		
		JLabel lblDoctorName = new JLabel("Doctor Name:");
		lblDoctorName.setBounds(15, 128, 71, 14);
		NewConfirmUI.getContentPane().add(lblDoctorName);
		
		JLabel lblSpeciality = new JLabel("speciality");
		lblSpeciality.setBounds(20, 161, 71, 14);
		NewConfirmUI.getContentPane().add(lblSpeciality);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(100, 359, 200, 20);
		NewConfirmUI.getContentPane().add(textField_4);
		
		JLabel lblHmoId = new JLabel("HMO ID : ");
		lblHmoId.setBounds(20, 331, 66, 14);
		NewConfirmUI.getContentPane().add(lblHmoId);
		NewConfirmUI.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{logo}));
		NewConfirmUI.setBounds(100, 100, 316, 528);
		NewConfirmUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
