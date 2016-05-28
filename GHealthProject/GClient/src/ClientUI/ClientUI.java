package ClientUI;

import javax.swing.JFrame;
import java.awt.Color;

import javax.swing.JButton;
import Client.Application;
import Client.Config;
import Client.Resources;
import models.Doctor;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.SwingConstants;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Window.Type;
import java.awt.Panel;

public class ClientUI {

	private JFrame frame;
	private final JButton btnNewButton = new JButton("Patients");
	private final JButton btnLabs = new JButton("Appointments");
	private final JButton btnUsers = new JButton("Users");
	private final JButton btnTests = new JButton("Weekly reports");
	private final JLabel lblNewLabel = new JLabel("GHealth System");
	private final JLabel lblNewLabel_1 = new JLabel("");
	private final JButton btnMonthly = new JButton("Monthly reports");
	private final JLabel lblNewLabel_3 = new JLabel("Connected to server : ");
	private final JButton btnTests_1 = new JButton("Examinations");
	private final JButton btnResults = new JButton("Results");
	private final JLabel lblMedical = new JLabel("Medical and patients");
	private final JLabel lblLabratoriesAndTests = new JLabel("Labratories and examinations");
	private final JLabel lblManagmentAndReports = new JLabel("Managment and reports");

	public ClientUI() {
		initialize();
		frame.setSize(609, 495);
		frame.setVisible(true);
		lblNewLabel_1.setBounds(0, 0, 203, 44);
		lblNewLabel_1.setText(Application.user.getFirstName() + " " + Application.user.getLastName() + " (" + Application.user.getClass().getSimpleName() + ")");
		
		if(Application.client.isConnected())
			lblNewLabel_3.setText("Connected to server: " + Config.getConfig().getHost() + ":" + Config.getConfig().getPort());
		else
			lblNewLabel_3.setText("Offline");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 10));

		
		lblNewLabel_3.setBounds(10, 60, 308, 14);
		
		frame.getContentPane().add(lblNewLabel_3);
		
		Panel panel = new Panel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(20, 80, 570, 4);
		frame.getContentPane().add(panel);
		lblMedical.setForeground(new Color(0, 191, 255));
		lblMedical.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMedical.setBounds(20, 202, 203, 35);
		
		frame.getContentPane().add(lblMedical);
		lblLabratoriesAndTests.setForeground(new Color(0, 191, 255));
		lblLabratoriesAndTests.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLabratoriesAndTests.setBounds(20, 325, 274, 35);
		
		frame.getContentPane().add(lblLabratoriesAndTests);
		lblManagmentAndReports.setForeground(new Color(0, 191, 255));
		lblManagmentAndReports.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblManagmentAndReports.setBounds(17, 90, 276, 22);
		
		frame.getContentPane().add(lblManagmentAndReports);


	}

	private void initialize(){
		Resources res = new Resources();
		frame = new JFrame();
		frame.setResizable(false);
		frame.setIconImage(Resources.getImage("icon.png"));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(Color.WHITE);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Settings settings = new Settings();
			}
		});
		button.setHorizontalAlignment(SwingConstants.LEFT);
		button.setForeground(Color.BLACK);
		button.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button.setBorder(null);
		button.setBackground(Color.WHITE);
		button.setBounds(553, 0, 41, 35);
		button.setBorder(null);
		button.setIcon(res.getIcon("settings.png"));
		frame.getContentPane().add(button);
		button.setToolTipText("Doctors managment form");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Application.user.getClass().equals(Doctor.class)){
					AddPatientUI p = new AddPatientUI();
				}
			}
		});

		
		btnNewButton.setBounds(57, 249, 191, 65);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setIcon(res.getIcon("doctors.png"));
		btnNewButton.setBorder(null);
		btnTests_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				labratoryUI lab = new labratoryUI();
			}
		});

		btnTests_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnTests_1.setForeground(Color.BLACK);
		btnTests_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTests_1.setBorder(null);
		btnTests_1.setBackground(Color.WHITE);
		btnTests_1.setBounds(57, 376, 191, 68);
		btnTests_1.setIcon(res.getIcon("lab.png"));
		frame.getContentPane().add(btnTests_1);
		
		btnResults.setHorizontalAlignment(SwingConstants.LEFT);
		btnResults.setForeground(Color.BLACK);
		btnResults.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnResults.setBorder(null);
		btnResults.setBackground(Color.WHITE);
		btnResults.setBounds(259, 380, 181, 60);
		btnResults.setIcon(res.getIcon("treatment.png"));
		frame.getContentPane().add(btnResults);
		
		frame.getContentPane().add(btnNewButton);
		btnLabs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new Identification().getFrame().setVisible(true);
			}
		});
		btnLabs.setToolTipText("Laboratiries Managment form");
		btnLabs.setBounds(269, 254, 171, 60);
		btnLabs.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLabs.setHorizontalAlignment(SwingConstants.LEFT);
		btnLabs.setForeground(Color.BLACK);
		btnLabs.setBackground(Color.WHITE);
		btnLabs.setIcon(res.getIcon("appoitment.png"));
		btnLabs.setBorder(null);

		frame.getContentPane().add(btnLabs);
		btnUsers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUsers.setToolTipText("Users managment form");
	
		btnUsers.setBounds(452, 123, 128, 68);
		btnUsers.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnUsers.setBackground(Color.WHITE);
		btnUsers.setHorizontalAlignment(SwingConstants.LEFT);
		btnUsers.setForeground(Color.BLACK);
		btnUsers.setBorder(null);
		btnUsers.setIcon(res.getIcon("users.png"));
		btnUsers.setBorder(null);

		
		frame.getContentPane().add(btnUsers);
		btnTests.setBounds(54, 123, 194, 65);
		btnTests.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTests.setBackground(Color.WHITE);
		btnTests.setHorizontalAlignment(SwingConstants.LEFT);
		btnTests.setForeground(Color.BLACK);
		btnTests.setIcon(res.getIcon("tests.png"));
		btnTests.setBorder(null);

		btnMonthly.setHorizontalAlignment(SwingConstants.LEFT);
		btnMonthly.setForeground(Color.BLACK);
		btnMonthly.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnMonthly.setBorder(null);
		btnMonthly.setBackground(Color.WHITE);
		btnMonthly.setBounds(259, 123, 181, 68);
		btnMonthly.setIcon(res.getIcon("tests.png"));

		frame.getContentPane().add(btnMonthly);
		
		
		
		
		frame.getContentPane().add(btnTests);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(165, 0, 308, 60);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setIcon(res.getIcon("logo.png"));

		frame.getContentPane().add(lblNewLabel);
		lblNewLabel_1.setIcon(res.getIcon("user.png"));
		
		frame.getContentPane().add(lblNewLabel_1);
	}
}
