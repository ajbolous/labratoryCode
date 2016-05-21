package ClientUI;

import java.awt.EventQueue;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

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

import models.Visit;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import java.awt.Component;
import java.awt.SystemColor;

import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.JScrollBar;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.ListSelectionModel;

import java.awt.ScrollPane;
import java.awt.Choice;

import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.AbstractListModel;

import java.awt.List;
import java.awt.Scrollbar;
import java.awt.Panel;

import javax.swing.border.BevelBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.event.TreeExpansionListener;
import javax.swing.event.TreeExpansionEvent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DoctorMedicalRecordUI {

	private JFrame DoctorMedicalRecord;
	Panel panel_1 = new Panel();
	
	public DoctorMedicalRecordUI() {
		initialize();
		DoctorMedicalRecord.setSize(950, 653);
		DoctorMedicalRecord.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Resources res = new Resources();
		DoctorMedicalRecord = new JFrame();
		DoctorMedicalRecord.setTitle("<Frame name> - GHealth");
		DoctorMedicalRecord.setResizable(false);
		Image icon= new ImageIcon(this.getClass().getResource("/img/" + "icon.png")).getImage();
		DoctorMedicalRecord.setIconImage(icon);
		DoctorMedicalRecord.setForeground(Color.BLACK);
		DoctorMedicalRecord.setFont(new Font("Dialog", Font.PLAIN, 16));
		DoctorMedicalRecord.setBackground(Color.WHITE);
		DoctorMedicalRecord.getContentPane().setBackground(Color.WHITE);
		DoctorMedicalRecord.getContentPane().setLayout(null);
		
		JLabel logo = new JLabel("GHealth - MedicalRecord");
		logo.setBounds(0, 0, 847, 81);
		logo.setForeground(SystemColor.textHighlight);
		logo.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 17));
		logo.setBackground(Color.WHITE);
		logo.setIcon(res.getIcon("logo.png"));
		DoctorMedicalRecord.getContentPane().add(logo);
		DoctorMedicalRecord.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{logo}));
		DoctorMedicalRecord.setBounds(100, 100, 863, 595);
		DoctorMedicalRecord.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 91, 822, 45);
		DoctorMedicalRecord.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 11, 46, 21);
		panel.add(lblNewLabel);
		
		JLabel cName = new JLabel("Maisam Marjieh");
		cName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cName.setBounds(61, 11, 96, 21);
		panel.add(cName);
		
		JLabel lblPhone = new JLabel("Phone:");
		lblPhone.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPhone.setBounds(323, 11, 67, 21);
		panel.add(lblPhone);
		
		JLabel label_1 = new JLabel("052-6833409");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_1.setBounds(383, 11, 85, 21);
		panel.add(label_1);
		
		JLabel lblAge = new JLabel("Age :");
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAge.setBounds(491, 11, 52, 21);
		panel.add(lblAge);
		
		JLabel lblMuhamadigacgmailcom = new JLabel("15");
		lblMuhamadigacgmailcom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMuhamadigacgmailcom.setBounds(540, 8, 37, 27);
		panel.add(lblMuhamadigacgmailcom);
		
		JLabel lblWeight = new JLabel("Weight : ");
		lblWeight.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblWeight.setBounds(576, 11, 62, 21);
		panel.add(lblWeight);
		
		JLabel label = new JLabel("120");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(648, 14, 46, 14);
		panel.add(label);
		
		JLabel lblHeight = new JLabel("Height :");
		lblHeight.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblHeight.setBounds(697, 11, 67, 21);
		panel.add(lblHeight);
		
		JLabel label_2 = new JLabel("173");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_2.setBounds(766, 14, 46, 14);
		panel.add(label_2);
		
		JLabel lblId = new JLabel("Id:");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblId.setBounds(185, 14, 60, 14);
		panel.add(lblId);
		
		JLabel label_3 = new JLabel("205495161");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_3.setBounds(218, 14, 84, 14);
		panel.add(label_3);
		
		
		
		
		
		
		panel_1.setBounds(283, 142, 539, 414);
		DoctorMedicalRecord.getContentPane().add(panel_1);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 143, 283, 413);
		DoctorMedicalRecord.getContentPane().add(scrollPane);
		scrollPane.setViewportBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		
		
		JTree tree = new JTree();
		scrollPane.setViewportView(tree);
		tree.setShowsRootHandles(true);
		tree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("Treatments") {
				{
					
					Visit visit = new Visit();
					visit.setVid(1);
					visit.setComments("good");
					
					DefaultMutableTreeNode node_1;
					
					DefaultMutableTreeNode node_2;
					DefaultMutableTreeNode node_3;
					node_1 = new DefaultMutableTreeNode("Treatment");
					node_2 = new DefaultMutableTreeNode("Visits");
					node_2.add(new DefaultMutableTreeNode(visit));
					node_2.add(new DefaultMutableTreeNode("visit2"));
					node_2.add(new DefaultMutableTreeNode("visit3"));
				
					node_3 =  new DefaultMutableTreeNode("Tests");
					node_3.add(new DefaultMutableTreeNode("test123"));
					
					node_1.add(node_2);
					node_1.add(node_3);	
					add(node_1);
					
					node_1 = new DefaultMutableTreeNode("Treatment2");
					node_2 = new DefaultMutableTreeNode("Visits");
					node_2.add(new DefaultMutableTreeNode("visit12"));
					node_2.add(new DefaultMutableTreeNode("visit22"));
					node_2.add(new DefaultMutableTreeNode("visit32"));
					node_3 =  new DefaultMutableTreeNode("Tests");
					node_3.add(new DefaultMutableTreeNode("test12345"));
					node_3.add(new DefaultMutableTreeNode("test45"));
					node_1.add(node_2);
					node_1.add(node_3);	
					add(node_1);
					
					node_1 = new DefaultMutableTreeNode("Treatment3");
					node_2 = new DefaultMutableTreeNode("Visits");
					node_2.add(new DefaultMutableTreeNode("visit12"));
					node_2.add(new DefaultMutableTreeNode("visit22"));
					node_2.add(new DefaultMutableTreeNode("visit32"));
					node_3 =  new DefaultMutableTreeNode("Tests");
					node_3.add(new DefaultMutableTreeNode("test12345"));
					node_3.add(new DefaultMutableTreeNode("test45"));
					node_1.add(node_2);
					node_1.add(node_3);	
					add(node_1);
					
				}
			}
		));
		
		JButton btnCancel = new JButton("cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DoctorMedicalRecord.setVisible(false);
				 PatientUI p = new PatientUI();
			}
		});
		btnCancel.setBounds(823, 590, 89, 23);
		DoctorMedicalRecord.getContentPane().add(btnCancel);
		tree.getSelectionModel().addTreeSelectionListener(new TreeSelectionListener() {
		    @Override
		    public void valueChanged(TreeSelectionEvent e) {
		    	DefaultMutableTreeNode node =(DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
		    	Object obj = node.getUserObject();
		    	if(obj.getClass()==Visit.class)
		    	{
		    		//VisitUI vi= new VisitUI();
		    		//panel_1.set
		    	}
		    }
		});
		
		
	}
}
