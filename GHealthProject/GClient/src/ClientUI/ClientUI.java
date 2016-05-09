package ClientUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JDesktopPane;

import java.awt.BorderLayout;

import javax.swing.JTextPane;

import java.awt.Color;

import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Client.Client;
import Client.Config;
import Client.Resources;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Window.Type;

public class ClientUI {

	private JFrame frame;
	private final JButton btnNewButton = new JButton("Physicians");
	private final JButton btnLabs = new JButton("Labs");
	private final JButton btnUsers = new JButton("Users");
	private final JButton btnTests = new JButton("Reports");
	private final JLabel lblNewLabel = new JLabel("GHealth System");
	private final JLabel lblNewLabel_1 = new JLabel("");
	private final JLabel lblNewLabel_2 = new JLabel("Views and Reports");
	private final JLabel lblManage = new JLabel("Managment");
	private final JButton btnMonthly = new JButton("Monthly reports");
	private final JButton button_2 = new JButton("Reports");
	private final JLabel lblNewLabel_3 = new JLabel("Connected to server : ");
	private final JLabel lblTestsAndResults = new JLabel("Tests and results");
	private final JButton btnTests_1 = new JButton("Tests");
	private final JButton btnResults = new JButton("Results");

	public ClientUI() {
		initialize();
		frame.setSize(781, 547);
		frame.setVisible(true);
		lblNewLabel_1.setBounds(503, 2, 221, 44);
		lblNewLabel_1.setText("Logged in as ProtoAdmin");
		
		if(Application.client.isConnected())
			lblNewLabel_3.setText("Connected to server: " + Config.getConfig().getHost() + ":" + Config.getConfig().getPort());
		else
			lblNewLabel_3.setText("Offline");

		
		lblNewLabel_3.setBounds(4, 505, 308, 14);
		
		frame.getContentPane().add(lblNewLabel_3);
		lblTestsAndResults.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTestsAndResults.setBounds(10, 359, 193, 22);
		
		frame.getContentPane().add(lblTestsAndResults);


	}

	private void initialize(){
		Resources res = new Resources();
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
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
		button.setBounds(726, 11, 39, 35);
		button.setBorder(null);
		button.setIcon(res.getIcon("settings.png"));
		frame.getContentPane().add(button);
		button.setToolTipText("Doctors managment form");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Physicians phys = new Physicians();
			}
		});
		
		
		btnNewButton.setBounds(34, 152, 169, 65);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setIcon(res.getIcon("doctors.png"));
		btnNewButton.setBorder(null);

		btnTests_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnTests_1.setForeground(Color.BLACK);
		btnTests_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTests_1.setBorder(null);
		btnTests_1.setBackground(Color.WHITE);
		btnTests_1.setBounds(34, 394, 151, 68);
		btnTests_1.setIcon(res.getIcon("lab.png"));
		frame.getContentPane().add(btnTests_1);
		
		btnResults.setHorizontalAlignment(SwingConstants.LEFT);
		btnResults.setForeground(Color.BLACK);
		btnResults.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnResults.setBorder(null);
		btnResults.setBackground(Color.WHITE);
		btnResults.setBounds(195, 394, 183, 68);
		btnResults.setIcon(res.getIcon("treatment.png"));
		frame.getContentPane().add(btnResults);
		
		frame.getContentPane().add(btnNewButton);
		btnLabs.setToolTipText("Laboratiries Managment form");
		btnLabs.setBounds(213, 152, 118, 65);
		btnLabs.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLabs.setHorizontalAlignment(SwingConstants.LEFT);
		btnLabs.setForeground(Color.BLACK);
		btnLabs.setBackground(Color.WHITE);
		btnLabs.setIcon(res.getIcon("result.png"));
		btnLabs.setBorder(null);

		frame.getContentPane().add(btnLabs);
		btnUsers.setToolTipText("Users managment form");
		btnUsers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Physicians users = new Physicians();
				
			}
		});
		btnUsers.setBounds(390, 150, 118, 68);
		btnUsers.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnUsers.setBackground(Color.WHITE);
		btnUsers.setHorizontalAlignment(SwingConstants.LEFT);
		btnUsers.setForeground(Color.BLACK);
		btnUsers.setBorder(null);
		btnUsers.setIcon(res.getIcon("users.png"));
		btnUsers.setBorder(null);

		
		frame.getContentPane().add(btnUsers);
		btnTests.setBounds(34, 264, 129, 68);
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
		btnMonthly.setBounds(195, 264, 183, 65);
		btnMonthly.setIcon(res.getIcon("tests.png"));

		frame.getContentPane().add(btnMonthly);
		button_2.setHorizontalAlignment(SwingConstants.LEFT);
		button_2.setForeground(Color.BLACK);
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_2.setBorder(null);
		button_2.setBackground(Color.WHITE);
		button_2.setBounds(390, 262, 183, 68);
		button_2.setIcon(res.getIcon("tests.png"));

		frame.getContentPane().add(button_2);
		
		
		
		
		frame.getContentPane().add(btnTests);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(0, 0, 366, 58);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setIcon(res.getIcon("logo.png"));

		frame.getContentPane().add(lblNewLabel);
		lblNewLabel_1.setIcon(res.getIcon("user.png"));
		
		frame.getContentPane().add(lblNewLabel_1);
		
		
		
		
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(10, 228, 193, 22);

		frame.getContentPane().add(lblNewLabel_2);
		lblManage.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblManage.setBounds(10, 100, 111, 22);
		
		frame.getContentPane().add(lblManage);
		
		
		
	}
}
