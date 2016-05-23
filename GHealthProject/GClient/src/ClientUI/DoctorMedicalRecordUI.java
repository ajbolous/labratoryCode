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

import models.Doctor;
import models.Examination;
import models.Patient;
import models.Treatment;
import models.Visit;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import Utils.DateTime;

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
import java.util.Date;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.Year;
import java.util.Calendar;

import javax.swing.JToolBar;
import javax.swing.ScrollPaneConstants;

public class DoctorMedicalRecordUI {

	private JFrame DoctorMedicalRecord ;
	
	JButton btnNewButton = new JButton("Add Visit");
	JButton btnNewButton_1 = new JButton("Add Referral");
	JButton btnNewButton_2 = new JButton("New button");
	JPanel panel_2 = new JPanel();
	
	public DoctorMedicalRecordUI(Patient p) throws ParseException {
		initialize(p);
		DoctorMedicalRecord.setSize(950, 800);
		DoctorMedicalRecord.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws ParseException 
	 */
	private void initialize(Patient p) throws ParseException {
		Resources res = new Resources();
		DoctorMedicalRecord = new JFrame();
		DoctorMedicalRecord.setTitle("<Doctor Medical Record> - GHealth");
		DoctorMedicalRecord.setResizable(false);
		Image icon= new ImageIcon(this.getClass().getResource("/img/" + "icon.png")).getImage();
		DoctorMedicalRecord.setIconImage(icon);
		DoctorMedicalRecord.setForeground(Color.BLACK);
		DoctorMedicalRecord.setFont(new Font("Dialog", Font.PLAIN, 16));
		DoctorMedicalRecord.setBackground(Color.WHITE);
		DoctorMedicalRecord.getContentPane().setBackground(Color.WHITE);
		DoctorMedicalRecord.getContentPane().setLayout(null);
		
		JLabel logo = new JLabel("GHealth - MedicalRecord");
		logo.setBounds(0, 0, 847, 60);
		logo.setForeground(SystemColor.textHighlight);
		logo.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 17));
		logo.setBackground(Color.WHITE);
		logo.setIcon(res.getIcon("logo.png"));
		DoctorMedicalRecord.getContentPane().add(logo);
		DoctorMedicalRecord.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{logo}));
		DoctorMedicalRecord.setBounds(100, 100, 863, 595);
		DoctorMedicalRecord.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 67, 984, 45);
		DoctorMedicalRecord.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 11, 46, 21);
		panel.add(lblNewLabel);
		
		JLabel cName = new JLabel(p.getFirstName()+""+ p.getLastName());
		cName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cName.setBounds(61, 11, 205, 21);
		panel.add(cName);
		
		JLabel lblPhone = new JLabel("Phone:");
		lblPhone.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPhone.setBounds(413, 11, 67, 21);
		panel.add(lblPhone);
		
		JLabel label_1 = new JLabel(p.getPhone());
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_1.setBounds(471, 11, 119, 21);
		panel.add(label_1);
		
		JLabel lblAge = new JLabel("Age :");
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAge.setBounds(600, 11, 52, 21);
		panel.add(lblAge);
		
		int currentMonth = Calendar.getInstance().get(Calendar.MONTH)+1;
		
		String age = (""+(calculateAge(p.getBirthDate()))[0]+"."+(calculateAge(p.getBirthDate()))[1]);
		JLabel lblAge_2 = new JLabel(age);
		lblAge_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAge_2.setBounds(641, 8, 72, 27);
		panel.add(lblAge_2);
		
		JLabel lblWeight = new JLabel("Gender :");
		lblWeight.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblWeight.setBounds(723, 11, 62, 21);
		panel.add(lblWeight);
		
		JLabel label = new JLabel(p.getGender());
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(779, 14, 62, 14);
		panel.add(label);
		
		JLabel lblHeight = new JLabel("Height :");
		lblHeight.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblHeight.setBounds(851, 11, 67, 21);
		panel.add(lblHeight);
		
		JLabel label_2 = new JLabel("173");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_2.setBounds(928, 14, 46, 14);
		panel.add(label_2);
		
		JLabel lblId = new JLabel("Id:");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblId.setBounds(283, 14, 33, 14);
		panel.add(lblId);
		
		JLabel label_3 = new JLabel(p.getSid());
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_3.setBounds(308, 14, 95, 14);
		panel.add(label_3);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 249, 272, 409);
		DoctorMedicalRecord.getContentPane().add(scrollPane);
		scrollPane.setViewportBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		
		
		JTree tree = new JTree();
		scrollPane.setViewportView(tree);
		tree.setEditable(true);
		tree.setShowsRootHandles(true);
		tree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("Treatments") {
				{
					DefaultMutableTreeNode node_S= new DefaultMutableTreeNode("Specialty Type : fizotrby");
					DefaultMutableTreeNode node_1;
					DefaultMutableTreeNode node_2;
					DefaultMutableTreeNode node_3;
					
					Visit visit = new Visit();
					visit.setVid(1);
					visit.setComments("goodsdsdsdsdssssssssssssssssssssssssssssssssssssssss\nssssssssssssssssssssssssssssssssssssssssssssss ");
					visit.setVisitDate(DateTime.getDate(2015, 5, 1));
					
					Visit visit2 = new Visit();
					visit2.setVid(2);
					visit2.setComments("bad" );
					
					Treatment t = new Treatment();
					t.setTid(102);
					Doctor d = new Doctor();
					d.setFirstName("maisam" );
					d.setLastName("marjieh");
					d.setSpeciality("love");
					d.setSid("2054");
					t.setDoctor(d);
					
					Examination e = new Examination();
					e.setEid(52);
					e.setEType("sdf");
					e.setTreatment(t);
					e.setExaminationDate(DateTime.getDate(2016, 1, 3));
					
					
					node_1 = new DefaultMutableTreeNode(t);
					node_2 = new DefaultMutableTreeNode("Visits");
					node_2.add(new DefaultMutableTreeNode(visit));
					node_2.add(new DefaultMutableTreeNode(visit2));
					
				
					node_3 =  new DefaultMutableTreeNode("Tests");
					node_3.add(new DefaultMutableTreeNode(e));
					
					node_1.add(node_2);
					node_1.add(node_3);	
					node_S.add(node_1);
					add(node_S);
					add(new DefaultMutableTreeNode("Specialty Type : love"));
					
					
					
				}
			}
		));
		
		
		
		
		tree.getSelectionModel().addTreeSelectionListener(new TreeSelectionListener() {
		    @Override
		    public void valueChanged(TreeSelectionEvent e) {
		    	DefaultMutableTreeNode node =(DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
		    	Object obj = node.getUserObject();
		    	JPanel panel_1 = new JPanel();
		    	DoctorMedicalRecord.getContentPane().add(panel_1);
		    	panel_1.setBackground(Color.LIGHT_GRAY);
				panel_1.setBounds(279, 204, 539, 45);
				
				panel_1.setLayout(null);
				panel_1.add(btnNewButton);
				panel_1.add(btnNewButton_1);
				panel_1.add(btnNewButton_2);
				JScrollPane scrollPane_1 = new JScrollPane();
				scrollPane_1.setBounds(279, 249, 646, 420);
				scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
	    		scrollPane_1.setViewportBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				DoctorMedicalRecord.getContentPane().add(scrollPane_1);
		    	if(obj.getClass()== Visit.class)
		    	{
		    		
		    		VisitPanel vi = new VisitPanel((Visit) obj);
		    		
		    		scrollPane_1.setViewportView(vi);
		    		
		    	}
		    	if (obj.getClass()==Treatment.class)
		    	{
		    		TreatmentPanel t = new TreatmentPanel((Treatment)obj);
		    		scrollPane_1.setViewportView(t);
		    	}
		    	
		    	if(obj.getClass()== Examination.class)
		    	{
		    		ExaminationPanel	ep = new ExaminationPanel((Examination) obj);
		    		scrollPane_1.setViewportView(ep);
		    		
		    	}
		    	
		    }
		});
		
		JButton btnCancel = new JButton("cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DoctorMedicalRecord.setVisible(false);
				 PatientUI p = new PatientUI();
			}
		});
		btnCancel.setBounds(713, 706, 89, 23);
		DoctorMedicalRecord.getContentPane().add(btnCancel);
		
		
		btnNewButton.setBounds(26, 11, 108, 23);
		btnNewButton.setFont(new Font("Arial Black", Font.PLAIN, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Visit v= new Visit();
				v.setVid(12);
				try {
					v.setVisitDate(DateTime.getDate(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH)));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				NewVisitPanel vi = new NewVisitPanel(v);
				JScrollPane scrollPane_1 = new JScrollPane();
				scrollPane_1.setBounds(279, 249, 646, 420);
				DoctorMedicalRecord.getContentPane().add(scrollPane_1);
				scrollPane_1.setViewportView(vi);
			}
		});
		
		
		btnNewButton_1.setBounds(235, 11, 124, 23);
		btnNewButton_1.setFont(new Font("Arial Black", Font.PLAIN, 12));
		btnNewButton_2.setBounds(419, 12, 89, 23);
		
		
		
		
	
		JButton btnUpdateInformation = new JButton(" Patient Information");
		btnUpdateInformation.setFont(new Font("Arial", Font.BOLD, 12));
		btnUpdateInformation.setBounds(10, 123, 151, 23);
		DoctorMedicalRecord.getContentPane().add(btnUpdateInformation);
		
		JButton btnReguestInformationFrom = new JButton("Reguest Information From HMO");
		btnReguestInformationFrom.setFont(new Font("Arial", Font.BOLD, 12));
		btnReguestInformationFrom.setBounds(257, 123, 230, 23);
		DoctorMedicalRecord.getContentPane().add(btnReguestInformationFrom);
	}
	 private static int[] calculateAge(Date birthDate)
	   {
	      int years = 0;
	      int months = 0;
	      int days = 0;
	      int YM[]=new int[2];
	      //create calendar object for birth day
	      Calendar birthDay = Calendar.getInstance();
	      birthDay.setTimeInMillis(birthDate.getTime());
	      //create calendar object for current day
	      long currentTime = System.currentTimeMillis();
	      Calendar now = Calendar.getInstance();
	      now.setTimeInMillis(currentTime);
	      //Get difference between years
	      years = now.get(Calendar.YEAR) - birthDay.get(Calendar.YEAR);
	      int currMonth = now.get(Calendar.MONTH) + 1;
	      int birthMonth = birthDay.get(Calendar.MONTH) + 1;
	      //Get difference between months
	      months = currMonth - birthMonth;
	      //if month difference is in negative then reduce years by one and calculate the number of months.
	      if (months < 0)
	      {
	         years--;
	         months = 12 - birthMonth + currMonth;
	         if (now.get(Calendar.DATE) < birthDay.get(Calendar.DATE))
	            months--;
	      } else if (months == 0 && now.get(Calendar.DATE) < birthDay.get(Calendar.DATE))
	      {
	         years--;
	         months = 11;
	      }
	      //Calculate the days
	      if (now.get(Calendar.DATE) > birthDay.get(Calendar.DATE))
	         days = now.get(Calendar.DATE) - birthDay.get(Calendar.DATE);
	      else if (now.get(Calendar.DATE) < birthDay.get(Calendar.DATE))
	      {
	         int today = now.get(Calendar.DAY_OF_MONTH);
	         now.add(Calendar.MONTH, -1);
	         days = now.getActualMaximum(Calendar.DAY_OF_MONTH) - birthDay.get(Calendar.DAY_OF_MONTH) + today;
	      } else
	      {
	         days = 0;
	         if (months == 12)
	         {
	            years++;
	            months = 0;
	         }
	      }
	      YM[0]=years;
	      YM[1]=months;
	      //Create new Age object 
	      return  YM;
	   }
}
