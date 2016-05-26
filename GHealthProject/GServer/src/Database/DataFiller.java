package Database;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import Utils.DateTime;
import Views.Reports;
import models.*;

public class DataFiller {

	DbHandler db;
	public static String[] firstNames = { "John", "Tyrion", "Arya", "Sandor",
			"Euron", "Dyneris", "Ned", "Cersi", "Sam", "Sansa", "Ramsey",
			"Roose", "Robert", "Walder", "Jora", "Varys", "Mountain", "Yara",
			"Jaime", "Stannis", "Renly", "Robert" };
	public static String[] lastNames = { "Blackfrey", "Martel", "River",
			"Andal", "Lanister", "Bolton", "Stark", "Clegane", "Targeryan",
			"Greyjoy", "Weiss", "Drogo", "Karstak", "Turlly", "Mormont",
			"Frey", "Baratheon", "Slavador", "Snow" };
	public static String[] cities = { "King's Landing", "Winterfell",
			"Iron Islands", "Valyeria", "The Wall", "Castle Black",
			"Dreadfall", "Mereen", "Highgarden", "Dorn" };

	public static String[] specialities = { "Surgon", "Oncologe", "Urologe",
			"Cardiologe", "Bone", "Family", "Children" };

	public static Random rand = new Random();

	public DataFiller(DbHandler d) {
		db = d;
	}

	public void fillDoctors() throws SQLException {
		for (int i = 0; i < 120; i++) {
			Doctor d = new Doctor();
			d.setFirstName(firstNames[rand.nextInt(firstNames.length)]);
			d.setLastName(lastNames[rand.nextInt(lastNames.length)]);

			d.setEmail((d.getFirstName() + "." + d.getLastName() + i)
					.toLowerCase() + "@crows.com");
			try {
				d.setBirthDate(Utils.DateTime.getDate(1960 + rand.nextInt(20),
						rand.nextInt(12), rand.nextInt(29)));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			d.setAddress(cities[rand.nextInt(cities.length)] + ", St. " + i);
			d.setPhone("0" + (548143001 + i));
			d.setClinic(db.clinics.queryForId(i % 10 + 1));
			d.setPass("123123");
			d.setSpeciality(specialities[i % specialities.length]);
			d.setSid("" + (200000000 + i));
			db.doctors.createIfNotExists(d);
		}
	}

	public void fillPatients() throws SQLException {
		for (int i = 0; i < 120; i++) {
			Patient p = new Patient();
			p.setFirstName(firstNames[rand.nextInt(firstNames.length)]);
			p.setLastName(lastNames[rand.nextInt(lastNames.length)]);

			p.setEmail((p.getFirstName() + "." + p.getLastName() + i)
					.toLowerCase() + "@crows.com");
			try {
				p.setBirthDate(Utils.DateTime.getDate(1970 + rand.nextInt(20),
						rand.nextInt(12), rand.nextInt(29)));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			p.setAddress(cities[rand.nextInt(cities.length)] + ", St. " + i);
			p.setPhone("0" + (548143001 + i));
			p.setSid("" + (300000000 + i));
			db.patients.createIfNotExists(p);
		}
	}

	public void fillStatistics() throws SQLException, ParseException {
		int i;
		Random r = new Random();
		Date d = Utils.DateTime.getDate(2016,1,1);
		for (i = 0; i < 360; i++) {
			Statistic s = new Statistic();
			s.setNumOfPatients(r.nextInt(30));
			s.setWaitingPeriod(r.nextInt(60));
			d = Utils.DateTime.addDay(d,1);
			s.setDate(d);
			db.statistics.createIfNotExists(s);
		}
	}

	public void fillClinics() throws SQLException {
		for (int i = 0; i < cities.length; i++) {

			Labratorian l = new Labratorian();
			l.setFirstName(firstNames[rand.nextInt(firstNames.length)]);
			l.setLastName(lastNames[rand.nextInt(lastNames.length)]);

			l.setEmail((l.getFirstName() + "." + l.getLastName() + i)
					.toLowerCase() + "@crows.com");
			try {
				l.setBirthDate(Utils.DateTime.getDate(1980 + rand.nextInt(20),
						rand.nextInt(12), rand.nextInt(29)));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			l.setAddress(cities[rand.nextInt(cities.length)] + ", St. " + i);
			l.setPhone("0" + (548143001 + i));
			l.setSid("" + (400000000 + i));

			db.labratorians.createIfNotExists(l);

			Labratory lab = new Labratory();
			//lab.setLabratorian(l);
			db.labratories.createIfNotExists(lab);

			Clinic c = new Clinic();
			c.setAddress(cities[i]);
			c.setPhone("04-" + (5143001 + i));
			c.setName("GHealth " + c.getAddress());
			c.setEmail(c.getName().replace(" ", "_").toLowerCase() + i
					+ "@crows.com");
			c.setLabratory(lab);
			db.clinics.create(c);
		}
	}

	public void fillAppointments() throws SQLException, ParseException {

		for (int i = 0; i < 8; i++) {
			Doctor d = db.doctors.queryForId("20000000" + i);
			Patient p = db.patients.queryForId("30000000" + i);

			Appointment a = new Appointment(d, p, DateTime.getDate(2016, 10,
					5 + i, 11, 10));

			db.appointments.createIfNotExists(a);
		}

	}
	
	public void fillShifts() throws SQLException{
	
		for(int j=0;j<8;j++){
			Doctor d = db.doctors.queryForId("20000000" + j);
			ArrayList<Shift> doc_shifts = doctorShiftsGenerator(4, d);
			for(Shift a: doc_shifts){
				db.shifts.createIfNotExists(a);
			}
		
		}
	}
	
	private ArrayList<Shift> doctorShiftsGenerator(int weeks, Doctor d){
		ArrayList<Shift> shifts= new ArrayList<Shift>();
		
		int from;
		Calendar start_time= Calendar.getInstance();
		start_time.set(Calendar.HOUR_OF_DAY, 9);
		start_time.set(Calendar.MINUTE, 0);
		
		from=start_time.get(Calendar.WEEK_OF_YEAR);
		Calendar end_time = Calendar.getInstance();
		end_time.set(Calendar.HOUR_OF_DAY, 9);
		end_time.set(Calendar.MINUTE, 0);
		end_time.add(Calendar.HOUR_OF_DAY, 8);
		
		
		for( int i =from;i< weeks+from;i++){
			
			for(int j=0; j<5 &&
					(start_time.get(Calendar.DAY_OF_WEEK)!=Calendar.FRIDAY ) && 
					(start_time.get(Calendar.DAY_OF_WEEK)!=Calendar.SATURDAY);
					j++){
				shifts.add(new Shift(calendarToDate(start_time),calendarToDate(end_time),d));
				start_time.add(Calendar.DATE, 1);
				end_time.add(Calendar.DATE, 1);
			}
			if(start_time.get(Calendar.DAY_OF_WEEK)==Calendar.FRIDAY){
				start_time.add(Calendar.DATE, 2);
				end_time.add(Calendar.DATE, 2);
			}
			else if(start_time.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY){
				start_time.add(Calendar.DATE, 1);
				end_time.add(Calendar.DATE, 1);
			}
		}
		
		return shifts;
	}
	
	private  Date calendarToDate(Calendar date){
		
		try {
			return  DateTime.getDate(date.get(Calendar.YEAR), date.get(Calendar.MONTH)+1, date.get(Calendar.DAY_OF_MONTH),
					date.get(Calendar.HOUR_OF_DAY),
					date.get(Calendar.MINUTE));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
