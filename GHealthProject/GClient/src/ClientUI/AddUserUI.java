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

import javax.swing.JTextField;
import javax.swing.JPasswordField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JComboBox;
import javax.swing.DropMode;
import javax.swing.DefaultComboBoxModel;

public class AddUserUI {

	private JFrame template;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_5;
	private JTextField textField_6;
	private JComboBox day_cbox;
	
	
	private  int year;
	private  int month;
	private int numDays;


	
	public AddUserUI() {
		initialize();
		template.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Resources res = new Resources();
		template = new JFrame();
		template.setTitle("Add New Patient- GHealth");
		template.setResizable(false);
		Image icon= new ImageIcon(this.getClass().getResource("/img/" + "icon.png")).getImage();
		template.setIconImage(icon);
		template.setForeground(Color.BLACK);
		template.setFont(new Font("Dialog", Font.PLAIN, 16));
		template.setBackground(Color.WHITE);
		template.getContentPane().setBackground(Color.WHITE);
		template.getContentPane().setLayout(null);
		
		JLabel logo = new JLabel("GHealth - Add New Patient");
		logo.setBounds(0, 0, 458, 80);
		logo.setForeground(SystemColor.textHighlight);
		logo.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 15));
		logo.setBackground(Color.WHITE);
		logo.setIcon(res.getIcon("logo.png"));
		template.getContentPane().add(logo);
		
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setBounds(29, 106, 114, 35);
		template.getContentPane().add(lblNewLabel);
		
		JLabel label_1 = new JLabel("First Name:");
		label_1.setBounds(29, 136, 114, 35);
		template.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Last Name:");
		label_2.setBounds(29, 166, 114, 35);
		template.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("Birth Date:");
		label_3.setBounds(29, 196, 59, 35);
		template.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("Email:");
		label_4.setBounds(29, 226, 114, 35);
		template.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("Phone:");
		label_5.setBounds(29, 256, 114, 35);
		template.getContentPane().add(label_5);
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				
			}
		});
		
		textField.setBounds(90, 110, 252, 26);
		template.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(90, 140, 252, 26);
		template.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(90, 170, 252, 26);
		template.getContentPane().add(textField_3);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(90, 230, 252, 26);
		template.getContentPane().add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(90, 260, 252, 26);
		template.getContentPane().add(textField_6);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.printf(""+numDays);
			}
		});
		btnNewButton.setBounds(139, 297, 89, 23);
		template.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.setBounds(253, 297, 89, 23);
		template.getContentPane().add(btnNewButton_1);
		
	
		
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		JComboBox year_cbox1 = new JComboBox();
		year_cbox1.addItemListener(new java.awt.event.ItemListener() {
			public void itemStateChanged(java.awt.event.ItemEvent e) {
				year = Integer.parseInt((String)year_cbox1.getSelectedItem());
				
				
				
			}
		});
		year_cbox1.setBackground(Color.WHITE);
	    ArrayList <String> Y_tmp=new ArrayList();
		
		//-all the way to current year
		Y_tmp.add("Year");
		for(int i=currentYear; i>currentYear-100;i--){
			Y_tmp.add(""+i);
		}
		String[] y_temp = new String[Y_tmp.size()];
	y_temp =Y_tmp.toArray(y_temp);
	
			  year_cbox1.setModel(new DefaultComboBoxModel(y_temp)); 

		year_cbox1.setBounds(89, 203, 72, 20);
		template.getContentPane().add(year_cbox1);
		
		
		
		JComboBox mounth_cbox = new JComboBox();
		mounth_cbox.addItemListener(new java.awt.event.ItemListener() {
			public void itemStateChanged(java.awt.event.ItemEvent e) {
				String m = (String)mounth_cbox.getSelectedItem();
			System.out.printf(m);
				 month =  Integer.parseInt(m);
				//System.out.printf(""+year);
				switch (month) {
	            case 1: case 3: case 5:
	            case 7: case 8: case 10:
	            case 12:
	                numDays = 31;
	                
	                break;
	            case 4: case 6:
	            case 9: case 11:
	                numDays = 30;
	                break;
	            case 2:
	                if (((year % 4 == 0) && 
	                     !(year % 100 == 0))
	                     || (year % 400 == 0))
	                    numDays = 29;
	                else
	                    numDays = 28;
	                break;
	            default:
	                break;
	               
	        }
				day_cbox.insertItemAt("D", 1);
				
			}
		});
		
		
		mounth_cbox.setBackground(Color.WHITE);
		mounth_cbox.setModel(new DefaultComboBoxModel(new String[] {"Mounth", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		mounth_cbox.setBounds(171, 203, 80, 20);
		template.getContentPane().add(mounth_cbox);
		
		
		JComboBox day_cbox = new JComboBox();
		day_cbox.setBackground(Color.WHITE);
		day_cbox.setModel(new DefaultComboBoxModel(new String[]{"Days"}));
		
		day_cbox.setBounds(262, 203, 80, 20);
		template.getContentPane().add(day_cbox);
		template.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{logo}));
		template.setBounds(100, 100, 428, 370);
		template.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}


}