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
import javax.swing.JSplitPane;
import javax.swing.JTextField;

public class NewConformUI {

	private JFrame NewConformUI;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	
	public NewConformUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Resources res = new Resources();
		NewConformUI = new JFrame();
		NewConformUI.setTitle("New Conformation - GHealth");
		NewConformUI.setResizable(false);
		Image icon= new ImageIcon(this.getClass().getResource("/img/" + "icon.png")).getImage();
		NewConformUI.setIconImage(icon);
		NewConformUI.setForeground(Color.BLACK);
		NewConformUI.setFont(new Font("Dialog", Font.PLAIN, 16));
		NewConformUI.setBackground(Color.WHITE);
		NewConformUI.getContentPane().setBackground(Color.WHITE);
		NewConformUI.getContentPane().setLayout(null);
		
		JLabel logo = new JLabel("GHealth - New Conformation");
		logo.setBounds(0, 0, 495, 80);
		logo.setForeground(SystemColor.textHighlight);
		logo.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 17));
		logo.setBackground(Color.WHITE);
		logo.setIcon(res.getIcon("logo.png"));
		NewConformUI.getContentPane().add(logo);
		
		JLabel lblPatientId = new JLabel("Patient ID");
		lblPatientId.setBounds(37, 119, 66, 14);
		NewConformUI.getContentPane().add(lblPatientId);
		
		JLabel lblRefferalNum = new JLabel("Refferal Num");
		lblRefferalNum.setBounds(37, 153, 66, 14);
		NewConformUI.getContentPane().add(lblRefferalNum);
		
		JLabel lblApprovalNum = new JLabel("Approval Num:");
		lblApprovalNum.setBounds(32, 184, 71, 14);
		NewConformUI.getContentPane().add(lblApprovalNum);
		
		JLabel lblOther = new JLabel("Other: ");
		lblOther.setBounds(59, 223, 71, 14);
		NewConformUI.getContentPane().add(lblOther);
		
		textField = new JTextField();
		textField.setBounds(107, 116, 200, 20);
		NewConformUI.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(107, 150, 200, 20);
		NewConformUI.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(107, 181, 200, 20);
		NewConformUI.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(107, 221, 200, 80);
		NewConformUI.getContentPane().add(textField_3);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(107, 345, 89, 23);
		NewConformUI.getContentPane().add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(206, 345, 89, 23);
		NewConformUI.getContentPane().add(btnCancel);
		NewConformUI.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{logo}));
		NewConformUI.setBounds(100, 100, 501, 496);
		NewConformUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
