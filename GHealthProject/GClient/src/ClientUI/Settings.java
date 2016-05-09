package ClientUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JTextField;

import Client.Client;
import Client.Config;
import Client.Resources;

import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import java.awt.Window.Type;
import java.awt.Font;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.CompoundBorder;

public class Settings {

	private JFrame frame;
	private JButton btnCancel;
	private JTextField txtHost;
	private JTextField txtPort;

	public Settings() {
		initialize();
		frame.setVisible(true);
		Config cfg = Config.getConfig();

		txtHost.setText(cfg.getHost());
		txtPort.setText(""+cfg.getPort());
		
	}


	private void initialize() {
		frame = new JFrame();
		frame.setType(Type.UTILITY);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 304, 195);

		frame.getContentPane().setLayout(null);

		Resources res = new Resources();

		JButton btnLogin = new JButton("Connect");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Config cfg = Config.getConfig();
				cfg.setHost(txtHost.getText());
				cfg.setPort(Integer.parseInt(txtPort.getText()));
				Application.connect();
				frame.dispose();
			}
		});
		btnLogin.setForeground(Color.BLACK);
		btnLogin.setBackground(Color.WHITE);

		btnLogin.setBounds(78, 134, 79, 20);
		frame.getContentPane().add(btnLogin);

		JLabel lblWelcomeToGhealth = new JLabel("Connect");
		lblWelcomeToGhealth.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblWelcomeToGhealth.setHorizontalAlignment(SwingConstants.LEFT);
		lblWelcomeToGhealth.setIcon(res.getIcon("logo.png"));
		lblWelcomeToGhealth.setBounds(0, 0, 278, 61);
		frame.getContentPane().add(lblWelcomeToGhealth);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnCancel.setForeground(Color.BLACK);
		btnCancel.setBackground(Color.WHITE);
		btnCancel.setBounds(205, 134, 79, 20);
		frame.getContentPane().add(btnCancel);
		
		txtHost = new JTextField();
		txtHost.setBounds(78, 72, 206, 20);
		frame.getContentPane().add(txtHost);
		txtHost.setColumns(10);
		
		txtPort = new JTextField();
		txtPort.setColumns(10);
		txtPort.setBounds(78, 103, 206, 20);
		frame.getContentPane().add(txtPort);
		
		JLabel lblNewLabel = new JLabel("Host:");
		lblNewLabel.setBounds(22, 75, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblPort = new JLabel("Port:");
		lblPort.setBounds(22, 106, 46, 14);
		frame.getContentPane().add(lblPort);
		frame.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{btnLogin, frame.getContentPane(), lblWelcomeToGhealth}));
	}
}
