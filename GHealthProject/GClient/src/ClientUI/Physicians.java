package ClientUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JTextField;

import Client.Client;
import Client.Config;
import Client.Resources;
import Utils.Request;
import models.Physician;

import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import java.awt.Window.Type;
import java.awt.Font;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.CompoundBorder;
import java.util.ArrayList;

public class Physicians {

	private JFrame frame;
	private JTextField txtUser;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblSpecialization;
	private JButton btnSelect;
	private Physician selectedPhysician;
	public Physicians() {
		initialize();
		frame.setVisible(true);
		loadData("");
	}
	private ArrayList<Physician> physicians;
	@SuppressWarnings("unchecked")
	private void loadData(String filter) {
		physicians = (ArrayList<Physician>) Application.client.Request(new Request("physicians/all"));

		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);

		for (Physician p : physicians) {
			model.addRow(new Object[] {p.getName(), p.getSpecialization()});
			
		}
		table.setModel(model);

	}

	private void initialize() {
		frame = new JFrame();
		frame.setType(Type.UTILITY);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 518, 623);

		frame.getContentPane().setLayout(null);
		txtUser = new JTextField();
		txtUser.setBounds(10, 64, 347, 20);
		frame.getContentPane().add(txtUser);
		txtUser.setColumns(10);

		Resources res = new Resources();

		JButton btnLogin = new JButton("Search");
		btnLogin.setForeground(Color.BLACK);
		btnLogin.setBackground(Color.WHITE);

		btnLogin.setBounds(367, 64, 79, 20);
		frame.getContentPane().add(btnLogin);

		JLabel lblWelcomeToGhealth = new JLabel("Physicians");
		lblWelcomeToGhealth.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblWelcomeToGhealth.setHorizontalAlignment(SwingConstants.LEFT);
		lblWelcomeToGhealth.setIcon(res.getIcon("logo.png"));
		lblWelcomeToGhealth.setBounds(0, 0, 365, 61);
		frame.getContentPane().add(lblWelcomeToGhealth);

		table = new JTable();
		table.setBackground(Color.WHITE);
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table.setBounds(10, 95, 482, 374);
		frame.getContentPane().add(table);
		
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Name", "Specialization"
				}
			) {
				Class[] columnTypes = new Class[] {
					String.class, String.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
				boolean[] columnEditables = new boolean[] {
				true, true
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(105, 513, 172, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Change");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				selectedPhysician.setSpecialization(textField_1.getText());
				Request r = new Request("physicians/update");
				r.addParam("physician", selectedPhysician);
				Application.client.Request(r);
				loadData("");
			}
		});
		
		btnNewButton.setBounds(287, 512, 95, 52);
		frame.getContentPane().add(btnNewButton);
		
		textField_1 = new JTextField();
		textField_1.setBounds(105, 544, 172, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(10, 516, 46, 14);
		frame.getContentPane().add(lblName);
		
		lblSpecialization = new JLabel("Specialization:");
		lblSpecialization.setBounds(10, 547, 85, 14);
		frame.getContentPane().add(lblSpecialization);
		
		btnSelect = new JButton("Select");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				Physician p = physicians.get(row);
				textField.setText(p.getName());
				textField_1.setText(p.getSpecialization());
				selectedPhysician = p;
			}
		});
		btnSelect.setBounds(10, 480, 482, 23);
		frame.getContentPane().add(btnSelect);
		frame.setFocusTraversalPolicy(new FocusTraversalOnArray(
				new Component[] { txtUser, btnLogin, frame.getContentPane(), lblWelcomeToGhealth }));
	}
}
