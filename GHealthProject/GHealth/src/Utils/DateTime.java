package Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class DateTime {
	public static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-hh:mm:ss"); 
	public static SimpleDateFormat dateFormat = new SimpleDateFormat("E dd/MM/yyyy");

	public static Date getTime(int h,int m) throws ParseException{
		Date d = new Date();
		return formatter.parse(String.format("%d-%d-%d-%d:%d:%d", d.getYear(),d.getMonth(),d.getDay(),h,m,0));
	}
	
	public static Date addDay(Date d,int period)
	{
		Date date=new Date();
		 date.setTime( d.getTime() + period * 24 * 60 * 60 * 1000);
		 return date;
	}
	public static Date getDate(int y,int m,int d) throws ParseException{
		return formatter.parse(String.format("%d-%d-%d-%d:%d:%d", y,m,d,0,0,0));
	}
	
	public static Date getDate(String s) throws ParseException{
		return dateFormat.parse(s);
	}
	
	public static Date getDate(int y,int m,int d,int h,int min) throws ParseException{
		return formatter.parse(String.format("%d-%d-%d-%d:%d:%d", y,m,d,h,min,0));
	}
	public static Date currentDate() throws ParseException{
		Date curr = new Date();
		return getDate(curr.getYear()+1900, curr.getMonth()+1, curr.getDate(), curr.getHours(), curr.getMinutes());
	}
	public static String getTimeString(Date d){
		SimpleDateFormat format = new SimpleDateFormat("hh:mm");
		return format.format(d);
	}
	
//	public static String getDateString(Date d){
//		return dateFormat.format(d);
//	}
	
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
}
