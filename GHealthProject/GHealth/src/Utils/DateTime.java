package Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class DateTime {
	public static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-hh:mm:ss"); 
	public static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	public static Calendar calendar = Calendar.getInstance();

	public static Date getTime(int h,int m){
		Date d = new Date();
		try {
			return formatter.parse(String.format("%d-%d-%d-%d:%d:%d", d.getYear()+1900,d.getMonth()+1,d.getDate(),h,m,0));
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Date addDay(Date d,int period)
	{
		Date date=new Date();
		 date.setTime( d.getTime() + period * 24 * 60 * 60 * 1000);
		 return date;
	}
	
	public static Date addMonth(Date d){
		Calendar c =  Calendar.getInstance();
		c.setTime(d);
		c.add(Calendar.MONTH,1);
		return c.getTime();
	}
	
	
	public static List<Date> getMonths(int year){
		Date d = DateTime.getDate(year, 1, 1);
		
		ArrayList<Date> dates = new ArrayList<Date>();
		for (int i =0;i<12;i++){
			dates.add(d);
			d = DateTime.addMonth(d);
		}
		
		return dates;
	}
	public static Date addHour(Date d,int hour)
	{
		Date date=new Date();
		 date.setTime( d.getTime() +  hour * 60 * 60 * 1000);
		 return date;
	}
	
	public static Date addMinutes(Date d,int min)
	{
		Date date=new Date();
		date.setTime( d.getTime() +  min * 60 * 1000);
		return date;
	}
	
	public static int getDayOfWeek(Date d ){
		calendar.setTime(d);
		return calendar.get(Calendar.DAY_OF_WEEK);
	}
	
	public static String getDayOfWeekString(Date d){
		int day= getDayOfWeek(d);
		switch(day){
		case 1: return "Sunday";
		case 2: return "Monday";
		case 3: return "Tuesday";
		case 4: return "Wednesday";
		case 5: return "Thursday";
		case 6: return "Friday";
		case 7: return "Saturday";
		}
		return null;
	}
	
	public static int getWeekOfYear(Date d ){
		calendar.setTime(d);
		return calendar.get(Calendar.WEEK_OF_YEAR);
	}
	
	public static int getMonthOfYear(Date d ){
		calendar.setTime(d);
		return calendar.get(Calendar.MONTH+1);
	}
		
	public static Date getDate(int y,int m,int d) {
		try {
			return formatter.parse(String.format("%d-%d-%d-%d:%d:%d", y,m,d,0,0,0));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static Date getDate(String s) throws ParseException{
		
		return dateFormat.parse(s);
	}
	public static Date getReportDate(String s) throws ParseException{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		return dateFormat.parse(s);
	}
	
	public static Date getDate(int y,int m,int d,int h,int min) throws ParseException{
		return formatter.parse(String.format("%d-%d-%d-%d:%d:%d", y,m,d,h,min,0));
	}
	public static Date currentDate() throws ParseException{
		Date curr = new Date();
		return getDate(curr.getYear()+1900, curr.getMonth()+1, curr.getDate(), curr.getHours(), curr.getMinutes());
	}
	
	public static Random rand = new Random();
	public static Date randomDate(){
		
			return DateTime.getDate(1990+rand.nextInt(20), rand.nextInt(11), rand.nextInt(29));
		 
	}
	
	public static String getTimeString(Date d){
		SimpleDateFormat format = new SimpleDateFormat("HH:mm");
		return format.format(d);
	}

	public static String getDateString(Date d){
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		return format.format(d);
	}
	
	public static  Date calendarToDate(Calendar date){
		
		try {
			return  DateTime.getDate(date.get(Calendar.YEAR), date.get(Calendar.MONTH)+1, date.get(Calendar.DAY_OF_MONTH),
					date.get(Calendar.HOUR_OF_DAY),
					date.get(Calendar.MINUTE));
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Date addHoursToTime(Date date,int valueToAdd){
		Calendar cdate= Calendar.getInstance();
		cdate.setTime(date);
		cdate.add(Calendar.MINUTE, valueToAdd);
		return calendarToDate(cdate);
	}
	
	
	public static boolean isOverlap(Date d1_start,Date d1_end, Date d2_start , Date d2_end){
		//Overlap <==> (StartA < EndB)  and  (EndA > StartB)
		
		if(  (d1_start.before(d2_end) ) && 
				(d1_end.after(d2_start) ) ) return true;
		return false;
	}
	

	public static Date getTomorrowDate(){
		try {
			return addDay(currentDate(), 1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
}
