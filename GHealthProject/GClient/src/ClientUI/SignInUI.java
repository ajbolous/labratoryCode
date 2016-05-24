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

import Client.Application;
import Client.Resources;
import Controllers.IdentifecationController;
import models.User;

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

	
	public SignInUI() {
		initialize();
		SignInUI.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Resources res = new Resources();
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
		logo.setBounds(0, 0, 259, 60);
		logo.setForeground(new Color(0, 0, 0));
		logo.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 17));
		logo.setBackground(Color.WHITE);
		logo.setIcon(res.getIcon("logo.png"));
		SignInUI.getContentPane().add(logo);
		
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setBounds(10, 92, 46, 14);
		SignInUI.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setBounds(10, 124, 76, 14);
		SignInUI.getContentPane().add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(66, 121, 190, 21);
		SignInUI.getContentPane().add(passwordField);
		
		textField = new JTextField();
		textField.setBounds(66, 88, 190, 23);
		SignInUI.getContentPane().add(textField);
		textField.setColumns(10);
		
	
		
		JLabel labelDetails = new JLabel("Please enter user Id and Password");
		labelDetails.setBounds(10, 67, 246, 14);
		SignInUI.getContentPane().add(labelDetails);
		SignInUI.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{logo}));
		SignInUI.setBounds(100, 100, 331, 324);
		SignInUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnLogIn = new JButton("Sign in ");

		btnLogIn.setBounds(46, 185, 190, 23);
		SignInUI.getContentPane().add(btnLogIn);
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				char[] passy= passwordField.getPassword();  
				String pass=new String(passy); 
				User u = IdentifecationController.getUser(textField.getText());
				if (UITests.notEmpty(textField.getText()) == false  && UITests.notEmpty(pass)== false){			
					labelDetails.setText("*Please enter  ID and password");
					return;
				}
				else if (UITests.notEmpty(textField.getText()) == false){
					labelDetails.setText("*Please enter  ID");
					return;
				}
				else if (UITests.notEmpty(pass)== false){
					labelDetails.setText("*Please enter  password");
					return;	
				}
				else if (UITests.correctId(textField.getText()) == false){
					labelDetails.setText("*Please enter 9 digits ID");
					return;
				}
				if(u == null){
					labelDetails.setText("*User does not exist");
					return;
				}
				boolean status = IdentifecationController.authinticateUser(u, pass);
				if(status){
					u = IdentifecationController.setOnline(u);
					if(u==null){
						labelDetails.setText("*Couldnt connect user");
						return;
					}
					Application.user = u;
					ClientUI cui = new ClientUI();
					SignInUI.hide();
				}else{
					labelDetails.setText("*Wrong password ");
				}
			}
		});
		
	}

	public JFrame getFrame() {
		// TODO Auto-generated method stub
		return SignInUI;
	}
}
