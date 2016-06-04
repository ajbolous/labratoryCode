package ui.labratories;

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

import Client.Application;
import Client.Resources;
import Controllers.ExaminationController;
import models.Appointment;
import models.Examination;
import models.Labratorian;
import ui.utils.MyTableModel;

import javax.swing.BoxLayout;

import java.awt.GridLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.FlowLayout;

import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import Utils.DateTime;

import java.awt.Component;
import java.awt.SystemColor;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Canvas;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextPane;

public class ExamEditor {

	private JFrame labratoryUI;
	private int  ex_id ; 
	private ExaminationController ex_ctrl= new ExaminationController(); 

	
	public ExamEditor() {
		initialize();
		labratoryUI.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Labratorian lab = (Labratorian) Application.user;
		Resources res = new Resources();
		labratoryUI = new JFrame();
		labratoryUI.setTitle("<Frame name> - GHealth");
		labratoryUI.setResizable(false);
		Image icon= new ImageIcon(this.getClass().getResource("/img/" + "icon.png")).getImage();
		labratoryUI.setIconImage(icon);
		labratoryUI.setForeground(Color.BLACK);
		labratoryUI.setFont(new Font("Dialog", Font.PLAIN, 16));
		labratoryUI.setBackground(Color.WHITE);
		labratoryUI.getContentPane().setBackground(Color.WHITE);
		labratoryUI.getContentPane().setLayout(null);
		
		JLabel logo = new JLabel("Examinations");
		logo.setBounds(0, 0, 645, 60);
		logo.setForeground(SystemColor.textHighlight);
		logo.setFont(new Font("Tahoma", Font.BOLD, 16));
		logo.setBackground(Color.WHITE);
		logo.setIcon(res.getIcon("logo.png"));
		labratoryUI.getContentPane().add(logo);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 66, 757, 157);
		labratoryUI.getContentPane().add(panel);
		
		JLabel lblPatient = new JLabel("Patient:");
		lblPatient.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPatient.setBounds(10, 11, 80, 21);
		panel.add(lblPatient);
		
		JLabel label_1 = new JLabel("<dynamic> <dynamic>");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_1.setBounds(106, 11, 207, 21);
		panel.add(label_1);
		
		label_1.setText(new String (lab.getFirstName()+" "+lab.getLastName()));
		
		JLabel label_3 = new JLabel((String) null);
		label_3.setHorizontalAlignment(SwingConstants.TRAILING);
		label_3.setVerticalAlignment(SwingConstants.TOP);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_3.setBounds(223, 11, 90, 21);
		panel.add(label_3);
		
		JLabel label_2 = new JLabel("<dynamic> <dynamic>");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_2.setBounds(502, 11, 239, 21);
		panel.add(label_2);
		try {
			label_2.setText(new String ("Tody:"+Utils.DateTime.currentDate().toString()));
			
			JLabel lblExaminationType = new JLabel("Examination Type:");
			lblExaminationType.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblExaminationType.setBounds(10, 43, 452, 21);
			panel.add(lblExaminationType);
			
			JLabel lblComments = new JLabel("Doctor comments:");
			lblComments.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblComments.setBounds(10, 75, 168, 21);
			panel.add(lblComments);
			
			JScrollPane scrollPane_1 = new JScrollPane();
			scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane_1.setBounds(161, 46, 416, 87);
			panel.add(scrollPane_1);
			
			Canvas canvas = new Canvas();
			canvas.setBackground(Color.GRAY);
			canvas.setBounds(442, 249, 305, 157);
			labratoryUI.getContentPane().add(canvas);
			
			JLabel lblResults = new JLabel("Result comments:");
			lblResults.setBounds(179, 229, 128, 14);
			labratoryUI.getContentPane().add(lblResults);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane.setBounds(10, 250, 416, 156);
			labratoryUI.getContentPane().add(scrollPane);
			
			JTextPane textPane = new JTextPane();
			scrollPane.setViewportView(textPane);
			
			JLabel lblAttachedImage = new JLabel("Attached Image");
			lblAttachedImage.setBounds(542, 229, 128, 14);
			labratoryUI.getContentPane().add(lblAttachedImage);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		labratoryUI.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{logo}));
		labratoryUI.setBounds(100, 100, 763, 440);
		labratoryUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void fillExaminations(JTable tbl){
		Labratorian lab = (Labratorian) Application.user;
	//	for(Examination e : lab.getExaminations())
//			model.addRow(new Object[]{e.getEid(),
//					e.getTreatment().getDoctor().getFirstName(),
//					e.getTreatment().getMedicalRecord().getPatient().getSid(),
//					e.geteType(),
//					"Opened"
//			});
	}
}
