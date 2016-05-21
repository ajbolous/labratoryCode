package ClientUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ListSelectionModel;

import models.Patient;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import Client.Resources;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.SwingConstants;

import java.awt.Insets;
import java.awt.Point;

public class Appointments {

	
	private JFrame app;
	private JTable apps_table;

	private Patient patient;
	
	public Appointments(Patient patient) {
		this.patient=patient;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Resources res = new Resources();
		app = new JFrame();
		app.setTitle("Client Appointments - GHealth");
		app.setResizable(false);
		Image icon= new ImageIcon(this.getClass().getResource("/img/" + "icon.png")).getImage();
		app.setIconImage(icon);
		app.setForeground(Color.BLACK);
		app.setFont(new Font("Dialog", Font.PLAIN, 16));
		app.setBackground(Color.WHITE);
		app.getContentPane().setBackground(Color.WHITE);
		app.getContentPane().setLayout(null);
		
		JLabel logo = new JLabel("GHealth - Appointments");
		logo.setBounds(0, 0, 495, 80);
		logo.setForeground(SystemColor.textHighlight);
		logo.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 17));
		logo.setBackground(Color.WHITE);
		logo.setIcon(res.getIcon("logo.png"));
		app.getContentPane().add(logo);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 91, 621, 45);
		app.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 11, 46, 21);
		panel.add(lblNewLabel);
		
		JLabel cName = new JLabel("Muhamad Igbaria");
		cName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cName.setBounds(61, 11, 140, 21);
		panel.add(cName);
		
		JLabel lblPhone = new JLabel("Phone:");
		lblPhone.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPhone.setBounds(211, 11, 67, 21);
		panel.add(lblPhone);
		
		JLabel label_1 = new JLabel("052-6833409");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_1.setBounds(264, 11, 85, 21);
		panel.add(label_1);
		
		JLabel lblEmail = new JLabel("E-Mail:");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmail.setBounds(387, 11, 46, 21);
		panel.add(lblEmail);
		
		JLabel lblMuhamadigacgmailcom = new JLabel("muhamadig.ac@gmail.com");
		lblMuhamadigacgmailcom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMuhamadigacgmailcom.setBounds(445, 8, 194, 27);
		panel.add(lblMuhamadigacgmailcom);
		
		JButton btnCancelSelectedAppointment = new JButton("Cancel Selected Appointment");
		btnCancelSelectedAppointment.setBounds(177, 140, 173, 30);
		app.getContentPane().add(btnCancelSelectedAppointment);
		
//		Table--------------------------
		
		JScrollPane apps_scrollPane = new JScrollPane();
		apps_scrollPane.setBounds(10, 220, 603, 208);
		app.getContentPane().add(apps_scrollPane);
		
		String[] doc_columnNames = {"Speciality","Doctor","Clinic","Date","Hour"};
		Object[][] doc_data = {
				{"Cardiologist","Muhamad","Haifa","23/1/2016","10:00"},
			   
				{"Cardiologist","Maysam","telaviv","15/11/2017","10:30"},
			  
				{"Cardiologist","Boulus","karmeil","15/7/2016","15:00"},
			
				{"Cardiologist","Ahdab","Clinic","20/5/2018","16:40"},
			 
				{"Cardiologist","Ahmad","Clinic","Date","Hour"},
			
				{"Cardiologist","Sargee","Clinic","Date","Hour"}
			
			};
		apps_table = new JTable();
		apps_table.setModel(new MyTableModel(doc_columnNames,doc_data));
		
		apps_table.setFillsViewportHeight(true);
		apps_table.setSurrendersFocusOnKeystroke(true);
		apps_table.setShowVerticalLines(false);
		apps_table.setRowHeight(30);
		apps_table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		apps_scrollPane.setViewportView(apps_table);
		apps_table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		apps_table.setBackground(SystemColor.menu);
		
		JLabel lblActiveFutureAppointments = new JLabel("Active Future Appointments :");
		lblActiveFutureAppointments.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblActiveFutureAppointments.setBounds(10, 190, 219, 25);
		app.getContentPane().add(lblActiveFutureAppointments);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(524, 439, 89, 23);
		app.getContentPane().add(btnBack);
		
		JButton btnAddNewAppointment = new JButton("Add New Appointment");
		btnAddNewAppointment.setBounds(10, 140, 157, 30);
		app.getContentPane().add(btnAddNewAppointment);
		
		
		
		
//		---------------------------------
		app.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{logo}));
		app.setBounds(100, 100, 629, 508);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public JFrame getFrame(){
		return app;
	}
}
