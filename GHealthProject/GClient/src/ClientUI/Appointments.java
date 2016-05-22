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

import models.Appointment;
import models.Patient;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import Utils.DateTime;
import Utils.Request;

import com.j256.ormlite.dao.ForeignCollection;

import Client.Application;
import Client.Resources;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import java.awt.Insets;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Appointments {

	private JFrame app;
	private JTable apps_table;

	private Patient patient;

	public Appointments(Patient patient) {
		this.patient = patient;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void getAppointments() {
		
		for (Appointment a : patient.getAppointments()) {
			DefaultTableModel dm = (DefaultTableModel) apps_table.getModel();
			dm.addRow(new Object[] { a.getDoctor().getSpeciality(),
					a.getDoctor().getFirstName(), a.getDoctor().getClinic().getName(),
					DateTime.getDateString(a.getTime()),
					DateTime.getTimeString(a.getTime()), a});

		}
		
		
		
	}

	private void initialize() {
		Resources res = new Resources();
		app = new JFrame();
		app.setTitle("Client Appointments - GHealth");
		app.setResizable(false);
		Image icon = new ImageIcon(this.getClass().getResource(
				"/img/" + "icon.png")).getImage();
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

		JLabel cName = new JLabel(patient.getFirstName() + " "
				+ patient.getLastName());
		cName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cName.setBounds(61, 11, 140, 21);
		panel.add(cName);

		JLabel lblPhone = new JLabel("Phone:");
		lblPhone.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPhone.setBounds(211, 11, 67, 21);
		panel.add(lblPhone);

		JLabel label_1 = new JLabel(patient.getPhone());
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_1.setBounds(264, 11, 85, 21);
		panel.add(label_1);

		JLabel lblEmail = new JLabel("E-Mail:");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmail.setBounds(387, 11, 46, 21);
		panel.add(lblEmail);

		JLabel lblMuhamadigacgmailcom = new JLabel(patient.getEmail());
		lblMuhamadigacgmailcom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMuhamadigacgmailcom.setBounds(445, 8, 194, 27);
		panel.add(lblMuhamadigacgmailcom);

		JButton cancel_btn = new JButton(
				"Cancel Selected Appointment");
		cancel_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int row = apps_table.getSelectedRow();
				Appointment a = (Appointment) apps_table.getModel().getValueAt(row,5);
				Request r = new  Request("appointments/delete");
				r.addParam("appointment",a);
				String s = (String) Application.client.sendRequest(r);
			}
		});
		cancel_btn.setVisible(false);
		cancel_btn.setBounds(194, 140, 230, 30);
		app.getContentPane().add(cancel_btn);

		JScrollPane apps_scrollPane = new JScrollPane();
		apps_scrollPane.setBounds(10, 220, 603, 208);
		app.getContentPane().add(apps_scrollPane);

		String[] doc_columnNames = { "Speciality", "Doctor", "Clinic", "Date","Hour","app" };
		Object[][] doc_data = {};
		apps_table = new JTable();
		apps_table.setModel(new MyTableModel(doc_columnNames, doc_data));
		getAppointments();
		apps_table.setFillsViewportHeight(true);
		apps_table.setSurrendersFocusOnKeystroke(true);
		apps_table.setShowVerticalLines(false);
		apps_table.setRowHeight(30);
		apps_table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		apps_scrollPane.setViewportView(apps_table);
		apps_table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		apps_table.setBackground(SystemColor.menu);

		JLabel lblActiveFutureAppointments = new JLabel(
				"Active Future Appointments :");
		lblActiveFutureAppointments.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblActiveFutureAppointments.setBounds(10, 190, 219, 25);
		app.getContentPane().add(lblActiveFutureAppointments);

		
		apps_table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
	        public void valueChanged(ListSelectionEvent event) {
	        	cancel_btn.setVisible(true);
	        	
	           // System.out.println(table.getValueAt(table.getSelectedRow(), 0).toString());
	        }
	    });
		JButton btnBack = new JButton("Exit Account");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				app.setVisible(false);
				new Identification().getFrame().setVisible(true);
			}
		});
		btnBack.setBounds(501, 439, 112, 23);
		app.getContentPane().add(btnBack);

		JButton newApp_btn = new JButton("Add New Appointment");
		newApp_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new NewApp().getFrame().setVisible(true);
			}
		});
		newApp_btn.setBounds(10, 140, 174, 30);
		app.getContentPane().add(newApp_btn);

		// ---------------------------------
		app.getContentPane().setFocusTraversalPolicy(
				new FocusTraversalOnArray(new Component[] { logo }));
		app.setBounds(100, 100, 629, 508);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setLocationRelativeTo(null);
	}

	public JFrame getFrame() {
		return app;
	}
}
