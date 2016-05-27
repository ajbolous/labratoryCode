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
import Controllers.PatientsController;

import javax.swing.BoxLayout;

import java.awt.GridLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.FlowLayout;

import javax.swing.SwingConstants;

import models.Patient;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import java.awt.Component;
import java.awt.SystemColor;

import javax.swing.JTextField;
import javax.swing.JPasswordField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JComboBox;
import javax.swing.DropMode;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;

public class AddPatientUI {

	private JFrame addPatient;
	private PatientsController idctrl = new PatientsController();
	private JTextField FieldID;
	private JTextField FnameField;
	private JTextField LnameField;
	private JTextField PhoneField;
	private JTextField EmailField;
	private JTextField AddressField; 
	private JComboBox day_cbox = new JComboBox();
	private JComboBox month_cbox = new JComboBox();
	private JComboBox year_cbox1= new JComboBox();	
	private JComboBox comboBox_gender = new JComboBox();
	private int numDays = 0;
	private Date date ; 
	
	
	private  int year;
	private  int month;
	private int day;
	private String id ;
	private String Fname ;
	private String Lname ;
	private String email;
	private String phone ; 
	private String address; 
	
	private JLabel msqlbl;
	private JLabel msqlbl_1;
	private JLabel msqlbl_2;
	private JLabel msqlbl_3;
	private JLabel msqlbl_4;
	private JLabel msqlbl_5;
	private JLabel msqlbl_6;
	private JLabel msqlbl_7;

	

	
	public AddPatientUI() {
		initialize();
		addPatient.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Resources res = new Resources();
		addPatient = new JFrame();
		addPatient.setTitle("Add New Patient- GHealth");
		addPatient.setResizable(false);
		Image icon= new ImageIcon(this.getClass().getResource("/img/" + "icon.png")).getImage();
		addPatient.setIconImage(icon);
		addPatient.setForeground(Color.BLACK);
		addPatient.setFont(new Font("Dialog", Font.PLAIN, 16));
		addPatient.setBackground(Color.WHITE);
		addPatient.getContentPane().setBackground(Color.WHITE);
		addPatient.getContentPane().setLayout(null);
		
		JLabel logo = new JLabel("GHealth - Add New Patient");
		logo.setBounds(0, 0, 458, 80);
		logo.setForeground(SystemColor.textHighlight);
		logo.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 15));
		logo.setBackground(Color.WHITE);
		logo.setIcon(res.getIcon("logo.png"));
		addPatient.getContentPane().add(logo);
		
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setBounds(29, 82, 114, 35);
		addPatient.getContentPane().add(lblNewLabel);
		
		JLabel label_1 = new JLabel("First Name:");
		label_1.setBounds(29, 112, 114, 35);
		addPatient.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Last Name:");
		label_2.setBounds(29, 142, 114, 35);
		addPatient.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("BirthDate:");
		label_3.setBounds(29, 172, 59, 35);
		addPatient.getContentPane().add(label_3);
		
		JLabel lblPhone = new JLabel("Phone:");
		lblPhone.setBounds(29, 262, 114, 35);
		addPatient.getContentPane().add(lblPhone);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(29, 232, 114, 35);
		addPatient.getContentPane().add(lblEmail);
		
		FieldID = new JTextField();
		FieldID.setBounds(90, 86, 252, 26);
		addPatient.getContentPane().add(FieldID);
		FieldID.setColumns(10);
		
		FnameField = new JTextField();
		FnameField.setColumns(10);
		FnameField.setBounds(90, 116, 252, 26);
		
	
		addPatient.getContentPane().add(FnameField);
		
		LnameField = new JTextField();
		LnameField.setColumns(10);
		LnameField.setBounds(90, 146, 252, 26);
		addPatient.getContentPane().add(LnameField);
		
		
		EmailField = new JTextField();
		EmailField.setColumns(10);
		EmailField.setBounds(90, 236, 252, 26);
		addPatient.getContentPane().add(EmailField);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setBounds(116, 359, 89, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)  {

				id= FieldID.getText();
				Fname= FnameField.getText();
			    Lname= LnameField.getText();
				phone= PhoneField.getText();
				email=EmailField.getText();
				address=AddressField.getText();
				  msqlbl.setText("");
				  msqlbl_1.setText("");
				  msqlbl_2.setText("");
				  msqlbl_3.setText("");
				  msqlbl_4.setText("");
				  msqlbl_5.setText("");
				  msqlbl_6.setText("");
				  msqlbl_7.setText("");
				  
				  if (!isvalid())
					  return ; 
				
					Patient patient = new Patient();
					patient.setSid(id);
					patient.setFirstName(Fname);
					patient.setLastName(Lname);
					patient.setEmail(email);
					patient.setPhone(phone);
					patient.setGender((String)comboBox_gender.getSelectedItem());
					patient.setAddress(address);
					
					idctrl.AddNewPatient(patient); 
					return;
							}
		   
		 

				
			}
		);
		addPatient.getContentPane().add(btnNewButton);
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.setBounds(230, 359, 89, 23);
		addPatient.getContentPane().add(btnNewButton_1);
		
	
		month_cbox.setModel(new DefaultComboBoxModel(new String[] {"Month"}));
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		year_cbox1 = new JComboBox();
		year_cbox1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)  {
				String y =  (String)year_cbox1.getSelectedItem();
				if (y.equals("Year"))
				{
					month_cbox.setModel(new DefaultComboBoxModel(new String[] {"Month"})) ;
					day_cbox.setModel(new DefaultComboBoxModel(new String[] {"Days"}));
				return;
				
				}
				year = Integer.parseInt(y);
				month_cbox.setModel(new DefaultComboBoxModel(new String[] {"Month", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
				
				
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

		year_cbox1.setBounds(89, 179, 72, 20);
		addPatient.getContentPane().add(year_cbox1);
		
		
		
		
		month_cbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)  {
				
				
				 String m = (String)month_cbox.getSelectedItem();
				 numDays = 0 ;
				if(m.equals("Month")) {day_cbox.setModel(new DefaultComboBoxModel(new String [] {"Day"})); return;}
				 month =  Integer.parseInt(m);
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
	            
	               
	        }
			
				
			String Days[]=new String [numDays+1];
			Days[0]="Day";
			for (int i=1;i<=numDays;i++)
				Days[i]=""+i;
			day_cbox.setModel(new DefaultComboBoxModel(Days));
			}
			
		});
		
		
		month_cbox.setBackground(Color.WHITE);
		

		month_cbox.setBounds(171, 179, 80, 20);
		addPatient.getContentPane().add(month_cbox);
		
		
		day_cbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)  {
				String d =  (String)day_cbox.getSelectedItem();
				if (d.equals("Days"))return ;
				day= Integer.parseInt(d);

			}
		});
		day_cbox.setBackground(Color.WHITE);
		day_cbox.setModel(new DefaultComboBoxModel(new String[] {"Day"}));
		day_cbox.setBounds(262, 179, 80, 20);
		addPatient.getContentPane().add(day_cbox);
		
		JLabel lblAdressess = new JLabel("Address:");
		lblAdressess.setBounds(29, 292, 114, 35);
		addPatient.getContentPane().add(lblAdressess);
		
		PhoneField = new JTextField();
		PhoneField.setColumns(10);
		PhoneField.setBounds(90, 266, 252, 26);
		addPatient.getContentPane().add(PhoneField);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setBounds(29, 202, 59, 35);
		addPatient.getContentPane().add(lblGender);
		comboBox_gender.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		
		
		comboBox_gender.setBounds(90, 206, 252, 20);
		addPatient.getContentPane().add(comboBox_gender);
		
		AddressField = new JTextField();
		AddressField.setColumns(10);
		AddressField.setBounds(90, 296, 252, 26);
		addPatient.getContentPane().add(AddressField);
		
	    msqlbl = new JLabel("ID:");
	    msqlbl.setForeground(Color.RED);
		msqlbl.setBounds(352, 82, 145, 35);
		addPatient.getContentPane().add(msqlbl);
		
		msqlbl_1 = new JLabel("First Name:");
		msqlbl_1.setForeground(Color.RED);
		msqlbl_1.setBounds(352, 112, 145, 35);
		addPatient.getContentPane().add(msqlbl_1);
		
	    msqlbl_2 = new JLabel("Last Name:");
	    msqlbl_2.setForeground(Color.RED);
		msqlbl_2.setBounds(352, 142, 145, 35);
		addPatient.getContentPane().add(msqlbl_2);
		
		msqlbl_3 = new JLabel("BirthDate:");
		msqlbl_3.setForeground(Color.RED);
		msqlbl_3.setBounds(352, 172, 145, 35);
		addPatient.getContentPane().add(msqlbl_3);
		
		msqlbl_4 = new JLabel("Gender:");
		msqlbl_4.setForeground(Color.RED);
		msqlbl_4.setBounds(352, 202, 145, 35);
		addPatient.getContentPane().add(msqlbl_4);
		
	    msqlbl_5 = new JLabel("Email:");
	    msqlbl_5.setForeground(Color.RED);
		msqlbl_5.setBounds(352, 232, 155, 35);
		addPatient.getContentPane().add(msqlbl_5);
		
	    msqlbl_6 = new JLabel("Phone:");
	    msqlbl_6.setForeground(Color.RED);
		msqlbl_6.setBounds(352, 262, 145, 35);
		addPatient.getContentPane().add(msqlbl_6);
		
		msqlbl_7 = new JLabel("Address:");
		msqlbl_7.setForeground(Color.RED);
		msqlbl_7.setBounds(352, 292, 145, 35);
		addPatient.getContentPane().add(msqlbl_7);
		
		addPatient.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{logo}));
		addPatient.setBounds(100, 100, 513, 459);
		addPatient.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

