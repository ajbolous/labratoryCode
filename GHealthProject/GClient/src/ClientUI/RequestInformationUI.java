package ClientUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import Client.Resources;

import javax.swing.JRadioButton;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JRadioButtonMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class RequestInformationUI {
     private JFrame requestInfo;
     private JLabel lblComments ;
     private JTextArea textArea;
     private JScrollPane scrollPane;
     private JRadioButton rdbtnNewRadioButton;
     private JLabel lblPleaseChooseType;

	
	public RequestInformationUI() {
		initialize();
		requestInfo.setSize(405, 394);
		requestInfo.setLocale(null);
		requestInfo.setLocationRelativeTo(null);
		requestInfo.setVisible(true);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Resources res = new Resources();
		requestInfo = new JFrame();
		requestInfo.setTitle("<Request Information> - GHealth");
		requestInfo.setResizable(false);
		Image icon= new ImageIcon(this.getClass().getResource("/img/" + "icon.png")).getImage();
		requestInfo.setIconImage(icon);
		requestInfo.setForeground(Color.BLACK);
		requestInfo.setFont(new Font("Dialog", Font.PLAIN, 16));
		requestInfo.setBackground(Color.WHITE);
		requestInfo.getContentPane().setBackground(Color.WHITE);
		requestInfo.getContentPane().setLayout(null);
		
		JLabel logo = new JLabel(" Request Information");
		logo.setBounds(0, 0, 399, 60);
		logo.setForeground(SystemColor.textHighlight);
		logo.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 17));
		logo.setBackground(Color.WHITE);
		logo.setIcon(res.getIcon("logo.png"));
		requestInfo.getContentPane().add(logo);
		requestInfo.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{logo}));
		requestInfo.setBounds(100, 100, 501, 496);
		requestInfo.setDefaultCloseOperation(requestInfo.DISPOSE_ON_CLOSE);
		
		JButton btnSend = new JButton("Send");
		btnSend.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSend.setEnabled(false);
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Messages.successMessage("Request was sended successfully", "success",requestInfo );
				requestInfo.setVisible(false);
			}
		});
		btnSend.setBounds(61, 315, 89, 23);
		requestInfo.getContentPane().add(btnSend);
		
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				requestInfo.setVisible(false);
			}
		});
		btnCancel.setBounds(210, 315, 89, 23);
		requestInfo.getContentPane().add(btnCancel);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("partial information");
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnNewRadioButton_1.setToolTipText("partial information request according to the doctor's specialty type");
		rdbtnNewRadioButton_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				btnSend.setEnabled(true);
				
			}
		});
		

	
		rdbtnNewRadioButton_1.setBounds(79, 130, 169, 23);
		requestInfo.getContentPane().add(rdbtnNewRadioButton_1);
		
		 rdbtnNewRadioButton = new JRadioButton("Complete Medical Record ");
		 rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnNewRadioButton.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				btnSend.setEnabled(true);
				
				 
			}
		});
		rdbtnNewRadioButton.setBounds(79, 172, 169, 23);
		requestInfo.getContentPane().add(rdbtnNewRadioButton);
		
		ButtonGroup group = new ButtonGroup();
		
	    group.add(rdbtnNewRadioButton);
	    group.add(rdbtnNewRadioButton_1);
	    
	    scrollPane = new JScrollPane();
	    scrollPane.setBounds(79, 225, 239, 47);
	     textArea = new JTextArea();
	     scrollPane.setViewportView(textArea);
	     requestInfo.getContentPane().add(scrollPane);
	     scrollPane.setVisible(true);
	     
	     
	    lblComments = new JLabel("Notes :");
	    lblComments.setFont(new Font("Tahoma", Font.PLAIN, 12));
	    lblComments.setBounds(27,230, 94, 14);
	    requestInfo.getContentPane().add(lblComments);
	    
	    lblPleaseChooseType = new JLabel("* Please choose type of request");
	    lblPleaseChooseType.setBounds(79, 109, 197, 14);
	    requestInfo.getContentPane().add(lblPleaseChooseType);
	    lblComments.setVisible(true);
	    
	   
	    
	    
		
	}
	
	
}



