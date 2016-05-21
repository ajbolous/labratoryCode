package ClientUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import Client.Application;
import Client.Resources;
import Utils.Request;
import models.Doctor;

import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JList;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollBar;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.DefaultComboBoxModel;

public class NewApp  {

	private JFrame newApp;
	private JTable doctors_table;
	private JTable time_table;

	
	public  NewApp () {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Resources res = new Resources();
		newApp = new JFrame();
		newApp.setResizable(false);
		//JScrollPane pane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		//newApp.setContentPane(pane);
		newApp.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 16));
		newApp.setTitle("New Appointment- GHealth");
		Image icon= new ImageIcon(this.getClass().getResource("/img/" + "icon.png")).getImage();
		newApp.setIconImage(icon);
		newApp.setForeground(Color.BLACK);
		newApp.setFont(new Font("Dialog", Font.PLAIN, 16));
		newApp.setBackground(Color.WHITE);
		newApp.getContentPane().setBackground(Color.WHITE);
		newApp.getContentPane().setLayout(null);
		
		JLabel logo = new JLabel("GHealth - New Appointment");
		logo.setBounds(0, 0, 465, 64);
		logo.setForeground(SystemColor.textHighlight);
		logo.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 17));
		logo.setBackground(Color.WHITE);
		logo.setIcon(res.getIcon("logo.png"));
		newApp.getContentPane().add(logo);
		
		JComboBox speciality = new JComboBox();
		speciality.setModel(new DefaultComboBoxModel(new String[] {"Bone", "Family"}));
		speciality.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Request r = new Request("doctors/bySpeciality");
				r.addParam("speciality", speciality.getSelectedItem());
				ArrayList<Doctor> doctors = (ArrayList<Doctor>) Application.client.Request(r);
				int x = 10;
			}
		});
		speciality.setEditable(true);
		speciality.setBounds(120, 106, 247, 25);
		newApp.getContentPane().add(speciality);
		
		JLabel lblSpeciality = new JLabel("Speciality:");
		lblSpeciality.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSpeciality.setBounds(30, 100, 105, 32);
		newApp.getContentPane().add(lblSpeciality);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSave.setBounds(272, 567, 89, 23);
		newApp.getContentPane().add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int choise=JOptionPane.showConfirmDialog(null, "Are you sure you want to cancel this appointment setting", "Cancel", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				if(choise==JOptionPane.YES_OPTION) newApp.setVisible(false);
			}
		});
		btnCancel.setBounds(361, 567, 89, 23);
		newApp.getContentPane().add(btnCancel);
		
		JLabel lblDoctors = new JLabel("Doctors:");
		lblDoctors.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDoctors.setBounds(30, 142, 99, 32);
		newApp.getContentPane().add(lblDoctors);
		
		JLabel lblTime = new JLabel("Time:");
		lblTime.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTime.setBounds(30, 357, 62, 25);
		newApp.getContentPane().add(lblTime);
		
		JScrollPane doctors_scrll_table = new JScrollPane();
		doctors_scrll_table.setBounds(30, 171, 420, 175);
		newApp.getContentPane().add(doctors_scrll_table);
		
		String[] doc_columnNames = {"Doctor","Clinic","Last Visit"};
		Object[][] doc_data = {
			    {"Muhamad", "Haifa","22/1/2016"},
			   
			    {"Maysam", "Tel-aviv","22/1/2016"},
			  
			    {"Boulus", "Karmiel","22/1/2016"},
			
			    {"Ahdab", "Paris","NON"},
			 
			    {"Ahmad", "nasre","NON"},
			
			     {"Faysal", "majd elkroom","NON"}
			
			};
		doctors_table = new JTable();
		doctors_table.setModel(new MyTableModel(doc_columnNames,doc_data));
		
		doctors_table.setFillsViewportHeight(true);
		doctors_table.setSurrendersFocusOnKeystroke(true);
		doctors_table.setShowVerticalLines(false);
		doctors_table.setRowHeight(30);
		doctors_table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		doctors_scrll_table.setViewportView(doctors_table);
		doctors_table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		doctors_table.setBackground(SystemColor.menu);
		//doctors_table.setCellSelectionEnabled(false);
		
		JScrollPane time_scrll_table = new JScrollPane();
		time_scrll_table.setBounds(30, 381, 420, 175);
		newApp.getContentPane().add(time_scrll_table);
		
		
		
		
		String[] columnNames = {"Date",
                "Day",
                "Hour"};
		Object[][] data = {
			    {"23/2/2016", "Monday",
			     "15:30"},
			    {"15/3/2017", "Saunday",
			     "17:10"},
			    {"22/7/2016", "Sunday",
			     "10:00"},
			    {"27/8/2008", "Monday",
			     "12:30"},
			    {"22/2/2022", "Monday",
			     "20:00"}
			     , {"22/2/2022", "Monday",
			     "20:00"}
			};
		time_table = new JTable();
		time_table.setModel(new MyTableModel(columnNames,data));
		time_table.setFillsViewportHeight(true);
		time_table.setSurrendersFocusOnKeystroke(true);
		time_table.setShowVerticalLines(false);
		time_table.setRowHeight(30);
		
		time_table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		time_scrll_table.setViewportView(time_table);
		time_table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		time_table.setBackground(SystemColor.menu);
		
		
		newApp.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{logo}));
		newApp.setBounds(100, 100, 481, 632);
		newApp.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		newApp.setLocationRelativeTo(null);

		

	}
	
	public JFrame getFrame(){
		return newApp;
	}
}
