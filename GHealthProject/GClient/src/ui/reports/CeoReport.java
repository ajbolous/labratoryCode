package ui.reports;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import Client.Application;
import Client.Client;
import Client.Config;
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
	JRadioButton rdbPeriodReport;

	/**
	 * @wbp.parser.entryPoint
	 */

	public CeoReport() {
		initialize();
		ceoReport.setVisible(true);
	}

	private void initialize() {
		Date date1 = null;
		int weekNum;
		Report r = new Report();
		Resources res = new Resources();
		ceoReport = new JFrame();
		ceoReport.getContentPane().setBackground(Color.WHITE);
		ceoReport.setResizable(true);
		ceoReport.getContentPane().setLayout(null);
		ceoReport.setTitle("CEO Report");
		Image icon = new ImageIcon(this.getClass().getResource("/img/" + "icon.png")).getImage();
		ceoReport.setIconImage(icon);
		JLabel lblChooseDate = new JLabel("From :");
		lblChooseDate.setForeground(new Color(0, 0, 0));
		lblChooseDate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblChooseDate.setBounds(140, 107, 37, 20);
		ceoReport.getContentPane().add(lblChooseDate);
		lblChooseDate.setVisible(false);
		JLabel logo = new JLabel("CEO Report");
		logo.setBounds(0, 0, 439, 50);
		logo.setForeground(SystemColor.textHighlight);
		logo.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 17));
		logo.setBackground(Color.WHITE);
		logo.setIcon(Resources.getIcon("logo.png"));
		ceoReport.getContentPane().add(logo);

		JScrollPane weekly_scrll_table = new JScrollPane();
		weekly_scrll_table.setBounds(9, 141, 535, 240);
		ceoReport.getContentPane().add(weekly_scrll_table);

		ceo_table = new JTable();
		String[] report_rawNames = { "Day", "Number Of Patients", "Waiting Period" };
		ceo_table.setModel(new MyTableModel(report_rawNames, new Object[][] {}));
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
		txtPavg.setBounds(29, 435, 101, 20);
		ceoReport.getContentPane().add(txtPavg);
		txtPavg.setColumns(10);

		txtPmax = new JTextField();
		txtPmax.setEditable(false);
		txtPmax.setColumns(10);
		txtPmax.setBounds(140, 435, 119, 20);
		ceoReport.getContentPane().add(txtPmax);

		txtPmin = new JTextField();
		txtPmin.setEditable(false);
		txtPmin.setColumns(10);
		txtPmin.setBounds(269, 435, 126, 20);
		ceoReport.getContentPane().add(txtPmin);

		txtPstd = new JTextField();
		txtPstd.setEditable(false);
		txtPstd.setColumns(10);
		txtPstd.setBounds(405, 435, 139, 20);
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
		txtWavg.setBounds(29, 491, 101, 20);
		ceoReport.getContentPane().add(txtWavg);

		txtWmax = new JTextField();
		txtWmax.setEditable(false);
		txtWmax.setColumns(10);
		txtWmax.setBounds(140, 491, 119, 20);
		ceoReport.getContentPane().add(txtWmax);

		txtWmin = new JTextField();
		txtWmin.setEditable(false);
		txtWmin.setColumns(10);
		txtWmin.setBounds(269, 491, 126, 20);
		ceoReport.getContentPane().add(txtWmin);

		txtWstd = new JTextField();
		txtWstd.setEditable(false);
		txtWstd.setColumns(10);
		txtWstd.setBounds(405, 491, 139, 20);
		ceoReport.getContentPane().add(txtWstd);
		JComboBox<String> cmbFromMonth = new JComboBox<String>();
		for (Date d : DateTime.getMonths(2016)) {
			cmbFromMonth.addItem(DateTime.getDateString(d));
		}

		cmbFromMonth.setForeground(new Color(0, 0, 0));
		cmbFromMonth.setBackground(new Color(192, 192, 192));
		cmbFromMonth.setBounds(183, 106, 107, 22);

		ceoReport.getContentPane().add(cmbFromMonth);
		ceoReport.setBounds(100, 100, 570, 567);
		cmbFromMonth.setVisible(false);

		JLabel lblTo = new JLabel("To :");
		lblTo.setForeground(Color.BLACK);
		lblTo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTo.setBounds(300, 107, 37, 20);
		ceoReport.getContentPane().add(lblTo);
		lblTo.setVisible(false);
		JComboBox<String> cmbToMonth = new JComboBox<String>();
		for (Date d : DateTime.getMonths(2016)) {
			cmbToMonth.addItem(DateTime.getDateString(d));
		}

		cmbToMonth.setForeground(Color.BLACK);
		cmbToMonth.setBackground(Color.LIGHT_GRAY);
		cmbToMonth.setBounds(329, 107, 98, 22);
		ceoReport.getContentPane().add(cmbToMonth);
		cmbToMonth.setVisible(false);

		JComboBox<Integer> cmbNMonths = new JComboBox<Integer>();
		for (int i = 1; i <= 12; i++) {
			cmbNMonths.addItem(i);
			;
		}

		cmbNMonths.setForeground(Color.BLACK);
		cmbNMonths.setBackground(Color.LIGHT_GRAY);
		cmbNMonths.setBounds(183, 72, 107, 22);
		ceoReport.getContentPane().add(cmbNMonths);
		cmbNMonths.setVisible(false);
		JLabel lblN = new JLabel("N :");
		lblN.setForeground(Color.BLACK);
		lblN.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblN.setBounds(148, 74, 37, 20);
		ceoReport.getContentPane().add(lblN);
		lblN.setVisible(false);
		JRadioButton rdbNReports = new JRadioButton("Last N Months");
		rdbNReports.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cmbNMonths.setVisible(true);
				lblN.setVisible(true);

				rdbPeriodReport.setSelected(false);
				cmbFromMonth.setVisible(false);
				cmbToMonth.setVisible(false);
				lblChooseDate.setVisible(false);
				lblTo.setVisible(false);
			}
		});
		rdbNReports.setBounds(9, 71, 123, 25);
		ceoReport.getContentPane().add(rdbNReports);

		rdbPeriodReport = new JRadioButton("Specific Period");
		rdbPeriodReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				rdbNReports.setSelected(false);
				cmbNMonths.setVisible(false);
				lblN.setVisible(false);

				cmbFromMonth.setVisible(true);
				cmbToMonth.setVisible(true);
				lblChooseDate.setVisible(true);
				lblTo.setVisible(true);

			}
		});
		rdbPeriodReport.setBounds(11, 106, 123, 25);
		ceoReport.getContentPane().add(rdbPeriodReport);

		JButton btnShowReport = new JButton("Show Report");
		btnShowReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (rdbNReports.isSelected())
					fillNReports((int) cmbNMonths.getSelectedItem());

				if (rdbPeriodReport.isSelected()) {
					try {
						Date date1 = Utils.DateTime.getReportDate((String) cmbFromMonth.getSelectedItem());
						Date date2 = Utils.DateTime.getReportDate((String) cmbToMonth.getSelectedItem());
						fillPeriodReports(date1, date2);

					} catch (ParseException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnShowReport.setBounds(437, 72, 107, 55);
		ceoReport.getContentPane().add(btnShowReport);
		ceo_table.setVisible(true);
		ceoReport.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { logo }));

		ceoReport.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}

	/**
	 * this function takes n months and return statistics from the current date
	 * to date n
	 * 
	 * @param curr
	 * @param n
	 */
	public void fillNReports(int n) {
		Report report;
		Request r = new Request("reports/getNMonths");
		r.addParam("N", n);
		report = (Report) Application.client.sendRequest(r);
		DefaultTableModel dm = (DefaultTableModel) ceo_table.getModel();
		dm.setNumRows(0);
		for (Statistic s : report.getStatistic())
			dm.addRow(new Object[] { Utils.DateTime.getDateString(s.getDate()), s.getNumOfPatients(),
					s.getWaitingPeriod() });

		fillTexts(report);

	}

	private void fillTexts(Report report) {
		txtPavg.setText(String.format("Average: %.2f", report.getpAvg()));
		txtWavg.setText(String.format("Average: %.2f", report.getwAvg()));

		txtPmax.setText(String.format("Max: %d", report.getpMax()));
		txtWmax.setText(String.format("Max: %d", report.getwMax()));

		txtPmin.setText(String.format("Min: %d", report.getpMin()));
		txtWmin.setText(String.format("Min: %d", report.getwMin()));

		txtPstd.setText(String.format("StdDev: %.2f", report.getpStd()));
		txtWstd.setText(String.format("StdDev: %.2f", report.getwStd()));

	}

	/**
	 * this function gets two dates and fill a statistics for report between
	 * those two dates
	 * 
	 * @param date1
	 * @param date2
	 */
	public void fillPeriodReports(Date date1, Date date2) {
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

		fillTexts(report);
	}

	public JFrame getFrame() {
		return ceoReport;
	}
}
