package ClientUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

import models.Appointment;
import models.Patient;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import Utils.DateTime;
import Utils.Request;

import com.j256.ormlite.dao.ForeignCollection;

import Client.Application;
import Client.Resources;
import Controllers.AppointmentsController;

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
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.awt.Frame;

public class Appointments {

	private JFrame app;
	private JTable apps_table;

	private Patient patient;

	
	private ArrayList<Appointment> apps_list= new ArrayList<Appointment>();

	private AppointmentsController apctrl=new AppointmentsController();
	public Appointments(Patient patient) {
		this.patient = patient;
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

		JLabel name_lbl = new JLabel(patient.getFirstName() + " "
				+ patient.getLastName());
		name_lbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		name_lbl.setBounds(61, 11, 140, 21);
		panel.add(name_lbl);

		JLabel lblPhone = new JLabel("Phone:");
		lblPhone.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPhone.setBounds(211, 11, 67, 21);
		panel.add(lblPhone);

		JLabel phone_lbl = new JLabel(patient.getPhone());
		phone_lbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		phone_lbl.setBounds(264, 11, 85, 21);
		panel.add(phone_lbl);

		JLabel lblEmail = new JLabel("E-Mail:");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmail.setBounds(387, 11, 46, 21);
		panel.add(lblEmail);

		JLabel mail_lbl = new JLabel(patient.getEmail());
		mail_lbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mail_lbl.setBounds(445, 8, 194, 27);
		panel.add(mail_lbl);

		JButton cancel_btn = new JButton("Cancel Selected Appointment");
		cancel_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int row = apps_table.getSelectedRow();
				Date current= new Date();
				Date appointment_date= apps_list.get(row).getAppointmentTime();
				Date curr_date = null;
				Date app_date=null;
				try {
					curr_date= DateTime.getDate(current.getYear(), current.getMonth(), current.getDay());
					app_date= DateTime.getDate(appointment_date.getYear(), appointment_date.getMonth(), appointment_date.getDay());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(curr_date.equals(app_date)){
					JOptionPane.showMessageDialog(cancel_btn, "Cannot cancel appointment of today", "Cancel Appointment", JOptionPane.ERROR_MESSAGE);

				}
				else{
					if(apctrl.deleteAppointment(apps_list.get(row))==false){
						JOptionPane.showMessageDialog(cancel_btn, "Cannot complete the request", "Cancel Appointment", JOptionPane.ERROR_MESSAGE);
					}
					else{
						apps_list.remove(row);
						DefaultTableModel dm = (DefaultTableModel) apps_table.getModel();
						dm.removeRow(row);
						JOptionPane.showMessageDialog(cancel_btn, "Appointment Canceled", "Cancel Appointment", JOptionPane.INFORMATION_MESSAGE);

					}
				}
				
				cancel_btn.setEnabled(false);
			}
		});
		cancel_btn.setEnabled(false);

		cancel_btn.setBounds(183, 140, 230, 30);
		app.getContentPane().add(cancel_btn);

		JScrollPane apps_scrollPane = new JScrollPane();
		apps_scrollPane.setBounds(10, 170, 603, 208);
		app.getContentPane().add(apps_scrollPane);

		String[] doc_columnNames = { "Speciality", "Doctor", "Clinic", "Date",
				"Hour" };
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
		apps_table.setBackground(Color.WHITE);

		apps_table.getSelectionModel().addListSelectionListener(
				new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent event) {
						cancel_btn.setEnabled(true);
						}
				});
		JButton btnBack = new JButton("Exit Account");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				app.setVisible(false);
				new Identification().getFrame().setVisible(true);
			}
		});
		btnBack.setBounds(501, 389, 112, 23);
		app.getContentPane().add(btnBack);

		JButton newApp_btn = new JButton("Add New Appointment");
		newApp_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new NewApp(patient).getFrame().setVisible(true);
			}
		});
		newApp_btn.setBounds(10, 140, 174, 30);
		app.getContentPane().add(newApp_btn);

		// ---------------------------------
		app.getContentPane().setFocusTraversalPolicy(
				new FocusTraversalOnArray(new Component[] { logo }));
		app.setBounds(100, 100, 629, 448);
		app.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		app.setLocationRelativeTo(null);
	}

	public JFrame getFrame() {
		return app;
	}

	private void getAppointments() {
		ForeignCollection<Appointment> apps=apctrl.getPatientAppointments(patient);
		for (Appointment a : apps) {
			DefaultTableModel dm = (DefaultTableModel) apps_table.getModel();
			dm.addRow(new Object[] { a.getDoctor().getSpeciality(),
					a.getDoctor().getFirstName(),
					a.getDoctor().getClinic().getName(),
					DateTime.getDateString(a.getAppointmentTime()),
					DateTime.getTimeString(a.getAppointmentTime())});
			
			apps_list.add(a);
		}
	}
}
