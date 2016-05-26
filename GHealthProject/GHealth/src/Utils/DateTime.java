package Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class DateTime {
	public static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-hh:mm:ss"); 
	public static Date getTime(int h,int m) throws ParseException{
		Date d = new Date();
		return formatter.parse(String.format("%d-%d-%d-%d:%d:%d", d.getYear(),d.getMonth(),d.getDay(),h,m,0));
	}
	
	public static Date getDate(int y,int m,int d) throws ParseException{
		return formatter.parse(String.format("%d-%d-%d-%d:%d:%d", y,m,d,0,0,0));
	}
	
	public static Date getDate(int y,int m,int d,int h,int min) throws ParseException{
		return formatter.parse(String.format("%d-%d-%d-%d:%d:%d", y,m,d,h,min,0));
	}
	
	public static String getTimeString(Date d){
		SimpleDateFormat format = new SimpleDateFormat("hh:mm");
		return format.format(d);
	}
	
	public static String getDateString(Date d){
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		return format.format(d);
	}
}
