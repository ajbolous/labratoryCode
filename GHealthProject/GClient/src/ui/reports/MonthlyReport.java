package ui.reports;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import Client.Application;
import Client.Client;
import Client.Resources;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import models.Appointment;
import models.Report;
import models.Statistic;
import ui.utils.MyTableModel;
import Utils.DateTime;
import Utils.Request;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class MonthlyReport {
	private JFrame monthlyReport;
	private JTable monthly_table;
	private JTable table;
	private Statistic s;
	private Appointment a;
	private int t;
	private JTextField txtPavg;
	private JTextField txtPmax;
	private JTextField txtPmin;
	private JTextField txtPstd;
	private JTextField txtWavg;
	private JTextField txtWmax;
	private JTextField txtWmin;
	private JTextField txtWstd;

	/**
	 * @wbp.parser.entryPoint
	 */

	public MonthlyReport() {
		initialize();
		monthlyReport.setVisible(true);
	}

	private void initialize() {
		
		int weekNum;
		Report r = new Report();
		Resources res = new Resources();
		monthlyReport = new JFrame();
		monthlyReport.getContentPane().setBackground(Color.WHITE);
		monthlyReport.setResizable(true);
		monthlyReport.getContentPane().setLayout(null);
		monthlyReport.setTitle("Monthly Report");
		Image icon = new ImageIcon(this.getClass().getResource(
				"/img/" + "icon.png")).getImage();
		monthlyReport.setIconImage(icon);
		JLabel lblChooseDate = new JLabel("Choose Date :");
		lblChooseDate.setForeground(new Color(0, 0, 0));
		lblChooseDate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblChooseDate.setBounds(10, 59, 84, 20);
		monthlyReport.getContentPane().add(lblChooseDate);
		
		JLabel logo = new JLabel("Monthly Report");
		logo.setBounds(0, 0, 439, 50);
		logo.setForeground(SystemColor.textHighlight);
		logo.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 17));
		logo.setBackground(Color.WHITE);
		logo.setIcon(res.getIcon("logo.png"));
		monthlyReport.getContentPane().add(logo);

		JComboBox<String> months = new JComboBox<String>();
		for (Date d : DateTime.getMonths(2016)){
			months.addItem(DateTime.getDateString(d));
		}
		months.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Date cDate = new Date();
				try {
					cDate = Utils.DateTime.getReportDate((String)months.getSelectedItem());
				} catch (ParseException e) {
					e.printStackTrace();
				}

				fillMonthlyReport(cDate);
				
			}
		});
		
		months.setForeground(new Color(0, 0, 0));
		months.setBackground(new Color(192, 192, 192));
		months.setBounds(104, 59, 335, 22);

		monthlyReport.getContentPane().add(months);
		monthlyReport.setBounds(100, 100, 465, 511);

		JScrollPane weekly_scrll_table = new JScrollPane();
		weekly_scrll_table.setBounds(10, 90, 430, 240);
		monthlyReport.getContentPane().add(weekly_scrll_table);

		monthly_table = new JTable();
		String[] report_rawNames = { "Day", "Number Of Patients","Waiting Period" };
		monthly_table.setModel(new MyTableModel(report_rawNames,
				new Object[][] {}));
		monthly_table.setFillsViewportHeight(true);
		monthly_table.setSurrendersFocusOnKeystroke(true);
		monthly_table.setShowVerticalLines(false);
		monthly_table.setRowHeight(30);
		monthly_table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		weekly_scrll_table.setViewportView(monthly_table);
		monthly_table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		monthly_table.setBackground(Color.WHITE);
		
		txtPavg = new JTextField();
		txtPavg.setEditable(false);
		txtPavg.setBounds(30, 388, 95, 20);
		monthlyReport.getContentPane().add(txtPavg);
		txtPavg.setColumns(10);
		
		txtPmax = new JTextField();
		txtPmax.setEditable(false);
		txtPmax.setColumns(10);
		txtPmax.setBounds(135, 388, 95, 20);
		monthlyReport.getContentPane().add(txtPmax);
		
		txtPmin = new JTextField();
		txtPmin.setEditable(false);
		txtPmin.setColumns(10);
		txtPmin.setBounds(240, 388, 95, 20);
		monthlyReport.getContentPane().add(txtPmin);
		
		txtPstd = new JTextField();
		txtPstd.setEditable(false);
		txtPstd.setColumns(10);
		txtPstd.setBounds(345, 388, 95, 20);
		monthlyReport.getContentPane().add(txtPstd);
		
		JLabel lblNewLabel_1 = new JLabel("Statistics");
		lblNewLabel_1.setForeground(new Color(30, 144, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(10, 341, 84, 14);
		monthlyReport.getContentPane().add(lblNewLabel_1);
		
		JLabel lblPatientsStatistics = new JLabel("Number of patients");
		lblPatientsStatistics.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPatientsStatistics.setBounds(20, 363, 130, 14);
		monthlyReport.getContentPane().add(lblPatientsStatistics);
		
		JLabel lblWaitingPeriodStatistics = new JLabel("Waiting period");
		lblWaitingPeriodStatistics.setHorizontalAlignment(SwingConstants.CENTER);
		lblWaitingPeriodStatistics.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblWaitingPeriodStatistics.setBounds(10, 419, 107, 14);
		monthlyReport.getContentPane().add(lblWaitingPeriodStatistics);
		
		txtWavg = new JTextField();
		txtWavg.setEditable(false);
		txtWavg.setColumns(10);
		txtWavg.setBounds(30, 444, 93, 20);
		monthlyReport.getContentPane().add(txtWavg);
		
		txtWmax = new JTextField();
		txtWmax.setEditable(false);
		txtWmax.setColumns(10);
		txtWmax.setBounds(135, 444, 93, 20);
		monthlyReport.getContentPane().add(txtWmax);
		
		txtWmin = new JTextField();
		txtWmin.setEditable(false);
		txtWmin.setColumns(10);
		txtWmin.setBounds(240, 444, 93, 20);
		monthlyReport.getContentPane().add(txtWmin);
		
		txtWstd = new JTextField();
		txtWstd.setEditable(false);
		txtWstd.setColumns(10);
		txtWstd.setBounds(345, 444, 93, 20);
		monthlyReport.getContentPane().add(txtWstd);
		monthly_table.setVisible(true);
		monthlyReport.getContentPane().setFocusTraversalPolicy(
				new FocusTraversalOnArray(new Component[] { logo }));

		monthlyReport.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	

	public void fillMonthlyReport(Date d) {
		Report report;
		Request r = new Request("reports/getMonthlyReport");
		r.addParam("date", d);
		report = (Report) Application.client.sendRequest(r);

		DefaultTableModel dm = (DefaultTableModel) monthly_table.getModel();
		dm.setNumRows(0);
		for (Statistic s : report.getStatistic())
			dm.addRow(new Object[] { Utils.DateTime.getDateString(s.getDate()), s.getNumOfPatients(),
					s.getWaitingPeriod() });
		txtPavg.setText("Average: " + report.getpAvg());
		txtWavg.setText("Average: " + report.getwAvg());
		
		txtPmax.setText("Max: " + report.getpMax());
		txtWmax.setText("Max: " + report.getwMax());
		
		txtPmin.setText("Min: " + report.getpMin());
		txtWmin.setText("Min: " + report.getwMin());
		
		txtPstd.setText(String.format("StdDev: %.2f",report.getpStd()));
		txtWstd.setText(String.format("StdDev: %.2f",report.getwStd()));

	}
	
	public JFrame getFrame() {
		return monthlyReport;
	}
}
