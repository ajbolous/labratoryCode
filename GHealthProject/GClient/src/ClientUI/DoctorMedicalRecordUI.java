package ClientUI;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;

import Client.Resources;
import Controllers.AppointmentsController;
import Controllers.MedicalRecordController;

import models.Doctor;
import models.Examination;
import models.Patient;
import models.Treatment;
import models.Visit;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import Utils.DateTime;

import java.awt.Component;
import java.awt.SystemColor;

import javax.swing.JTree;
import javax.swing.JScrollPane;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.border.BevelBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Date;
import java.text.ParseException;
import java.util.Calendar;

import javax.swing.ScrollPaneConstants;
import javax.swing.JTextField;

public class DoctorMedicalRecordUI {

	private JFrame DoctorMedicalRecord;

	JButton btnNewButton = new JButton("Add Visit");
	JButton btnNewButton_1 = new JButton("Add Referral");
	JButton btnNewButton_2 = new JButton("New button");
	JPanel panel_2 = new JPanel();
	private AppointmentsController apctrl = new AppointmentsController();
	private MedicalRecordController mrctrl = new MedicalRecordController();
	JPanel panel_1 = new JPanel();

	public DoctorMedicalRecordUI(Patient p) throws ParseException {
		initialize(p);
		DoctorMedicalRecord.setSize(877, 689);
		DoctorMedicalRecord.setLocationRelativeTo(null);
		DoctorMedicalRecord.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws ParseException
	 */
	private void initialize(Patient p) throws ParseException {
		DoctorMedicalRecord = new JFrame();
		DoctorMedicalRecord.setTitle("<Doctor Medical Record> - GHealth");
		DoctorMedicalRecord.setResizable(false);
		Image icon= Resources.getImage("icon.png");
		DoctorMedicalRecord.setIconImage(icon);
		DoctorMedicalRecord.setForeground(Color.BLACK);
		DoctorMedicalRecord.setFont(new Font("Dialog", Font.PLAIN, 16));
		DoctorMedicalRecord.setBackground(Color.WHITE);
		DoctorMedicalRecord.getContentPane().setBackground(Color.WHITE);
		DoctorMedicalRecord.getContentPane().setLayout(null);
		
		JLabel logo = new JLabel("Medical Record");
		logo.setBounds(0, 0, 847, 53);
		logo.setForeground(SystemColor.textHighlight);
		logo.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 17));
		logo.setBackground(Color.WHITE);
		logo.setIcon(Resources.getIcon("logo.png"));
		DoctorMedicalRecord.getContentPane().add(logo);
		DoctorMedicalRecord.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{logo}));
		DoctorMedicalRecord.setBounds(100, 100, 863, 595);
		DoctorMedicalRecord.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 56, 869, 78);
		DoctorMedicalRecord.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 11, 46, 21);
		panel.add(lblNewLabel);
		
		JTextField cName = new JTextField(p.getFirstName()+""+ p.getLastName());
		cName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cName.setBounds(61, 11, 195, 21);
		panel.add(cName);
		
		JLabel lblPhone = new JLabel("Phone:");
		lblPhone.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPhone.setBounds(293, 11, 52, 21);
		panel.add(lblPhone);
		
		JTextField label_1 = new JTextField(p.getPhone());
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_1.setBounds(351, 11, 119, 21);
		panel.add(label_1);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAge.setBounds(751, 45, 40, 21);
		panel.add(lblAge);
		
		int currentMonth = Calendar.getInstance().get(Calendar.MONTH)+1;
		
		String age = (String.format("%3.2f",(float)calculateAge2(p.getBirthDate())));
		JTextField lblAge_2 = new JTextField(age);
		lblAge_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAge_2.setBounds(791, 45, 67, 21);
		panel.add(lblAge_2);
		
		JLabel lblWeight = new JLabel("Gender:");
		lblWeight.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblWeight.setBounds(293, 45, 62, 21);
		panel.add(lblWeight);
		
		JTextField label = new JTextField(p.getGender());
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(354, 44, 72, 23);
		panel.add(label);
		
		JLabel lblHeight = new JLabel("Height:");
		lblHeight.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblHeight.setBounds(436, 45, 67, 21);
		panel.add(lblHeight);
		
		JTextField label_2 = new JTextField("173");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_2.setBounds(489, 44, 52, 22);
		panel.add(label_2);
		
		JLabel lblId = new JLabel("Id:");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblId.setBounds(10, 48, 33, 14);
		panel.add(lblId);
		
		JTextField label_3 = new JTextField(p.getSid());
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_3.setBounds(61, 45, 195, 21);
		panel.add(label_3);
		
		JLabel lblWeight_1 = new JLabel("Weight:");
		lblWeight_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblWeight_1.setBounds(551, 45, 67, 21);
		panel.add(lblWeight_1);
		
		JTextField label_5 = new JTextField("173");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_5.setBounds(624, 45, 83, 21);
		panel.add(label_5);
		
		JButton btnReguestInformationFrom = new JButton("Reguest Information From HMO");
		btnReguestInformationFrom.setBounds(629, 11, 230, 23);
		panel.add(btnReguestInformationFrom);
		btnReguestInformationFrom.setFont(new Font("Arial", Font.BOLD, 12));
		
		
		
		
	
		JButton btnUpdateInformation = new JButton(" Patient Information");
		btnUpdateInformation.setBounds(479, 11, 151, 23);
		panel.add(btnUpdateInformation);
		btnUpdateInformation.setFont(new Font("Arial", Font.BOLD, 12));
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 157, 277, 501);
		DoctorMedicalRecord.getContentPane().add(scrollPane);
		scrollPane.setViewportBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		
		
		JTree tree = new JTree();
		scrollPane.setViewportView(tree);
		tree.setEditable(true);
		tree.setShowsRootHandles(true);
		tree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("Specialisties") {
				{
					
					/*String  specialty [] = apctrl.getSpecialties();
					for (int i=1;i<specialty.length;i++)
					{
					DefaultMutableTreeNode node_S= new DefaultMutableTreeNode(specialty[i]);
					DefaultMutableTreeNode node_1;
					ArrayList <Treatment> t = (ArrayList)p.getMedicalRecord().getTreatments();
					for ( int k=0; k<p.getMedicalRecord().getTreatments().size();k++)
					{
						if (t.get(k).getDoctor().getSpeciality().equals(specialty[i]))
						{
							node_1 = new DefaultMutableTreeNode(t.get(k));
							DefaultMutableTreeNode	node_2 = new DefaultMutableTreeNode("Visits");
							for (int j=0 ; j<t.get(k).getVisits().size() ; j++)
							{
								
								Visit visit=(Visit) ((ArrayList)t.get(k).getVisits()).get(j);
								node_2.add(new DefaultMutableTreeNode(visit));
							}
							DefaultMutableTreeNode node_3 =  new DefaultMutableTreeNode("Tests");
							for (int j=0 ; j<t.get(k).getExamination().size() ; j++)
							{
								
								Examination ex=(Examination) ((ArrayList)t.get(k).getExamination()).get(j);
								node_3.add(new DefaultMutableTreeNode(ex));
							}
							node_1.add(node_2);
							node_1.add(node_3);
									
								
						}
								
					}
					add(node_S);
					}*/
					
					/*DefaultMutableTreeNode node_1;
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
					add(new DefaultMutableTreeNode("Specialty Type : love"));*/
					
					
					
				}
			}
		));
		
		
		
		
		tree.getSelectionModel().addTreeSelectionListener(new TreeSelectionListener() {
		    @Override
		    public void valueChanged(TreeSelectionEvent e) {
		    	DefaultMutableTreeNode node =(DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
		    	Object obj = node.getUserObject();
		    	
		    	
		    	
		    	
				JScrollPane scrollPane_1 = new JScrollPane();
				scrollPane_1.setBounds(279, 249, 646, 420);
				scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
	    		scrollPane_1.setViewportBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				
		    	if(obj.getClass()== Visit.class)
		    	{
		    		
		    		VisitPanel vi = new VisitPanel((Visit) obj);
		    		
		    		scrollPane_1.setViewportView(vi);
		    		DoctorMedicalRecord.getContentPane().add(scrollPane_1);
		    		DoctorMedicalRecord.getContentPane().add(panel_1);
		    		
		    	}
		    	if (obj.getClass()==Treatment.class)
		    	{
		    	//	TreatmentPanel t = new TreatmentPanel((Treatment)obj);
		    	//	scrollPane_1.setViewportView(t);
		    	//	DoctorMedicalRecord.getContentPane().add(scrollPane_1);
		    	//	DoctorMedicalRecord.getContentPane().add(panel_1);
		    	}
		    	
		    	if(obj.getClass()== Examination.class)
		    	{
		    	//	ExaminationPanel	ep = new ExaminationPanel((Examination) obj);
		    	//	scrollPane_1.setViewportView(ep);
		    	//	DoctorMedicalRecord.getContentPane().add(scrollPane_1);
		    	//	DoctorMedicalRecord.getContentPane().add(panel_1);
		    		
		    	}
		    	
		    }
		});
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		DoctorMedicalRecord.getContentPane().add(panel_1);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(290, 156, 579, 32);
		panel_1.setLayout(null);
		
		panel_1.add(btnNewButton);
		panel_1.add(btnNewButton_1);
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_1.add(btnNewButton_2);
		
		
		btnNewButton.setBounds(109, 6, 114, 23);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
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
				NewVisitUI vi = new NewVisitUI(v);
				
				
			}
		});
		
		
		btnNewButton_1.setBounds(233, 6, 104, 23);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_2.setBounds(347, 6, 104, 23);
		
		JButton btnNewTreatment = new JButton("New Treatment");
		btnNewTreatment.setBounds(8, 7, 98, 22);
		panel_1.add(btnNewTreatment);
		
		JButton btnCancel = new JButton("cancel");
		btnCancel.setBounds(461, 7, 89, 22);
		panel_1.add(btnCancel);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DoctorMedicalRecord.setVisible(false);
				 PatientUI p = new PatientUI();
			}
		});
		btnNewTreatment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				try {
					new NewTreatmentUI(mrctrl.getNewTreatment(new Doctor(), p.getMedicalRecord()));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}

	private static double calculateAge2(Date d){
		return (new Date().getTime() - d.getTime())/(1000*60*60*24*365.0);
	}
	private static int[] calculateAge(Date birthDate) {
		int years = 0;
		int months = 0;
		int days = 0;
		int YM[] = new int[2];
		// create calendar object for birth day
		Calendar birthDay = Calendar.getInstance();
		birthDay.setTimeInMillis(birthDate.getTime());
		// create calendar object for current day
		long currentTime = System.currentTimeMillis();
		Calendar now = Calendar.getInstance();
		now.setTimeInMillis(currentTime);
		// Get difference between years
		years = now.get(Calendar.YEAR) - birthDay.get(Calendar.YEAR);
		int currMonth = now.get(Calendar.MONTH) + 1;
		int birthMonth = birthDay.get(Calendar.MONTH) + 1;
		// Get difference between months
		months = currMonth - birthMonth;
		// if month difference is in negative then reduce years by one and
		// calculate the number of months.
		if (months < 0) {
			years--;
			months = 12 - birthMonth + currMonth;
			if (now.get(Calendar.DATE) < birthDay.get(Calendar.DATE))
				months--;
		} else if (months == 0
				&& now.get(Calendar.DATE) < birthDay.get(Calendar.DATE)) {
			years--;
			months = 11;
		}
		// Calculate the days
		if (now.get(Calendar.DATE) > birthDay.get(Calendar.DATE))
			days = now.get(Calendar.DATE) - birthDay.get(Calendar.DATE);
		else if (now.get(Calendar.DATE) < birthDay.get(Calendar.DATE)) {
			int today = now.get(Calendar.DAY_OF_MONTH);
			now.add(Calendar.MONTH, -1);
			days = now.getActualMaximum(Calendar.DAY_OF_MONTH)
					- birthDay.get(Calendar.DAY_OF_MONTH) + today;
		} else {
			days = 0;
			if (months == 12) {
				years++;
				months = 0;
			}
		}
		YM[0] = years;
		YM[1] = months;
		// Create new Age object
		return YM;
	}
}
