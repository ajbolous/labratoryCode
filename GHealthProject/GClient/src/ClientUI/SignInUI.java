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

import Client.Resources;
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

public class SignInUI {

	private JFrame template;
	private JPasswordField passwordField;
	private JTextField textField;

	
	public SignInUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Resources res = new Resources();
		template = new JFrame();
		template.setTitle("Sign In - GHealth");
		template.setResizable(false);
		Image icon= new ImageIcon(this.getClass().getResource("/img/" + "icon.png")).getImage();
		template.setIconImage(icon);
		template.setForeground(Color.BLACK);
		template.setFont(new Font("Dialog", Font.PLAIN, 16));
		template.setBackground(Color.WHITE);
		template.getContentPane().setBackground(Color.WHITE);
		template.getContentPane().setLayout(null);
		
		JLabel logo = new JLabel("GHealth - Sign In");
		logo.setBounds(0, 0, 495, 80);
		logo.setForeground(SystemColor.textHighlight);
		logo.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 17));
		logo.setBackground(Color.WHITE);
		logo.setIcon(res.getIcon("logo.png"));
		template.getContentPane().add(logo);
		
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setBounds(106, 148, 46, 14);
		template.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setBounds(80, 189, 70, 14);
		template.getContentPane().add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(136, 182, 200, 28);
		template.getContentPane().add(passwordField);
		
		textField = new JTextField();
		textField.setBounds(136, 141, 200, 28);
		template.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnLogIn = new JButton("Log in ");
		btnLogIn.setBounds(185, 243, 89, 23);
		template.getContentPane().add(btnLogIn);
		template.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{logo}));
		template.setBounds(100, 100, 396, 315);
		template.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
