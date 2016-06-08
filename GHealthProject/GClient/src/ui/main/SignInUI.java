package ui.main;

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

import Client.Application;
import Client.Resources;
import Controllers.UsersController;
import models.User;
import ui.medical.TreatmentsInvoiceUI;
import ui.utils.UITests;

import javax.swing.BoxLayout;

import java.awt.GridLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.FlowLayout;

import javax.swing.SwingConstants;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import java.awt.Component;
import java.awt.SystemColor;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;
import java.awt.Dialog.ModalExclusionType;

public class SignInUI {

	private JFrame SignInUI;
	private JPasswordField passwordField;
	private JTextField textField;
	private int attempts = 0;
	private JButton btnLogIn = new JButton("Sign in ");

	public SignInUI() {
		initialize();
		SignInUI.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		SignInUI = new JFrame();
		SignInUI.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		SignInUI.setTitle("Sign In - GHealth");
		SignInUI.setResizable(false);
		Image icon= new ImageIcon(this.getClass().getResource("/img/" + "icon.png")).getImage();
		SignInUI.setIconImage(icon);
		SignInUI.setForeground(Color.BLACK);
		SignInUI.setFont(new Font("Dialog", Font.PLAIN, 16));
		SignInUI.setBackground(Color.WHITE);
		SignInUI.getContentPane().setBackground(Color.WHITE);
		SignInUI.getContentPane().setLayout(null);
		
		JLabel logo = new JLabel("Sign In");
		logo.setBounds(0, 0, 295, 50);
		logo.setForeground(new Color(0, 0, 0));
		logo.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 17));
		logo.setBackground(Color.WHITE);
		logo.setIcon(Resources.getIcon("logo.png"));
		SignInUI.getContentPane().add(logo);
		
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setBounds(10, 75, 46, 14);
		SignInUI.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setBounds(10, 107, 76, 14);
		SignInUI.getContentPane().add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(69, 104, 212, 21);
		SignInUI.getContentPane().add(passwordField);
		
		textField = new JTextField();
		textField.setBounds(69, 71, 212, 23);
		SignInUI.getContentPane().add(textField);
		textField.setColumns(10);
		
	
		
		JLabel labelDetails = new JLabel("Please enter user Id and Password");
		labelDetails.setForeground(Color.RED);
		labelDetails.setBounds(10, 132, 271, 14);
		SignInUI.getContentPane().add(labelDetails);
		labelDetails.setVisible(false);
		SignInUI.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{logo}));
		SignInUI.setBounds(100, 100, 301, 202);
		SignInUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		btnLogIn.setBounds(69, 147, 212, 23);
		SignInUI.getContentPane().add(btnLogIn);
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				labelDetails.setVisible(true);
				
				String pass=new String(passwordField.getPassword()); 
				
				if (UITests.notEmpty(textField.getText()) == false  && UITests.notEmpty(pass)== false){			
					labelDetails.setText("*Please enter ID and password");
					return;
				}
				else if (UITests.notEmpty(textField.getText()) == false){
					labelDetails.setText("*Please enter an ID");
					return;
				}
				else if (UITests.notEmpty(pass)== false){
					labelDetails.setText("*Please enter a password");
					return;	
				}
				else if (UITests.correctId(textField.getText()) == false){
					labelDetails.setText("*Please enter 9 digits ID");
					return;
				}
				
				User u = UsersController.getUser(textField.getText());
				if(u == null){
					labelDetails.setText("*User does not exist");
					return;
				}
				if(u.isLocked()){
					labelDetails.setText("*Your account is locked, contact admin");
					btnLogIn.setEnabled(false);
					return;
				}
				if(!UsersController.authinticateUser(u, pass)){
					labelDetails.setText("*Wrong password or username");
					attempts++;
					if(attempts>3){
						UsersController.setLocked(u,true);
						labelDetails.setText("*Your account has been locked, contact admin");
						btnLogIn.setEnabled(false);
					}
					return;
				}
				

				if(!UsersController.setOnline(u)){
						labelDetails.setText("*Unable to connect multiple users");
						return;
				}
				Application.user = u;
				ClientUI cui = new ClientUI();
				//SecretaryUI sec = new SecretaryUI();
				SignInUI.hide();
			}
		});
	}

	public JFrame getFrame() {
		// TODO Auto-generated method stub
		return SignInUI;
	}
}
