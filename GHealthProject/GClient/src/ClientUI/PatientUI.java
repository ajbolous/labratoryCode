package ClientUI;

import java.awt.EventQueue;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;

import Client.Resources;
import Controllers.IdentifecationController;

import javax.swing.BoxLayout;

import java.awt.GridLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.FlowLayout;

import javax.swing.SwingConstants;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import java.awt.Component;
import java.awt.SystemColor;

import javax.swing.JScrollPane;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.ParseException;


// PatientUI will be destroy 
public class PatientUI {

	private JFrame pat;
	private JTextField textField;
	private IdentifecationController idcontroller=new IdentifecationController();

	
	public PatientUI() {
		initialize();
		pat.setSize(400, 300);
		pat.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Resources res = new Resources();
		pat = new JFrame();
		pat.setTitle("PatientID - GHealth");
		pat.setResizable(false);
		Image icon= new ImageIcon(this.getClass().getResource("/img/" + "icon.png")).getImage();
		pat.setIconImage(icon);
		pat.setForeground(Color.BLACK);
		pat.setFont(new Font("Dialog", Font.PLAIN, 16));
		pat.setBackground(Color.WHITE);
		pat.getContentPane().setBackground(Color.WHITE);
		pat.getContentPane().setLayout(null);
		
		JLabel logo = new JLabel("GHealth - Patient");
		logo.setBounds(0, 0, 495, 80);
		logo.setForeground(SystemColor.textHighlight);
		logo.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 17));
		logo.setBackground(Color.WHITE);
		logo.setIcon(res.getIcon("logo.png"));
		pat.getContentPane().add(logo);
		
		JLabel lblPatientId = new JLabel("Patient Id :");
		lblPatientId.setBounds(30, 134, 88, 14);
		pat.getContentPane().add(lblPatientId);
		
		textField = new JTextField();
		
		textField.setBounds(99, 131, 246, 20);
		pat.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String Id = null;
				Id=textField.getText();
				if(Id.equals("")){
				 
				
					JOptionPane.showMessageDialog(pat,
					        "please Enter patient ID to open Medical Record" + "'.",
					        "Backup problem",
					        JOptionPane.ERROR_MESSAGE);
				}
				
				/*if(!checkFields(Id))
					{showMessage("");//check input 
					textField.setText("");//clearing textField to enter Id again
					
					}*/
				else{
					pat.setVisible(false);
					try {
						idcontroller.openMedicalRecord(Id);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				}

		
			
		});
		btnNewButton.setBounds(110, 184, 89, 23);
		pat.getContentPane().add(btnNewButton);
		
		JButton btnCancel = new JButton("cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pat.setVisible(false);
				ClientUI c = new ClientUI();
				
			}
		});
		btnCancel.setBounds(252, 184, 89, 23);
		pat.getContentPane().add(btnCancel);
		pat.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{logo}));
		pat.setBounds(100, 100, 501, 496);
		pat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	private boolean checkFields(String string){
		return true; 
	}
	private void showMessage(String string) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(pat,
		        string + "'.",
		        "Id problem",
		        JOptionPane.ERROR_MESSAGE);
		
	}
	public JFrame getFrame(){
		return pat;
	}
	
}
