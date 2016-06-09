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
import javax.swing.JRadioButton;
public class CeoReport {

	private JFrame ceoReport;
	private JTable ceo_table;
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

	public CeoReport() {
		initialize();
		ceoReport.setVisible(true);
	}

	private void initialize() {
		Date date1=null;
		int weekNum;
		Report r = new Report();
		Resources res = new Resources();
		ceoReport = new JFrame();
		ceoReport.getContentPane().setBackground(Color.WHITE);
		ceoReport.setResizable(true);
		ceoReport.getContentPane().setLayout(null);
		ceoReport.setTitle("CEO Report");
		Image icon = new ImageIcon(this.getClass().getResource(
				"/img/" + "icon.png")).getImage();
		ceoReport.setIconImage(icon);
		JLabel lblChooseDate = new JLabel("From :");
		lblChooseDate.setForeground(new Color(0, 0, 0));
		lblChooseDate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblChooseDate.setBounds(140, 107, 84, 20);
		ceoReport.getContentPane().add(lblChooseDate);
		lblChooseDate.setVisible(false);
		JLabel logo = new JLabel("CEO Report");
		logo.setBounds(0, 0, 439, 50);
		logo.setForeground(SystemColor.textHighlight);
		logo.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 17));
		logo.setBackground(Color.WHITE);
		logo.setIcon(res.getIcon("logo.png"));
		ceoReport.getContentPane().add(logo);

		
		JScrollPane weekly_scrll_table = new JScrollPane();
		weekly_scrll_table.setBounds(9, 141, 430, 240);
		ceoReport.getContentPane().add(weekly_scrll_table);

		ceo_table = new JTable();
		String[] report_rawNames = { "Day", "Number Of Patients","Waiting Period" };
		ceo_table.setModel(new MyTableModel(report_rawNames,
				new Object[][] {}));
		ceo_table.setFillsViewportHeight(true);
		ceo_table.setSurrendersFocusOnKeystroke(true);
		ceo_table.setShowVerticalLines(false);
		ceo_table.setRowHeight(30);
		ceo_table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		weekly_scrll_table.setViewportView(ceo_table);
		ceo_table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ceo_table.setBackground(Color.WHITE);
		
		txtPavg = new JTextField();
		txtPavg.setEditable(false);
		txtPavg.setBounds(29, 435, 95, 20);
		ceoReport.getContentPane().add(txtPavg);
		txtPavg.setColumns(10);
		
		txtPmax = new JTextField();
		txtPmax.setEditable(false);
		txtPmax.setColumns(10);
		txtPmax.setBounds(134, 435, 95, 20);
		ceoReport.getContentPane().add(txtPmax);
		
		txtPmin = new JTextField();
		txtPmin.setEditable(false);
		txtPmin.setColumns(10);
		txtPmin.setBounds(239, 435, 95, 20);
		ceoReport.getContentPane().add(txtPmin);
		
		txtPstd = new JTextField();
		txtPstd.setEditable(false);
		txtPstd.setColumns(10);
		txtPstd.setBounds(344, 435, 95, 20);
		ceoReport.getContentPane().add(txtPstd);
		
		JLabel lblNewLabel_1 = new JLabel("Statistics");
		lblNewLabel_1.setForeground(new Color(30, 144, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(9, 388, 84, 14);
		ceoReport.getContentPane().add(lblNewLabel_1);
		
		JLabel lblPatientsStatistics = new JLabel("Number of patients");
		lblPatientsStatistics.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPatientsStatistics.setBounds(19, 410, 130, 14);
		ceoReport.getContentPane().add(lblPatientsStatistics);
		
		JLabel lblWaitingPeriodStatistics = new JLabel("Waiting period");
		lblWaitingPeriodStatistics.setHorizontalAlignment(SwingConstants.CENTER);
		lblWaitingPeriodStatistics.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblWaitingPeriodStatistics.setBounds(9, 466, 107, 14);
		ceoReport.getContentPane().add(lblWaitingPeriodStatistics);
		
		txtWavg = new JTextField();
		txtWavg.setEditable(false);
		txtWavg.setColumns(10);
		txtWavg.setBounds(29, 491, 93, 20);
		ceoReport.getContentPane().add(txtWavg);
		
		txtWmax = new JTextField();
		txtWmax.setEditable(false);
		txtWmax.setColumns(10);
		txtWmax.setBounds(134, 491, 93, 20);
		ceoReport.getContentPane().add(txtWmax);
		
		txtWmin = new JTextField();
		txtWmin.setEditable(false);
		txtWmin.setColumns(10);
		txtWmin.setBounds(239, 491, 93, 20);
		ceoReport.getContentPane().add(txtWmin);
		
		txtWstd = new JTextField();
		txtWstd.setEditable(false);
		txtWstd.setColumns(10);
		txtWstd.setBounds(344, 491, 93, 20);
		ceoReport.getContentPane().add(txtWstd);
		JComboBox<String> months = new JComboBox<String>();
		for (Date d : DateTime.getMonths(2016)){
			months.addItem(DateTime.getDateString(d));
		}
		months.addActionListener(new ActionListener() {
			/**
			 * this function set the source date into variable date1
			 */
			public void actionPerformed(ActionEvent arg0) {
				Date date1 = new Date();
				try {
					date1 = Utils.DateTime.getReportDate((String)months.getSelectedItem());
				} catch (ParseException e) {
					e.printStackTrace();
				}

				
			}
		});
		months.setForeground(new Color(0, 0, 0));
		months.setBackground(new Color(192, 192, 192));
		months.setBounds(183, 106, 107, 22);

		ceoReport.getContentPane().add(months);
		ceoReport.setBounds(100, 100, 499, 567);
		months.setVisible(false);
		
		JLabel lblTo = new JLabel("To :");
		lblTo.setForeground(Color.BLACK);
		lblTo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTo.setBounds(313, 107, 84, 20);
		ceoReport.getContentPane().add(lblTo);
		lblTo.setVisible(false);
		JComboBox<String> comboBox = new JComboBox<String>();
		for (Date d : DateTime.getMonths(2016)){
			comboBox.addItem(DateTime.getDateString(d));
		}
		months.addActionListener(new ActionListener() {
			/**
			 * this function set the target date into the variable date2
			 */
			public void actionPerformed(ActionEvent arg0) {
				Date date2 = new Date();
				try {
					date2 = Utils.DateTime.getReportDate((String)comboBox.getSelectedItem());
				} catch (ParseException e) {
					e.printStackTrace();
				}

				fillPeriodReports(date1,date2);
			}
		});
		comboBox.setForeground(Color.BLACK);
		comboBox.setBackground(Color.LIGHT_GRAY);
		comboBox.setBounds(339, 106, 107, 22);
		ceoReport.getContentPane().add(comboBox);
		comboBox.setVisible(false);
		
		JComboBox<Integer> comboBox_1 = new JComboBox<Integer>();
		for (int i=1;i<=12;i++){
			comboBox_1.addItem(i);;
		}
		comboBox_1.addActionListener(new ActionListener() {
			/**
			 * this function set the value of the n requested months into the variable n
			 */
			public void actionPerformed(ActionEvent arg0) {
				Date currDate=new Date();
				int n=(int) comboBox_1.getSelectedItem();
				try {
					currDate = Utils.DateTime.currentDate();
				
				} catch (ParseException e) {
					e.printStackTrace();
				}

				fillNReports(currDate,n);

			}
		});
		comboBox_1.setForeground(Color.BLACK);
		comboBox_1.setBackground(Color.LIGHT_GRAY);
		comboBox_1.setBounds(183, 72, 107, 22);
		ceoReport.getContentPane().add(comboBox_1);
		comboBox_1.setVisible(false);
		JLabel lblN = new JLabel("N :");
		lblN.setForeground(Color.BLACK);
		lblN.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblN.setBounds(148, 74, 37, 20);
		ceoReport.getContentPane().add(lblN);
		lblN.setVisible(false);
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Last N Months");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox_1.setVisible(true);
				lblN.setVisible(true);
			}
		});
		rdbtnNewRadioButton.setBounds(1, 71, 123, 25);
		ceoReport.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Specific Period");
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				months.setVisible(true);
				comboBox.setVisible(true);
				lblChooseDate.setVisible(true);
				lblTo.setVisible(true);
				
			}
		});
		rdbtnNewRadioButton_1.setBounds(1, 105, 123, 25);
		ceoReport.getContentPane().add(rdbtnNewRadioButton_1);
		ceo_table.setVisible(true);
		ceoReport.getContentPane().setFocusTraversalPolicy(
				new FocusTraversalOnArray(new Component[] { logo }));

		ceoReport.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
/**
 * this function takes n months and return  statistics from the current date to date n
 * @param curr
 * @param n
 */
	public void fillNReports(Date curr,int n) { 
		Report report;
		Request r = new Request("reports/getNMonths");
		r.addParam("N", n);
		report = (Report) Application.client.sendRequest(r);
		DefaultTableModel dm = (DefaultTableModel) ceo_table.getModel();
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
/**
 * this function gets two dates and fill a statistics for report between those two dates	
 * @param date1
 * @param date2
 */
	public void fillPeriodReports(Date date1,Date date2)
	{
		Report report;
		Request r = new Request("reports/getPeriodReport");
		r.addParam("date1", date1);
		r.addParam("date2", date2);
		report = (Report) Application.client.sendRequest(r);

		DefaultTableModel dm = (DefaultTableModel) ceo_table.getModel();
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
		return ceoReport;
	}
}
