package ui.main;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;

import Client.Application;
import Client.Config;
import Client.Resources;
import models.*;
import ui.appointments.DoctorAppointments;
import ui.labratories.Labratory;
import ui.medical.TreatmentsInvoiceUI;
import ui.reports.MonthlyReport;
import ui.reports.WeeklyReport;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.SwingConstants;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Panel;

import javax.swing.ImageIcon;

public class ClientUI {

	private JFrame frame;
	private final JButton btnMedicalRecords = new JButton("Medical Records");
	private final JButton btnAppointments = new JButton("Appointments");
	private final JButton btnUsers = new JButton("Users");
	private final JButton btnWeeklyReport = new JButton("Weekly reports");
	private final JLabel lblNewLabel = new JLabel("GHealth System");
	private final JLabel lblNewLabel_1 = new JLabel("");
	private final JButton btnMonthlyReport = new JButton("Monthly reports");
	private final JButton btnConformation = new JButton("Conformation");
	private final JButton btnCreateInvoice = new JButton("Create Invoice");
	private final JLabel lblNewLabel_3 = new JLabel("Connected to server : ");
	private final JButton btnExaminations = new JButton("Examinations");
	private final JButton btnResults = new JButton("Results");
	private final JLabel lblMedical = new JLabel("Medical and patients");
	private final JLabel lblLabratoriesAndTests = new JLabel("Labratories and examinations");
	private final JLabel lblManagmentAndReports = new JLabel("Managment and reports");