private Boolean isvalid(){
	   int flag=0; 
	  if (UITests.notEmpty(this.id) == false ){
			msqlbl.setText("*Please enter patient ID");
		 
	  }else if (UITests.correctId(this.id) == false){
		  msqlbl.setText("*ID should be 9 digit");
		  
	  } else if(idctrl.exists(this.id)){
	  
		  	msqlbl.setText("*is exist");
		  	
	  	
	  }else flag=1; 
	  
	  if (UITests.notEmpty(this.Fname) == false){
		  msqlbl_1.setText("*is Empty");
	  }else if(UITests.checkIsCh(this.Fname)==false){
		  msqlbl_1.setText("*should be only char");
	  }else flag=1; 
	  if( UITests.notEmptybirth(year_cbox1.getSelectedItem()) == false){
		  msqlbl_3.setText("choose a year,mounth,day");
	  }else if ( UITests.notEmptybirth(month_cbox.getSelectedItem()) == false){
		  msqlbl_3.setText("choose a mounth,day");
	  }else if ( UITests.notEmptybirth(day_cbox.getSelectedItem()) == false){
		  msqlbl_3.setText("choose a day");
	  }else flag=1; 
		  
		 
	  if (UITests.notEmpty(this.Lname) == false){
		  msqlbl_2.setText("*is Empty");
	  }else if(UITests.checkIsCh(this.Lname) == false){
		  msqlbl_2.setText("*should be only char");
	  }else flag=1; 
	  if (UITests.notEmpty(this.phone) == false){
		  msqlbl_6.setText("*is Empty");
	  }else if(UITests.checkIsDigit(this.phone)== false){
		  msqlbl_2.setText("*should be only digits");
	  }else flag=1; 
	  if (UITests.notEmpty(this.email) == false){
		  msqlbl_5.setText("*is Empty");

	  }else flag=1; 
	  if (UITests.notEmpty(this.address) == false){
		  msqlbl_7.setText("*is Empty");
	  }else flag=1; 
	  
    if (flag == 0 )
    	return false ; 
    else
    	return true; 
}

	
}
