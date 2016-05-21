package ClientUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import models.Appointment;
import models.Patient;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import Client.Resources;
import Controllers.PatientsController;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Identification implements FrameInterface {

	private JFrame disID;
	private JTextField IdTxt;
	private JLabel error_lbl;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JTextPane txtpnEnterPatientId;
	private JLabel lblNewLabel_1;

	private PatientsController idctrl = new PatientsController();

	public Identification() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Resources res = new Resources();
		disID = new JFrame();
		disID.setTitle("Appointments- GHealth");
		disID.setResizable(false);
		Image icon = new ImageIcon(this.getClass().getResource("/img/" + "icon.png")).getImage();
		ImageIcon loginImg = res.getIcon("loginRow.png");
		disID.setIconImage(icon);
		disID.setForeground(Color.BLACK);
		disID.setFont(new Font("Dialog", Font.PLAIN, 16));
		disID.setBackground(Color.WHITE);
		disID.getContentPane().setBackground(Color.WHITE);
		disID.getContentPane().setLayout(null);

		IdTxt = new JTextField();
		IdTxt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				identificationHandler();
			}
		});
		IdTxt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		IdTxt.setBounds(80, 127, 165, 35);
		disID.getContentPane().add(IdTxt);
		IdTxt.setColumns(10);

		JButton login_btn = new JButton("Enter");
		login_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				identificationHandler();
			}
		});
		login_btn.setBorder(null);
		login_btn.setBackground(Color.WHITE);
		login_btn.setIcon(loginImg);
		login_btn.setBounds(245, 127, 64, 35);
		disID.getContentPane().add(login_btn);

		JLabel logo = new JLabel("Appointments");
		logo.setBounds(0, 0, 495, 80);
		logo.setForeground(SystemColor.textHighlight);
		logo.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 17));
		logo.setBackground(Color.WHITE);
		logo.setIcon(res.getIcon("logo.png"));
		disID.getContentPane().add(logo);

		error_lbl = new JLabel("");
		error_lbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		error_lbl.setForeground(Color.RED);
		error_lbl.setBounds(80, 102, 269, 25);
		disID.getContentPane().add(error_lbl);

		btnNewButton = new JButton("Exit");
		btnNewButton.setBounds(260, 230, 89, 23);
		disID.getContentPane().add(btnNewButton);

		btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setBounds(172, 230, 89, 23);
		disID.getContentPane().add(btnNewButton_1);

		txtpnEnterPatientId = new JTextPane();
		txtpnEnterPatientId.setEditable(false);
		txtpnEnterPatientId.setText("Enter Patient ID to Open Patient's Appointments");
		txtpnEnterPatientId.setBounds(80, 168, 200, 35);
		disID.getContentPane().add(txtpnEnterPatientId);

		lblNewLabel_1 = new JLabel("");
		ImageIcon info = res.getIcon("info.png");
		lblNewLabel_1.setIcon(info);
		lblNewLabel_1.setBounds(26, 113, 44, 70);
		disID.getContentPane().add(lblNewLabel_1);

		disID.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { logo }));
		disID.setBounds(100, 100, 365, 291);
		disID.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		disID.setLocationRelativeTo(null);

		
		
	}

	private void identificationHandler() {
		String id = IdTxt.getText();
		Patient patient;

		error_lbl.setText("");
		if (UITests.notEmpty(id) == false)
			error_lbl.setText("*Please enter patient ID");
		else if (UITests.correctId(id) == false)
			error_lbl.setText("*Please enter 9 digits ID");
		else if ((patient = idctrl.getById(id)) == null)
			error_lbl.setText("*Patient does not exist in the system");
		else {
			disID.setVisible(false);
			new Appointments(patient).getFrame().setVisible(true);
		}

	}

	@Override
	public JFrame getFrame() {
		return disID;
	}
}
