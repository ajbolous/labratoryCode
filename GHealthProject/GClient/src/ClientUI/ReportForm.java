package ClientUI;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;

import javax.swing.JFrame;

import Client.Resources;

import javax.swing.JButton;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JToggleButton;
import javax.swing.JRadioButton;
import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class ReportForm {
	private JFrame newReport;
	public  ReportForm () {
		initialize();
		newReport.show();
		
	}
	private void initialize() {
		Resources res = new Resources();
		JFrame ReportForm = new JFrame();
		ReportForm.getContentPane().setBackground(new Color(255, 255, 255));
		ReportForm.setResizable(false);
		ReportForm.getContentPane().setLayout(null);
		
		newReport.setTitle("Reports");
		Image icon= new ImageIcon(this.getClass().getResource("/img/" + "icon.png")).getImage();
		ReportForm.setIconImage(icon);
		
		JLabel logo = new JLabel("GHealth - Reports");
		logo.setBounds(0, 0, 541, 70);
		logo.setForeground(SystemColor.textHighlight);
		logo.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 17));
		logo.setBackground(Color.WHITE);
		logo.setIcon(res.getIcon("logo.png"));
		ReportForm.getContentPane().add(logo);
		
		JButton btnNewButton = new JButton("Weekly Report");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				ReportForm.dispose();
				WeeklyReport wReport=new WeeklyReport();
				wReport.getFrame().setVisible(true);
			}
		});
		btnNewButton.setBackground(new Color(30, 144, 255));
		btnNewButton.setBounds(10, 124, 155, 37);
		ReportForm.getContentPane().add(btnNewButton);
		
		JButton btnMonthlyReport = new JButton("Monthly Report");
		btnMonthlyReport.setBackground(new Color(30, 144, 255));
		btnMonthlyReport.setBounds(184, 124, 155, 37);
		ReportForm.getContentPane().add(btnMonthlyReport);
		
		JButton btnNewButton_1 = new JButton("CEO Report");
		btnNewButton_1.setBackground(new Color(30, 144, 255));
		btnNewButton_1.setBounds(364, 124, 155, 37);
		ReportForm.getContentPane().add(btnNewButton_1);
		
		
		
		
	}
	public JFrame getFrame(){
		return newReport;
	}
}
