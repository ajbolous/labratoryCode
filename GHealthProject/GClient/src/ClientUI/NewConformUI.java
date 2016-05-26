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
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import javax.swing.JPanel;

public class NewConformUI {

	private JFrame NewConformUI;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	
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
		
		JLabel logo = new JLabel("New Conformation");
		logo.setBounds(0, 0, 377, 80);
		logo.setForeground(SystemColor.textHighlight);
		logo.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 17));
		logo.setBackground(Color.WHITE);
		logo.setIcon(res.getIcon("logo.png"));
		NewConformUI.getContentPane().add(logo);
		
		JLabel lblPatientId = new JLabel("Patient ID");
		lblPatientId.setBounds(20, 100, 66, 14);
		NewConformUI.getContentPane().add(lblPatientId);
		
		JLabel lblRefferalNum = new JLabel("Refferal Num");
		lblRefferalNum.setBounds(20, 133, 66, 14);
		NewConformUI.getContentPane().add(lblRefferalNum);
		
		JLabel lblApprovalNum = new JLabel("Approval Num:");
		lblApprovalNum.setBounds(20, 163, 71, 14);
		NewConformUI.getContentPane().add(lblApprovalNum);
		
		JLabel lblOther = new JLabel("Other: ");
		lblOther.setBounds(20, 188, 71, 14);
		NewConformUI.getContentPane().add(lblOther);
		
		textField = new JTextField();
		textField.setBounds(100, 100, 200, 20);
		NewConformUI.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(100, 130, 200, 20);
		NewConformUI.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(100, 160, 200, 20);
		NewConformUI.getContentPane().add(textField_2);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(110, 281, 89, 23);
		NewConformUI.getContentPane().add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(211, 281, 89, 23);
		NewConformUI.getContentPane().add(btnCancel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(101, 190, 200, 80);
		NewConformUI.getContentPane().add(scrollPane);
		
		JTextPane textPane = new JTextPane();
		scrollPane.setViewportView(textPane);
		textPane.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		NewConformUI.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{logo}));
		NewConformUI.setBounds(100, 100, 320, 346);
		NewConformUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
