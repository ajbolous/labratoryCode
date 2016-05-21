package ClientUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import Client.Resources;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;



public class Dis_Identification implements FrameInterface {
	
	private JFrame disID;
	private JTextField IdTxt;
	private JLabel lblNewLabel;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JTextPane txtpnEnterPatientId;

	
	public Dis_Identification() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Resources res = new Resources();
		disID = new JFrame();
		disID.setTitle("Appointments- GHealth");
		disID.setResizable(false);
		Image icon= new ImageIcon(this.getClass().getResource("/img/" + "icon.png")).getImage();
		ImageIcon loginImg=res.getIcon("loginRow.png");
		disID.setIconImage(icon);
		disID.setForeground(Color.BLACK);
		disID.setFont(new Font("Dialog", Font.PLAIN, 16));
		disID.setBackground(Color.WHITE);
		disID.getContentPane().setBackground(Color.WHITE);
		disID.getContentPane().setLayout(null);
		
		IdTxt = new JTextField();
		IdTxt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		IdTxt.setBounds(80, 127, 165, 35);
		disID.getContentPane().add(IdTxt);
		IdTxt.setColumns(10);
		
		JButton login_btn = new JButton("");
		login_btn.setBackground(Color.CYAN);
		login_btn.setIcon(loginImg);
		login_btn.setBounds(243, 127, 35, 35);
		disID.getContentPane().add(login_btn);
		
		JLabel logo = new JLabel("Appointments");
		logo.setBounds(0, 0, 495, 80);
		logo.setForeground(SystemColor.textHighlight);
		logo.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 17));
		logo.setBackground(Color.WHITE);
		logo.setIcon(res.getIcon("logo.png"));
		disID.getContentPane().add(logo);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(80, 102, 200, 25);
		disID.getContentPane().add(lblNewLabel);
		
		btnNewButton = new JButton("Exit");
		btnNewButton.setBounds(260, 230, 89, 23);
		disID.getContentPane().add(btnNewButton);
		
		btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setBounds(172, 230, 89, 23);
		disID.getContentPane().add(btnNewButton_1);
		
		txtpnEnterPatientId = new JTextPane();
		txtpnEnterPatientId.setEditable(false);
		txtpnEnterPatientId.setText("Enter Patient ID to Open Patient's Appointments");
		txtpnEnterPatientId.setBounds(80, 168, 200, 35);
		disID.getContentPane().add(txtpnEnterPatientId);
		
	
		disID.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{logo}));
		disID.setBounds(100, 100, 365, 291);
		disID.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


	@Override
	public JFrame getFrame() {
		return disID;
	}
}
