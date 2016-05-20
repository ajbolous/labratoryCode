package ClientUI;

import java.awt.Color;
import java.awt.Image;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import Client.Application;
import Client.Resources;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import models.Doctor;
import Utils.Request;

public class WeeklyReport {
	private JFrame weeklyReport;
	private JTable weekly_table;
	private JTable table;
	
	/**
	 * @wbp.parser.entryPoint
	 */
	private void initialize() 
	{
		Resources res = new Resources();
		weeklyReport = new JFrame();
		weeklyReport.setResizable(true);
		weeklyReport.getContentPane().setLayout(null);
		weeklyReport.setTitle("Weekly Report");
		Image icon= new ImageIcon(this.getClass().getResource("/img/" + "icon.png")).getImage();
		weeklyReport.setIconImage(icon);
		JLabel lblChooseDate = new JLabel("Choose Date :");
		lblChooseDate.setForeground(new Color(0, 0, 0));
		lblChooseDate.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblChooseDate.setBounds(10, 92, 103, 33);
		weeklyReport.getContentPane().add(lblChooseDate);
		
		JLabel logo = new JLabel("Weekly Report");
		logo.setBounds(0, 0, 541, 70);
		logo.setForeground(SystemColor.textHighlight);
		logo.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 17));
		logo.setBackground(Color.WHITE);
		logo.setIcon(res.getIcon("logo.png"));
		weeklyReport.getContentPane().add(logo);
		
		JComboBox dates = new JComboBox();
		dates.setForeground(new Color(0, 0, 0));
		dates.setBackground(new Color(192, 192, 192));
		dates.setBounds(137, 93, 244, 33);
		dates.setModel(new DefaultComboBoxModel(new String[] {"1/5/2016", "7/5/2016"}));// have to add array of dates

		weeklyReport.getContentPane().add(dates);
		
		JButton btnView = new JButton("View");
		
		
			
		btnView.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnView.setBackground(new Color(30, 144, 255));
		btnView.setForeground(new Color(0, 0, 0));
		btnView.setBounds(431, 95, 97, 29);
		weeklyReport.getContentPane().add(btnView);
		
		
		
		
		
		JScrollPane weekly_scrll_table = new JScrollPane();
		weekly_scrll_table.setBounds(30, 145, 552, 238);
		weeklyReport.getContentPane().add(weekly_scrll_table);
		
		
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				weekly_table.setVisible(true);
				
			}
		});
		String[] report_rawNames = {"Day", "Number Of Patients","Serves Time","Waiting Period"};
		Object[][] report_data = {
			    {"Sunday :", "20"},
			    {"Monday :", "35"},
			    {"Tuesday :", "40"},
			    {"Wednesday :", "50"},
			    {"Thursday :", "55"},
			    {"Friday :", "60"},
			    {"Saturday :", "70"}
			   
			};
		weekly_table = new JTable();
		weekly_table.setModel(new MyTableModel(report_rawNames,report_data));
		
		weekly_table.setFillsViewportHeight(true);
		weekly_table.setSurrendersFocusOnKeystroke(true);
		weekly_table.setShowVerticalLines(false);
		weekly_table.setRowHeight(30);
		weekly_table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		weekly_scrll_table.setViewportView(weekly_table);
		weekly_table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		weekly_table.setBackground(SystemColor.menu);
		weekly_table.setVisible(false);
		//doctors_table.setCellSelectionEnabled(false);
		
	}
	public JFrame getFrame(){
		return weeklyReport;
	}
}