	public ClientUI() {
		initialize();
		frame.setSize(601, 684);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		lblNewLabel_1.setBounds(331, 21, 279, 44);
		lblNewLabel_1.setText(Application.user.getFirstName() + " " + Application.user.getLastName() + " ("
				+ Application.user.getClass().getSimpleName() + ")");

		if (Application.client.isConnected())
			lblNewLabel_3.setText(
					"Connected to server: " + Config.getConfig().getHost() + ":" + Config.getConfig().getPort());
		else
			lblNewLabel_3.setText("Offline");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 10));

		lblNewLabel_3.setBounds(20, 634, 308, 14);

		frame.getContentPane().add(lblNewLabel_3);

		Panel panel = new Panel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(20, 80, 570, 4);
		frame.getContentPane().add(panel);
		lblMedical.setForeground(new Color(0, 191, 255));
		lblMedical.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMedical.setBounds(37, 107, 203, 35);

		frame.getContentPane().add(lblMedical);
		lblLabratoriesAndTests.setForeground(new Color(0, 191, 255));
		lblLabratoriesAndTests.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLabratoriesAndTests.setBounds(37, 230, 274, 35);

		frame.getContentPane().add(lblLabratoriesAndTests);
		lblManagmentAndReports.setForeground(new Color(0, 191, 255));
		lblManagmentAndReports.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblManagmentAndReports.setBounds(27, 360, 276, 22);

		frame.getContentPane().add(lblManagmentAndReports);
		setPermissions();
	}

	private void disableAllButtons() {
		btnWeeklyReport.setEnabled(false);
		btnMonthlyReport.setEnabled(false);
		btnUsers.setEnabled(false);
		btnCreateInvoice.setEnabled(false);
		btnConformation.setEnabled(false);
		btnExaminations.setEnabled(false);
		btnResults.setEnabled(false);
		btnMedicalRecords.setEnabled(false);
		btnAppointments.setEnabled(false);
	}

	private void setPermissions() {
		disableAllButtons();
		if (Application.user.getClass() == Doctor.class) {
			btnMedicalRecords.setEnabled(true);
			btnAppointments.setEnabled(true);
		} else if (Application.user.getClass() == Labratorian.class) {
			btnExaminations.setEnabled(true);
			btnResults.setEnabled(true);
		} else if (Application.user.getClass() == Secretary.class) {
			btnCreateInvoice.setEnabled(true);
			btnConformation.setEnabled(true);
		} else if (Application.user.getClass() == Manager.class) {
			btnWeeklyReport.setEnabled(true);
			btnMonthlyReport.setEnabled(true);
			btnUsers.setEnabled(true);
		} else if (Application.user.getClass() == Dispatcher.class) {
			btnAppointments.setEnabled(true);
		}

	}

	private void initialize() {

		Resources res = new Resources();
		frame = new JFrame();
		frame.setResizable(false);
		frame.setIconImage(Resources.getImage("icon.png"));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(Color.WHITE);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		btnMedicalRecords.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (Application.user.getClass().equals(Doctor.class)) {
					Identification p = new Identification();
					p.getFrame().setVisible(true);
				}
			}
		});

		btnMedicalRecords.setBounds(95, 157, 191, 68);
		btnMedicalRecords.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnMedicalRecords.setBackground(Color.WHITE);
		btnMedicalRecords.setHorizontalAlignment(SwingConstants.LEFT);
		btnMedicalRecords.setForeground(Color.BLACK);
		btnMedicalRecords.setIcon(Resources.getIcon("doctors.png"));
		btnMedicalRecords.setBorder(null);
		btnExaminations.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Labratory();
			}
		});

		btnExaminations.setHorizontalAlignment(SwingConstants.LEFT);
		btnExaminations.setForeground(Color.BLACK);
		btnExaminations.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnExaminations.setBorder(null);
		btnExaminations.setBackground(Color.WHITE);
		btnExaminations.setBounds(95, 289, 191, 68);
		btnExaminations.setIcon(Resources.getIcon("lab.png"));
		frame.getContentPane().add(btnExaminations);

		btnResults.setHorizontalAlignment(SwingConstants.LEFT);
		btnResults.setForeground(Color.BLACK);
		btnResults.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnResults.setBorder(null);
		btnResults.setBackground(Color.WHITE);
		btnResults.setBounds(342, 285, 181, 68);
		btnResults.setIcon(Resources.getIcon("treatment.png"));
		frame.getContentPane().add(btnResults);

		frame.getContentPane().add(btnMedicalRecords);
		btnAppointments.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Application.user.getClass().equals(Doctor.class)) {
					new DoctorAppointments((Doctor) Application.user);
					return;
				}

				new Identification().getFrame().setVisible(true);
			}
		});
		btnAppointments.setToolTipText("Laboratiries Managment form");
		btnAppointments.setBounds(342, 159, 171, 68);
		btnAppointments.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAppointments.setHorizontalAlignment(SwingConstants.LEFT);
		btnAppointments.setForeground(Color.BLACK);
		btnAppointments.setBackground(Color.WHITE);
		btnAppointments.setIcon(Resources.getIcon("appoitment.png"));
		btnAppointments.setBorder(null);

		frame.getContentPane().add(btnAppointments);
		btnUsers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UsersManagingUI();
			}
		});
		btnUsers.setToolTipText("Users managment form");

		btnUsers.setBounds(95, 555, 184, 68);
		btnUsers.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnUsers.setBackground(Color.WHITE);
		btnUsers.setHorizontalAlignment(SwingConstants.LEFT);
		btnUsers.setForeground(Color.BLACK);
		btnUsers.setBorder(null);
		btnUsers.setIcon(Resources.getIcon("users.png"));
		btnUsers.setBorder(null);

		frame.getContentPane().add(btnUsers);
		btnWeeklyReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				WeeklyReport report = new WeeklyReport();
				report.getFrame().setVisible(true);

			}
		});
		btnWeeklyReport.setBounds(98, 393, 181, 68);
		btnWeeklyReport.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnWeeklyReport.setBackground(Color.WHITE);
		btnWeeklyReport.setHorizontalAlignment(SwingConstants.LEFT);
		btnWeeklyReport.setForeground(Color.BLACK);
		btnWeeklyReport.setIcon(Resources.getIcon("tests.png"));
		btnWeeklyReport.setBorder(null);
		btnMonthlyReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				MonthlyReport mReport = new MonthlyReport();

				mReport.getFrame().setVisible(true);
			}
		});

		btnMonthlyReport.setHorizontalAlignment(SwingConstants.LEFT);
		btnMonthlyReport.setForeground(Color.BLACK);
		btnMonthlyReport.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnMonthlyReport.setBorder(null);
		btnMonthlyReport.setBackground(Color.WHITE);
		btnMonthlyReport.setBounds(335, 393, 181, 68);
		btnMonthlyReport.setIcon(Resources.getIcon("tests.png"));

		frame.getContentPane().add(btnMonthlyReport);

		frame.getContentPane().add(btnWeeklyReport);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(10, 11, 284, 60);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setIcon(Resources.getIcon("logo.png"));
		frame.getContentPane().add(lblNewLabel);
		lblNewLabel_1.setIcon(Resources.getIcon("user.png"));
		frame.getContentPane().add(lblNewLabel_1);
		btnConformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Identification();

			}
		});
		btnConformation.setIcon(new ImageIcon(ClientUI.class.getResource("/img/treatment.png")));
		btnConformation.setHorizontalAlignment(SwingConstants.LEFT);
		btnConformation.setForeground(Color.BLACK);
		btnConformation.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnConformation.setBorder(null);
		btnConformation.setBackground(Color.WHITE);
		btnConformation.setBounds(98, 479, 181, 68);
		frame.getContentPane().add(btnConformation);
		btnCreateInvoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new TreatmentsInvoiceUI();
			}
		});
		btnCreateInvoice.setIcon(new ImageIcon(ClientUI.class.getResource("/img/info.png")));
		btnCreateInvoice.setHorizontalAlignment(SwingConstants.LEFT);
		btnCreateInvoice.setForeground(Color.BLACK);
		btnCreateInvoice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCreateInvoice.setBorder(null);
		btnCreateInvoice.setBackground(Color.WHITE);
		btnCreateInvoice.setBounds(335, 479, 181, 68);
		frame.getContentPane().add(btnCreateInvoice);

	}
}
